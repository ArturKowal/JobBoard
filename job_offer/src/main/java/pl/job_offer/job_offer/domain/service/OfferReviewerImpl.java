package pl.job_offer.job_offer.domain.service;

import org.springframework.stereotype.Service;
import pl.job_offer.job_offer.domain.Offer;
import pl.job_offer.job_offer.domain.OfferRepository;
import pl.job_offer.job_offer.domain.dto.OfferDto;
import pl.job_offer.job_offer.domain.exception.NotExistingOfferException;

import java.util.List;

@Service
public class OfferReviewerImpl implements OfferReviewer {

    public final OfferRepository offerRepository;

    public OfferReviewerImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public OfferDto findOffer(String offerId) throws NotExistingOfferException {
        Offer offer = offerRepository.findById(Long.parseLong(offerId)).orElseThrow(() -> new NotExistingOfferException("Test message"));
        return OfferDto.builder()
                .offerId(offer.getOfferId())
                .title(offer.getTitle())
                .description(offer.getDescription())
                .salary(offer.getSalary())
                .build();
    }

    @Override
    public List<OfferDto> findOffersByKeys(List<String> keys) {
        return keys.stream()
                .flatMap(key -> offerRepository.findSelectedOffers(key).stream())
                .map(offer -> OfferDto.builder()
                        .offerId(offer.getOfferId())
                        .title(offer.getTitle())
                        .description(offer.getDescription())
                        .salary(offer.getSalary())
                        .build())
                .toList();
    }

    @Override
    public List<OfferDto> findRecentOffers(int numberOfRecentOffers) {
        List<Offer> selectedOffers = offerRepository.findTopNByOrderByCreationDateDesc(numberOfRecentOffers);
        return selectedOffers.stream()
                .map(offer -> OfferDto.builder()
                        .offerId(offer.getOfferId())
                        .title(offer.getTitle())
                        .description(offer.getDescription())
                        .salary(offer.getSalary())
                        .build()).toList();
    }
}
