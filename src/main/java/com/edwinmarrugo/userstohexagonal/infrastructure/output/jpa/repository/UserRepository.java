package com.edwinmarrugo.userstohexagonal.infrastructure.output.jpa.repository;

import com.edwinmarrugo.userstohexagonal.infrastructure.output.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    Optional<UserEntity> findByTypeIdAndNumberId(String typeId, String numberId);
}
