package com.example.localspecialoffers.entity.specialOffer;

import com.example.localspecialoffers.entity.local.Local;

import java.util.List;

public interface SpecialOfferRepository {
    SpecialOffer save(Long localId, SpecialOffer specialOffer);

    SpecialOffer findById(Long id);

    List<SpecialOffer> findByLocalId(Local local);
}
