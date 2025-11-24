package com.neoapps.userService.domain.usecases;

import com.neoapps.userService.domain.gateways.UserRepositoryGateway;
import com.neoapps.userService.domain.model.User;
import com.neoapps.userService.domain.usecases.dtos.CreateUserRequest;

import java.time.LocalDateTime;

public class AddUserUseCase {
    private final UserRepositoryGateway userRepository;

    public AddUserUseCase(UserRepositoryGateway userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(CreateUserRequest createUserRequest) {
        if (createUserRequest == null) {
            throw new RuntimeException("The request to create a user can't be null");
        }
        User user = new User();
        user.setName(createUserRequest.getName());
        user.setEmailAddress(createUserRequest.getEmailAddress());
        user.setPassword(createUserRequest.getPassword());
        user.setRole(createUserRequest.getRole());
        user.setCreatedAt(LocalDateTime.now());
        userRepository.addUser(user);
    }
}
