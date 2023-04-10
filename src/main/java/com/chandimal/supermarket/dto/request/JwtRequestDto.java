package com.chandimal.supermarket.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JwtRequestDto  {

    private static final long serialVersionUID = 5926468583005150707L;

    private String username;
    private String password;

}
