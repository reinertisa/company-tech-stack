package com.reinertisa.cts.repository;

import com.reinertisa.cts.model.TechStack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechStackRepository extends JpaRepository<TechStack, Long> {

    Optional<TechStack> findTechStackByName(String name);
}
