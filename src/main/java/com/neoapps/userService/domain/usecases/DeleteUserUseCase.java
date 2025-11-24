package com.neoapps.userService.domain.usecases;

import com.neoapps.userService.domain.gateways.UserRepositoryGateway;

public class DeleteUserUseCase {

    private final UserRepositoryGateway userRepository;

    public DeleteUserUseCase(UserRepositoryGateway userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteUserById(Long id) {
        userRepository.deleteUserById(id);
    }
}
