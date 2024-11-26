package com.reinertisa.cts.service;

import com.reinertisa.cts.exception.ResourceNotFoundException;
import com.reinertisa.cts.model.CompanyDto;
import com.reinertisa.cts.model.CompanyRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface CompanyService {

    List<CompanyDto> getAllCompanies();

    CompanyDto getCompanyById(Integer companyId) throws ResourceNotFoundException;

    void createCompany(@Valid CompanyRequest companyRequest);

    void updateCompany(Integer companyId, @Valid CompanyRequest companyRequest) throws ResourceNotFoundException;

    void deleteCompany(Integer companyId) throws ResourceNotFoundException;
}
