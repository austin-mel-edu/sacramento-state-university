SELECT fname, lname, dob, salary FROM amele_student WHERE TRUNC(MONTHS_BETWEEN(sysdate,dob)/12) > 15;

SELECT CONCAT(ssn, CONCAT(', ', CONCAT(LOWER(lname), CONCAT(', ', UPPER(fname))))) "Full_Name" FROM amele_student;

SELECT fname, lname, dob, salary FROM amele_student WHERE UPPER(lname) LIKE '%H%' OR UPPER(lname) LIKE '%A%';

SELECT fname, lname, NVL(TO_CHAR(dob),'not born yet'), salary FROM amele_student WHERE TRUNC(MONTHS_BETWEEN(sysdate,dob)/12) BETWEEN 15 AND 25 AND UPPER(fname) LIKE 'ABR%';

SELECT fname, lname, dob, DECODE(SIGN(salary-20000),-1,'poor','rich') FROM amele_student WHERE dob IS NOT NULL; 

SELECT (SQRT(MONTHS_BETWEEN(sysdate,dob)/12)+20)/5) FROM amele_student;

SELECT fname, lname, dob, salary FROM amele_student WHERE UPPER(fname) NOT IN ('JOHN','JACK','BOB');

SELECT fname, lname, dob, salary FROM amele_student WHERE SUBSTR(UPPER(fname),3,1) LIKE 'B' AND salary>10000 AND phone LIKE '527%';

CREATE TABLE amele_student2 AS SELECT fname, lname, (salary*2) AS doublesal FROM amele_student WHERE UPPER(lname) LIKE '%NN%' AND dob IS NOT NULL;