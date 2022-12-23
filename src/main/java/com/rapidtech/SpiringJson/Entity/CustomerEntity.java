package com.rapidtech.SpiringJson.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rapidtech.SpiringJson.Model.AddressModel;
import com.rapidtech.SpiringJson.Model.CustomerModel;
import com.rapidtech.SpiringJson.Model.RequestCustomerModel;
import com.rapidtech.SpiringJson.Model.SchoolModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer_tab")
public class CustomerEntity {
    @Id
    @TableGenerator(name = "customer_id_generator",table = "sequence_table",
                    pkColumnName = "gen_name",valueColumnName = "gen_value",
                    pkColumnValue = "customer_id",initialValue = 0,allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "customer_id_generator")
    private Long id;

    @Column(name = "full_name",length = 100,nullable = false)
    private String fullName;
    @JsonIgnore
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<AddressEntity> address = new ArrayList<>();

    @Column (name = "gender",length = 15,nullable = false)
    private String gender;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column (name = "date_of_birth",length = 32,nullable = false)
    private Date dateOfBirth;

    @Column(name = "place_of_birth",nullable = false)
    private String placeOfBirth;

    @JsonIgnore
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<SchoolEntity> school= new ArrayList<>();

//    @ManyToOne
//    @JoinColumn(name = "req_customer",insertable = false,updatable = false)
//    private RequestCustomerEntity reqCustomer;




    public CustomerEntity(CustomerModel model) {
       this.fullName = model.getFullName();
       this.gender = model.getGender();
       this.dateOfBirth = model.getDateOfBirth();
       this.placeOfBirth = model.getPlaceOfBirth();
    }

    public CustomerEntity(Long id, String fullName, String gender) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
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
