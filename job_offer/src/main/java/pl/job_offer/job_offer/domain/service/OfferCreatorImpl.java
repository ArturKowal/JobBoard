package pl.job_offer.job_offer.domain.service;

import org.springframework.stereotype.Service;
import pl.job_offer.job_offer.domain.Offer;
import pl.job_offer.job_offer.domain.OfferRepository;
import pl.job_offer.job_offer.domain.dto.OfferDto;
import pl.job_offer.job_offer.domain.dto.OfferResponseDto;

@Service
public class OfferCreatorImpl implements OfferCreator {
    public final OfferRepository offerRepository;

    OfferCreatorImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    @Override
    public OfferResponseDto createOffer(OfferDto offerDto) {
        Offer offer = Offer.builder()
                .title(offerDto.getTitle())
                .description(offerDto.getDescription())
                .salary(offerDto.getSalary())
                .build();
        Long offerId = offerRepository.save(offer).getOfferId();
        return OfferResponseDto.builder()
                .offerId(offerId.toString())
                .build();
    }
}
