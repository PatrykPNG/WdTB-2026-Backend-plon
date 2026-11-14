package pl.wsb.plon.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.plon.reservation.entity.Reservation;

import java.util.List;

/**
 * Repozytorium rezerwacji: Spring Data buduje zapytania z nazw metod.
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // rezerwacje zalogowanej osoby: przez relację Reservation.reserver do kolumny user_account.email
    List<Reservation> findByReserver_Email(String email);

    // ile rezerwacji ma oferta: przez relację Reservation.offer do kolumny offer.id
    long countByOffer_Id(Long offerId);
}
