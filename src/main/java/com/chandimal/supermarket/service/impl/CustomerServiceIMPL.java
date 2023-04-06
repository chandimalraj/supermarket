package com.chandimal.supermarket.service.impl;

import com.chandimal.supermarket.dto.request.CustomerSaveDto;
import com.chandimal.supermarket.entity.Customer;
import com.chandimal.supermarket.repo.CustomerRepo;
import com.chandimal.supermarket.service.CustomerService;
import com.chandimal.supermarket.util.mappers.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ItemMapper itemMapper;

    @Override
    public String saveCustomer(CustomerSaveDto customerSaveDto) {
        Customer customer1 = itemMapper.toEntity(customerSaveDto);

        Customer customer = new Customer(
                customerSaveDto.getCustomerId(),
                customerSaveDto.getCustomerName(),
                customerSaveDto.getCustomerEmail()
        );
        customerRepo.save(customer1);
        return "saved " + customerSaveDto.getCustomerName();
    }
}
