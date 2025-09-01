amele



CREATE TABLE amele_candidate(
	fname VARCHAR2(20),
	lname VARCHAR2(20),
	dob DATE,
	salary NUMBER
);

CREATE TABLE amele_party(
	partyDesc VarChar2(30)
);

ALTER TABLE amele_candidate DROP (dob);

ALTER TABLE amele_candidate ADD dob DATE;

ALTER TABLE amele_candidate ADD id NUMBER;
ALTER TABLE amele_candidate ADD CONSTRAINT amele_candidate_id_pk PRIMARY KEY (id);

ALTER TABLE amele_party ADD partyid NUMBER;
ALTER TABLE amele_party ADD CONSTRAINT amele_party_partyid_pk PRIMARY KEY (partyid);

ALTER TABLE amele_candidate ADD CONSTRAINT amele_composite_uk NOT NULL UNQIUE (fname, lname, dob);

DROP TABLE amele_candidate;

CREATE TABLE amele_candidate(
	id NUMBER CONSTRAINT amele_candidate_id_pk PRIMARY KEY,
	fname VARCHAR(20),
	lname VARCHAR(20),
	dob DATE,
	salary NUMBER
);