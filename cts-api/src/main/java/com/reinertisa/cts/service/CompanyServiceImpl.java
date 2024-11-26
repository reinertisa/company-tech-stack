package com.reinertisa.cts.service;

import com.reinertisa.cts.exception.ResourceNotFoundException;
import com.reinertisa.cts.model.CompanyDto;
import com.reinertisa.cts.model.CompanyRequest;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {
    @Override
    public List<CompanyDto> getAllCompanies() {
        return List.of();
    }

    @Override
    public CompanyDto getCompanyById(Integer companyId) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public void createCompany(CompanyRequest companyRequest) {

    }

    @Override
    public void updateCompany(Integer companyId, CompanyRequest companyRequest) throws ResourceNotFoundException {

    }

    @Override
    public void deleteCompany(Integer companyId) throws ResourceNotFoundException {

    }
}
