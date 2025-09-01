amele

ALTER TABLE amele_candidate ADD CONSTRAINT amele_candidate_salary_ck CHECK (salary BETWEEN 10001 and 49999);

ALTER TABLE amele_party MODIFY partyDesc NOT NULL;

ALTER TABLE amele_candidate DISABLE CONSTRAINT amele_candidate_salary_ck;

ALTER TABLE amele_candidate ADD partyid NUMBER;
ALTER TABLE amele_candidate ADD CONSTRAINT amele_candidate_partyid_fk FOREIGN KEY (partyID) REFERENCES amele_party;

ALTER TABLE amele_candidate DISABLE CONSTRAINT amele_candidate_partyid_fk;

ALTER TABLE amele_candidate DROP CONSTRAINT amele_candidate_partyid_fk;
