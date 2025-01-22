package com.bazan.backend.shared.infrastructure.services;

import com.bazan.backend.shared.aplication.abstractions.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
class ImageServiceImpl implements ImageService {
    @Override
    public String uploadImage(MultipartFile file) {
        return "";
    }
}
