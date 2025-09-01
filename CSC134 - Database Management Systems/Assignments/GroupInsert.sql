DROP TABLE amele_candidate;
DROP TABLE amele_party;

CREATE TABLE amele_candidate(
	candidate_id NUMBER CONSTRAINT amele_candidate_id_pk PRIMARY KEY,
	first_name VARCHAR2(20),
	last_name VARCHAR(30),
	dob DATE,
	salary NUMBER CONSTRAINT amele_candidate_salary_pk CHECK (salary BETWEEN 10001 AND 49999),
	party_id NUMBER CONSTRAINT amele_candidate_partyid_fk REFERENCES amele_party (party_id),
	CONSTRAINT amele_candidate_name_uk UNIQUE (first_name,last_name) 
);

CREATE TABLE amele_party(
	party_id NUMBER CONSTRAINT amele_party_id_pk PRIMARY KEY,
	partydesc VARCHAR2(20) CONSTRAINT amele_party_partydesc_uk UNIQUE
);


INSERT INTO amele_party VALUES ('1','Green Party');
INSERT INTO amele_party VALUES ('2','Communists');
INSERT INTO amele_candidate VALUES ('1','Jeff','Johnson','10/MAY/1987','25000','1');
INSERT INTO amele_candidate VALUES ('2','Jack','Smith','13/FEB/1992','12000','2'); 

INSERT INTO amele_candidate VALUES ('3','Mikey','Grumble',TO_DATE('01/20/94' 'mm/dd/yy'),'42000','1');
INSERT INTO amele_candidate VALUES ('4','Nick','Gobblesnort',TO_DATE('27/07/87' 'dd/mm/yy'),'34050','2');

SELECT TO_CHAR(dob, 'MM/DD/YYYY') FROM amele_candidate;

SELECT TO_CHAR(dob, 'DD/YYYY/MM HH12:MI;SS') FROM amele_candidate;

INSERT INTO amele_candidate VALUES ('5','Gerome','Gurgus','15/SEP/1991','100000','2');

INSERT INTO amele_candidate VALUES ('6','Nick','Gobblesnort','27/JUL/87','17920','2');

SELECT table_name,constraint_name,constraint_type FROM user_constraints WHERE table_name='AMELE_PARTY,AMELE_CANDIDATE';


 