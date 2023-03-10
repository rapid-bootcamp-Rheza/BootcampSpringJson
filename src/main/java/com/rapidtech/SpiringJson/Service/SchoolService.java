package com.rapidtech.SpiringJson.Service;

import com.rapidtech.SpiringJson.Model.RequestCustomerModel;
import com.rapidtech.SpiringJson.Model.SchoolModel;

import java.util.List;
import java.util.Optional;

public interface SchoolService {
    List<SchoolModel> getAll();
    Optional<SchoolModel> getById(Long id);
    Optional<SchoolModel> save(SchoolModel model);


    Optional<SchoolModel> update(Long id, SchoolModel model);

    Optional<SchoolModel> delete(Long id);
}
