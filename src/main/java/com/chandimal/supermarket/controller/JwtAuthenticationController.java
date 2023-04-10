package com.chandimal.supermarket.controller;

import com.chandimal.supermarket.config.JwtTokenUtil;
import com.chandimal.supermarket.dto.request.CustomerLoginDto;
import com.chandimal.supermarket.dto.request.JwtRequestDto;
import com.chandimal.supermarket.dto.response.JwtResponseDto;
import com.chandimal.supermarket.service.CustomerService;
import com.chandimal.supermarket.service.impl.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/authenticate")
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService jwtInMemoryUserDetailsService;

    @Autowired
    private CustomerService customerService;

   //@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    @PostMapping(path = "/customer")
    public ResponseEntity<?> generateAuthenticationToken(@RequestBody CustomerLoginDto authenticationRequest)
            throws Exception {

        //authentication process
        authenticate(authenticationRequest.getCustomerEmail(), authenticationRequest.getPassword());

        final UserDetails userDetails = jwtInMemoryUserDetailsService
                .loadUserByUsername(authenticationRequest.getCustomerEmail());
        System.out.println(userDetails);
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponseDto(token));
    }

    private void authenticate(String username, String password) throws Exception {

        Objects.requireNonNull(username);
       Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }


}
