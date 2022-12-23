package com.rapidtech.SpiringJson.Service.Impl;

import com.rapidtech.SpiringJson.Entity.AddressEntity;
import com.rapidtech.SpiringJson.Entity.CustomerEntity;
import com.rapidtech.SpiringJson.Entity.SchoolEntity;
import com.rapidtech.SpiringJson.Model.AddressModel;
import com.rapidtech.SpiringJson.Model.CustomerModel;
import com.rapidtech.SpiringJson.Model.SchoolModel;
import com.rapidtech.SpiringJson.Repository.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
    @InjectMocks
    @Autowired
    private CustomerServiceImpl service;

    private List<CustomerEntity> customerEntityList;
    @Mock
    private CustomerRepo customerRepo;

    @BeforeEach
    void setUp() {
        log.info("Setup Run........");
        customerEntityList= Arrays.asList(
                new CustomerEntity(1L,"Kezia","Wanita Solehah"),
                new CustomerEntity(2L,"Yoga","Pria"),
                new CustomerEntity(3L,"Koala","hewan")

        );
    }

    @AfterEach
    void tearDown() {
        log.info("Setup Clear........");
    }

    @Test
    void getAll() {
        //Mocking => perumpamaan
        //ketika ada request customerRepo , maka kembalikan value list kosong
        when(this.customerRepo.findAll()).thenReturn(Collections.emptyList());
        List<CustomerModel> result = service.getAll();
        assertNotNull(result);
        assertEquals(0,result.size());

        when(this.customerRepo.findAll()).thenReturn(customerEntityList);
        result = service.getAll();
        assertNotNull(result);
        assertEquals(3,result.size());
        assertEquals(1L,result.get(0).getId());
        assertEquals("Kezia",result.get(0).getFullName());
        assertEquals("Wanita Solehah",result.get(0).getGender());

    }

    @Test
    void getById() {
        Optional<CustomerModel> result = service.getById(0L);
        assertEquals(Optional.empty(),result);


        CustomerEntity customerEntity = new CustomerEntity(1L,"Kezia","Wanita Solehah");
        Optional<CustomerEntity> optional = Optional.of(customerEntity);

        when(customerRepo.findById(1L)).thenReturn(optional);
        result = service.getById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L,result.get().getId());
        assertEquals("Kezia",result.get().getFullName());
        assertEquals("Wanita Solehah",result.get().getGender());

    }

    @Test
    void save() {
        Optional<CustomerModel> result = this.service.save(null);
        assertEquals(Optional.empty(),result);
        List<AddressModel> addressModels = Arrays.asList(
                new AddressModel(0L,"Address 1","Jl. Cempaka","sukoharjo","Kecamatan 1","Yogya","DI Yogyakarta"),
                new AddressModel(0L,"Address 2","Jl. Cempaka2","sukirejo","Kecamatan 2","Yogya","DI Yogyakarta")
        );
        List<SchoolModel> schoolModels =  Arrays.asList(
                new SchoolModel(0L,"SD","SD Bagunan","Elementary"),
                new SchoolModel(0L,"SMP","SMP Bagunan2","Middle School"),
                new SchoolModel(0L,"SMA","SMA Bagunan3","High School")

        );
        //prepare data request
        CustomerModel model = new CustomerModel(1L,"Joko","pria",new Date(),"jakarta",
                addressModels,schoolModels
                );
        //prepare response dari repo save
        CustomerEntity entity = new CustomerEntity(model);
        List<AddressEntity> addressEntities = addressModels.stream().map(AddressEntity::new).collect(Collectors.toList());
        entity.setAddress(addressEntities);

        List<SchoolEntity> schoolEntities = schoolModels.stream().map(SchoolEntity::new).collect(Collectors.toList());
        entity.setSchool(schoolEntities);

        // mocking pura-pura save ke DB
        when(this.customerRepo.save(any(CustomerEntity.class))).thenReturn(entity);
        result = this.service.save(model);
        assertNotNull(result);
        assertEquals("joko", result.get().getFullName());
        assertEquals("pria", result.get().getGender());
        assertEquals("jakarta", result.get().getPlaceOfBirth());

        //Validasi Address
        assertEquals(2,result.get().getAddress().size());

        //validasi School
        assertEquals(3,result.get().getSchool().size());


    }

    @Test
    void saveAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}