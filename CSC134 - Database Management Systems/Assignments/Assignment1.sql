CREATE TABLE amele_student(
	ssn VARCHAR2(9) CONSTRAINT amele_student_ssn_pk PRIMARY KEY,
	lname VARCHAR2(30),
	fname VARCHAR2(30),
	age NUMBER,
	salary NUMBER,
	dob NUMBER
);

ALTER TABLE amele_student ADD CONSTRAINT amele_student_lname_uk UNIQUE (lname);
ALTER TABLE amele_student ADD CONSTRAINT amele_student_fname_uk UNIQUE (fname);

ALTER TABLE amele_student ADD CONSTRAINT amele_student_age_ck CHECK (age BETWEEN 11 and 49);

ALTER TABLE amele_student ADD address VARCHAR2(40);

ALTER TABLE amele_student MODIFY dob DATE NOT NULL;

CREATE INDEX amele_student_idx ON amele_student (ssn,dob);

ALTER TABLE amele_student ADD transferable VARCHAR2(40) NOT NULL;

ALTER TABLE amele_student ADD CONSTRAINT amele_student_transf_ck CHECK (transferable in ('Y','y','N','n'));

ALTER TABLE amele_student DROP (age);



CREATE TABLE amele_class(
	classCode VARCHAR2(10),
	classDesc VARCHAR2(50) UNIQUE NOT NULL
);

ALTER TABLE amele_class ADD CONSTRAINT amele_class_pk PRIMARY KEY (classCode);

CREATE INDEX amele_class_idx ON amele_class (classDesc);

CREATE TABLE amele_student_class(
	ssn VARCHAR2(9),
	classCode VARCHAR2(10)
);

ALTER TABLE amele_student_class ADD CONSTRAINT amele_student_class_pk PRIMARY KEY (ssn,classCode);

ALTER TABLE amele_student_class ADD CONSTRAINT amele_student_class_st_fk FOREIGN KEY (ssn) REFERENCES amele_student;
ALTER TABLE amele_student_class ADD CONSTRAINT amele_student_class_cl_fk FOREIGN KEY (classCode) REFERENCES amele_class;