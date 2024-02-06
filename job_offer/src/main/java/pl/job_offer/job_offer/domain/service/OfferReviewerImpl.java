package pl.job_offer.job_offer.domain.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.job_offer.job_offer.domain.Offer;
import pl.job_offer.job_offer.domain.OfferRepository;
import pl.job_offer.job_offer.domain.dto.OfferDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferReviewerImpl implements OfferReviewer {

    public final OfferRepository offerRepository;

    public OfferReviewerImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public OfferDto findOffer(String offerId) {
        Offer offer = offerRepository.findById(Long.parseLong(offerId)).get();
        return OfferDto.builder()
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
                        .title(offer.getTitle())
                        .description(offer.getDescription())
                        .salary(offer.getSalary())
                        .build())
                .toList();
    }

    @Override
    public List<OfferDto> findRecentOffers(int numberOfRecentOffers) {
        Pageable firstNElements = PageRequest.of(0, numberOfRecentOffers);
        List<Offer> selectedOffers = offerRepository.findAll(firstNElements).getContent();
        return selectedOffers.stream()
                .map(offer -> OfferDto.builder()
                        .title(offer.getTitle())
                        .description(offer.getDescription())
                        .salary(offer.getSalary())
                        .build()).toList();
    }
}
