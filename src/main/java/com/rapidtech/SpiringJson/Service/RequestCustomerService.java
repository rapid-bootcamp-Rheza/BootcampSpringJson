package com.rapidtech.SpiringJson.Service;

import com.rapidtech.SpiringJson.Model.CustomerModel;
import com.rapidtech.SpiringJson.Model.RequestCustomerModel;

import java.util.List;
import java.util.Optional;

public interface RequestCustomerService {


    List<RequestCustomerModel> getAll();
    Optional<RequestCustomerModel> getById(Long id);
    Optional<RequestCustomerModel> save(RequestCustomerModel model);


    Optional<RequestCustomerModel> update(Long id, RequestCustomerModel model);

    Optional<RequestCustomerModel> delete(Long id);
}
