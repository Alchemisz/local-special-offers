package com.example.localspecialoffers.entity.specialOffer;

import com.example.localspecialoffers.entity.local.Local;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpecialOffer {

    private Long id;
    private String name;
    private String description;
}
