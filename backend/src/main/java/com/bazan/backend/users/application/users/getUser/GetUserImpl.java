package com.bazan.backend.users.application.users.getUser;

import com.bazan.backend.shared.domain.abstractions.Result;
import com.bazan.backend.shared.infrastructure.services.JwtService;
import com.bazan.backend.users.application.users.UserMapper;
import com.bazan.backend.users.application.users.create.CreateUserResponse;
import com.bazan.backend.users.domain.users.User;
import com.bazan.backend.users.domain.users.UserErrors;
import com.bazan.backend.users.infrastructure.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetUserImpl implements GetUser {
    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Override
    public Result<CreateUserResponse> getUser(String token) {
        token = token.replace("Bearer ", "");
        String email = jwtService.getUserEmailFromToken(token);

        if (email == null) {
            return Result.failure(UserErrors.notFound);
        }

        User user = userRepository.findByEmail(email);

        return Result.success(UserMapper.fromEntity(user));
    }
}
