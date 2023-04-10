package com.chandimal.supermarket.service.impl;

import com.chandimal.supermarket.dto.request.ItemSaveDto;
import com.chandimal.supermarket.entity.Item;
import com.chandimal.supermarket.repo.ItemRepo;
import com.chandimal.supermarket.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveItem(ItemSaveDto itemSaveDto) {
        Item item = modelMapper.map(itemSaveDto,Item.class);
        itemRepo.save(item);
        return itemSaveDto.getItemName()+ " saved";
    }


}
