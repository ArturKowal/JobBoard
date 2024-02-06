package pl.job_offer.job_offer.domain;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.job_offer.job_offer.domain.dto.OfferDto;
import pl.job_offer.job_offer.domain.dto.OfferResponseDto;
import pl.job_offer.job_offer.domain.service.OfferCreator;
import pl.job_offer.job_offer.domain.service.OfferReviewer;

import java.util.List;

@RestController
@RequestMapping("/offer")
class OfferController {

    public final OfferCreator offerCreator;
    public final OfferReviewer offerReviewer;

    OfferController(OfferCreator offerCreator, OfferReviewer offerReviewer) {
        this.offerCreator = offerCreator;
        this.offerReviewer = offerReviewer;
    }

    @PostMapping
    ResponseEntity<OfferResponseDto> createOffer(@RequestBody OfferDto offerDto) {
        OfferResponseDto offer = offerCreator.createOffer(offerDto);
        return ResponseEntity.ok(offer);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> findOffer(@PathVariable String id) {
        return ResponseEntity.ok(offerReviewer.findOffer(id));
    }

    @GetMapping
    ResponseEntity<?> findSelectedOffers(@RequestParam List<String> keys) {
        return ResponseEntity.ok(offerReviewer.findOffersByKeys(keys));
    }

    @GetMapping("/recent/{number}")
    ResponseEntity<?> findSelectedOffers(@PathVariable String number) {
        return ResponseEntity.ok(offerReviewer.findRecentOffers(Integer.parseInt(number)));
    }

}
