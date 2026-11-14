package pl.wsb.plon.gardener.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import pl.wsb.plon.account.domain.UserAccount;
import pl.wsb.plon.crop.entity.Crop;
import pl.wsb.plon.garden.entity.AllotmentGarden;

import java.util.HashSet;
import java.util.Set;

/**
 * Działkowiec: osoba z działką w ogrodzie działkowym, która wystawia nadwyżki plonów.
 */
@Entity
@Table(name = "gardener")
public class Gardener {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "plot_number", nullable = false, length = 10)
    private String plotNumber;

    @Column(name = "plot_area_m2")
    private Integer plotAreaM2;

    // LAB 03: konto, którym działkowiec loguje się do aplikacji (jedno konto = jeden działkowiec)
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_account_id", nullable = false, unique = true)
    private UserAccount account;

    // LAB 03: ogród działkowy (ROD), w którym jest działka; w jednym ogrodzie jest wielu działkowców
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "allotment_garden_id", nullable = false)
    private AllotmentGarden garden;

    // LAB 03: wiele-do-wielu, działkowiec uprawia wiele gatunków, a gatunek uprawia wielu działkowców
    @ManyToMany
    @JoinTable(name = "gardener_crop",
            joinColumns = @JoinColumn(name = "gardener_id"),
            inverseJoinColumns = @JoinColumn(name = "crop_id"))
    private Set<Crop> crops = new HashSet<>();

    protected Gardener() {
    }

    public Gardener(String fullName, String phone, String plotNumber, Integer plotAreaM2,
                    UserAccount account, AllotmentGarden garden) {
        this.fullName = fullName;
        this.phone = phone;
        this.plotNumber = plotNumber;
        this.plotAreaM2 = plotAreaM2;
        this.account = account;
        this.garden = garden;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String getPlotNumber() {
        return plotNumber;
    }

    public Integer getPlotAreaM2() {
        return plotAreaM2;
    }

    public UserAccount getAccount() {
        return account;
    }

    public AllotmentGarden getGarden() {
        return garden;
    }

    public Set<Crop> getCrops() {
        return crops;
    }
}
