package com.neoapps.userService.domain.usecases;

import com.neoapps.userService.domain.gateways.UserRepositoryGateway;
import com.neoapps.userService.domain.model.User;
import com.neoapps.userService.domain.usecases.dtos.UpdateUserLoginRequest;

import java.util.Optional;

public class UpdateUserUseCase {

    private final UserRepositoryGateway userRepository;

    public UpdateUserUseCase(UserRepositoryGateway userRepository) {
        this.userRepository = userRepository;
    }

    public void updateUserLastLogin(UpdateUserLoginRequest request) {

        if (request == null) throw new RuntimeException("User to update can't be null");
        Optional<User> userDbOptional = userRepository.getUserByEmail(request.getEmail());

        if (userDbOptional.isEmpty()) {
            throw new RuntimeException("The user to update with emailAddress " + request.getEmail() + " was not found in the database");
        }

        User user = userDbOptional.get();
        user.setLastLogin(request.getLastLogin());

        userRepository.updateUser(user);
    }
}
