package com.example.keyclokeservice.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private String access_token;
    private String refresh_token;
    private String expires_in;
    private String refresh_expires_in;
    private String token_type;

}
