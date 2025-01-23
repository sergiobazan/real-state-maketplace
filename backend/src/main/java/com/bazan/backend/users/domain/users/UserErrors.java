package com.bazan.backend.users.domain.users;

import com.bazan.backend.shared.domain.abstractions.Error;

public class UserErrors {
    public static final Error notFound = new Error(
            "Users.NotFound",
            "User with given Id not Found"
    );

    public static final Error roleNotFound = new Error(
            "Roles.NotFound",
            "Role with given name not found"
    );
}
