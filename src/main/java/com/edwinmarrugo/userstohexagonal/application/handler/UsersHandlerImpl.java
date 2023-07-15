package com.edwinmarrugo.userstohexagonal.application.handler;

import com.edwinmarrugo.userstohexagonal.application.dto.UserResponse;
import com.edwinmarrugo.userstohexagonal.application.dto.UserRequest;
import com.edwinmarrugo.userstohexagonal.application.mapper.ApplicationMapper;
import com.edwinmarrugo.userstohexagonal.domain.api.UserServicePort;
import com.edwinmarrugo.userstohexagonal.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsersHandlerImpl implements UsersHandler{

    private final UserServicePort userServicePort;

    @Override
    @Transactional
    public void saveUser(UserRequest userRequest) {
        userServicePort.saveUser(ApplicationMapper.userRequestToUser(userRequest));
    }

    @Override
    public UserResponse getUser(String numberId, String typeId) {
        User user = userServicePort.getUser(typeId, numberId);
        return ApplicationMapper.toUserResponse(user);
    }

    @Override
    public String getHelloWorld() {
        return userServicePort.getHelloWorld();
    }

}
