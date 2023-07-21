package com.edwinmarrugo.userstohexagonal.application.handler;

import com.edwinmarrugo.userstohexagonal.application.dto.UserRequest;
import com.edwinmarrugo.userstohexagonal.application.dto.UserResponse;
import com.edwinmarrugo.userstohexagonal.domain.api.UserServicePort;
import com.edwinmarrugo.userstohexagonal.domain.model.User;
import com.edwinmarrugo.userstohexagonal.infrastructure.input.rest.RestTestData;
import com.edwinmarrugo.userstohexagonal.infrastructure.output.jpa.adapter.JpaAdapterTestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsersHandlerImplTest {

    @InjectMocks
    private UsersHandlerImpl usersHandler;
    @Mock
    private UserServicePort userServicePort;


    @Test
    public void testSaveUser() {
        UserRequest userRequest = HandlerTestData.getUserRequest();

        usersHandler.saveUser(userRequest);

        verify(userServicePort, times(1)).saveUser(any());
    }

    @Test
    public void testGetUser() {
        String numberId = "12345";
        String typeId = "CC";

        User user = JpaAdapterTestData.getUser();

        given(userServicePort.getUser(typeId, numberId)).willReturn(user);

        UserResponse expectedResponse = RestTestData.getUserResponse();

        UserResponse actualResponse = usersHandler.getUser(numberId, typeId);

        assertEquals(expectedResponse.getNumberId(), actualResponse.getNumberId());
        assertEquals(expectedResponse.getTypeId(), actualResponse.getTypeId());
    }
}
