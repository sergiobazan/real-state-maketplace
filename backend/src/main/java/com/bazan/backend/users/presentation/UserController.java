package com.bazan.backend.users.presentation;

import com.bazan.backend.users.application.users.create.CreateUser;
import com.bazan.backend.users.application.users.create.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUser createUser;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest createUserRequest) {
        var result = createUser.create(createUserRequest);

        if (result.isFailure()) {
            return ResponseEntity.badRequest().body(result.error());
        }

        return ResponseEntity.ok(result.getValue());
    }
}
