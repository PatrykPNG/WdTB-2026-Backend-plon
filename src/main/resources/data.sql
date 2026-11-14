-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
insert into user_account (email, display_name, role, created_at) values
    ('ola@student.merito.pl',   'Ola',   'USER',    current_timestamp),
    ('kuba@student.merito.pl',  'Kuba',  'USER',    current_timestamp),
    ('wrx82034@student.wroclaw.merito.pl',  'Patryk',  'USER',    current_timestamp),
    ('wrx97149@student.wroclaw.merito.pl',  'Marcin',  'USER',    current_timestamp),
    ('sasiad@example.com',  'Sąsiad (konto testowe)',  'USER',    current_timestamp),
    ('firma@example.com',       'Firma', 'PARTNER', current_timestamp),
    ('admin@example.com',       'Admin', 'ADMIN',   current_timestamp);

-- LAB 01: Wasze konta (zmieńcie na swoje dane, rola USER)
-- insert into user_account (email, display_name, role, created_at) values
--     ('imie.nazwisko@student.merito.pl', 'Imię', 'USER', current_timestamp);

-- ===== LAB 02 · allotment_garden =====
insert into allotment_garden (name, city, plot_count, founded_year) values
    ('ROD Malwa',     'Wrocław', 180, 1975),
    ('ROD Słonecznik', 'Wrocław', 120, 1982),
    ('ROD Pod Dębami', 'Oława',    65, 1990);

-- ===== LAB 03 · gardener =====
-- user_account_id: konto z sekcji user_account (1 = Ola, 3 = Patryk, 4 = Marcin); każde konto najwyżej raz (@OneToOne)
-- allotment_garden_id: ogród z sekcji allotment_garden (1 = ROD Malwa, 2 = ROD Słonecznik, 3 = ROD Pod Dębami)
insert into gardener (full_name, phone, plot_number, plot_area_m2, user_account_id, allotment_garden_id) values
    ('Patryk Ostrowski', '600111222', '27',  300, 3, 1),
    ('Marcin Przybyl',   null,        '104', 250, 4, 2),
    ('Ola Zielińska',    '600333444', '15',  400, 1, 3);

-- ===== LAB 03 · crop =====
insert into crop (name, category, season_start_month, season_end_month) values
    ('Pomidor', 'WARZYWO', 7, 9),
    ('Cukinia', 'WARZYWO', 7, 9),
    ('Jabłko',  'OWOC',    8, 11),
    ('Ogórek',  'WARZYWO', 7, 8);

-- ===== LAB 03 · gardener_crop =====
-- pary: działkowiec (gardener_id) uprawia gatunek (crop_id)
insert into gardener_crop (gardener_id, crop_id) values
    (1, 1),                     -- Patryk: pomidor
    (1, 4),                     -- Patryk: ogórek
    (2, 2),                     -- Marcin: cukinia
    (3, 3);                     -- Ola: jabłko

-- ===== LAB 02 · offer =====
-- LAB 03: gardener_id wskazuje działkowca z sekcji gardener (działka zgodna z plot_number)
insert into offer (crop_name, quantity_kg, pickup_date, status, street, city, plot_number, gardener_id) values
    ('Pomidory malinowe', 4.00, '2026-08-14', 'PICKED_UP', 'ul. Kwiatowa 12', 'Wrocław', '27',  1),
    ('Cukinia',           6.50, '2026-09-02', 'RESERVED',  'ul. Ogrodowa 3',  'Wrocław', '104', 2),
    ('Jabłka Szampion',  12.00, '2026-11-12', 'AVAILABLE', 'ul. Polna 8',     'Oława',   '15',  3);

-- ===== LAB 03 · reservation =====
-- offer_id: oferta z sekcji offer (1 = pomidory, 2 = cukinia, 3 = jabłka)
-- user_account_id: rezerwujący z sekcji user_account (5 = Sąsiad, 2 = Kuba)
insert into reservation (quantity_kg, pickup_date, picked_up, offer_id, user_account_id) values
    (2.50, '2026-08-14', true,  1, 5),
    (5.00, '2026-09-02', true,  2, 2),
    (1.20, '2026-11-12', false, 3, 5);
