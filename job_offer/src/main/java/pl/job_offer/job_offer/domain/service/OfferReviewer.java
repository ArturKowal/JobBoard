package pl.job_offer.job_offer.domain.service;

import pl.job_offer.job_offer.domain.dto.OfferDto;
import pl.job_offer.job_offer.domain.exception.NotExistingOfferException;

import java.util.List;

public interface OfferReviewer {
    OfferDto findOffer(String offerId) throws NotExistingOfferException;
    List<OfferDto> findOffersByKeys(List<String> keys);
    List<OfferDto> findRecentOffers(int numberOfRecentOffers);
}
