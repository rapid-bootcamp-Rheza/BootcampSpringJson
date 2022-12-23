package com.rapidtech.SpiringJson.Service;

import com.rapidtech.SpiringJson.Model.AddressModel;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<AddressModel> getAll();
    Optional<AddressModel> getById(Long id);
    Optional<AddressModel> save(AddressModel model);


    Optional<AddressModel> update(Long id, AddressModel model);

    Optional<AddressModel> delete(Long id);
}
