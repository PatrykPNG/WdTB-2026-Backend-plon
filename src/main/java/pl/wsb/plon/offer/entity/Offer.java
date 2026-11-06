package pl.wsb.plon.offer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

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

    protected Offer() {
    }

    public Offer(String cropName, BigDecimal quantityKg, LocalDate pickupDate, OfferStatus status,
                 PickupAddress pickupAddress) {
        this.cropName = cropName;
        this.quantityKg = quantityKg;
        this.pickupDate = pickupDate;
        this.status = status;
        this.pickupAddress = pickupAddress;
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
}
