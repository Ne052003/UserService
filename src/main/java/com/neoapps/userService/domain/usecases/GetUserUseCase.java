package com.neoapps.userService.domain.usecases;

import com.neoapps.userService.domain.gateways.UserRepositoryGateway;
import com.neoapps.userService.domain.model.User;
import com.neoapps.userService.domain.usecases.dtos.UserCredentials;

import java.util.List;
import java.util.Optional;

public class GetUserUseCase {
    private final UserRepositoryGateway userRepository;

    public GetUserUseCase(UserRepositoryGateway userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    public Optional<User> getUserByEmailAddress(String emailAddress) {
        return userRepository.getUserByEmail(emailAddress);
    }

    public Optional<UserCredentials> getUserCredentialsByEmailAddress(String emailAddress) {
        Optional<User> userOptional = userRepository.getUserByEmail(emailAddress);
        return userOptional.map(UserCredentials::new).or(Optional::empty);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

}
