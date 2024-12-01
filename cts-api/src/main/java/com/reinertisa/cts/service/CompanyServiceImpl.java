package com.reinertisa.cts.service;

import com.reinertisa.cts.exception.ResourceNotFoundException;
import com.reinertisa.cts.model.*;
import com.reinertisa.cts.repository.CompanyRepository;
import com.reinertisa.cts.repository.TechStackRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final TechStackRepository techStackRepository;
    private final CompanyMapper companyMapper;

    @Override
    public List<CompanyDto> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream()
                .map(companyMapper)
                .toList();
    }

    @Override
    public CompanyDto getCompanyByName(String name) throws ResourceNotFoundException {
        Objects.requireNonNull(name, "Company name must not be null.");
        return companyRepository
                .findByName(name)
                .map(companyMapper)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found for this name: " + name));
    }

    @Override @Transactional
    public CompanyDto createCompany(@Valid CompanyRequest companyRequest) throws ResourceNotFoundException {

        Set<String> techStackNames = companyRequest.getTechStackNames();
        Set<TechStack> techStacks = new HashSet<>();
        if (!techStackNames.isEmpty()) {
            for (String techStackName: techStackNames) {
                TechStack techStack = techStackRepository.findTechStackByName(techStackName)
                        .orElseThrow(() -> new ResourceNotFoundException("Tech stack name not found: " + techStackName));
                techStacks.add(techStack);
            }
        }

        Company company = Company.builder()
                .name(companyRequest.getName())
                .address(companyRequest.getAddress())
                .numOfEmployees(companyRequest.getNumOfEmployees())
                .industry(companyRequest.getIndustry())
                .type(companyRequest.getType())
                .techStacks(techStacks)
                .build();

        companyRepository.save(company);

        return companyRepository.findById(company.getId())
                .map(companyMapper)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found for this name: " + company.getName()));

    }

    @Override
    public void updateCompany(Integer companyId, CompanyRequest companyRequest) throws ResourceNotFoundException {

    }

    @Override
    public void deleteCompany(Integer companyId) throws ResourceNotFoundException {

    }
}
