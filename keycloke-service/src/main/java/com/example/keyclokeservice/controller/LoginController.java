package com.example.keyclokeservice.controller;

import com.example.keyclokeservice.response.IntrospectResponse;
import com.example.keyclokeservice.response.LoginRequest;
import com.example.keyclokeservice.response.LoginResponse;
import com.example.keyclokeservice.response.TokenRequest;
import com.example.keyclokeservice.service.LoginService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    LoginService loginService;

    // login
    @PostMapping("/login")
    public ResponseEntity<LoginResponse>login(@RequestBody LoginRequest loginRequest){
        return loginService.login(loginRequest);
    }

    //logout.expires the refresh token and token
    @PostMapping("/logout")
    public ResponseEntity<Response> logout (@RequestBody TokenRequest token) {
        return loginService.logout(token);
    }

    //checks if a refresh token is available or not
    @PostMapping("/introspect")
    public ResponseEntity<IntrospectResponse> introspect(@RequestBody TokenRequest token) {
        return loginService.introspect(token);
    }
}
