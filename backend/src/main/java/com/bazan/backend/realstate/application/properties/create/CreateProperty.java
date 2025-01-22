package com.bazan.backend.realstate.application.properties.create;

import org.springframework.web.multipart.MultipartFile;

public interface CreateProperty {
    CreatePropertyResponse create(CreatePropertyRequest request, MultipartFile file) throws Exception;
}
