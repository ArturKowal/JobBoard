package pl.job_offer.job_offer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.job_offer.job_offer.domain.service.OfferCreator;

@RestController
class TestApp {
    public final OfferCreator offerCreator;

    TestApp(OfferCreator offerCreator) {
        this.offerCreator = offerCreator;
    }

    @GetMapping("/test")
    String test() {
        return "test API";
    }

    @GetMapping("/test2")
    String test2() {
        return "test API2";
    }

    @GetMapping("/test3")
    String test3() {
        return "test API3";
    }

    @GetMapping("/test4")
    String test4() {
        return "test API4";
    }
}
