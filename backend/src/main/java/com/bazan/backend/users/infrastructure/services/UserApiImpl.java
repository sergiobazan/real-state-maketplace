package com.bazan.backend.users.infrastructure.services;

import com.bazan.backend.users.UserApi;
import com.bazan.backend.users.domain.users.User;
import com.bazan.backend.users.infrastructure.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class UserApiImpl implements UserApi {
    private final UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
