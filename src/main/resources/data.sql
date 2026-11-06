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

-- ===== LAB 02 · reservation =====
insert into reservation (reserver_email, quantity_kg, pickup_date, picked_up) values
    ('sasiad@example.com',                  2.50, '2026-08-14', true),
    ('wrx97149@student.wroclaw.merito.pl',  5.00, '2026-09-02', true),
    ('sasiad@example.com',                  1.20, '2026-11-12', false);

-- ===== LAB 02 · offer =====
insert into offer (crop_name, quantity_kg, pickup_date, status, street, city, plot_number) values
    ('Pomidory malinowe', 4.00, '2026-08-14', 'PICKED_UP', 'ul. Kwiatowa 12', 'Wrocław', '27'),
    ('Cukinia',           6.50, '2026-09-02', 'RESERVED',  'ul. Ogrodowa 3',  'Wrocław', '104'),
    ('Jabłka Szampion',  12.00, '2026-11-12', 'AVAILABLE', 'ul. Polna 8',     'Oława',   '15');
