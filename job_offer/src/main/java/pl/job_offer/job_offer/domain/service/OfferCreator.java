package pl.job_offer.job_offer.domain.service;

import pl.job_offer.job_offer.domain.dto.OfferDto;
import pl.job_offer.job_offer.domain.dto.OfferResponseDto;

public interface OfferCreator {
    OfferResponseDto createOffer(OfferDto offer);
}
