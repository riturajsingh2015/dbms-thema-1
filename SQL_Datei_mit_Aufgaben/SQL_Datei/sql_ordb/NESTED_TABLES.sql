--  NESTED_TABLES.sql befasst sich mit Geschachtelte Relationen. Es ist wichtig zu beachten, 
--  dass Postgres den Begriff der verschachtelten Tabelle nicht unterstützt. 
--  Es werden jedoch Arrays beliebiger Typen unterstützt, das wohl ein gleichwertiges Konzept ist. 
--  In dieser Aufgabe haben wir einen Enum-Typ (EventDescriptionType) erstellt, der als vordefinierte Tabelle 
--  interpretiert werden kann und dieser EventDescriptionType wird als Datentyp in einem anderen benutzerdefinierten 
--  Datentyp namens EventDescription verwendet. Später wird diese EventDescription als Array verwendet, 
--  wodurch eine verschachtelte Tabellenbeziehung entsteht. Beim Einfügen der Daten in die Tabelle sollte 
--  das Array vor dem Einfügen auf EventDescription[] typisiert werden.


---   Beispiel-3 :

DROP TABLE IF EXISTS Event;
DROP TYPE IF EXISTS EventDescriptionType,EventDescription;

CREATE TYPE EventDescriptionType AS ENUM (
 'felt report',
 'Flinn-Engdahl region',
 'local time',
 'tectonic summary',
 'nearest cities',
 'earthquake name',
 'region name'
);

CREATE TYPE EventDescription AS (
 "text" text,
 "type" EventDescriptionType
);
CREATE TABLE Event (
 "Event_id"                   serial PRIMARY KEY,
 "description"                EventDescription ARRAY
);

INSERT INTO Event values (1,ARRAY[('L','felt report')]::EventDescription[]);
INSERT INTO Event values (2,ARRAY[('R','region name'),('P','nearest cities')]::EventDescription[]);
                          
--  AUFGABEN
--  Schreiben Sie eine Abfrage, um den gesamten Inhalt der Tabelle Ereignis anzuzeigen
--  Schreiben Sie eine Abfrage, um nur das erste Element der Tabelle Arrays from Event anzuzeigen
--  Schreiben Sie eine Abfrage, um nur das "type" attribut des ersten Elements der Arrays from Event-Tabelle anzuzeigen


