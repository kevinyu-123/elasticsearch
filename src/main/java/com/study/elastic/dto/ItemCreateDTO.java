package com.study.elastic.dto;

public record ItemCreateDTO(
        String name,
        String description,
        int usage
)
{ }
