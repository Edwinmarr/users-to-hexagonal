package com.edwinmarrugo.userstohexagonal.domain.api;

import com.edwinmarrugo.userstohexagonal.domain.model.User;

public interface UserServicePort {
    void saveUser(User user);
    User getUser(String typeId, String numberId);
    String getHelloWorld();

}
