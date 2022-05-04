DROP TABLE IF EXISTS location;
DROP TYPE IF EXISTS address;
DROP DOMAIN IF EXISTS addr;
CREATE DOMAIN addr VARCHAR(90) NOT NULL DEFAULT 'N/A';

CREATE TYPE address AS (city VARCHAR(90), street VARCHAR(90));

CREATE TABLE location (ship_address addr, full_address address);

INSERT INTO location VALUES ('ship_address1', ('Northampton1', 'Tower St1')::address);
INSERT INTO location VALUES ('ship_address2', ('Northampton2', 'Tower St2')::address);
INSERT INTO location VALUES ('ship_address3', ('Northampton3', 'Tower St3')::address);
INSERT INTO location VALUES ('ship_address4', ('Northampton4', 'Tower St4')::address);

