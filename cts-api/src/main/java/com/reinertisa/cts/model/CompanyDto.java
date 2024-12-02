package com.reinertisa.cts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class CompanyDto {
    private Long id;
    private String name;
    private String country;
    private Integer size;
    private String industry;
    private CompanyType type;
    private Set<TechStack> techStacks;
}
