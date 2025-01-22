package com.bazan.backend.shared.aplication.abstractions;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    String uploadImage(MultipartFile file);
}
