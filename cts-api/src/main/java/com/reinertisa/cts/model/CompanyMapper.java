package com.reinertisa.cts.model;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CompanyMapper implements Function<Company, CompanyDto> {

    @Override
    public CompanyDto apply(Company company) {
        return CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .address(company.getAddress())
                .numOfEmployees(company.getNumOfEmployees())
                .industry(company.getIndustry())
                .type(company.getType())
                .techStacks(company.getTechStacks())
                .build();
    }
}
