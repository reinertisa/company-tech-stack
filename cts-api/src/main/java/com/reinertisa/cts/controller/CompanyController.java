package com.reinertisa.cts.controller;

import com.reinertisa.cts.exception.ResourceNotFoundException;
import com.reinertisa.cts.model.CompanyDto;
import com.reinertisa.cts.model.CompanyRequest;
import com.reinertisa.cts.service.CompanyServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/companies")
@RequiredArgsConstructor
@CrossOrigin
public class CompanyController {

    private final CompanyServiceImpl companyService;

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getAllCompanies() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(companyService.getAllCompanies());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @GetMapping(value = "/{cid}")
    public ResponseEntity<CompanyDto> getCompanyByCompanyId(@PathVariable(value = "cid") String companyId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(companyService.getCompanyByCompanyId(companyId));
        } catch (ResourceNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @PostMapping
    public ResponseEntity<CompanyDto> createCompany(@Valid @RequestBody CompanyRequest companyRequest) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(companyService.createCompany(companyRequest));
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }
}
