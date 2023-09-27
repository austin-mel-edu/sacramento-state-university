DROP TABLE amele_student_class;
DROP TABLE amele_student;
DROP TABLE amele_class;

CREATE TABLE amele_student(
	ssn VARCHAR2(9) CONSTRAINT amele_student_ssn_pk PRIMARY KEY,
	fname VARCHAR2(20),
	lname VARCHAR2(30),
	dob DATE,
	salary NUMBER CONSTRAINT amele_student_salary_ck CHECK (salary > 10000),
	CONSTRAINT amele_student_name_uk UNIQUE (fname,lname)
);

CREATE TABLE amele_class(
	classCode VARCHAR2(5) CONSTRAINT amele_class_ccode_pk PRIMARY KEY,
	classDesc VARCHAR2(40),
);

CREATE TABLE amele_student_class(
	ssn VARCHAR2(9) CONSTRAINT amele_stdclass_ssn_fk REFERENCES amele_student (ssn),
	classCode VARCHAR2(5) CONSTRAINT amele_stdclass_clcode_fk REFERENCES amele_class (classCode),
	CONSTRAINT amele_stdclass_pk PRIMARY KEY (ssn,classCode)
); 

CREATE INDEX amele_class_idx ON amele_class (classDesc);


INSERT INTO amele_class VALUES ('10001','Physics 1A');
INSERT INTO amele_class VALUES ('20205','Discrete Math');

INSERT INTO amele_student VALUES ('111111111','John','Doe',TO_DATE('03-23-02' 'yy-dd-mm'),'34000');
INSERT INTO amele_student VALUES ('222222222','Emily','Smith','12-OCT-2002','40000');

INSERT INTO amele_student_class VALUES ('111111111','10001');
INSERT INTO amele_student_class VALUES ('222222222','20205');
INSERT INTO amele_student_class VALUES ('111111111','20205');



INSERT INTO amele_student VALUES ('111111111', 'Jack','Turnip','07-MAY-1999','32010');

INSERT INTO amele_student VALUES ('333333333','John','Doe',04-JUL-2001','12000');

INSERT INTO amele_student VALUES ('444444444','Michael','Tyson','13-JAN-1980','7000');

INSERT INTO amele_student_class VALUES ('111111111','30000');

INSERT INTO amele_student_class VALUES ('777777777','20205');

INSERT INTO amele_student_class VALUES ('111111111','10001');

ALTER TABLE amele_student_class DISABLE CONSTRAINT amele_stdclass_ssn_fk;

INSERT INTO amele_student_class VALUES ('999999999','20205');

ALTER TABLE amele_student_class ENABLE CONSTRAINT amele_stdclass_ssn_fk;

DELETE FROM amele_student_class;

TRUNCATE TABLE amele_student;

DROP INDEX amele_student_ssn_pk;
DROP INDEX amele_student_name_uk;

ALTER TABLE amele_student_class DROP CONSTRAINT amele_stdclass_ssn_fk;
ALTER TABLE amele_student_class DROP CONSTRAINT amele_stdclass_clcode_fk;

DROP TABLE amele_student;