package com.edwinmarrugo.userstohexagonal.infrastructure.input.rest;

import com.edwinmarrugo.userstohexagonal.application.dto.UserResponse;

public class RestTestData {

    public static String getUserRequest(){
        String userString = "{\"typeId\" : \"CC\", \"numberId\" : \"12345\", \"name\" : \"Edwin\"}";
        return userString;
    }
    public static UserResponse getUserResponse(){
        return UserResponse.builder()
                .name("Edwin")
                .numberId("12345")
                .typeId("CC")
                .build();
    }
}
