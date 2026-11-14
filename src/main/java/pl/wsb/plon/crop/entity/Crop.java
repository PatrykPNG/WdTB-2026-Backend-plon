package pl.wsb.plon.crop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Gatunek plonu (np. pomidor, cukinia); podstawa statystyk uratowanej żywności z podziałem na gatunki.
 */
@Entity
@Table(name = "crop")
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 60)
    private String name;

    @Column(name = "category", nullable = false, length = 30)
    private String category;

    @Column(name = "season_start_month")
    private Integer seasonStartMonth;

    @Column(name = "season_end_month")
    private Integer seasonEndMonth;

    protected Crop() {
    }

    public Crop(String name, String category, Integer seasonStartMonth, Integer seasonEndMonth) {
        this.name = name;
        this.category = category;
        this.seasonStartMonth = seasonStartMonth;
        this.seasonEndMonth = seasonEndMonth;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Integer getSeasonStartMonth() {
        return seasonStartMonth;
    }

    public Integer getSeasonEndMonth() {
        return seasonEndMonth;
    }
}
