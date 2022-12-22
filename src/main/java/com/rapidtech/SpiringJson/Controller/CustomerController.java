package com.rapidtech.SpiringJson.Controller;

import com.rapidtech.SpiringJson.Model.CustomerModel;
import com.rapidtech.SpiringJson.Model.RequestCustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService service;

    @Autowired
    public CustomerController(CustomerService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<CustomerModel> result = service.getAll();
        return null;
    }
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody RequestCustomerModel request){
        return ResponseEntity.ok().body(request);
    }

}
