-- Query 1 Visualizzare il numero totale di posti nei cinema di Lecce.
SELECT sum(Posti) as "Numero Posti a Lecce"
FROM CINEMA
WHERE CINEMA.Citta = "Lecce"

-- Query 2 Visualizzare il numero totale di cinema presenti nelle varie città
SELECT count(CodiceCinema) as "Cinema totali"
FROM CINEMA

-- Query 3 Visualizzare il numero di cinema presenti nella città di Firenze che hanno meno di   100 posti.
SELECT count(codiceCinema) as "Numero cinema a Firenze"
FROM CINEMA
WHERE Posti < 100
AND Citta = "Firenze"

-- Query 4 Visualizzare il numero totale di cinema presenti in ogni città.
SELECT count(codiceCinema) as "Numero cinema per Citta", Citta
FROM CINEMA
GROUP BY Citta

-- Query 5 Visualizzare il numero di cinema che hanno meno di 200 posti presenti in ogni città.
SELECT count(codiceCinema) as "Numero cinema per Citta", Citta
FROM CINEMA
GROUP BY Citta
HAVING Posti < 200

-- Query 6 Visualizzare il numero di film prodotti dopo il 2000 in ogni luogo di produzione.
SELECT count(CodiceFilm) as "Numero film dopo il 2000", LuogoProduzione
FROM FILM
WHERE AnnoProduzione > 2000
GROUP BY LuogoProduzione


-- Query 7 Visualizzare l’incasso totale delle proiezioni dei film di ogni regista.
SELECT sum(Incasso) as "Incasso film per regista", CognomeRegista
FROM FILM, PROGRAMMATO
WHERE FILM.CodiceFilm = PROGRAMMATO.CodiceFilm 
GROUP BY CognomeRegista


-- Query 8 Visualizzare il titolo e l’incasso totale di tutti i film prodotti nel 2018.
SELECT Titolo, sum(Incasso) as "Incasso film 2018"
FROM FILM, PROGRAMMATO
WHERE FILM.CodiceFilm = PROGRAMMATO.CodiceFilm 
AND AnnoProduzione = 2018


-- Query 9 Visualizzare per ogni film di animazione e di avventura il titolo il titolo e l’incasso totale relativo alle proiezioni effettuate tra il 2018 e il 2020.
SELECT FILM.Titolo, sum(PROGRAMMATO.Incasso) as "Incasso film tra 2018 e 1020", FILM.Genere
FROM FILM, PROGRAMMATO
WHERE (FILM.Genere = "Azione" 
OR FILM.Genere = "Avventura")
AND (FILM.AnnoProduzione BETWEEN 2018 and 2020)
AND PROGRAMMATO.CodiceFilm = FILM.CodiceFilm
GROUP BY FILM.Genere



-- Query 10 Visualizzare per ogni film di F. Ozpetek, il titolo del film, il numero totale di proiezioni effettuate a Torino e l’incasso totale.
SELECT FILM.Titolo, count(PROGRAMMATO.CodiceFilm) as "numero film", sum(PROGRAMMATO.Incasso) as "Incasso film Torino"
FROM FILM, PROGRAMMATO, CINEMA
WHERE FILM.CognomeRegista = "Ozpetek" 
AND CINEMA.Citta = "Torino"
AND PROGRAMMATO.CodiceCinema = CINEMA.CodiceCinema
AND PROGRAMMATO.CodiceFilm = FILM.CodiceFilm


-- Query 11 Restituire i titoli dei film il cui incasso totale supera i 5 milioni di euro.
"""
SELECT FILM.Titolo, count(FILM.CodiceFilm), sum(PROGRAMMATO.Incasso) as "Incasso_totale"
FROM FILM, PROGRAMMATO
WHERE PROGRAMMATO.CodiceFilm = FILM.CodiceFilm
GROUP BY PROGRAMMATO.CodiceFilm
"""

-- Query 12


