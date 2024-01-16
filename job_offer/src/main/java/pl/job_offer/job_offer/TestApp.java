package pl.job_offer.job_offer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TestApp {

    @GetMapping("/test")
    String test() {
        return "test API";
    }
}
