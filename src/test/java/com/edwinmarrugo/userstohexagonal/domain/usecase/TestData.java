package com.edwinmarrugo.userstohexagonal.domain.usecase;

import com.edwinmarrugo.userstohexagonal.domain.model.User;

public class TestData {
    private TestData(){

    }
    public static User getUser(){
        User user = new User();
        user.setName("Edwin");
        user.setTypeId("CC");
        user.setNumberId("12345");
        return user;
    }
}
