SELECT ssn,fname,NVL(class_description,'No description is available yet') FROM amele_student 
	NATURAL JOIN amele_student_class 
		NATURAL JOIN amele_class; 

SELECT lname,class_code FROM amele_student 
	INNER JOIN amele_student_class USING (ssn) 
		INNER JOIN amele_class USING (class_code) WHERE class_description='Introduction to C programming';

SELECT NVL(class_description,'Other Classes'),COUNT(class_code) FROM amele_student_class INNER JOIN amele_class USING (class_code)
		INNER JOIN amele_student USING (ssn) WHERE MONTHS_BETWEEN(sysdate,dob)/12 > 
    		(SELECT AVG(MONTHS_BETWEEN(sysdate,dob)/12) FROM amele_student) GROUP BY class_description 
        		HAVING COUNT(class_code) > 1 ORDER BY COUNT(class_code);

SELECT class_code,class_description FROM amele_class
	WHERE class_code NOT IN (SELECT class_code FROM amele_student_class);

SELECT ssn,fname,lname FROM amele_student
	MINUS (SELECT ssn,fname,lname FROM amele_student st
    		WHERE EXISTS (SELECT ssn FROM amele_student_class sc WHERE st.ssn=sc.ssn));

CREATE TABLE new_list AS SELECT ssn social,class_code cls,NVL(class_description,'No description') descr FROM amele_student
  NATURAL JOIN amele_student_class
    NATURAL JOIN amele_class
	UNION SELECT st.ssn,NVL(sc.class_code,'No classes'),NVL(cl.class_description,'No description') 
  		FROM amele_student st,amele_student_class sc, amele_class cl WHERE st.ssn = sc.ssn(+) AND sc.class_code = cl.class_code(+);
      

CREATE TABLE new_list2 AS SELECT ssn social,class_code cls,NVL(class_description,'No description') descr FROM amele_student
  NATURAL JOIN amele_student_class
    NATURAL JOIN amele_class
	UNION (SELECT st.ssn,NVL(sc.class_code,'No classes'),NVL(cl.class_description,'No description') 
  		FROM amele_student st,amele_student_class sc, amele_class cl WHERE 
      		NOT EXISTS (SELECT st.ssn,cl.class_code,cl.class_description FROM amele_student st,amele_student_class sc, amele_class cl 
		WHERE st.ssn = sc.ssn AND sc.class_code = cl.class_code));

CREATE VIEW list_view AS SELECT fname,lname,class_description FROM amele_student
	INNER JOIN amele_student_class USING (ssn)
		INNER JOIN amele_class USING(class_code) WHERE MONTHS_BETWEEN(sysdate,dob)/12 > 
    		(SELECT AVG(MONTHS_BETWEEN(sysdate,dob)/12) FROM amele_student);

SELECT lname,class_description FROM amele_student,amele_student_class,amele_class
MINUS SELECT lname,class_description FROM amele_student
	NATURAL JOIN amele_student_class
		NATURAL JOIN amele_class;

SELECT constraint_name,column_name FROM user_cons_columns WHERE constraint_name IN 
  (SELECT constraint_name FROM user_constraints WHERE table_name='AMELE_STUDENT' AND constraint_type='P');


SELECT constraint_name,column_name FROM user_cons_columns WHERE constraint_name IN 
  (SELECT constraint_name FROM user_constraints WHERE table_name='AMELE_STUDENT' AND constraint_type='U');

SELECT constraint_name,column_name FROM user_cons_columns WHERE constraint_name IN 
  ((SELECT constraint_name FROM user_constraints WHERE table_name='AMELE_STUDENT' AND constraint_type='R')
  UNION
  (SELECT r_constraint_name FROM user_constraints WHERE table_name='AMELE_STUDENT' AND constraint_type='R'));

SELECT

SELECT constraint_name,search_condition FROM user_constraints WHERE table_name='AMELE_STUDENT' AND constraint_type='C';







		
