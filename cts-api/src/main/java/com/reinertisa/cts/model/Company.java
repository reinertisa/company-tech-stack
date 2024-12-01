package com.reinertisa.cts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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
    private String companyId;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Integer numOfEmployees;

    @Column(nullable = false)
    private String industry;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CompanyType type;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "CompanyTechStackAssoc",
            joinColumns = {@JoinColumn(name = "companyId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "techStackId", referencedColumnName = "id")})
    private Set<TechStack> techStacks = new HashSet<>();
}
