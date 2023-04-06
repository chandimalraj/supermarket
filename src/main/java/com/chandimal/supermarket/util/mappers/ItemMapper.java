package com.chandimal.supermarket.util.mappers;


import com.chandimal.supermarket.dto.request.CustomerSaveDto;
import com.chandimal.supermarket.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    //Customer customerDtoToCustomer(CustomerSaveDto customerSaveDto);
    Customer toEntity(CustomerSaveDto customerSaveDto);
}
