package com.chandimal.supermarket.entity;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    @Column(name = "customer_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name = "customer_name", length = 100,nullable = false)
    private String customerName;

    @Column(name = "customer_email", length = 45 , unique = true , nullable = false)
    private String customerEmail;

    @Column(name="customer_contact" , length = 20)
    private String contact;

    @Column(name = "password")
    @Setter
    private String password;

    //setter method for saving password in hashing method
    public void setPassword(String password){

       this.password = BCrypt.hashpw(password,BCrypt.gensalt());

   }

}
