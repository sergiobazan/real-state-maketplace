package com.bazan.backend.realstate.application.properties.getById;

import java.util.UUID;

import com.bazan.backend.realstate.application.properties.create.CreatePropertyResponse;
import com.bazan.backend.shared.domain.abstractions.Result;

public interface GetPropertyById {
	Result<CreatePropertyResponse> getById(UUID id);
}
