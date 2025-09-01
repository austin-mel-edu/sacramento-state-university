SELECT fname FROM amele_candidate WHERE partyid=(SELECT partyid FROM amele_party WHERE partydesc='Democrat');

SELECT fname, lname, partydesc FROM amele_candidate c ,amele_party p WHERE UPPER(c.lname) LIKE '%C';

SELECT fname FROM amele_candidate WHERE partyid IN (SELECT partyid FROM amele_party WHERE IN('Democrat','Republican');

CREATE TABLE amele_candidate2 AS SELECT fname, lname, salary-(salary*.10) tenpercentless FROM amele_candidate WHERE partyid=(SELECT partyid FROM amele_party WHERE partydesc='Republican'); 
