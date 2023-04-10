package com.chandimal.supermarket.controller;

import com.chandimal.supermarket.dto.request.CustomerLoginDto;
import com.chandimal.supermarket.dto.request.CustomerSaveDto;
import com.chandimal.supermarket.service.CustomerService;
import com.chandimal.supermarket.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
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
    public ResponseEntity<StandardResponse> customerSave(@RequestBody CustomerSaveDto customerSaveDto){
        String msg = customerService.saveCustomer(customerSaveDto);
        ResponseEntity<StandardResponse> response = new ResponseEntity<>(
                new StandardResponse(200,"customer saved succefully",msg),
                HttpStatus.CREATED
        );
       return response;
    }

    @PostMapping(
            path = "/login"
    )
    public ResponseEntity<StandardResponse> customerLogin(@RequestBody CustomerLoginDto customerLoginDto){
        UserDetails msg = customerService.loginCustomer(customerLoginDto);
        ResponseEntity<StandardResponse> response = new ResponseEntity<>(
                new StandardResponse(200,"customer login succefully",msg),
                HttpStatus.CREATED
        );
        return response;
    }
}
