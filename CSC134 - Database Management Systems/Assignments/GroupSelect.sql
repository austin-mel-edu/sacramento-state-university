SELECT CONCAT(INITCAP(fname), CONCAT(',', CONCAT('INITCAP(lname), CONCAT(',', dob)))) "Full Information" FROM candidate;

SELECT fname,lname AS name, TRUNC(MONTHS_BETWEEN(sysdate, dob)/12) AS age FROM candidate;

SELECT DISTINCT lname FROM candidate;

SELECT fname FROM candidate WHERE MONTHS_BETWEEN(sysdate, dob)/12 > 40;

SELECT fname FROM candidate WHERE salary IS NULL OR salary BETWEEN 20000 AND 40000;

SELECT fname FROM candidate WHERE UPPER(fname) LIKE 'C%' AND MONTHS_BETWEEN(sysdate, dob)/12 > 40;