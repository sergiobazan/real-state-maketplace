package com.bazan.backend.users.presentation;

import com.bazan.backend.users.application.users.create.CreateUser;
import com.bazan.backend.users.application.users.create.CreateUserRequest;
import com.bazan.backend.users.application.users.login.LoginRequest;
import com.bazan.backend.users.application.users.login.LoginUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class AuthController {
    private final LoginUser loginUser;
    private final CreateUser createUser;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        var result = loginUser.login(loginRequest);

        if (result.isFailure())
            return ResponseEntity.badRequest().body(result.error());

        return ResponseEntity.ok().body(result.getValue());
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody CreateUserRequest userRequest) {
        var result = createUser.create(userRequest);

        if (result.isFailure())
            return ResponseEntity.badRequest().body(result.error());

        return ResponseEntity.ok().body(result.getValue());
    }
}
