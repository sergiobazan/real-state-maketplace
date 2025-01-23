package com.bazan.backend.shared.aplication.abstractions;

import com.bazan.backend.shared.domain.abstractions.Result;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    Result<String> uploadImage(MultipartFile file);
}
