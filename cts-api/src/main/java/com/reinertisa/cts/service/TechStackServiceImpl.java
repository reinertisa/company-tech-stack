package com.reinertisa.cts.service;

import com.reinertisa.cts.exception.ResourceNotFoundException;
import com.reinertisa.cts.model.TechStack;
import com.reinertisa.cts.model.TechStackDto;
import com.reinertisa.cts.model.TechStackMapper;
import com.reinertisa.cts.model.TechStackRequest;
import com.reinertisa.cts.repository.TechStackRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class TechStackServiceImpl implements TechStackService {
    private final TechStackRepository techStackRepository;
    private final TechStackMapper techStackMapper;

    @Override
    public List<TechStackDto> getAllTechStacks() {
        return techStackRepository.findAll()
                .stream()
                .map(techStackMapper)
                .toList();
    }

    @Override
    public TechStackDto getTechStackById(Long id) throws ResourceNotFoundException {
        Objects.requireNonNull(id, "Tech stack ID must not be null.");

        return techStackRepository.findById(id)
                .map(techStackMapper)
                .orElseThrow(() -> new ResourceNotFoundException("Tech stack not found for this ID: " + id));
    }

    @Override
    public TechStackDto getTechStackByName(String name) throws ResourceNotFoundException {
        Objects.requireNonNull(name, "Tech stack name must not be null.");
        return techStackRepository.findTechStackByName(name)
                .map(techStackMapper)
                .orElseThrow(() -> new ResourceNotFoundException("Tech stack not found this name: " + name));
    }

    @Override @Transactional
    public void createTechStack(TechStackRequest techStackRequest) {
        TechStack techStack = TechStack.builder()
                .name(techStackRequest.getName())
                .category(techStackRequest.getCategory())
                .build();
        techStackRepository.save(techStack);
    }

    @Override
    public void updateTechStack(Long id, TechStackRequest techStackRequest) throws ResourceNotFoundException {

    }

    @Override
    public void deleteTechStack(Long id) throws ResourceNotFoundException {

    }
}
