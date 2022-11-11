-- Query 12: i dati delle operai/e con stipendio sotto i 900€ della sede B
SELECT DISTINCT * 
FROM SEDEB
WHERE SEDEB.stipendio < 900