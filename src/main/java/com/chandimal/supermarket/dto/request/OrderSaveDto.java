package com.chandimal.supermarket.dto.request;


import com.chandimal.supermarket.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderSaveDto {

    private int customer;
    private Date date;
    private Double total;
    private List<OrderDetailsSaveDto> orderDetails;

}
