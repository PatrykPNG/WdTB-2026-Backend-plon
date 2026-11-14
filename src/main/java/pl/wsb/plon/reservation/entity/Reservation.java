package pl.wsb.plon.reservation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import pl.wsb.plon.account.domain.UserAccount;
import pl.wsb.plon.offer.entity.Offer;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Rezerwacja odbioru: sąsiad rezerwuje część plonów z oferty na konkretny dzień.
 */
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity_kg", nullable = false, precision = 6, scale = 2)
    private BigDecimal quantityKg;

    @Column(name = "pickup_date", nullable = false)
    private LocalDate pickupDate;

    @Column(name = "picked_up")
    private Boolean pickedUp;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "offer_id", nullable = false)
    private Offer offer;

    // LAB 03: konto osoby, która rezerwuje odbiór; jedno konto może mieć wiele rezerwacji
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_account_id", nullable = false)
    private UserAccount reserver;

    protected Reservation() {
    }

    public Reservation(BigDecimal quantityKg, LocalDate pickupDate, Boolean pickedUp, Offer offer,
                       UserAccount reserver) {
        this.quantityKg = quantityKg;
        this.pickupDate = pickupDate;
        this.pickedUp = pickedUp;
        this.offer = offer;
        this.reserver = reserver;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getQuantityKg() {
        return quantityKg;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public Boolean getPickedUp() {
        return pickedUp;
    }

    public Offer getOffer() {
        return offer;
    }

    public UserAccount getReserver() {
        return reserver;
    }
}
