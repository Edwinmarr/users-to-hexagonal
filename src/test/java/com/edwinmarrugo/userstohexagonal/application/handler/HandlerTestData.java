package com.edwinmarrugo.userstohexagonal.application.handler;

import com.edwinmarrugo.userstohexagonal.application.dto.UserRequest;

public class HandlerTestData {

    public static UserRequest getUserRequest(){
        UserRequest userRequest = new UserRequest();
        userRequest.setNumberId("12345");
        userRequest.setTypeId("CC");
        return userRequest;
    }
}
