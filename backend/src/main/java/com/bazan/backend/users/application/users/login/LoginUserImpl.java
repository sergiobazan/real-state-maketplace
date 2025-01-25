package com.bazan.backend.users.application.users.login;

import com.bazan.backend.shared.domain.abstractions.Error;
import com.bazan.backend.shared.domain.abstractions.Result;
import com.bazan.backend.shared.infrastructure.services.JwtService;
import com.bazan.backend.users.infrastructure.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginUserImpl implements LoginUser {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public Result<String> login(LoginRequest request) {
        var user = userRepository.findByEmail(request.email());

        if (user == null) {
            return Result.failure(new Error("Auth.Login", "Invalid Credentials"));
        }

        if (!encoder.matches(request.password(), user.getPassword())) {
            return Result.failure(new Error("Auth.Login", "Invalid Credentials"));
        }

        String token = jwtService.generateToken(user);

        return Result.success(token);
    }
}
