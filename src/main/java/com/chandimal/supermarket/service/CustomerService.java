package com.chandimal.supermarket.service;

import com.chandimal.supermarket.dto.request.CustomerLoginDto;
import com.chandimal.supermarket.dto.request.CustomerSaveDto;

public interface CustomerService {

    String saveCustomer(CustomerSaveDto customerSaveDto);

    String loginCustomer(CustomerLoginDto customerLoginDto);
}
