package com.edwinmarrugo.userstohexagonal.infrastructure.output.jpa.adapter;

import com.edwinmarrugo.userstohexagonal.domain.model.User;
import com.edwinmarrugo.userstohexagonal.infrastructure.output.jpa.entity.UserEntity;
import com.edwinmarrugo.userstohexagonal.infrastructure.output.jpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserPersistenceAdapterTest {
    @InjectMocks
    private UserPersistenceAdapter userPersistenceAdapter;
    @Mock
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        User user = JpaAdapterTestData.getUser();

        userPersistenceAdapter.saveUser(user);

        verify(userRepository, times(1)).save(any());
    }

    @Test
    public void testGetUser_UserFound() {
        String numberId = "12345";
        String typeId = "passport";

        UserEntity userEntity = JpaAdapterTestData.getUserEntity();

        when(userRepository.findByTypeIdAndNumberId(typeId, numberId)).thenReturn(Optional.of(userEntity));

        User expectedUser = JpaAdapterTestData.getUser();

        User actualUser = userPersistenceAdapter.getUser(typeId, numberId);

        assertEquals(expectedUser.getNumberId(), actualUser.getNumberId());
        assertEquals(expectedUser.getTypeId(), actualUser.getTypeId());
    }

    @Test
    public void testGetUser_UserNotFound() {
        String numberId = JpaAdapterTestData.numberId;
        String typeId = JpaAdapterTestData.typeId;

        when(userRepository.findByTypeIdAndNumberId(typeId, numberId)).thenReturn(Optional.empty());

        User actualUser = userPersistenceAdapter.getUser(typeId, numberId);

        assertNull(actualUser);
    }
}
