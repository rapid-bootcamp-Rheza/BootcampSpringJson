package com.rapidtech.SpiringJson.Model;

import com.rapidtech.SpiringJson.Entity.AddressEntity;
import com.rapidtech.SpiringJson.Entity.SchoolEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolModel {
    private Long id;
    private String title;
    private String name;

    private String level;

    private Long customerId;
    public SchoolModel(SchoolEntity schoolEntity){
        BeanUtils.copyProperties(schoolEntity,this);
    }

    public SchoolModel(Long id, String title, String name, String level) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.level = level;
    }
}
