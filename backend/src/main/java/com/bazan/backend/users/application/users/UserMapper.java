package com.bazan.backend.users.application.users;

import com.bazan.backend.users.application.users.create.CreateUserResponse;
import com.bazan.backend.users.domain.users.User;

public class UserMapper {
    public static CreateUserResponse fromEntity(User user) {
        return new CreateUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
