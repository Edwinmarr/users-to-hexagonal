package com.edwinmarrugo.userstohexagonal.domain.usecase;

import com.edwinmarrugo.userstohexagonal.domain.model.User;
import com.edwinmarrugo.userstohexagonal.domain.spi.UserPersistencePort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserUseCaseTest {

    @InjectMocks
    private UserUseCase userUseCase;
    @Mock
    private UserPersistencePort userPersistencePort;
    @Test
    @DisplayName("ItShouldSaveAnUserInTheDatabase")
    void saveUser() {
        //Given a new user
        User user = TestData.getUser();
        //When
        userUseCase.saveUser(user);
        //Then
        verify(userPersistencePort).saveUser(user);

    }

    @Test
    void getUser() {
        //Given
        User expected = TestData.getUser();
        given(userPersistencePort.getUser(any(),any())).willReturn(expected);
        //When
        User result = userUseCase.getUser("CC", "12345");
        //Then
        assertThat(result.getName()).isEqualTo(expected.getName());
        assertThat(result.getNumberId()).isEqualTo(expected.getNumberId());
        assertThat(result.getTypeId()).isEqualTo(expected.getTypeId());

    }

}