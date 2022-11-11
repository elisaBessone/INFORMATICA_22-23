-- Restituire codice fiscale, nome, cognome, e sesso delle persone con età superiore ai 30 anni.
SELECT CodiceFiscale, Nome, Cognome, Sesso
FROM PERSONA
WHERE Anni > 30

-- Restituire l'indirizzo di tutte le donne.
SELECT Via
FROM ABITAZIONE, PERSONA
WHERE ABITAZIONE.CodPersona = PERSONA.CodiceFiscale 
AND PERSONA.Sesso = "F"

-- Trovare l'elenco delle persone (indicandone il nome e cognome) che abitano in via Roma, ma non in via Roma a Torino.
SELECT PERSONA.Nome, PERSONA.Cognome
FROM PERSONA, ABITAZIONE
WHERE ABITAZIONE.Via = "Via Roma"
AND ABITAZIONE.Citta != "Torino"
AND ABITAZIONE.CodPersona = PERSONA.CodiceFiscale

-- Trovare l'indirizzo del padre della persona con codice fiscale BNOVVN68B69B55D.
SELECT ABITAZIONE.Via, ABITAZIONE.Citta
FROM ABITAZIONE, GENITORE
WHERE GENITORE.CodiceFiglio = "BNOVVN68B69B55D"
AND ABITAZIONE.CodPersona = GENITORE.CodiceFiglio

-- Trovare i figli maschi (indicandone il codice fiscale) di Luca Bianchi.
SELECT CodiceFiglio
FROM PERSONA as f, PERSONA as p, GENITORE
WHERE GENITORE.CodiceGenitore = p.CodiceFiscale
AND f.CodiceFiscale = GENITORE.CodiceFiglio
AND p.Nome = "Luca"
AND p.Cognome = "Bianchi"
AND f.Sesso = "M"

-- Trovare i figli maschi (indicandone il nome e cognome) di Luca Bianchi.
SELECT f.Nome, f.Cognome
FROM PERSONA as f, PERSONA as p, GENITORE
WHERE GENITORE.CodiceGenitore = p.CodiceFiscale
AND f.CodiceFiscale = GENITORE.CodiceFiglio
AND p.Nome = "Luca"
AND p.Cognome = "Bianchi"

-- Trovare tutti i figli e le figlie che abitano nella stessa città dei genitori.
SELECT af.CodPersona
FROM GENITORE,ABITAZIONE as ag, ABITAZIONE as af
WHERE GENITORE.CodiceFiglio = af.CodPersona
AND GENITORE.CodiceGenitore = ag.CodPersona
AND ag.Citta = af.Citta


-- conteggio città, conta anche i duplicati
SELECT count(Citta) as NUMERO_CITTA
FROM ABITAZIONE

-- conta tutte le righe indipendemente dagli attributi NULL
SELECT count(*) as NUMERO_CITTA
FROM ABITAZIONE

-- conta le righe senza duplicati, se ho un duplicato lo conteggio solo una volta
SELECT count(DISTINCT Citta) as NUMERO_CITTA
FROM ABITAZIONE

--Numero persona che abitano nelle varie città
SELECT Citta, count(codPersona)    
GROUP BY Citta
HAVING Citta is not NULL