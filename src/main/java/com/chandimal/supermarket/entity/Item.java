package com.chandimal.supermarket.entity;

import com.chandimal.supermarket.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name")
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type")
    private MeasuringUnitType measuringUnitType;

    @Column(name = "balance_qty" , length = 100 ,nullable = false)
    private double balanceQuantity;

    @Column(name = "supplier_price" , length = 100 ,nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price" , length = 100 ,nullable = false)
    private double sellingPrice;

    @Column(name = "active_status",columnDefinition = "TINYINT default 0")
    private boolean active;

    @OneToMany(mappedBy = "items")
    private Set<OrderDetails> orderDetails;

}
