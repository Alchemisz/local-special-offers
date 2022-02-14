package com.example.localspecialoffers.entity.specialOffer;

import com.example.localspecialoffers.entity.local.Local;

import java.util.List;

public interface SpecialOfferService {

    SpecialOffer save(Long localId, SpecialOffer specialOffer);
    SpecialOffer getById(Long id);
    List<SpecialOffer> getSpecialOffersForLocal(Local local);

}
