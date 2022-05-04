--  guitarist hat nur Zugriff auf seinen eigenen Inhalt, erhält jedoch Attribute aus der übergeordneten Tabelle(musician)
SELECT * FROM guitarist;
--  musician hat Zugriff auf seine eigenen Daten, aber auch auf Gitarristendaten, da es seine Eltern sind. 
--  Mit dieser Abfrage können wir also alle Daten abrufen.
SELECT * FROM musician;
--  Mit dieser Abfrage können wir nur die Daten der musician-tabelle abrufen
SELECT * FROM only musician;

