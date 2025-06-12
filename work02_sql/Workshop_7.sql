-- 1.
CREATE TABLE my_dept
(
	dept_no int,
	dept_name varchar(20),
	dept_loc varchar(20),
	dept_telno varchar(20)
);

-- 2.
ALTER TABLE my_dept ADD constraint my_dept_dept_no_pk primary key (dept_no);

-- 3.
INSERT INTO my_dept (dept_no, dept_name, dept_loc, dept_telno) VALUES (10, 'SALES', 'SEOUL', '02-671-1111');
INSERT INTO my_dept (dept_no, dept_name, dept_loc, dept_telno) VALUES (20, 'FINANCE', 'SEOUL', '02-862-2222');
INSERT INTO my_dept (dept_no, dept_name, dept_loc, dept_telno) VALUES (30, 'HR', 'BUSAN', '051-111-1111');
INSERT INTO my_dept (dept_no, dept_name, dept_loc, dept_telno) VALUES (40, 'PURCHASE', 'BUSAN', '051-222-2222');
INSERT INTO my_dept (dept_no, dept_name, dept_loc, dept_telno) VALUES (50, 'MANAGEMENT', 'SEOUL', '02-383-3333');

-- 4.
CREATE TABLE my_emp
(
	emp_no int,
 	emp_name varchar(10),
 	emp_mgr int,
 	hiredate date,
 	sal double,
 	dept_no int 
);

-- 5.
ALTER TABLE my_emp ADD constraint my_emp_emp_no_pk primary key (emp_no);
ALTER TABLE my_emp ADD constraint my_emp_dept_no_fk foreign key (dept_no) references my_dept(dept_no) ON DELETE CASCADE;

-- 6.
INSERT INTO my_emp (emp_no, emp_name, emp_mgr, hiredate, sal, dept_no) VALUES (1001, 'KIM', 1003, '2019-01-15', 4750, 20);
INSERT INTO my_emp (emp_no, emp_name, emp_mgr, hiredate, sal, dept_no) VALUES (1002, 'LEE', 1003, '2021-06-05', 3000, 30);
INSERT INTO my_emp (emp_no, emp_name, emp_mgr, hiredate, sal, dept_no) VALUES (1003, 'PARK', 1001, '2023-11-28', 3500, 10);

-- 7.
UPDATE my_emp SET dept_no=50 WHERE dept_no=30;

-- 8.
DELETE FROM my_dept WHERE dept_no=30;

-- 9.
INSERT INTO my_emp (emp_no, emp_name, emp_mgr, hiredate, sal, dept_no) VALUES (2001, 'chung', 1001, curdate(), 3000, 50);