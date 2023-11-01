DROP TABLE IF EXISTS persoon, transactie, certificaat;

CREATE TABLE persoon (
                         persoon_id SERIAL PRIMARY KEY ,
                         persoon_naam VARCHAR(255) NOT NULL
);

CREATE TABLE transactie (
                            transactie_id SERIAL PRIMARY KEY ,
                            persoon_id INT NOT NULL,
                            koopt INT,
                            verkoopt INT,
                            CONSTRAINT fk_persoon
                                FOREIGN KEY (persoon_id) REFERENCES persoon(persoon_id)
);

CREATE TABLE certificaat (
                             certificaat_id SERIAL PRIMARY KEY ,
                             persoon_id INT NOT NULL ,
                             CONSTRAINT fk_persoon
                                 FOREIGN KEY (persoon_id) REFERENCES persoon(persoon_id)
);

INSERT INTO mvppoc.public.persoon (persoon_naam)
VALUES ('Alfie'),
       ('Bilbo'),
       ('Chris') ;

INSERT INTO mvppoc.public.persoon (persoon_naam)
VALUES ('Damian');


INSERT INTO mvppoc.public.transactie (persoon_id, koopt, verkoopt) VALUES
                                                                       (2, 200, 0),
                                                                       (1, 0, 200),
                                                                       (3, 300, 0),
                                                                       (4, 0, 300);
