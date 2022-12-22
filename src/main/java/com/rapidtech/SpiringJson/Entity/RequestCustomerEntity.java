package com.rapidtech.SpiringJson.Entity;

import com.rapidtech.SpiringJson.Model.CustomerModel;
import com.rapidtech.SpiringJson.Model.RequestCustomerModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "req_customer_tab")
public class RequestCustomerEntity {
    @Id
    @TableGenerator(name = "id_generator",table = "sequence_table",
            pkColumnName = "gen_name",valueColumnName = "gen_value",
            pkColumnValue = "req_customer_id",initialValue = 0,allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "id_generator")
    private Long id;



    @OneToMany(mappedBy = "req_customer",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CustomerEntity> customerDetails = new ArrayList<>();




    public RequestCustomerEntity(RequestCustomerModel model) {
        BeanUtils.copyProperties(model,this);

    }
    public void addDetailCustomer(CustomerEntity customerEntity){
        this.customerDetails.add(customerEntity);
        customerEntity.setReqCustomer(this);
    }

    public void addDetailCustomerList (List<CustomerModel> detailsCustomer){
        for (CustomerModel item : detailsCustomer){
            CustomerEntity detailCustomerEntity = new CustomerEntity(item);
            addDetailCustomer(detailCustomerEntity);
        }
    }



}
