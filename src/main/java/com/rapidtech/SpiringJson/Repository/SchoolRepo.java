package com.rapidtech.SpiringJson.Repository;

import com.rapidtech.SpiringJson.Entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepo extends JpaRepository<SchoolEntity,Long> {
}