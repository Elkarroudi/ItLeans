package com.itLens.surveyApp.services.contracts;

import com.itLens.surveyApp.models.dtos.owner.CreateOwnerDTO;
import com.itLens.surveyApp.models.dtos.owner.OwnerDTO;
import com.itLens.surveyApp.services.IGenericService;

public interface IOwnerService extends IGenericService<OwnerDTO, CreateOwnerDTO> {
}
