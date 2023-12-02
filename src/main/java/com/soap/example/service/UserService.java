package com.soap.example.service;

import example.soap.com.generate.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    public static final Map<String, User> users=new HashMap<>();

    @PostConstruct
    public void initializeData(){
        User user1=new User();
        user1.setName("Simon");
        user1.setUserId(1);
        user1.setSalary(120000);
        User user2=new User();
        user2.setName("Vincent");
        user2.setUserId(2);
        user2.setSalary(130000);
        User user3=new User();
        user3.setName("Vaibhav");
        user3.setUserId(3);
        user3.setSalary(145000);
        users.put(user1.getName(),user1);
        users.put(user2.getName(),user2);
        users.put(user3.getName(),user3);
    }

    public User getUser(String name){
        return users.get(name);
    }
}
