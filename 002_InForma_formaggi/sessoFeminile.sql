-- Interrogazione 
SELECT DISTINCT SEDEA.codOperaio, SEDEA.sesso, RESPONSABILI.cognome, RESPONSABILI.nome, RESPONSABILI.codResp
FROM SEDEA, RESPONSABILI
WHERE SEDEA.sesso = "F"
AND RESPONSABILI.codResp= SEDEA.codResp
UNION
SELECT DISTINCT SEDEB.codOperaio, SEDEB.sesso, RESPONSABILI.cognome, RESPONSABILI.nome, RESPONSABILI.codResp
FROM SEDEB, RESPONSABILI
WHERE SEDEB.sesso = "F"
AND RESPONSABILI.codResp = SEDEB.codResp
ORDER BY cognome, codOperaio 
LIMIT 2

