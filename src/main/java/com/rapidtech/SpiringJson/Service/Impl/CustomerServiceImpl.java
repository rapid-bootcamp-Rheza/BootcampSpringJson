package com.rapidtech.SpiringJson.Service.Impl;

import com.rapidtech.SpiringJson.Entity.CustomerEntity;
import com.rapidtech.SpiringJson.Model.CustomerModel;
import com.rapidtech.SpiringJson.Model.CustomerResponse;
import com.rapidtech.SpiringJson.Model.RequestCustomerModel;
import com.rapidtech.SpiringJson.Repository.AddressRepo;
import com.rapidtech.SpiringJson.Repository.CustomerRepo;
import com.rapidtech.SpiringJson.Repository.SchoolRepo;
import com.rapidtech.SpiringJson.Service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepo customerRepo;
    private SchoolRepo schoolRepo;
    private AddressRepo addressRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo, SchoolRepo schoolRepo, AddressRepo addressRepo) {
        this.customerRepo = customerRepo;
        this.schoolRepo = schoolRepo;
        this.addressRepo = addressRepo;
    }

    @Override
    public List<CustomerModel> getAll() {
        return this.customerRepo.findAll().stream().map(CustomerModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerModel> getById(Long id) {
        if(id == 0) {
            return Optional.empty();
        }
        Optional<CustomerEntity> result = this.customerRepo.findById(id);
        return result.map(CustomerModel::new);

    }

    @Override
    public Optional<CustomerModel> save(CustomerModel model) {
//        if(model == null || model.getAddress().isEmpty() || model.getSchool().isEmpty()) {
        if (model == null){
            return Optional.empty();
        }

        CustomerEntity entity = new CustomerEntity(model);
            if(!model.getAddress().isEmpty()){
                entity.addDetailAddressList(model.getAddress());
            }
            if (!model.getSchool().isEmpty()){
                entity.addDetailSchoolList(model.getSchool());
            }

        try{
            this.customerRepo.save(entity);
            return Optional.of(new CustomerModel(entity));
        }catch (Exception e){
            log.error("Customer save is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public CustomerResponse saveAll(RequestCustomerModel request) {
        if (request.getCustomerDetail().isEmpty()){
            return new CustomerResponse();
        }
        CustomerResponse response = new CustomerResponse();
        int countSuccess = 0;
        int countFailed = 0;
        List<CustomerModel> customerModels = new ArrayList<>();
        for (CustomerModel model: request.getCustomerDetail()){
            // panggil method save
            Optional<CustomerModel> customerModel = this.save(model);
            // cek datanya
            if (customerModel.isPresent()){
                customerModels.add(model);
                countSuccess++;
            }else {
                countFailed++;
            }
        }
        //cara 1
        // return  new CustomerResponse(customerModels, countSuccess, countFailed);
        //cara 2
        response.setData(customerModels);
        response.setSuccessSave(countSuccess);
        response.setFailedSave(countFailed);
        return response;
    }


    @Override
    public Optional<CustomerModel> update(Long id, CustomerModel model) {
        if(id == 0) {
            return Optional.empty();
        }

        CustomerEntity result = this.customerRepo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }

        // copy property
        BeanUtils.copyProperties(model, result);
        try {
            this.customerRepo.save(result);
            return Optional.of(new CustomerModel(result));
        }catch (Exception e){
            log.error("Customer update is failed, error: {}", e.getMessage());
            return Optional.empty();
        }

    }

    @Override
    public Optional<CustomerModel> delete(Long id) {
        if(id == 0) {
            return Optional.empty();
        }

        CustomerEntity result = this.customerRepo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }

        try {
            this.customerRepo.delete(result);
            return Optional.of(new CustomerModel(result));
        }catch (Exception e){
            log.error("Customer delete is failed, error: {}", e.getMessage());
            return Optional.empty();
        }

    }
}
