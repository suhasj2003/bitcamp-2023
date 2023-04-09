package com.bitcamp2023.hobbyrecapi.user;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class UserService {


    public UserService() {
    }

    public User createNewUser(Long userID, Map<Object, Object> tagsMap) {
        Map<String, Double> tags = null;

        tags = tagsMap.entrySet()
            .stream()
            .collect(Collectors.toMap(
                (Entry<Object, Object> e) -> e.getKey().toString(),
                (Entry<Object, Object> e) -> (Double) e.getValue()
            ));

        return new User(userID, tags);
    }

    public Map<String, Object> userToMap(User user) {
         Map<String, Object> rtn = new LinkedHashMap<String, Object>();

        rtn.put("userID", user.getUserID());
        rtn.put("tags", user.getTags());

        return rtn;
    }
 
    
}
