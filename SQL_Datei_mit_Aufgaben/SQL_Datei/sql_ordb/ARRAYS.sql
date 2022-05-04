--  ARRAYS.sql befasst sich mit Arrays. Diese Datei klärt, wie wir Arrays in Postgres erstellen und 
--  darauf zugreifen können. Es ist wichtig zu beachten, dass Arrays in Postgres nicht 0-indiziert sind und 
--  Arrays können mit einfachen (wie Integer) oder komplexen (wie Text) Datentypen definiert werden . 
--  Es ist auch Slicing bei der Auswahl von Daten aus einem Array möglich, wie in jeder anderen Programmiersprache heutzutage.


DROP TABLE IF EXISTS tictactoe , messages;
---   Beispiel-1 :

CREATE TABLE tictactoe (
    squares   integer[3][3]
);

INSERT INTO tictactoe VALUES('{{1,2,3},{4,5,6},{7,8,9}}');

---   Beispiel-2 :

CREATE TABLE messages (
     msg  text[]
) ;

INSERT INTO messages VALUES ('{"hello", "world"}') ;
INSERT INTO messages VALUES ('{"I", "feel", "so", "free"}') ;

--  AUFGABEN
--  Schreiben Sie die Abfrage, um 8 als Ausgabe der Tic-Tac-Toe-Tabelle zu drucken : Hinweis : Arrays sind nicht null indiziert
--  Schreiben Sie die Abfrage so, dass "world" und "feel" in zwei Zeilen angezeigt werden.
--  Schreiben Sie die Abfrage, um "world" in der ersten Zeile und "feel,so,free" in der zweiten Zeile auszugeben

