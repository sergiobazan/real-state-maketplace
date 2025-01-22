package com.bazan.backend.realstate.presentation;

import com.bazan.backend.realstate.application.properties.create.CreateProperty;
import com.bazan.backend.realstate.application.properties.create.CreatePropertyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/properties")
public class PropertyController {
    private final CreateProperty createProperty;

    @PostMapping
    public ResponseEntity<?> createProperty(
            @RequestParam("image")MultipartFile image,
            @ModelAttribute CreatePropertyRequest request
    ) {
        var result = createProperty.create(request, image);

        if (result.isSuccess())
            return ResponseEntity.ok(result.getValue());

        return ResponseEntity.badRequest().body(result.error());
    }
}
