package com.edwinmarrugo.userstohexagonal.application.handler;

import com.edwinmarrugo.userstohexagonal.application.dto.UserRequest;
import com.edwinmarrugo.userstohexagonal.application.dto.UserResponse;

public interface UsersHandler {
    void saveUser(UserRequest userRequest);
    UserResponse getUser(String numberId, String typeId);
}
