SELECT * FROM location;
SELECT (location.full_address).city, (location.full_address).street from location;
SELECT (location.full_address).street from location where (location.full_address).city = 'Northampton4';