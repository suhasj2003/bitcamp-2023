package com.bitcamp2023.hobbyrecapi.user;

import java.util.Map;

public class User {

    private Long userID;
    private Map<String, Double> tags;

    public User(Long userID, Map<String,Double> tags) {
        this.userID = userID;
        this.tags = tags;
    }


    public Long getUserID() {
        return this.userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Map<String,Double> getTags() {
        return this.tags;
    }

    public void setTags(Map<String,Double> tags) {
        this.tags = tags;
    }

   
}
