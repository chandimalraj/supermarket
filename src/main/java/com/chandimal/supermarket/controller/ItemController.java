package com.chandimal.supermarket.controller;

import com.chandimal.supermarket.dto.request.CustomerSaveDto;
import com.chandimal.supermarket.dto.request.ItemSaveDto;
import com.chandimal.supermarket.service.ItemService;
import com.chandimal.supermarket.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(
            path = "/save"
    )
    public ResponseEntity<StandardResponse> itemSave(@RequestBody ItemSaveDto itemSaveDto){
        String msg = itemService.saveItem(itemSaveDto);
        ResponseEntity<StandardResponse> response = new ResponseEntity<>(
                new StandardResponse(200,"Item saved succefully",msg),
                HttpStatus.CREATED
        );
        return response;
    }



}
