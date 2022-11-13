package com.example.keyclokeservice.service;

import com.example.keyclokeservice.response.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;


@Service
public class LoginService {

    @Autowired
    RestTemplate restTemplate;

    public void login(LoginRequest loginRequest){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id","");
        map.add("client_secret","");
        map.add("grant_type","");
        map.add("client-secret","");
        map.add("username","");
        map.add("password","");

        HttpEntity<MultiValueMap<String,String>>httpEntity = new HttpEntity<>(map,headers);
        restTemplate.postForEntity("http://localhost:8180/auth/realms/auth-realm/protocol/openid-connect/token",
                loginRequest,null);


    }
}
