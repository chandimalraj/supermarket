package com.chandimal.supermarket.service.impl;

import com.chandimal.supermarket.dto.request.OrderSaveDto;
import com.chandimal.supermarket.entity.Customer;
import com.chandimal.supermarket.entity.Order;
import com.chandimal.supermarket.entity.OrderDetails;
import com.chandimal.supermarket.repo.CustomerRepo;
import com.chandimal.supermarket.repo.ItemRepo;
import com.chandimal.supermarket.repo.OrderDetailsRepo;
import com.chandimal.supermarket.repo.OrderRepo;
import com.chandimal.supermarket.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Override
    @Transactional
    public String saveOrder(OrderSaveDto orderSaveDto) {

        Order order = new Order(
               customerRepo.getById(orderSaveDto.getCustomer()),
                orderSaveDto.getDate(),
                orderSaveDto.getTotal()
        );

        orderRepo.save(order);

        if(orderRepo.existsById(order.getOrderId())){
            List<OrderDetails> orderDetailsList = modelMapper.map(
                    orderSaveDto.getOrderDetails() , new TypeToken<List<OrderDetails>>(){
                    }.getType());

            for (int i=0;i<orderDetailsList.size();i++){
                orderDetailsList.get(i).setOrders(order);
                orderDetailsList.get(i).setItems(itemRepo.getReferenceById(orderSaveDto.getOrderDetails().get(i).getItems()));
            }

            if(orderDetailsList.size()>0){
                orderDetailsRepo.saveAll(orderDetailsList);
                return "saved";
            }
            else{
                return "not saved";
            }

        }else{
            return "not saved";
        }

    }
}
