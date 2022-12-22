package com.rapidtech.SpiringJson.Entity;

import com.rapidtech.SpiringJson.Model.AddressModel;
import com.rapidtech.SpiringJson.Model.CustomerModel;
import com.rapidtech.SpiringJson.Model.RequestCustomerModel;
import com.rapidtech.SpiringJson.Model.SchoolModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer_tab")
public class CustomerEntity {
    @Id
    @TableGenerator(name = "id_generator",table = "sequence_table",
                    pkColumnName = "gen_name",valueColumnName = "gen_value",
                    pkColumnValue = "customer_id",initialValue = 0,allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "id_generator")
    private Long id;

    @Column(name = "full_name",length = 100,nullable = false)
    private String fullName;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<AddressEntity> address = new HashSet<>();

//    @Column(name = "address_id",nullable = false)
//    private Long addressId;
    @Column (name = "gender",length = 15,nullable = false)
    private String gender;

    @Temporal(TemporalType.DATE)
    @Column (name = "date_of_birth",length = 32,nullable = false)
    private Date dateOfBirth;

    @Column(name = "place_of_birth",nullable = false)
    private String placeOfBirth;

//    @Column(name = "req_customer_id",nullable = false)
//    private Long reqCustomerId;

//    @Column(name = "school_id",nullable = false)
//    private Long schoolId;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<SchoolEntity> school= new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "request_customer",insertable = false,updatable = false)
    private RequestCustomerEntity reqCustomer;

//    @ManyToOne
//    @JoinColumn(name = "req_customer_id",updatable = false,insertable = false)
//    private RequestCustomerEntity requestCustomer;


    public CustomerEntity(CustomerModel model) {
       this.fullName = model.getFullName();
       this.gender = model.getGender();
       this.dateOfBirth = model.getDateOfBirth();
       this.placeOfBirth = model.getPlaceOfBirth();
    }

    public void addDetailAddress (AddressEntity addressEntity){
        this.address.add(addressEntity);
        addressEntity.setCustomer(this);
    }
    public void addDetailSchool (SchoolEntity schoolEntity){
        this.school.add(schoolEntity);
        schoolEntity.setCustomer(this);
    }

    public void addDetailAddressList(List<AddressModel> addressDetail){
        for (AddressModel item : addressDetail){
            AddressEntity addressEntity = new AddressEntity(item);
            addDetailAddress(addressEntity);
        }
    }
    public void addDetailSchoolList(List<SchoolModel> schoolDetail){
        for (SchoolModel item : schoolDetail){
            SchoolEntity schoolEntity = new SchoolEntity(item);
            addDetailSchool(schoolEntity);
        }
    }

}
