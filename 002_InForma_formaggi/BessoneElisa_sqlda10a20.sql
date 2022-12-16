-- Query 10: i dati degli operai/e della sede A del responsabile 1
SELECT DISTINCT *
FROM SEDEA, RESPONSABILI
WHERE SEDEA.codResp = 1 
AND RESPONSABILI.codResp = 1

-- Query 11: i dati delle operaie assunte della sede A nel 2010
SELECT DISTINCT * 
FROM SEDEA
WHERE SEDEA.sesso = "F"
AND SEDEA.assuntoIl LIKE "%2010%"

-- Query 12: i dati delle operai/e con stipendio sotto i 900€ della sede B
SELECT DISTINCT * 
FROM SEDEB
WHERE SEDEB.stipendio < 900

-- Query 13: gli stipendi degli uomini della sede B
SELECT DISTINCT SEDEB.stipendio
FROM SEDEB
WHERE SEDEB.sesso = "M"

-- Query 14: codici dei responsabili degli operai/e della sede A
SELECT DISTINCT codResp
FROM SEDEA

-- Query 15: codice e codice responsabile degli operai/e della sede B
SELECT DISTINCT codResp
FROM SEDEB

-- Query 16: congiunzione tra responsabili e sede A
SELECT *
FROM RESPONSABILI INNER JOIN SEDEA ON RESPONSABILI.codResp = SEDEA.codResp

-- Query 17: prodotto cartesiano tra sede B e responsabili
-- cross join, tutti gli elementi e le combinazioni tra tabella Sedeb e responsabili.
SELECT *
FROM SEDEB CROSS JOIN RESPONSABILI

-- Query 18: codice e stipendio degli operai con responsabile 1 della sede B
SELECT codOperaio, stipendio
FROM SEDEB
WHERE codResp = 1

-- Query 19: data di assunzione degli operai/e che guadagnano meno di 950€ della sede A
SELECT assuntoIl
FROM SEDEA
WHERE stipendio < 950

-- Query 20: stipendio e codice responsabile degli operai/e assunte/e nel 2011 della sede B
SELECT stipendio, codResp
FROM SEDEB
WHERE assuntoIl LIKE "%2011%"

-- selezionare lo STIPENDIO_MINIMO, STIPENDIO_MASSIMO, STIPENDIO_MEDIO, STIPENDIO_SOMMA
SELECT min(stipendio) as STIPENDIO_MINIMO, max(stipendio) as STIPENDIO_MASSIMO, avg(stipendio) as STIPENDIO_MEDIO, sum(stipendio) as STIPENDIO_SOMMA
FROM SEDEA

-- somma per pagare lavoratori sotto Lerda Ivo
SELECT sum(stipendio) as STIPENDIO_SOMMA
FROM SEDEA, RESPONSABILI
WHERE RESPONSABILI.cognome = "Lerda"
AND RESPONSABILI.nome = "Ivo"
AND RESPONSABILI.codResp = SEDEA.codResp

-- SEDE A e SEDEB
SELECT sum(SOMMA_STIPENDI) FROM
(SELECT sum(stipendio) as SOMMA_STIPENDI
FROM SEDEA, RESPONSABILI
WHERE RESPONSABILI.cognome = "Lerda"
AND RESPONSABILI.nome = "Ivo"
AND RESPONSABILI.codResp = SEDEA.codResp
UNION
SELECT sum(stipendio) as SOMMA_STIPENDI
FROM SEDEB, RESPONSABILI
WHERE RESPONSABILI.cognome = "Lerda"
AND RESPONSABILI.nome = "Ivo"
AND RESPONSABILI.codResp = SEDEB.codResp)


-- Query: restituisce gli stipendi degli operai che hanno uno stipendio > media 
SELECT SEDEA.codOperaio
FROM SEDEA
WHERE stipendio > (SELECT avg(SEDEA.stipendio) FROM SEDEA)


-- tutti i dipendenti che hanno un responsabile diverso da lerva ivo
SELECT *
FROM SEDEA, (SELECT RESPONSABILI.codResp FROM RESPONSABILI WHERE RESPONSABILI.nome != "Ivo" AND RESPONSABILI.cognome != "Lerda") as R
WHERE SEDEA.codResp == R.codResp
 
 -- tutti i dipendenti che hanno un responsabile diverso da lerva ivo con utilizzo di NOT IN 
SELECT *
FROM SEDEA
WHERE SEDEA.codResp NOT IN (SELECT RESPONSABILI.codResp FROM RESPONSABILI WHERE RESPONSABILI.nome = "Ivo" AND RESPONSABILI.cognome = "Lerda") 

