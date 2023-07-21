package com.edwinmarrugo.userstohexagonal.infrastructure.input.rest;

import com.edwinmarrugo.userstohexagonal.application.handler.UsersHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class UserRestTest {

    @InjectMocks
    private UserRest userRest;
    @Mock
    private UsersHandler usersHandler;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userRest).build();
    }

    @Test
    void saveUser() throws Exception {
        //Given
        String userRequest = RestTestData.getUserRequest();
        //When
        //Then
        mockMvc.perform(post("/user/persistence")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userRequest))
                .andExpect(status().isCreated());
    }

    @Test
    void getUser() throws Exception {

        given(usersHandler.getUser(anyString(),anyString())).willReturn(RestTestData.getUserResponse());

        mockMvc.perform(get("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("user-number-id","12345")
                        .header("user-type-id", "CC"))
                .andExpect(status().isOk());
    }
}