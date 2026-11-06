package pl.wsb.plon.reservation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

    @Column(name = "reserver_email", nullable = false, length = 120)
    private String reserverEmail;

    @Column(name = "quantity_kg", nullable = false, precision = 6, scale = 2)
    private BigDecimal quantityKg;

    @Column(name = "pickup_date", nullable = false)
    private LocalDate pickupDate;

    @Column(name = "picked_up")
    private Boolean pickedUp;

    protected Reservation() {
    }

    public Reservation(String reserverEmail, BigDecimal quantityKg, LocalDate pickupDate, Boolean pickedUp) {
        this.reserverEmail = reserverEmail;
        this.quantityKg = quantityKg;
        this.pickupDate = pickupDate;
        this.pickedUp = pickedUp;
    }

    public Long getId() {
        return id;
    }

    public String getReserverEmail() {
        return reserverEmail;
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
}
