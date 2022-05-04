DROP TABLE IF EXISTS musician , country , guitarist CASCADE;

CREATE TABLE country (
code VARCHAR(2) PRIMARY KEY,
name VARCHAR,
population int,
capital VARCHAR
);

CREATE TABLE musician (
id SERIAL PRIMARY KEY,
name VARCHAR,
citizenship VARCHAR(2) REFERENCES country(code),
inband boolean,
favourite_style VARCHAR
);

CREATE TABLE guitarist (
maximum_picking_speed int,
guitar_of_choice VARCHAR
) INHERITS(musician);

INSERT INTO country VALUES ('US', 'United States of America',25000,'Washington');
INSERT INTO country VALUES ('CH', 'Switzerland',80000,'Bern');
INSERT INTO country VALUES ('LN', 'Netherland',170000,'Amesterdam');

SELECT * FROM country;

INSERT INTO musician(name, citizenship, inband, favourite_style) VALUES ('Bongoman', 'US',false,'speedybongo');
INSERT INTO musician(name, citizenship, inband, favourite_style) VALUES ('Drummerboy', 'CH',true,'metal');


INSERT INTO guitarist(name, citizenship, inband, favourite_style,maximum_picking_speed,guitar_of_choice) VALUES
('Runnerboy1', 'IN',true,'bongo1',30,'choice1');
INSERT INTO guitarist(name, citizenship, inband, favourite_style,maximum_picking_speed,guitar_of_choice) VALUES
('Runnerboy2', 'IN',true,'bongo2',40,'choice2');
INSERT INTO guitarist(name, citizenship, inband, favourite_style,maximum_picking_speed,guitar_of_choice) VALUES
('Runnerboy3', 'IN',true,'bongo3',50,'choice3');
INSERT INTO guitarist(name, citizenship, inband, favourite_style,maximum_picking_speed,guitar_of_choice) VALUES
('Runnerboy4', 'IN',true,'bongo4',60,'choice4');
