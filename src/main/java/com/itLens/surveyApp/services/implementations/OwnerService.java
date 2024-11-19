package com.itLens.surveyApp.services.implementations;

import com.itLens.surveyApp.models.dtos.owner.CreateOwnerDTO;
import com.itLens.surveyApp.models.dtos.owner.OwnerDTO;
import com.itLens.surveyApp.models.dtos.owner.OwnerResponseDTO;
import com.itLens.surveyApp.models.entities.Owner;
import com.itLens.surveyApp.models.mappers.contracts.OwnerMapper;
import com.itLens.surveyApp.repositories.OwnerRepository;
import com.itLens.surveyApp.services.contracts.IOwnerService;
import com.itLens.surveyApp.utils.responseEntities.ApiResponse;
import com.itLens.surveyApp.utils.responseEntities.ErrorApi;
import com.itLens.surveyApp.utils.responseEntities.SuccessApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@Validated
public class OwnerService implements IOwnerService {

    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;


    @Override
    public ApiResponse findAll() {
        List<OwnerResponseDTO> owners = ownerRepository.findAll()
                .stream()
                .map(ownerMapper::toResponseDtoFromEntityWithAllRelationShips)
                .toList();

        return new SuccessApi<>(200, owners);
    }

    @Override
    public ApiResponse findById(String id) {
        Map<String, String> errors = new HashMap<>();
        OwnerResponseDTO owner = ownerMapper.toResponseDtoFromEntityWithAllRelationShips(
                ownerRepository.findById(id).orElse(null)
        );

        if (owner == null) {
            errors.put("owner", "Owner Does Not Exists WIth This Id");
            return new ErrorApi(404, errors);
        }
        return new SuccessApi<>(200, owner);
    }

    @Override
    public ApiResponse save(CreateOwnerDTO createOwnerDTO) {
        Owner owner = ownerRepository.save(
                ownerMapper.toEntityFromCreateDto(createOwnerDTO)
        );

        OwnerResponseDTO newOwner = ownerMapper.toResponseDtoFromEntityWithAllRelationShips(owner);
        return new SuccessApi<OwnerResponseDTO>(201, newOwner);
    }

    @Override
    public ApiResponse update(String id, OwnerDTO ownerDTO) {
        Owner owner = ownerRepository.findById(id).orElse(null);
        owner.setName(ownerDTO.name());

        OwnerResponseDTO updatedOwner = ownerMapper.toResponseDtoFromEntityWithAllRelationShips(
                ownerRepository.save(owner)
        );

        return new SuccessApi<>(200, updatedOwner);
    }

    @Override
    public ApiResponse delete(String id) {
        Map<String, String> errors = new HashMap<>();
        Owner owner = ownerRepository.findById(id).orElse(null);
        if (owner == null) {
            errors.put("owner", "Owner Does Not Exists WIth This Id");
            return new ErrorApi(404, errors);
        }

        ownerRepository.delete(owner);
        return new SuccessApi<>(200, "Owner deleted successfully");
    }
}
