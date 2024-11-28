package com.reinertisa.cts.service;

import com.reinertisa.cts.exception.ResourceNotFoundException;
import com.reinertisa.cts.model.TechStackDto;
import com.reinertisa.cts.model.TechStackRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface TechStackService {

    List<TechStackDto> getAllTechStacks();

    TechStackDto getTechStackById(Long id) throws ResourceNotFoundException;

    TechStackDto getTechStackByName(String name) throws ResourceNotFoundException;

    void createTechStack(@Valid TechStackRequest techStackRequest);

    void updateTechStack(Long id, @Valid TechStackRequest techStackRequest) throws ResourceNotFoundException;

    void deleteTechStack(Long id) throws ResourceNotFoundException;
}
