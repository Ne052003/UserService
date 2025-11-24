package com.neoapps.userService.infrastructure.driven_adapters.repository;

import com.neoapps.userService.infrastructure.driven_adapters.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmailAddress(String email);
}
