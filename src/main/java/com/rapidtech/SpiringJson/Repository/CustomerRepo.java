package com.rapidtech.SpiringJson.Repository;

import com.rapidtech.SpiringJson.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity,Long> {
}
