package com.bazan.backend.realstate.application.properties.create;

import com.bazan.backend.realstate.application.abstractions.ImageService;
import com.bazan.backend.realstate.domain.properties.Category;
import com.bazan.backend.realstate.domain.properties.Property;
import com.bazan.backend.realstate.domain.sellers.Seller;
import com.bazan.backend.realstate.infrastructure.repositories.CategoryRepository;
import com.bazan.backend.realstate.infrastructure.repositories.PropertyRepository;
import com.bazan.backend.realstate.infrastructure.repositories.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class CreatePropertyImpl implements CreateProperty {
    private final PropertyRepository propertyRepository;
    private final SellerRepository sellerRepository;
    private final CategoryRepository categoryRepository;
    private final ImageService imageService;

    @Transactional
    @Override
    public CreatePropertyResponse create(CreatePropertyRequest request,  MultipartFile file) throws Exception {
        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new Exception("Category with given id not found"));

        Seller seller = sellerRepository.findById(request.sellerId())
                .orElseThrow(() -> new Exception("Seller with given id not found"));

        Property property = Property.create(
                request.title(),
                request.description(),
                request.price(),
                request.address(),
                request.measures(),
                imageService.uploadImage(file),
                request.type(),
                request.status(),
                category,
                seller
        );

        var propertySaved = propertyRepository.save(property);

        return new CreatePropertyResponse(
                propertySaved.getId(),
                propertySaved.getTitle(),
                propertySaved.getDescription(),
                propertySaved.getPrice(),
                propertySaved.getAddress(),
                propertySaved.getMeasures(),
                propertySaved.getImageUrl(),
                propertySaved.getType(),
                propertySaved.getStatus(),
                new CategoryResponse(
                        propertySaved.getCategory().getId(),
                        propertySaved.getCategory().getName(),
                        propertySaved.getCategory().getDescription()
                ),
                new SellerResponse(
                        propertySaved.getSeller().getId(),
                        propertySaved.getSeller().getName(),
                        propertySaved.getSeller().getEmail()
                )
        );
    }
}
