package com.reinertisa.cts.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class TechStackRequest {
    @NotBlank(message = "This field is required.")
    private String name;

    @NotNull(message = "This field is required.")
    private TechStackCategory category;
}
