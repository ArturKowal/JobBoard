package pl.job_offer.job_offer.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    @Query("SELECT o FROM Offer o WHERE o.title LIKE LOWER(CONCAT('%', :key, '%'))")
    List<Offer> findSelectedOffers(String key);

    @Query("SELECT o FROM Offer o ORDER BY o.creationDate DESC LIMIT :n")
    List<Offer> findTopNByOrderByCreationDateDesc(int n);
}
