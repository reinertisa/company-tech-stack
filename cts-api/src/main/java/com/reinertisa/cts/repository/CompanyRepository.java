package com.reinertisa.cts.repository;

import com.reinertisa.cts.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByName(String companyName);

}
