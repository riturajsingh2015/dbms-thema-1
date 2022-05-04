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
                          

