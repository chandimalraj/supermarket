package com.chandimal.supermarket.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.chandimal.supermarket.entity.Customer;
import com.chandimal.supermarket.exception.NotFoundException;
import com.chandimal.supermarket.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<Customer> customers;
        boolean matches;

//        if ("techgeeknext".equals(username)) {
//            return new User("techgeeknext", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//                    new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }

       // String email = customerLoginDto.getCustomerEmail();
       // String password = customerLoginDto.getPassword();




        try {

            customers = customerRepo.findByCustomerEmailEquals(username);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            //matches = encoder.matches(password, customers.get(0).getPassword());


        }catch (Exception e){
            throw new NotFoundException("user not found");
        }

        return new org.springframework.security.core.userdetails.User(customers.get(0).getCustomerEmail(), customers.get(0).getPassword(),
                new ArrayList<>());

    }

}
