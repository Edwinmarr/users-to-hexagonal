package com.edwinmarrugo.userstohexagonal.domain.usecase;

import com.edwinmarrugo.userstohexagonal.domain.api.UserServicePort;
import com.edwinmarrugo.userstohexagonal.domain.model.User;
import com.edwinmarrugo.userstohexagonal.domain.spi.ExternalServicePort;
import com.edwinmarrugo.userstohexagonal.domain.spi.UserPersistencePort;

public class UserUseCase implements UserServicePort {

    private final UserPersistencePort userPersistencePort;
    private final ExternalServicePort externalServicePort;


    public UserUseCase(UserPersistencePort userPersistencePort, ExternalServicePort externalServicePort) {
        this.userPersistencePort = userPersistencePort;
        this.externalServicePort = externalServicePort;
    }

    @Override
    public void saveUser(User user) {
        userPersistencePort.saveUser(user);
    }

    @Override
    public User getUser(String typeId, String numberId) {
        return userPersistencePort.getUser(typeId,numberId);
    }

    @Override
    public String getHelloWorld() {
        return externalServicePort.getHelloWorld();
    }

}
