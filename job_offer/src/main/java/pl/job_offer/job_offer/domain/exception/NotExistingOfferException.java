package pl.job_offer.job_offer.domain.exception;

public class NotExistingOfferException extends Exception {
        public NotExistingOfferException(String message) {
            super(message);
        }
}
