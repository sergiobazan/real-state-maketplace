package com.bazan.backend.users;

import com.bazan.backend.users.domain.users.User;

public interface UserApi {
    User findByEmail(String email);
}
