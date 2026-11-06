package pl.wsb.plon.garden.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Ogród działkowy (ROD), w którym działkowcy mają swoje działki.
 */
@Entity
@Table(name = "allotment_garden")
public class AllotmentGarden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 120)
    private String name;

    @Column(name = "city", nullable = false, length = 80)
    private String city;

    @Column(name = "plot_count")
    private Integer plotCount;

    @Column(name = "founded_year")
    private Integer foundedYear;

    protected AllotmentGarden() {
    }

    public AllotmentGarden(String name, String city, Integer plotCount, Integer foundedYear) {
        this.name = name;
        this.city = city;
        this.plotCount = plotCount;
        this.foundedYear = foundedYear;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Integer getPlotCount() {
        return plotCount;
    }

    public Integer getFoundedYear() {
        return foundedYear;
    }
}
