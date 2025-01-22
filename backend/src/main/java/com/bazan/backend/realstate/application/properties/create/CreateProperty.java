package com.bazan.backend.realstate.application.properties.create;

import com.bazan.backend.shared.domain.abstractions.Result;
import org.springframework.web.multipart.MultipartFile;

public interface CreateProperty {
    Result<CreatePropertyResponse> create(CreatePropertyRequest request, MultipartFile file);
}
