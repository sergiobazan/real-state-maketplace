package com.bazan.backend.realstate.application.properties.create;

import com.bazan.backend.shared.domain.abstractions.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CreateProperty {
    Result<CreatePropertyResponse> create(CreatePropertyRequest request, MultipartFile file);
    Result<List<CreatePropertyResponse>> findAll();
    Result<List<CategoryResponse>> findAllCategories();
}
