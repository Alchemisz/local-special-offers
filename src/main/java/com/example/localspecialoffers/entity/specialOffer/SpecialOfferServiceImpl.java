package com.example.localspecialoffers.entity.specialOffer;

import com.example.localspecialoffers.entity.local.Local;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SpecialOfferServiceImpl implements SpecialOfferService {

    private final SpecialOfferRepository specialOfferRepository;

    @Override
    public SpecialOffer save(Long localId, SpecialOffer specialOffer) {
        return specialOfferRepository.save(localId, specialOffer);
    }

    @Override
    public SpecialOffer getById(Long id) {
        return specialOfferRepository.findById(id);
    }

    @Override
    public List<SpecialOffer> getSpecialOffersForLocal(Local local) {
        return specialOfferRepository.findByLocalId(local);
    }
}
