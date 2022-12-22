package com.rapidtech.SpiringJson.Repository;

import com.rapidtech.SpiringJson.Entity.RequestCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestCustomerRepo extends JpaRepository<RequestCustomerEntity , Long> {
}
