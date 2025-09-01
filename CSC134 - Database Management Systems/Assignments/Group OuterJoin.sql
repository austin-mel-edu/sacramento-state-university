SELECT lname, NVL(partydesc,'No Party') FROM amele_candidate c, amele_party p WHERE p.partyid(+) = c.partyid;

SELECT NVL(lname,'No One'), partydesc FROM amele_candidate c, amele_party p WHERE p.partyid = c.partyid(+);