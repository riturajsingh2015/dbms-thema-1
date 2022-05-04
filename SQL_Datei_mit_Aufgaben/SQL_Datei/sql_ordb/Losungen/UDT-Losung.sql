--  Überprüfen Sie, wie alle Spalten und Zeilen in der Tabellenposition aussehen.
SELECT * FROM location;

--  Sie können mit der Punktnotation auf die Typen zugreifen

SELECT (location.full_address).city, (location.full_address).street from location;
SELECT (location.full_address).street from location where (location.full_address).city = 'Northampton4';