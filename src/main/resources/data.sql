DROP  TABLE IF EXISTS certificaat, transactie, optieplan, persoon CASCADE;

CREATE TABLE persoon (
                         persoon_id SERIAL PRIMARY KEY ,
                         persoon_naam VARCHAR(255) NOT NULL
);

CREATE TABLE optieplan (
                        optieplan_id SERIAL PRIMARY KEY,
                        optieplan_naam INT UNIQUE NOT NULL
);


CREATE TABLE transactie (
                        transactie_id SERIAL PRIMARY KEY ,
                        optieplan_id INT NOT NULL ,
                        persoon_id INT NOT NULL,
                        type_toewijzing varchar,
                        aantal INT,
                        zet_om_van_optieplan INT,
                        CONSTRAINT fk_persoon
                         FOREIGN KEY (persoon_id) REFERENCES persoon(persoon_id),
                        CONSTRAINT fk_optieplan
                         FOREIGN KEY (optieplan_id) REFERENCES optieplan(optieplan_id),
                        CONSTRAINT fk_zet_om_van_optieplan
                        FOREIGN KEY (zet_om_van_optieplan) REFERENCES optieplan(optieplan_id)

                        );


CREATE TABLE certificaat (
                             certificaat_id SERIAL PRIMARY KEY ,
                             certificaat_nummer INT NOT NULL,
                             optieplan_bij_aankoop INT NOT NULL ,
                             optieplan_bij_verkoop INT ,
                             persoon_id INT NOT NULL ,
                             CONSTRAINT fk_persoon
                                 FOREIGN KEY (persoon_id) REFERENCES persoon(persoon_id),
                             CONSTRAINT fk_optieplan_bij_aankoop
                                FOREIGN KEY (optieplan_bij_aankoop) REFERENCES optieplan(optieplan_id),
                             CONSTRAINT fk_optieplan_bij_verkoop
                                FOREIGN KEY (optieplan_bij_verkoop) REFERENCES optieplan(optieplan_id)
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
                                           (20041),
                                           (20042)
;


INSERT INTO mvppoc.public.transactie
    (optieplan_id, persoon_id, type_toewijzing, aantal, zet_om_van_optieplan)
VALUES
                     (1, 2, 'VERKOPEN',   100, 1),
                     (1, 3,  'AANKOPEN',  100, 1),
                     (1, 7,   'VERKOPEN', 300,  1),
                     (1, 1, 'AANKOPEN',   300, 1),
                     (2, 8,   'VERKOPEN', 400,  2),
                     (2, 3, 'AANKOPEN',   400, 2);




