package com.rapidtech.SpiringJson.Model;

import com.rapidtech.SpiringJson.Entity.CustomerEntity;
import com.rapidtech.SpiringJson.Entity.RequestCustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCustomerModel {

    private List<CustomerModel> customerDetail;


    public RequestCustomerModel(CustomerEntity customerEntity) {
        BeanUtils.copyProperties(customerEntity,this);
    }
}
