package com.reinertisa.cts.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "techstacks")
public class TechStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TechStackCategory category;
}
