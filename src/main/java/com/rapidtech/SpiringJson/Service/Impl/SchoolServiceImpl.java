package com.rapidtech.SpiringJson.Service.Impl;

import com.rapidtech.SpiringJson.Model.SchoolModel;
import com.rapidtech.SpiringJson.Repository.SchoolRepo;
import com.rapidtech.SpiringJson.Service.SchoolService;

import java.util.List;
import java.util.Optional;

public class SchoolServiceImpl implements SchoolService {

    public SchoolRepo repo;

    public SchoolServiceImpl(SchoolRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<SchoolModel> getAll() {
        return null;
    }

    @Override
    public Optional<SchoolModel> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<SchoolModel> save(SchoolModel model) {
        return Optional.empty();
    }

    @Override
    public Optional<SchoolModel> update(Long id, SchoolModel model) {
        return Optional.empty();
    }

    @Override
    public Optional<SchoolModel> delete(Long id) {
        return Optional.empty();
    }
}
