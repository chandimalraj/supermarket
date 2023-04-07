package com.chandimal.supermarket.service.impl;

import com.chandimal.supermarket.dto.request.CustomerLoginDto;
import com.chandimal.supermarket.dto.request.CustomerSaveDto;
import com.chandimal.supermarket.entity.Customer;
import com.chandimal.supermarket.exception.DuplicateDataException;
import com.chandimal.supermarket.exception.NotFoundException;
import com.chandimal.supermarket.repo.CustomerRepo;
import com.chandimal.supermarket.service.CustomerService;
import com.chandimal.supermarket.util.mappers.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ItemMapper itemMapper;

    @Override
    public String saveCustomer(CustomerSaveDto customerSaveDto) {

        try {

            Customer customer1 = itemMapper.toEntity(customerSaveDto);
            customerRepo.save(customer1);

        }catch (Exception e){

          throw new DuplicateDataException("email already registered");

        }

        return "saved " + customerSaveDto.getCustomerName();
    }

    @Override
    public String loginCustomer(CustomerLoginDto customerLoginDto) {

        String email = customerLoginDto.getCustomerEmail();
        String password = customerLoginDto.getPassword();

        List<Customer> customers;
        boolean matches;

        try {

            customers = customerRepo.findByCustomerEmailEquals(email);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            matches = encoder.matches(password, customers.get(0).getPassword());

        }catch (Exception e){

            throw new NotFoundException("user not found");
        }
        
        if(matches){
            return "password matches";
        }
        else{
            return "password does not match";
        }
    }
}
