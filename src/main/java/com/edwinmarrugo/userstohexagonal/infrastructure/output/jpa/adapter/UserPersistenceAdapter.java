package com.edwinmarrugo.userstohexagonal.infrastructure.output.jpa.adapter;

import com.edwinmarrugo.userstohexagonal.domain.model.User;
import com.edwinmarrugo.userstohexagonal.domain.spi.UserPersistencePort;
import com.edwinmarrugo.userstohexagonal.infrastructure.output.jpa.entity.UserEntity;
import com.edwinmarrugo.userstohexagonal.infrastructure.output.jpa.mapper.EntityMapper;
import com.edwinmarrugo.userstohexagonal.infrastructure.output.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    private final UserRepository userRepository;
    @Override
    public void saveUser(User user) {
        userRepository.save(EntityMapper.userToUserEntity(user));
    }

    @Override
    public User getUser(String typeId, String numberId) {
        Optional<UserEntity> userEntity = userRepository.findByTypeIdAndNumberId(typeId, numberId);
        return userEntity.map(EntityMapper::userEntityToUser).orElse(null);
    }
}
