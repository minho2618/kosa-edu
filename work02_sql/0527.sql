/* 
테이블 생성하기
데이터 입력시 디비 테이블에서 자동으로 생성되는 값을 지정
Auto_Increment 
1. A, 1000 데이터가 DB로 입력되는 시점에 DB에서 자동으로 생성됨. 
2. 무조건 Primary Key 제약 조건으로 만들어야함 
3. 테이블에서 Primary Key값은 오직 하나만 가능
 

*/
DROP TABLE custom;

CREATE TABLE custom (
	num int auto_increment, -- 컬럼레벨 지정
    name varchar(10) not null,
    address varchar(50) not null,
    birthday date,
    primary key(num) -- 테이블레벨 지정
);

DESC custom;

INSERT INTO custom (name, address, birthday) VALUES ('아이유', '제주', '1990-02-22');
INSERT INTO custom (name, address, birthday) VALUES ('박보검', '서울', '1991-03-12');
INSERT INTO custom (name, address, birthday) VALUES ('김혜자', '서울', '1940-12-30');

SELECT * FROM custom;

-- JDBC Application에서는ㄴ 원래가다 자동 Commit, 하지만 COnsole기반은 자동 Commit 설정이 false
-- MySQL은 Console기반도 자동커밋으로 설정되어있음
SELECT @@autocommit; -- 1은 autocommit
set autocommit=0;

/*
CTAS
Create
Table
As
Select
::
기존의 테이블을 이용해서 새로운 테이블을 생성,
기존 테이블의 데이터도 가져올 수 있다.
기본 테이블의 제약조건은 적용안된다.
*/

CREATE TABLE emp1
AS
(SELECT * FROM emp);

CREATE TABLE emp2
AS (SELECT empno, ename, sal FROM emp);

SELECT * FROM emp1;
SELECT * FROM emp2;

DESC emp1;
DESC emp2;

-- emp1, emp2 전부 구조도 남기지 말고 메모리에서 제거
DROP TABLE emp1;
DROP TABLE emp2;
DROP TABLE employee;
DROP TABLE department;

-- CTAS를 이용해서 employee, department를 생성
CREATE
TABLE employee
AS (SELECT * FROM emp);

CREATE
TABLE department
AS (SELECT * FROM dept);

select * from employee;
select * from department;

/*
제약조건 추가하기 ALTER TABLE
1. 기본키 제약조건 추가 - PK
2. 외래키 제약조건 추가 - FK
*/
-- 1. 기본키 제약조건 추가
ALTER TABLE employee ADD constraint employee_empno_pk primary key(empno);
ALTER TABLE department ADD constraint department_deptno_pk primary key(deptno);

DESC employee;
DESC department;

-- department 테이블에서 20번 부서 삭제 | DELETE
select @@autocommit;
set autocommit=1;

DELETE FROM department WHERE deptno=20;

select * from department; -- 20번 부서가 삭제
select * from employee; -- 20번 부서에 근무하는 직원은 삭제가 안되었다.

-- 20번 부서가 삭제되면 employee 테이블에서 20번 부서에 속한 직원도 함께 삭제되어야한다.alter

-- 2. 외래키 제약조건 추가
DROP TABLE employee;
DROP TABLE department;

CREATE
TABLE employee
AS (SELECT * FROM emp);

CREATE
TABLE department
AS (SELECT * FROM dept);

ALTER TABLE employee ADD constraint employee_empno_pk primary key(empno);
ALTER TABLE department ADD constraint department_deptno_pk primary key(deptno);

select * from employee;
select * from department;

ALTER TABLE employee ADD constraint employee_deptno_fk foreign key(deptno) references department(deptno);

DESC employee; -- MUL이라고 뜬다(외래키)

-- 20번 부서를 삭제하면 외래키로 연관되어져 있기 때문에 20번의 부서의 직원도 함께 삭제가 되어야 한다.
-- 자식을 둔 부모는 죽을 수 없다. --> 자식을 먼저 삭제한 후 다음에 부모를 삭제한다.
-- 외래키를 지정할 때는 함께 위와 같은 옵션을 지정해야한다.
DELETE FROM department WHERE deptno=20; -- Error 발생

-- 3. ON DELETE CASCADE;
DROP TABLE employee;
DROP TABLE department;

CREATE
TABLE employee
AS (SELECT * FROM emp);

CREATE
TABLE department
AS (SELECT * FROM dept);

ALTER TABLE employee ADD constraint employee_empno_pk primary key(empno);
ALTER TABLE department ADD constraint department_deptno_pk primary key(deptno);

select * from employee;
select * from department;

ALTER TABLE employee ADD constraint employee_deptno_fk foreign key(deptno) 
references department(deptno) ON DELETE cascade;

DELETE FROM department WHERE deptno=20;

select * from employee;
select * from department;