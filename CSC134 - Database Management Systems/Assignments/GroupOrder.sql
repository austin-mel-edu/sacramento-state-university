SELECT lname, fname, salary FROM amele_candidate ORDER BY lname ASC;

SELECT lname,fname,salary,CONCAT(lname,fname) AS fullname FROM amele_candidate ORDER BY 4 DESC;

SELECT lname, fname, (salary*2) AS double_salary FROM amele_candidate ORDER BY double_salary DESC;