package com.chandimal.supermarket.service;

import com.chandimal.supermarket.dto.request.CustomerLoginDto;
import com.chandimal.supermarket.dto.request.CustomerSaveDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface CustomerService {

    String saveCustomer(CustomerSaveDto customerSaveDto);

    UserDetails loginCustomer(CustomerLoginDto customerLoginDto);
}
