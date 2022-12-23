package com.rapidtech.SpiringJson.Model;

import com.rapidtech.SpiringJson.Entity.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressModel {
    private Long id;
    private String name;
    private String address;
    private String village;

    private String district;

    private String city;
    private String province;

//    private Long customerId;
    public AddressModel(AddressEntity addressEntity){
        BeanUtils.copyProperties(addressEntity,this);
    }

}
