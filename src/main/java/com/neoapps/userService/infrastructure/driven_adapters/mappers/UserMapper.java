package com.neoapps.userService.infrastructure.driven_adapters.mappers;

import com.neoapps.userService.domain.model.Permission;
import com.neoapps.userService.domain.model.Role;
import com.neoapps.userService.domain.model.User;
import com.neoapps.userService.infrastructure.driven_adapters.entities.RoleEntity;
import com.neoapps.userService.infrastructure.driven_adapters.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User toUser(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setEmailAddress(userEntity.getEmailAddress());
        user.setPassword(userEntity.getPassword());

        RoleEntity role = userEntity.getRole();
        Set<Permission> permissions = role.getPermissions().stream().map(permissionEntity -> {
            Permission permission = new Permission();
            permission.setId(permissionEntity.getId());
            permission.setName(permissionEntity.getName());
            return permission;
        }).collect(Collectors.toSet());
        user.setRole(new Role(role.getId(), role.getName(), permissions));

        user.setCreatedAt(userEntity.getCreatedAt());
        user.setLastLogin(userEntity.getLastLogin());
        return user;
    }

    public UserEntity toUserEntity(User user) {
        UserEntity userEntity = new UserEntity();

        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setEmailAddress(user.getEmailAddress());
        userEntity.setPassword(user.getPassword());
        userEntity.setCreatedAt(user.getCreatedAt());
        userEntity.setLastLogin(user.getLastLogin());

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(user.getRole().getId());
        userEntity.setRole(roleEntity);

        return userEntity;
    }
}
