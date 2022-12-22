package com.rapidtech.SpiringJson.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolModel {
    private Long id;
    private String title;
    private String name;

    private String level;

    private Long customerId;
}
