package com.itLens.surveyApp;
import com.itLens.surveyApp.models.dtos.owner.CreateOwnerDTO;
import com.itLens.surveyApp.models.dtos.owner.OwnerDTO;
import com.itLens.surveyApp.models.dtos.owner.OwnerResponseDTO;
import com.itLens.surveyApp.models.dtos.survey.SurveyDTO;
import com.itLens.surveyApp.models.entities.Owner;
import com.itLens.surveyApp.models.mappers.contracts.OwnerMapper;
import com.itLens.surveyApp.repositories.OwnerRepository;
import com.itLens.surveyApp.services.implementations.OwnerService;
import com.itLens.surveyApp.utils.responseEntities.ApiResponse;
import com.itLens.surveyApp.utils.responseEntities.ErrorApi;
import com.itLens.surveyApp.utils.responseEntities.SuccessApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OwnerServiceTest {

    @Mock
    private OwnerRepository ownerRepository;

    @Mock
    private OwnerMapper ownerMapper;

    @InjectMocks
    private OwnerService ownerService;

    private Owner owner;
    private OwnerResponseDTO ownerResponseDTO;
    private CreateOwnerDTO createOwnerDTO;
    private OwnerDTO ownerDTO;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        owner.setId("123");
        owner.setId("John Doe");

        List<SurveyDTO> surveys = List.of(
                new SurveyDTO("survey1", "Customer Satisfaction Survey", "This is a survey to measure customer satisfaction"),
                new SurveyDTO("survey2", "Product Feedback Survey", "lorem ipsum")
        );
        OwnerResponseDTO ownerResponseDTO = new OwnerResponseDTO("123", "John Doe", surveys);
        CreateOwnerDTO createOwnerDTO = new CreateOwnerDTO("John Doe");
        OwnerDTO ownerDTO = new OwnerDTO("123", "John Doe Updated");
    }

    @Test
    void testFindAll() {
        when(ownerRepository.findAll()).thenReturn(List.of(owner));
        when(ownerMapper.toResponseDtoFromEntityWithAllRelationShips(owner)).thenReturn(ownerResponseDTO);

        ApiResponse response = ownerService.findAll();

        assertInstanceOf(SuccessApi.class, response);
        assertEquals(List.of(ownerResponseDTO), ((SuccessApi<?>) response).getData());

        verify(ownerRepository, times(1)).findAll();
        verify(ownerMapper, times(1)).toResponseDtoFromEntityWithAllRelationShips(owner);
    }

    @Test
    void testFindByIdFound() {
        when(ownerRepository.findById("123")).thenReturn(Optional.of(owner));
        when(ownerMapper.toResponseDtoFromEntityWithAllRelationShips(owner)).thenReturn(ownerResponseDTO);

        ApiResponse response = ownerService.findById("123");

        assertInstanceOf(SuccessApi.class, response);
        assertEquals(ownerResponseDTO, ((SuccessApi<?>) response).getData());

        verify(ownerRepository, times(1)).findById("123");
        verify(ownerMapper, times(1)).toResponseDtoFromEntityWithAllRelationShips(owner);
    }

    @Test
    void testFindByIdNotFound() {
        when(ownerRepository.findById("123")).thenReturn(Optional.empty());

        ApiResponse response = ownerService.findById("123");

        assertInstanceOf(ErrorApi.class, response);

        verify(ownerRepository, times(1)).findById("123");
        verify(ownerMapper, never()).toResponseDtoFromEntityWithAllRelationShips(any());
    }

    @Test
    void testSave() {
        when(ownerMapper.toEntityFromCreateDto(createOwnerDTO)).thenReturn(owner);
        when(ownerRepository.save(owner)).thenReturn(owner);
        when(ownerMapper.toResponseDtoFromEntityWithAllRelationShips(owner)).thenReturn(ownerResponseDTO);

        ApiResponse response = ownerService.save(createOwnerDTO);

        assertInstanceOf(SuccessApi.class, response);
        assertEquals(ownerResponseDTO, ((SuccessApi<?>) response).getData());

        verify(ownerMapper, times(1)).toEntityFromCreateDto(createOwnerDTO);
        verify(ownerRepository, times(1)).save(owner);
        verify(ownerMapper, times(1)).toResponseDtoFromEntityWithAllRelationShips(owner);
    }

    @Test
    void testUpdateFound() {
        when(ownerRepository.findById("123")).thenReturn(Optional.of(owner));
        when(ownerMapper.updateEntityFromDto(ownerDTO, owner)).thenReturn(owner);
        when(ownerRepository.save(owner)).thenReturn(owner);
        when(ownerMapper.toResponseDtoFromEntityWithAllRelationShips(owner)).thenReturn(ownerResponseDTO);

        ApiResponse response = ownerService.update("123", ownerDTO);

        assertInstanceOf(SuccessApi.class, response);
        assertEquals(ownerResponseDTO, ((SuccessApi<?>) response).getData());

        verify(ownerRepository, times(1)).findById("123");
        verify(ownerMapper, times(1)).updateEntityFromDto(ownerDTO, owner);
        verify(ownerRepository, times(1)).save(owner);
        verify(ownerMapper, times(1)).toResponseDtoFromEntityWithAllRelationShips(owner);
    }

    @Test
    void testDeleteFound() {
        when(ownerRepository.findById("123")).thenReturn(Optional.of(owner));

        ApiResponse response = ownerService.delete("123");

        assertInstanceOf(SuccessApi.class, response);
        assertEquals("Owner deleted successfully", ((SuccessApi<?>) response).getData());

        verify(ownerRepository, times(1)).findById("123");
        verify(ownerRepository, times(1)).delete(owner);
    }

    @Test
    void testDeleteNotFound() {
        when(ownerRepository.findById("123")).thenReturn(Optional.empty());

        ApiResponse response = ownerService.delete("123");

        assertInstanceOf(ErrorApi.class, response);

        verify(ownerRepository, times(1)).findById("123");
        verify(ownerRepository, never()).delete(any());
    }

}
