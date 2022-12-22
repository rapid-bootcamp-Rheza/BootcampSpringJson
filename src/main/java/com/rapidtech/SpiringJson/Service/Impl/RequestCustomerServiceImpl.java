package com.rapidtech.SpiringJson.Service.Impl;

import com.rapidtech.SpiringJson.Entity.RequestCustomerEntity;
import com.rapidtech.SpiringJson.Model.RequestCustomerModel;
import com.rapidtech.SpiringJson.Repository.CustomerRepo;
import com.rapidtech.SpiringJson.Repository.RequestCustomerRepo;
import com.rapidtech.SpiringJson.Service.RequestCustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class RequestCustomerServiceImpl implements RequestCustomerService {

    private CustomerRepo repoCustomer;
    private RequestCustomerRepo repoReqCustomer;

    public RequestCustomerServiceImpl(CustomerRepo repoCustomer, RequestCustomerRepo repoReqCustomer) {
        this.repoCustomer = repoCustomer;
        this.repoReqCustomer = repoReqCustomer;
    }

    @Override
    public List<RequestCustomerModel> getAll() {
        return null;
    }

    @Override
    public Optional<RequestCustomerModel> getById(Long id) {
        return null;
    }

    @Override
    public Optional<RequestCustomerModel> save(RequestCustomerModel model) {
        if(model == null || model.getCustomerDetail().isEmpty()){
            return Optional.empty();
        }

        RequestCustomerEntity entity = new RequestCustomerEntity(model);
        entity.addDetailCustomerList(model.getCustomerDetail());
        try{
            repoReqCustomer.save(entity);
            return Optional.of(model);
        }catch (Exception e){
            log.error("Request Customer save is Failed,error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<RequestCustomerModel> update(Long id, RequestCustomerModel model) {
        return Optional.empty();
    }

    @Override
    public Optional<RequestCustomerModel> delete(Long id) {
        return Optional.empty();
    }
}
