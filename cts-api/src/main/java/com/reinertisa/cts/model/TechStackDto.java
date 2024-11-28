package com.reinertisa.cts.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TechStackDto {
    private Long id;
    private String name;
    private TechStackCategory category;
}
