SELECT fname, lname FROM amele_student WHERE ssn IN (SELECT ssn FROM amele_student_class WHERE class_code IN (SELECT class_code FROM amele_class WHERE UPPER(class_description)='DATABASE PROGRAMMING'));

SELECT * FROM amele_student_class WHERE class_code IN (SELECT class_code FROM amele_class WHERE class_description IS NOT NULL);

SELECT fname, lname FROM amele_student WHERE UPPER(fname) NOT IN ('JOHN','JACK','BOB') AND phone IS NOT NULL AND ssn IN (SELECT ssn FROM amele_student_class WHERE class_code IN (SELECT class_code FROM amele_class WHERE UPPER(class_description)='DATABASE PROGRAMMING'));

SELECT ssn, fname, lname, (TODIGIT(TRUNC(MONTHS_BETWEEN(sysdate,dob)))/12/2) halfage FROM amele_student WHERE UPPER(fname) LIKE 'J%' AND TRUNC(MONTHS_BETWEEN(sysdate,dob)/12) > 25 AND class_code IN (SELECT class_code FROM amele_class WHERE UPPER(class_description) LIKE '%Intro%');

SELECT fname, lname FROM amele_student WHERE UPPER(lname) LIKE '%NN%' AND class_code IN (SELECT class_code FROM amele_class WHERE UPPER(class_description) LIKE '%H%') ORDER BY 2;

DELETE FROM amele_class WHERE class_code IN (SELECT class_code FROM amele_student_class WHERE ssn IN (SELECT ssn FROM amele_student WHERE UPPER(city)='SACRAMENTO' AND WHERE salary < 15000);

CREATE TABLE amele_class2 AS SELECT class_code, class_description FROM amele_class WHERE class_code IN (SELECT class_code FROM amele_student_class WHERE ssn IN (SELECT ssn from amele_student WHERE TRUNC(MONTHS_BETWEEN(sysdate,dob)/12) > 30)));

UPDATE amele_student SET salary=75000 WHERE ssn IN (SELECT ssn FROM amele_student_class WHERE class_code IN (SELECT class_code FROM amele_class WHERE UPPER(class_description)='DATABASE PROGRAMMING');