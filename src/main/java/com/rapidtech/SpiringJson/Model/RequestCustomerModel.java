package com.rapidtech.SpiringJson.Model;

import com.rapidtech.SpiringJson.Entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCustomerModel {

    private List<CustomerModel> customerDetail;
//        private Object customerDetail;


//    public RequestCustomerModel(CustomerEntity customerEntity) {
//        BeanUtils.copyProperties(customerEntity,this);
//    }
}
