package com.chandimal.supermarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Table(name = "order_details")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetails {

    @Id
    @Column(name = "order_details_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  orderDetailsId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "qty" , length = 100 ,nullable = false)
    private double Quantity;

    @Column(name = "amount" , nullable = false)
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "item_id" , nullable = false)
    private Item items;

    @ManyToOne
    @JoinColumn(name = "order_id" , nullable = false)
    private Order orders;


}
