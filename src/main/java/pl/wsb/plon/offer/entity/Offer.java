package pl.wsb.plon.offer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import pl.wsb.plon.gardener.entity.Gardener;
import pl.wsb.plon.reservation.entity.Reservation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Oferta nadwyżki plonów wystawiona przez działkowca.
 */
@Entity
@Table(name = "offer")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "crop_name", nullable = false, length = 100)
    private String cropName;

    @Column(name = "quantity_kg", nullable = false, precision = 6, scale = 2)
    private BigDecimal quantityKg;

    @Column(name = "pickup_date")
    private LocalDate pickupDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private OfferStatus status;

    @Embedded
    private PickupAddress pickupAddress;

    // LAB 03: działkowiec, który wystawił ofertę; jeden działkowiec ma wiele ofert
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gardener_id", nullable = false)
    private Gardener gardener;

    // LAB 03: drugi koniec relacji Reservation.offer (bez nowej kolumny w bazie)
    @OneToMany(mappedBy = "offer")
    private List<Reservation> reservations = new ArrayList<>();

    protected Offer() {
    }

    public Offer(String cropName, BigDecimal quantityKg, LocalDate pickupDate, OfferStatus status,
                 PickupAddress pickupAddress, Gardener gardener) {
        this.cropName = cropName;
        this.quantityKg = quantityKg;
        this.pickupDate = pickupDate;
        this.status = status;
        this.pickupAddress = pickupAddress;
        this.gardener = gardener;
    }

    public Long getId() {
        return id;
    }

    public String getCropName() {
        return cropName;
    }

    public BigDecimal getQuantityKg() {
        return quantityKg;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public OfferStatus getStatus() {
        return status;
    }

    public PickupAddress getPickupAddress() {
        return pickupAddress;
    }

    public Gardener getGardener() {
        return gardener;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
