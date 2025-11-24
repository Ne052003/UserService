package com.neoapps.userService.domain.gateways;

import com.neoapps.userService.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryGateway {

    void addUser(User user);

    void updateUser(User user);

    Optional<User> getUserById(Long id);

    Optional<User> getUserByEmail(String email);

    void deleteUserById(Long id);

    List<User> getAllUsers();

}
