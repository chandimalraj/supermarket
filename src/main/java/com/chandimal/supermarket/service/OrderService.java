package com.chandimal.supermarket.service;

import com.chandimal.supermarket.dto.request.OrderSaveDto;

public interface OrderService {

    String saveOrder(OrderSaveDto orderSaveDto);
}
