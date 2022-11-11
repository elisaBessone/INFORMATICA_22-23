-- Query 10: i dati degli operai/e della sede A del responsabile 1
SELECT DISTINCT *
FROM SEDEA, RESPONSABILI
WHERE SEDEA.codResp = 1 
AND RESPONSABILI.codResp = 1