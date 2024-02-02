package pl.job_offer.job_offer.domain.service;

import org.springframework.stereotype.Service;
import pl.job_offer.job_offer.domain.Offer;
import pl.job_offer.job_offer.domain.OfferRepository;

@Service
public class OfferCreatorImpl implements OfferCreator {
    public final OfferRepository offerRepository;

    OfferCreatorImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    @Override
    public void createOffer() {
        Offer offer = Offer.builder().description("testD").title("testT").build();
        offerRepository.save(offer);
    }
}
