package com.bazan.backend.users.application.users.create;

import com.bazan.backend.shared.domain.abstractions.Result;
import com.bazan.backend.users.application.abstractions.contracts.UserCreatedEvent;
import com.bazan.backend.users.application.users.UserMapper;
import com.bazan.backend.users.domain.users.Role;
import com.bazan.backend.users.domain.users.User;
import com.bazan.backend.users.domain.users.UserErrors;
import com.bazan.backend.users.infrastructure.repositories.RoleRepository;
import com.bazan.backend.users.infrastructure.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CreateUserImpl implements CreateUser {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ApplicationEventPublisher publisher;

    @Override
    @Transactional
    public Result<CreateUserResponse> create(CreateUserRequest request) {
        Optional<Role> role = roleRepository.findByName(request.role());
        Role defaultRole = roleRepository.defaultRole();

        if (role.isEmpty())
            return Result.failure(UserErrors.roleNotFound);

        User user = User.create(
                request.username(),
                request.email(),
                request.password(),
                List.of(
                        defaultRole,
                        role.get()
                        )
        );

        var userCreated = userRepository.save(user);

        CreateUserResponse userResponse = UserMapper.fromEntity(userCreated);

        publisher.publishEvent(new UserCreatedEvent(
                userCreated.getId(),
                userCreated.getUsername(),
                userCreated.getEmail(),
                role.get().getName()
        ));

        return Result.success(userResponse);
    }
}
