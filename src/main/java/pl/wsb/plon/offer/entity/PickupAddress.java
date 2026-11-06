package pl.wsb.plon.offer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * Miejsce odbioru plonów. Nie ma własnej tabeli: jego kolumny trafiają do tabeli oferty.
 */
@Embeddable
public class PickupAddress {

    @Column(name = "street", length = 120)
    private String street;

    @Column(name = "city", length = 80)
    private String city;

    @Column(name = "plot_number", length = 10)
    private String plotNumber;

    protected PickupAddress() {
    }

    public PickupAddress(String street, String city, String plotNumber) {
        this.street = street;
        this.city = city;
        this.plotNumber = plotNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPlotNumber() {
        return plotNumber;
    }
}
