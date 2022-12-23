package com.rapidtech.SpiringJson.Controller;

import com.rapidtech.SpiringJson.Model.CustomerModel;
import com.rapidtech.SpiringJson.Model.RequestCustomerModel;
import com.rapidtech.SpiringJson.Model.ResponseModel;
import com.rapidtech.SpiringJson.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService service;

    @Autowired
    public CustomerController(CustomerService service){
        this.service = service;
    }

//    @GetMapping
//    public ResponseEntity<Object> getAll(){
//        List<CustomerModel> result = service.getAll();
//        return ResponseEntity.ok().body(
//                new ResponseModel(result));
//
//    }
//    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody RequestCustomerModel request){
//        Optional<CustomerModel> result = service.save(request);
        return ResponseEntity.ok().body(
                service.saveAll(request)
        );
//                new ResponseModel(200,"SUCCESS", service.save(request))
//        );
    }

}
