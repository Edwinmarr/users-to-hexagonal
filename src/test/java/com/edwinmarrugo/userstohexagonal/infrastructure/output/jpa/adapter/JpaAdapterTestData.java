package com.edwinmarrugo.userstohexagonal.infrastructure.output.jpa.adapter;

import com.edwinmarrugo.userstohexagonal.domain.model.User;
import com.edwinmarrugo.userstohexagonal.infrastructure.output.jpa.entity.UserEntity;

public class JpaAdapterTestData {
    public static String numberId = "12345";
    public static String typeId = "CC";

    public static User getUser(){
        User user = new User();
        user.setNumberId(numberId);
        user.setTypeId(typeId);
        return user;
    }

    public static UserEntity getUserEntity(){
        UserEntity userEntity = new UserEntity();
        userEntity.setNumberId(numberId);
        userEntity.setTypeId(typeId);
        return userEntity;
    }

}
