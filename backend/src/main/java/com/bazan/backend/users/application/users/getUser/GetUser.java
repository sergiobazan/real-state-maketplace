package com.bazan.backend.users.application.users.getUser;

import com.bazan.backend.shared.domain.abstractions.Result;
import com.bazan.backend.users.application.users.create.CreateUserResponse;

public interface GetUser {
    Result<CreateUserResponse> getUser(String token);
}
