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

import java.util.List;

@Service
@AllArgsConstructor
public class OwnerService implements IOwnerService {

    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;


    @Override
    public ApiResponse findAll() {
        List<OwnerResponseDTO> owners = ownerRepository.findAll()
                .stream()
                .map(ownerMapper::toResponseDtoFromEntity)
                .toList();

        return new SuccessApi<>(200, owners);
    }

    @Override
    public ApiResponse findById(String id) {
        OwnerResponseDTO owner = ownerMapper.toResponseDtoFromEntity(
                ownerRepository.findById(id).orElse(null)
        );

        if (owner == null) { return new ErrorApi(404, new String[]{"Owner not found"}); }
        return new SuccessApi<>(200, owner);
    }

    @Override
    public ApiResponse save(CreateOwnerDTO createOwnerDTO) {
        OwnerResponseDTO owner = ownerMapper.toResponseDtoFromEntity(
                    ownerRepository.save(
                            ownerMapper.toEntityFromCreateDto(createOwnerDTO)
                    )
                );

        return new SuccessApi<>(201, owner);
    }

    @Override
    public ApiResponse update(OwnerDTO ownerDTO) {
        return null;
    }

    @Override
    public ApiResponse delete(String id) {
        Owner owner = ownerRepository.findById(id).orElse(null);
        if (owner == null) { return new ErrorApi(404, new String[]{"Owner not found"}); }

        ownerRepository.delete(owner);
        return new SuccessApi<>(200, "Owner deleted successfully");
    }
}
