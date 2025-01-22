package com.bazan.backend.realstate.application.properties.create;

import com.bazan.backend.realstate.domain.properties.PropertyErrors;
import com.bazan.backend.realstate.domain.sellers.SellerErrors;
import com.bazan.backend.shared.aplication.abstractions.ImageService;
import com.bazan.backend.realstate.domain.properties.Category;
import com.bazan.backend.realstate.domain.properties.Property;
import com.bazan.backend.realstate.domain.sellers.Seller;
import com.bazan.backend.realstate.infrastructure.repositories.CategoryRepository;
import com.bazan.backend.realstate.infrastructure.repositories.PropertyRepository;
import com.bazan.backend.realstate.infrastructure.repositories.SellerRepository;
import com.bazan.backend.shared.domain.abstractions.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CreatePropertyImpl implements CreateProperty {
    private final PropertyRepository propertyRepository;
    private final SellerRepository sellerRepository;
    private final CategoryRepository categoryRepository;
    private final ImageService imageService;

    @Transactional
    @Override
    public Result<CreatePropertyResponse> create(CreatePropertyRequest request, MultipartFile file) {
        Optional<Category> category = categoryRepository.findById(request.categoryId());

        if (category.isEmpty()) {
            return Result.failure(PropertyErrors.categoryNotfound);
        }

        Optional<Seller> seller = sellerRepository.findById(request.sellerId());

        if (seller.isEmpty()) {
            return Result.failure(SellerErrors.notFound);
        }

        Property property = Property.create(
                request.title(),
                request.description(),
                request.price(),
                request.address(),
                request.measures(),
                imageService.uploadImage(file),
                request.type(),
                request.status(),
                category.get(),
                seller.get()
        );

        var propertySaved = propertyRepository.save(property);

        var response = new CreatePropertyResponse(
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

        return Result.success(response);
    }
}
