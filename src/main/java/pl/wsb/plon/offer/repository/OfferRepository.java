package pl.wsb.plon.offer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.plon.offer.entity.Offer;
import pl.wsb.plon.offer.entity.OfferStatus;

import java.util.List;

/**
 * Repozytorium ofert: Spring Data buduje zapytania z nazw metod.
 */
public interface OfferRepository extends JpaRepository<Offer, Long> {

    // oferty z okolicy: przez relacje Offer.gardener → Gardener.garden do kolumny allotment_garden.city
    List<Offer> findByGardener_Garden_City(String city);

    // dostępne oferty jednego działkowca: przez relację Offer.gardener do kolumny gardener.full_name
    List<Offer> findByGardener_FullNameAndStatus(String fullName, OfferStatus status);
}
