package com.neoapps.userService.infrastructure.entry_points;

import com.neoapps.userService.domain.model.User;
import com.neoapps.userService.domain.usecases.AddUserUseCase;
import com.neoapps.userService.domain.usecases.DeleteUserUseCase;
import com.neoapps.userService.domain.usecases.GetUserUseCase;
import com.neoapps.userService.domain.usecases.UpdateUserUseCase;
import com.neoapps.userService.domain.usecases.dtos.CreateUserRequest;
import com.neoapps.userService.domain.usecases.dtos.UpdateUserLoginRequest;
import com.neoapps.userService.domain.usecases.dtos.UserCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final AddUserUseCase addUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserRequest createUserRequest) {
        addUserUseCase.addUser(createUserRequest);

        return ResponseEntity.created(URI.create("/api/v1/users")).build();
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(getUserUseCase.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> userOptional = getUserUseCase.getUserById(id);

        return userOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{emailAddress}")
    public ResponseEntity<User> getUserByEmailAddress(@PathVariable String emailAddress) {
        Optional<User> userOptional = getUserUseCase.getUserByEmailAddress(emailAddress);

        return userOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/credentials/{emailAddress}")
    public ResponseEntity<UserCredentials> getUserCredentialsByEmailAddress(@PathVariable String emailAddress) {
        Optional<UserCredentials> userOptional = getUserUseCase.getUserCredentialsByEmailAddress(emailAddress);
        return userOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/logins")
    public ResponseEntity<Void> updateUserLastLogin(@RequestBody UpdateUserLoginRequest request) {
        updateUserUseCase.updateUserLastLogin(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        deleteUserUseCase.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

}
