package com.rapidtech.SpiringJson.Service.Impl;

import com.rapidtech.SpiringJson.Model.AddressModel;
import com.rapidtech.SpiringJson.Repository.AddressRepo;
import com.rapidtech.SpiringJson.Service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {
    public AddressRepo repo;

    public AddressServiceImpl(AddressRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<AddressModel> getAll() {
        return null;
    }

    @Override
    public Optional<AddressModel> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<AddressModel> save(AddressModel model) {
        return Optional.empty();
    }

    @Override
    public Optional<AddressModel> update(Long id, AddressModel model) {
        return Optional.empty();
    }

    @Override
    public Optional<AddressModel> delete(Long id) {
        return Optional.empty();
    }
}
