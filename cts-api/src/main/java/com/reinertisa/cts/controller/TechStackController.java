package com.reinertisa.cts.controller;

import com.reinertisa.cts.exception.ResourceNotFoundException;
import com.reinertisa.cts.model.TechStackDto;
import com.reinertisa.cts.model.TechStackRequest;
import com.reinertisa.cts.service.TechStackServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/techStacks")
@RequiredArgsConstructor
@CrossOrigin
public class TechStackController {

    private final TechStackServiceImpl techStackService;

    @GetMapping
    public ResponseEntity<List<TechStackDto>> getAllTechStacks() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(techStackService.getAllTechStacks());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @GetMapping(value = "/{tid}")
    public ResponseEntity<TechStackDto> getTechStackById(@PathVariable(name = "tid") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(techStackService.getTechStackById(id));
        } catch (ResourceNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    @PostMapping
    public ResponseEntity<Void> createTechStack(@Valid @RequestBody TechStackRequest techStackRequest) {
        try {
            techStackService.createTechStack(techStackRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

}
