package com.bazan.backend.users.application.users.login;

import com.bazan.backend.shared.domain.abstractions.Result;

public interface LoginUser {
    Result<LoginResponse> login(LoginRequest request);
}
