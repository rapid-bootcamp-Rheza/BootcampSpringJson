package com.rapidtech.SpiringJson.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseModel {
    private  Integer code;
    private String status;
    private Object data;


}
