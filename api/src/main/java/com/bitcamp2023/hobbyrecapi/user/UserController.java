package com.bitcamp2023.hobbyrecapi.user;

import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public User getTest() {
        return userService.createNewUser(null, null);
    }

    @PostMapping("/new-user")
    public User postNewUser(@RequestBody Map<String, Object> body) {
        Long userID = ((Number) body.get("userID")).longValue();
        
        Object tagsObject = body.get("tags");

        Map<String, Double> tags = null;

        if (tagsObject instanceof Map) {

            @SuppressWarnings("unchecked")
            Map<Object, Object> tagsMap = (Map<Object, Object>) tagsObject;

            tags = tagsMap
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                    (Entry<Object, Object> e) -> e.getKey().toString(),
                    (Entry<Object, Object> e) -> (Double) e.getValue()
                ));
        }

        return userService.createNewUser(userID, tags);
    }
    

}
