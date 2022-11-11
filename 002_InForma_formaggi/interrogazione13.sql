-- Query 13: gli stipendi degli uomini della sede B
SELECT DISTINCT SEDEB.stipendio
FROM SEDEB
WHERE SEDEB.sesso = "M"