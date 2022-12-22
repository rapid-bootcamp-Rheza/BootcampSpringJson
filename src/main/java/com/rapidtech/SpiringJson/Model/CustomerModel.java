package com.rapidtech.SpiringJson.Model;

//import com.rapidtech.SpiringJson.Entity.AddressEntity;
//import com.rapidtech.SpiringJson.Entity.SchoolEntity;
import com.rapidtech.SpiringJson.Entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel implements Serializable {
    private Long id;

    private String fullName;
    private String gender;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    private String placeOfBirth;

    private List<AddressModel> address;
    private List<SchoolModel> school;

    public CustomerModel(CustomerEntity entity) {
        BeanUtils.copyProperties(entity,this);
    }
}
