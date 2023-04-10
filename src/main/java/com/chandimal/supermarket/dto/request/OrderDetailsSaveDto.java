package com.chandimal.supermarket.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailsSaveDto {

    private String itemName;
    private double Quantity;
    private Double amount;
    private int items;
    private int orders;

}
