package com.bazan.backend.realstate.application.properties.getById;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.bazan.backend.realstate.application.properties.PropertyMapper;
import com.bazan.backend.realstate.application.properties.create.CreatePropertyResponse;
import com.bazan.backend.realstate.domain.properties.Property;
import com.bazan.backend.realstate.domain.properties.PropertyErrors;
import com.bazan.backend.realstate.infrastructure.repositories.PropertyRepository;
import com.bazan.backend.shared.domain.abstractions.Result;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
class GetPropertyByIdImpl implements GetPropertyById {
	private final PropertyRepository propertyRepository;
	
	@Override
	public Result<CreatePropertyResponse> getById(UUID id) {
		Optional<Property> property = propertyRepository.findById(id);
		
		if (property.isEmpty()) {
			return Result.failure(PropertyErrors.notfound);
		}
		
		return Result.success(PropertyMapper.fromEntity(property.get()));
	}
}
