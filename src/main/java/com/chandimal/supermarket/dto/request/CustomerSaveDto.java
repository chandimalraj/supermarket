package com.chandimal.supermarket.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerSaveDto {

    private String customerName;
    private String customerEmail;
    private String contact;
    private String password;

}
