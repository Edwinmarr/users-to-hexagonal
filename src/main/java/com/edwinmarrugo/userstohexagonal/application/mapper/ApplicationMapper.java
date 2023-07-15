package com.edwinmarrugo.userstohexagonal.application.mapper;

import com.edwinmarrugo.userstohexagonal.application.dto.UserResponse;
import com.edwinmarrugo.userstohexagonal.application.dto.UserRequest;
import com.edwinmarrugo.userstohexagonal.domain.model.User;

public class ApplicationMapper {
    private ApplicationMapper(){}
    public static User userRequestToUser(UserRequest userRequest){
        User user = new User();
        user.setName(userRequest.getName());
        user.setNumberId(userRequest.getNumberId());
        user.setTypeId(userRequest.getTypeId());
        return user;
    }

    public static UserResponse toUserResponse(User user){
        return UserResponse.builder()
                .typeId(user.getTypeId())
                .numberId(user.getNumberId())
                .name(user.getName())
                .build();
    }

}
