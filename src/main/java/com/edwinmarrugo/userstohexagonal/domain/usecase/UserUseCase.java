package com.edwinmarrugo.userstohexagonal.domain.usecase;

import com.edwinmarrugo.userstohexagonal.domain.api.UserServicePort;
import com.edwinmarrugo.userstohexagonal.domain.model.User;
import com.edwinmarrugo.userstohexagonal.domain.spi.UserPersistencePort;

public class UserUseCase implements UserServicePort {

    private final UserPersistencePort userPersistencePort;


    public UserUseCase(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveUser(User user) {
        userPersistencePort.saveUser(user);
    }

    @Override
    public User getUser(String typeId, String numberId) {
        return userPersistencePort.getUser(typeId,numberId);
    }


}
