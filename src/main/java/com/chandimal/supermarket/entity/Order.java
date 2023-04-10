package com.chandimal.supermarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id" , nullable = false)
    private Customer customer;

    @Column(name = "order_date",columnDefinition = "DATETIME")
    private Date date;

    @Column(name = "total" , nullable = false)
    private Double total;

    @OneToMany(mappedBy = "orders")
    private Set<OrderDetails> orderDetails;

}
