package com.bitcamp2023.hobbyrecapi.user;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserService {


    public UserService() {
    }

    public User createNewUser(Long userID, Map<String, Double> tags) {
        return new User(userID, tags);
    }
 
    
}
