package com.chandimal.supermarket.controller;

import com.chandimal.supermarket.dto.request.CustomerSaveDto;
import com.chandimal.supermarket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(
            path = "/save"
    )
    public String customerSave(@RequestBody CustomerSaveDto customerSaveDto){
       String msg = customerService.saveCustomer(customerSaveDto);
       return msg;
    }
}
