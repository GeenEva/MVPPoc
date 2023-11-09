DROP TABLE IF EXISTS persoon, transactie, certificaat, optieplan;

CREATE TABLE persoon (
                         persoon_id SERIAL PRIMARY KEY ,
                         persoon_naam VARCHAR(255) NOT NULL
);

CREATE TABLE transactie (
                            transactie_id SERIAL PRIMARY KEY ,
                            persoon_id INT NOT NULL,
                            koopt INT,
                            verkoopt INT,
                            zet_om INT,
                            zet_om_van_optieplan varchar,
                            CONSTRAINT fk_persoon
                                FOREIGN KEY (persoon_id) REFERENCES persoon(persoon_id)
);

CREATE TABLE optieplan (
                           optieplan_id SERIAL PRIMARY KEY,
                           optieplan_naam INT UNIQUE NOT NULL

);

CREATE TABLE certificaat (
                             certificaat_id SERIAL PRIMARY KEY ,
                             certificaat_nummer INT NOT NULL,
                             optieplan_id INT NOT NULL ,
                             persoon_id INT NOT NULL ,
                             CONSTRAINT fk_persoon
                                 FOREIGN KEY (persoon_id) REFERENCES persoon(persoon_id),
                             CONSTRAINT fk_optieplan
                                FOREIGN KEY (optieplan_id) REFERENCES optieplan(optieplan_id)
);




INSERT INTO mvppoc.public.persoon (persoon_naam)
VALUES ('Alfie'),
       ('Bilbo'),
       ('Chris'),
       ('Doris'),
       ('Ellie'),
       ('Fritzl'),
       ('Gerard'),
       ('Heini'),
       ('Izaak'),
       ('Jettie')
       ;

INSERT INTO mvppoc.public.transactie (persoon_id, koopt, verkoopt, zet_om, zet_om_van_optieplan)
VALUES
                     (2, 200,   0, 100, '2012.2'),
                     (7,   0, 200,   0, '0'),
                     (1, 300,   0,   0, '0'),
                     (8,   0, 300,   0, '0'),
                     (3,   0,   0, 500, '2019.1');

INSERT INTO optieplan (optieplan_naam) VALUES
                    (20051),
                    (20072),
                    (20081)
;