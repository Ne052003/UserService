package com.neoapps.userService.infrastructure.driven_adapters.repository;

import com.neoapps.userService.domain.gateways.UserRepositoryGateway;
import com.neoapps.userService.domain.model.User;
import com.neoapps.userService.infrastructure.driven_adapters.entities.UserEntity;
import com.neoapps.userService.infrastructure.driven_adapters.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryGateway {
    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public void addUser(User user) {
        UserEntity userEntity = userMapper.toUserEntity(user);
        userJpaRepository.save(userEntity);
    }

    @Override
    public void updateUser(User user) {
        if (user != null && user.getId() != null && user.getId() != 0) {
            userJpaRepository.save(userMapper.toUserEntity(user));
        } else {
            throw new RuntimeException("The user to update can't be null");
        }
    }

    @Override
    public Optional<User> getUserById(Long id) {
        Optional<UserEntity> userFromDB = userJpaRepository.findById(id);
        return userFromDB.isEmpty() ? Optional.empty() : userFromDB.map(userMapper::toUser);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        Optional<UserEntity> userFromDB = userJpaRepository.findByEmailAddress(email);
        return userFromDB.isEmpty() ? Optional.empty() : userFromDB.map(userMapper::toUser);
    }


    @Override
    public List<User> getAllUsers() {
        return userJpaRepository.findAll().stream().map(userMapper::toUser).toList();
    }

    @Override
    public void deleteUserById(Long id) {
        userJpaRepository.deleteById(id);
    }
}
