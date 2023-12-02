package com.soap.example.endpoint;

import com.soap.example.service.UserService;
import example.soap.com.generate.GetUserRequest;
import example.soap.com.generate.GetUserResponse;
import example.soap.com.generate.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    @Autowired
    public UserService userService;

    @PayloadRoot(namespace = "http://com.soap.example/generate",localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserInfo(@RequestPayload GetUserRequest request){
        GetUserResponse response=new GetUserResponse();
        User user = userService.getUser(request.getName());
        response.setUser(user);
        return response;
    }
}
