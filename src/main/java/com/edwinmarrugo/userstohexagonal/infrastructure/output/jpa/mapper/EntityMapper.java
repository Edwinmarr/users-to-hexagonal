package com.edwinmarrugo.userstohexagonal.infrastructure.output.jpa.mapper;

import com.edwinmarrugo.userstohexagonal.domain.model.User;
import com.edwinmarrugo.userstohexagonal.infrastructure.output.jpa.entity.UserEntity;

public class EntityMapper {
    private EntityMapper() {
    }

    public static UserEntity userToUserEntity(User user){
        return UserEntity.builder()
                .name(user.getName())
                .typeId(user.getTypeId())
                .numberId(user.getNumberId())
                .build();
    }
    public static User userEntityToUser(UserEntity userEntity){
        User user = new User();
        user.setName(userEntity.getName());
        user.setTypeId(userEntity.getTypeId());
        user.setNumberId(userEntity.getNumberId());
        return user;
    }
}
