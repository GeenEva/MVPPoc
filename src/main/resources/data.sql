DROP  TABLE IF EXISTS certificaat, transactie, transactie_moment, optieplan, persoon CASCADE;

CREATE TABLE persoon (
                         persoon_id SERIAL PRIMARY KEY ,
                         persoon_naam VARCHAR(255) NOT NULL
);

CREATE TABLE optieplan (
                        optieplan_id SERIAL PRIMARY KEY,
                        optieplan_naam INT UNIQUE NOT NULL
);

CREATE TABLE transactie_moment (
                        transactie_moment_id SERIAL PRIMARY KEY,
                        optieplan_id INT NOT NULL,
                        CONSTRAINT fk_optieplan
                         FOREIGN KEY (optieplan_id) REFERENCES optieplan(optieplan_id)
);

CREATE TABLE transactie (
                        transactie_id SERIAL PRIMARY KEY ,
                        transactie_moment_id INT NOT NULL ,
                        persoon_id INT NOT NULL,
                        koopt INT,
                        verkoopt INT,
                        zet_om INT,
                        zet_om_van_optieplan varchar,
                        CONSTRAINT fk_persoon
                         FOREIGN KEY (persoon_id) REFERENCES persoon(persoon_id),
                        CONSTRAINT fk_transactie_moment
                         FOREIGN KEY (transactie_moment_id) REFERENCES transactie_moment(transactie_moment_id)
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

INSERT INTO optieplan (optieplan_naam) VALUES
                                           (20011),
                                           (20012),
                                           (20021),
                                           (20022),
                                           (20031),
                                           (20032),
                                           (20041)
;

INSERT INTO mvppoc.public.transactie_moment (transactie_moment_id, optieplan_id)
VALUES
    (1,1), (2,2), (3,3), (4,4), (5,5), (6,6), (7,7);

INSERT INTO mvppoc.public.transactie
    (transactie_moment_id, persoon_id, koopt, verkoopt, zet_om, zet_om_van_optieplan)
VALUES
                     (1, 2, 200,   0, 100, '2012.2'),
                     (1, 3,   0, 200,   0, '0'),
                     (1, 7,   0, 300,   0, '0'),
                     (1, 1, 300,   0,   0, '0'),
                     (2, 8,   0, 300,   0, '0'),
                     (2, 3, 300,   0, 500, '2019.1');

