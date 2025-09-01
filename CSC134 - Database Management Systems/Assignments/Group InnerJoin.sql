SELECT * FROM amele_party, amele_candidate;

SELECT lname, partydesc FROM amele_party INNER JOIN amele_candidate USING (partyid);

SELECT lname, NVL(partydesc,'No Description') FROM amele_party p JOIN amele_candidate c ON NVL(p.partyid,-1) = NVL(c.partyid,-1);

SELECT COUNT(partydesc), partydesc FROM amele_party INNER JOIN amele_candidate USING (partyid) GROUP BY partydesc;

SELECT COUNT(partydesc), partydesc FROM amele_party INNER JOIN amele_candidate USING (partyid) WHERE
	(SELECT AVG(salary) FROM amele_candidate INNER JOIN amele_party USING (partyid)) > 50000 GROUP BY partydesc;