SELECT partyid, COUNT(partyid) FROM amele_candidate GROUP BY partyid;

SELECT partyid, COUNT(fname) FROM amele_candidate WHERE UPPER(fname) LIKE 'D%' OR UPPER(fname) LIKE 'R%';

SELECT partyid, AVG(salary) FROM amele_candidate GROUP BY partyid;

SELECT partyid, COUNT(partyid) FROM amele_candidate GROUP BY partyid HAVING COUNT(partyid) < 2;

SELECT partyid, AVG(salary) FROM amele_candidate GROUP BY partyid HAVING AVG(salary) <= 50000;

CREATE TABLE amele_candidate2 AS SELECT partyid, COUNT(partyid) AS partycount FROM amele_candidate GROUP BY partyid;