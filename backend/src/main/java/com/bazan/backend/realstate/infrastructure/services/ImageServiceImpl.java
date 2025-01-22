package com.bazan.backend.realstate.infrastructure.services;

import com.bazan.backend.realstate.application.abstractions.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
class ImageServiceImpl implements ImageService {
    @Override
    public String uploadImage(MultipartFile file) {
        return "";
    }
}
