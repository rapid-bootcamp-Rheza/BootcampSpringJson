package com.rapidtech.SpiringJson.Service;

import com.rapidtech.SpiringJson.Model.AddressModel;
import com.rapidtech.SpiringJson.Model.CustomerModel;
import com.rapidtech.SpiringJson.Model.CustomerResponse;
import com.rapidtech.SpiringJson.Model.RequestCustomerModel;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerModel> getAll();
    Optional<CustomerModel> getById(Long id);
    Optional<CustomerModel> save(CustomerModel model);

    //Dimodel sudah dalam bentuk list
    CustomerResponse saveAll(RequestCustomerModel request);
    Optional<CustomerModel> update(Long id, CustomerModel model);

    Optional<CustomerModel> delete(Long id);
}
