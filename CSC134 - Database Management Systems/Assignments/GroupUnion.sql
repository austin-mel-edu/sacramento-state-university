SELECT fname,'Honest' FROM amele_candidate WHERE salary < 50000 
	UNION SELECT fname,'Not so Honest' FROM amele_candidate WHERE salary > 50000 AND salary < 100000 
	UNION SELECT fname,'80000' FROM amele_candidate WHERE salary > 100000 ORDER BY fname;

SELECT CASE WHEN salary < 50000 THEN 'Honest' 
	WHEN salary > 50000 AND salary < 100000 THEN 'Not so Honest'
	WHEN salary > 100000 THEN '80000'
	END
FROM amele_candidate;

SELECT fname FROM amele_candidate WHERE NVL(partyid,NULL) NOT IN (SELECT partyid FROM amele_party);

SELECT fname FROM amele_candidate c WHERE partyid NOT EXISTS (SELECT partyid FROM amele_party p WHERE c.partyid = p.partyid) ORDER BY fname;

SELECT fname FROM amele_candidate WHERE NVL(partyid,-1) IN (SELECT NVL(partyid,-1) FROM amele_candidate
	MINUS SELECT partyid FROM amele_party) ORDER BY fname;