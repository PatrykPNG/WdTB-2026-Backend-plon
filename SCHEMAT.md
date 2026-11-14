# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 7 (w tym tabele łączące @ManyToMany: gardener_crop) · kolumny: 37 · relacje: 4 × @ManyToOne, 1 × @OneToMany, 1 × @OneToOne, 1 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| allotment_garden | AllotmentGarden | 5 | — |
| crop | Crop | 5 | — |
| gardener | Gardener | 7 | allotment_garden_id, user_account_id |
| offer | Offer | 9 | gardener_id |
| reservation | Reservation | 6 | offer_id, user_account_id |
| user_account | UserAccount | 5 | — |

```mermaid
erDiagram
    allotment_garden {
        Long id PK
        String city
        Integer founded_year
        String name
        Integer plot_count
    }
    crop {
        Long id PK
        String category
        String name
        Integer season_end_month
        Integer season_start_month
    }
    gardener {
        Long id PK
        Long allotment_garden_id FK
        String full_name
        String phone
        Integer plot_area_m2
        String plot_number
        Long user_account_id FK
    }
    offer {
        Long id PK
        String city
        String crop_name
        Long gardener_id FK
        LocalDate pickup_date
        String plot_number
        BigDecimal quantity_kg
        OfferStatus status
        String street
    }
    reservation {
        Long id PK
        Long offer_id FK
        Boolean picked_up
        LocalDate pickup_date
        BigDecimal quantity_kg
        Long user_account_id FK
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    allotment_garden ||--o{ gardener : "allotment_garden_id"
    gardener ||--o{ offer : "gardener_id"
    gardener }o--o{ crop : "gardener_crop"
    offer ||--o{ reservation : "offer_id"
    user_account ||--o{ reservation : "user_account_id"
    user_account ||--o| gardener : "user_account_id"
```
