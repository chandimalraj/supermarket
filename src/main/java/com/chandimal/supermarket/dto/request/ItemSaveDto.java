package com.chandimal.supermarket.dto.request;

import com.chandimal.supermarket.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemSaveDto {

    private String itemName;
    private MeasuringUnitType measuringUnitType;
    private double balanceQuantity;
    private double supplierPrice;
    private double sellingPrice;
}
