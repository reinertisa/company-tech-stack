package com.reinertisa.cts.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Integer numOfEmployees;

    @Column(nullable = false)
    private String industry;

    @Column(nullable = false)
    private CompanyType type;
}
