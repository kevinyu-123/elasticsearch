package com.study.elastic.dto;

public record ItemRespDTO (
         Long id,
         String name,
         String description,
         int usage
    )
{ }
