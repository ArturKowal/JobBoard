package pl.job_offer.job_offer.domain.service;

import pl.job_offer.job_offer.domain.dto.OfferDto;

import java.util.List;

public interface OfferReviewer {
    OfferDto findOffer(String offerId);
    List<OfferDto> findOffersByIds(List<String> offerId);
    List<OfferDto> findRecentOffers(int numberOfRecentOffers);
}
