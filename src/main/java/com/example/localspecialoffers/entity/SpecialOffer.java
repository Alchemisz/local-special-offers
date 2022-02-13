package com.example.localspecialoffers.entity;

import lombok.Data;

@Data
public class SpecialOffer {

    private Long id;
    private String name;
    private String description;

    public SpecialOffer(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
