package com.reinertisa.cts.model;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TechStackMapper implements Function<TechStack, TechStackDto> {

    @Override
    public TechStackDto apply(TechStack techStack) {
        return TechStackDto.builder()
                .id(techStack.getId())
                .name(techStack.getName())
                .category(techStack.getCategory())
                .build();
    }

}
