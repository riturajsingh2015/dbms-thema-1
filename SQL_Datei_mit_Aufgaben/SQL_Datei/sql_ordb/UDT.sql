--  UDT.sql befasst sich damit, wie wir unseren eigenen benutzerdefinierten Datentyp(z.B addr , address) 
--  erstellen und in einer anderen Tabelle(location) verwenden können.

--   einfaches Beispiel fur Benutzerdefinerte DatenTypen
DROP TABLE IF EXISTS location;
DROP TYPE IF EXISTS address;
DROP DOMAIN IF EXISTS addr;
--   Definieren Sie einen benutzerdefinierten Typ mit CREATE DOMAIN
CREATE DOMAIN addr VARCHAR(90) NOT NULL DEFAULT 'N/A';
--   oder Definieren Sie einen benutzerdefinierten Typ mit CREATE TYPE
CREATE TYPE address AS (city VARCHAR(90), street VARCHAR(90));
--   Verwenden Sie sie in einer Tabelle
CREATE TABLE location (ship_address addr, full_address address);

INSERT INTO location VALUES ('ship_address1', ('Northampton1', 'Tower St1')::address);
INSERT INTO location VALUES ('ship_address2', ('Northampton2', 'Tower St2')::address);
INSERT INTO location VALUES ('ship_address3', ('Northampton3', 'Tower St3')::address);
INSERT INTO location VALUES ('ship_address4', ('Northampton4', 'Tower St4')::address);
--   Daten in die Tabelle einfügen. Beachten Sie, dass das zweite Tupel als Adresse eingegeben wurde. 
--   weil es vom Adresstyp sein sollte.

--   Diese komplexen Typen widersprechen wirklich der 1NF:
--   dass alle Werte atomar sein sollten. 
--   Sie ermöglichen jedoch die Kapselung mehrerer verwandter Werte.
--   Da die full_address ein zusammengesetztes Attribut ist, wird sie im Tupel angezeigt

--  AUFGABEN
--  Überprüfen Sie, wie alle Spalten und Zeilen in der Tabellenposition aussehen.
--  Verwenden Sie die Punktnotation, um die Informationen über die Stadt und die Straße aus der Standorttabelle anzuzeigen
--  Zeigen Sie den Namen der Straße an, deren Stadtname Northampton 4 ist

