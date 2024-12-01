package com.reinertisa.cts.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@Builder
public class CompanyRequest {

    @NotBlank(message = "This field is required.")
    private String name;

    @NotBlank(message = "This field is required.")
    private String address;

    @NotNull(message = "This field is required.")
    private Integer numOfEmployees;

    @NotBlank(message = "This field is required.")
    private String industry;

    @NotNull(message = "This field is required.")
    private CompanyType type;

    private Set<String> techStackNames;
}
