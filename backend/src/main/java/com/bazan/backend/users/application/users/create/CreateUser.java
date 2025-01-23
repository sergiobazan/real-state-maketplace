package com.bazan.backend.users.application.users.create;

import com.bazan.backend.shared.domain.abstractions.Result;

public interface CreateUser {
    Result<CreateUserResponse> create(CreateUserRequest request);
}
