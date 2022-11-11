-- Query 11: i dati delle operaie assunte della sede A nel 2010
SELECT DISTINCT * 
FROM SEDEA
WHERE SEDEA.sesso = "F"
AND SEDEA.assuntoIl LIKE "%2010%"