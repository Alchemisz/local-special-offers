package com.example.localspecialoffers.entity.local;

import com.example.localspecialoffers.entity.specialOffer.SpecialOffer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
public class Local {

    private Long id;
    private String name;
    private List<SpecialOffer> specialOffers;

    public Local(String name) {
        this.name = name;
    }

    public Local(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addSpecialOffer(SpecialOffer specialOffer){
        if (this.specialOffers == null){
            this.specialOffers = new LinkedList<>();
        }
        this.specialOffers.add(specialOffer);
    }

}



