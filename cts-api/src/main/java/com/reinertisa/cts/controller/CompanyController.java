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
public class CompanyController {

    private final CompanyServiceImpl companyService;

    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CompanyDto>> getAllCompanies() {
        try {
            return ResponseEntity.ok().body(companyService.getAllCompanies());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @GetMapping(value = "/{cid}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CompanyDto> getCompanyByCompanyId(@PathVariable(value = "cid") String companyId) {
        try {
            return ResponseEntity.ok().body(companyService.getCompanyByCompanyId(companyId));
        } catch (ResourceNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createCompany(@Valid @RequestBody CompanyRequest companyRequest) {
        try {
            companyService.createCompany(companyRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }
}
