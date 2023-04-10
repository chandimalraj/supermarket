package com.chandimal.supermarket.controller;

import com.chandimal.supermarket.dto.request.ItemSaveDto;
import com.chandimal.supermarket.dto.request.OrderSaveDto;
import com.chandimal.supermarket.service.OrderService;
import com.chandimal.supermarket.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(
            path = "/save"
    )
    public ResponseEntity<StandardResponse> orderSave(@RequestBody OrderSaveDto orderSaveDto){
        String id = orderService.saveOrder(orderSaveDto);

        System.out.println(orderSaveDto);
        ResponseEntity<StandardResponse> response = new ResponseEntity<>(
                new StandardResponse(200,"Item saved succefully","msg"),
                HttpStatus.CREATED
        );
        return response;
    }

}
