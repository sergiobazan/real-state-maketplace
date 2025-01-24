package com.bazan.backend.realstate.application.properties.create;

import com.bazan.backend.realstate.application.properties.CategoryMapper;
import com.bazan.backend.realstate.application.properties.PropertyMapper;
import com.bazan.backend.realstate.domain.properties.Address;
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

import java.util.List;
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

        var imageResult = imageService.uploadImage(file);

        if (imageResult.isFailure())
            return Result.failure(imageResult.error());

        Property property = Property.create(
                request.title(),
                request.description(),
                request.price(),
                new Address(
                        request.city(),
                        request.street(),
                        request.zipCode()
                ),
                request.measures(),
                imageResult.getValue(),
                request.type(),
                request.status(),
                category.get(),
                seller.get()
        );

        var propertySaved = propertyRepository.save(property);

        var response = PropertyMapper.fromEntity(propertySaved);

        return Result.success(response);
    }

    @Override
    public Result<List<CreatePropertyResponse>> findAll() {
        return Result.success(propertyRepository.findAll().stream().map(PropertyMapper::fromEntity).toList());
    }

    @Override
    public Result<List<CategoryResponse>> findAllCategories() {
        return Result.success(categoryRepository.findAll().stream().map(CategoryMapper::fromEntity).toList());
    }
}
