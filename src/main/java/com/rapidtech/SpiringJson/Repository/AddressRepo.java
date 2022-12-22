package com.rapidtech.SpiringJson.Repository;

import com.rapidtech.SpiringJson.Entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<AddressEntity,Long> {
}
