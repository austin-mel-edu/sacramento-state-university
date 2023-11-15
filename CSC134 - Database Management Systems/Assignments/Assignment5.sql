SELECT lname, COUNT(lname) FROM amele_student WHERE UPPER(state) != 'CA' GROUP BY lname;

SELECT state, COUNT(state) FROM amele_student WHERE UPPER(city) NOT LIKE '%H%' GROUP BY state;

SELECT ssn, COUNT(class_code) AS "Number of Classes" FROM amele_student_class GROUP BY ssn HAVING COUNT(class_code) < 2 ORDER BY ssn DESC;

SELECT city, state, ROUND(AVG(TRUNC(MONTHS_BETWEEN(sysdate,dob))/12)) AS "AVERAGE AGE" FROM amele_student WHERE ssn IN (SELECT ssn FROM amele_student_class WHERE class_code IN (SELECT class_code FROM amele_class WHERE UPPER(class_description) LIKE '%INTRO%')) AND UPPER(city) != 'Berkeley' GROUP BY city,state ORDER BY city ASC, state DESC;

SELECT LOWER(state) AS "LowerState", ROUND(AVG(TRUNC(MONTHS_BETWEEN(sysdate,dob))/12)) AS "Average of Ages" FROM amele_student WHERE ssn IN (SELECT ssn FROM amele_student_class WHERE class_code IN (SELECT class_code FROM amele_class WHERE UPPDER(class_description) IN '%PRINCIPLES%'));