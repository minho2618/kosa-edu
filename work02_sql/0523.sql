/*
	JOIN
    - 하나 이상의 테이블에서 질의를 던지는 경우 발생한다
    - 일반적인 경우 Primary Key와 Foreign Key 값의 연관에 의해서 발생한다.
	- Primary Key를 가지고 있는 테이블이 부모가 되고
      Foreign Key를 가지고 있는 테이블이 자식이 된다.
	- Join의 종류를 여러가지가 있지만 대표적으로 equi join, Self join, Outer Join이 있다.
    - PK, FK의 관계지정이 없어도 논리적인 값들의 연결만으로도 Join 작업을 할 수 있다.
*/

-- 각각의 사원이 어떤 부서에서 일하는 지 검색
-- step 1.
SELECT * FROM emp, dept; -- 56개의 레코드
/*
Cartesian Product란?
emp와 dept 테이블의 수평적인 결합 14 x 4 = 56
1) 조인 조건을 생략했을 때
2) 조인 조건을 잘못줬을 때
*/

-- step 2
-- Equi Join (= 연산자를 사용하는 Join)
/*
- 조인조건을 where절에 사용
- 조인조건은 두 테이블의 공통컬럼으로 한다.
*/
SELECT * FROM emp, dept
WHERE emp.deptno=dept.deptno;

-- step 1.
-- 테이블 alias를 사용 안 했다.
select *
FROM emp, dept
WHERE emp.DEPTNO = dept.DEPTNO;

-- step 2.
-- 나열하고자 하는 컬럼명을 명시해야 한다. * 지양
select *
FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO;

-- step 3.
-- 컬럼 앞에 테이블 Alias를 지정하지 않으면 성능 저항를 야기한다.
select empno, ename, sal, d.deptno, dname, loc
FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO;

-- step 4.
select e.empno, e.ename, e.sal, d.deptno, d.dname, d.loc
FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO;

-- 사원 이름, 급여, 부서번호, 부서이름, 부서위치
-- 단 급여가 2000달러 이상이고 30번 부서의 한해서 조회
SELECT e.ename, e.sal, d.deptno, d.dname, d.loc
FROM emp e, dept d
WHERE e.deptno=d.deptno
	AND e.sal>=2000
    AND d.deptno=30;
    
SELECT e.ename, e.sal, d.loc
FROM emp e, dept d
WHERE e.deptno=d.deptno
    AND d.loc='NEW YORK';
    
/*
두 테이블 간의 조인시 가장 많이 사용되는 키워드
ON, USING

ON, USING (공통적인 컬럼을 사용)

조인할 컬럼명이 같은 경우 ON, USING 다 사용할 수 있지만
조인할 컬럼명이 다른 경우에는 ON만 사용할 수 있다.

ON은 AND절을 뒤에 사용할 수 있다.
USING은 AND절이 뒤에 못 온다.
*/

-- ON
SELECT e.empno, e.ename, e.sal, d.deptno, d.dname
FROM emp e JOIN dept d ON e.deptno=d.deptno;

/*
SELECT e.empno, e.ename, e.sal, d.deptno, d.dname
FROM emp e JOIN dept d ON e.deptno=d.deptno
WHERE e.sal >= 3000;
*/

SELECT e.empno, e.ename, e.sal, d.deptno, d.dname
FROM emp e JOIN dept d ON e.deptno=d.deptno
AND e.sal >= 3000;

SELECT e.empno, e.ename, e.sal, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno=d.deptno
	AND e.sal >= 3000;
    
-- USING 절 사용
-- e.deptno - d.deptno, 이런식으로 동일한 필드를 2번 부르지 않는다는 장점이 있다.
-- 오히려 모든 테이블에 공통적으로 들어있는 컬럼명 앞에는 테이블 Alias를 지정하지 않는다.
-- step 1.
SELECT e.empno, e.ename, e.sal, deptno, d.dname
FROM emp e JOIN dept d USING(deptno);

-- step 2.
-- 조건에 해당하는 and절 사용 못함
SELECT e.empno, e.ename, e.sal, deptno, d.dname
FROM emp e JOIN dept d USING(deptno)
AND e.sal>=3000;

-- step 3.
SELECT e.empno, e.ename, e.sal, deptno, d.dname
FROM emp e JOIN dept d USING(deptno)
WHERE e.sal>=3000;

/*
Self Join
하나의 테이블을 쪼개서 정리
하나의 테이블을 사원입장에서 관리자 입장에서 나눠서 질의하는 경우를 말한다.
이때 Join조건으로 공통적인 컬럼을 사용할 수 없다.
*/
-- 특정 사원의 상사의 이름을 조회
/*
	1. 먼저 특정사원을 조회 ename, ...ALLEN
    2. ALLEN에 해당하는 mgr을 찾아서 ...7698
    3. 다시 emp 테이블에 empno를 찾고 여기에 해당하는 ename을 찾는다 ...BLAKE
*/
-- step 1.
-- BLAKE 사원의 상사번호를 찾는다
SELECT empno, ename, mgr
FROM emp; -- 7839

SELECT empno, ename
FROM emp
WHERE empno=7839; -- KING

-- step 2.
SELECT *
FROM (SELECT empno, ename, mgr
      FROM emp) e, 
	 (SELECT empno, ename
	  FROM emp) m;
      
-- step 3. 조인 조건을 추가해서 Cartesian Product가 발생하지 않도록!!
SELECT *
FROM (SELECT empno, ename, mgr
      FROM emp) e 
      JOIN
	 (SELECT empno, ename
	  FROM emp) m
      ON (e.mgr=m.empno);
      
-- step 4.
SELECT e.ename 사원이름, e.mgr 상사코드, m.ename 상사이름
FROM emp e, emp m
WHERE e.mgr=m.empno;

SELECT e.ename 사원이름, e.mgr 상사코드, m.ename 상사이름
FROM emp e JOIN emp m ON e.mgr=m.empno
AND e.ename='BLAKE';


-- emp 테이블과 dept 테이블 모두 만족하는 조인조건을 받아왔다. Inner Join
-- dept 테이블에 있는 부서번호 40번은 출력되지 않았다.
SELECT * FROM dept;
SELECT e.ename, e.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno=d.deptno;

/*
Outer Join
A, B 테이블을 조인할 경우
양쪽 모두에 들어있는 데이터가 아니라도 표시하고 싶을 때 Outer Join을 사용

LEFT OUTER JOIN | RIGHT OUTER JOIN | FULL OUTER JOIN
(데이터 있는 쪽을 기준으로 한다)
*/

SELECT e.ename, e.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno=d.deptno;

-- right outer join
SELECT e.ename, d.deptno, d.dname
FROM emp e RIGHT OUTER JOIN dept d
ON e.DEPTNO=d.DEPTNO;

-- left outer join
SELECT e.ename, d.deptno, d.dname
FROM emp e LEFT OUTER JOIN dept d
ON e.DEPTNO=d.DEPTNO;

-- 2) LEFT OUTER JOIN
-- 특정 사원의 상사의 이름을 검색
-- KING은 MGR이 존재하지 않기때문에 컬럼값이 NULL
-- e.mgr이 부분이 null호 나오기 때문에 13행이 출력
SELECT concat(e.ename, '의 상사는 ', ifnull(m.ename, '없음'), '입니다') info
FROM emp e LEFT OUTER JOIN emp m ON e.mgr=m.empno;

SELECT e.ename, m.ename
FROM emp e LEFT OUTER JOIN emp m ON e.mgr=m.empno;

-- 3) FULL OUTER JOIN
-- MySQL에서는 FULL OUTER JOIN을 지원 안함
-- 대신 UNION(중복을 제외한 합집합) 사용
CREATE TABLE outera(sawonid int); -- 10, 20, 40
CREATE TABLE outerb(sawonid int); -- 10, 20, 30

insert into outera values(10);
insert into outera values(20);
insert into outera values(40);

insert into outerb values(10);
insert into outerb values(20);
insert into outerb values(30);

select * from outera;
select * from outerb;

select sawonid from outera 
UNION 
select sawonid from outerb;

/*
SET 연산자
(집합 연산자)

UNION
UNION ALL
INTERSECT
MINUS

CTAS
Create Table AS Select
기존의 테이블을 가지고 새로운 테이블로 생성할 떄 사용
제약조건은 적용되지 않는다 -> 별도로 적용해야함
*/

-- emp --> newemp
-- dept --> newdept
CREATE TABLE newemp
AS (SELECT  * FROM emp);

DESC newemp;

DROP table newemp;

DESC newemp;

CREATE TABLE newemp
AS (SELECT empno, ename, job, sal, deptno
	FROM emp 
    WHERE deptno=20);
    
DESC newemp;

INSERT INTO newemp
VALUES (111, '박나래', 'CLERK', 900, 10);
INSERT INTO newemp
VALUES (222, '전현무', 'MANAGER', 1400, 20);

select * from newemp;

-- UNION(EMP+NEWEMP)
-- UNION ALL
-- INTERSECT
-- MINUS
SELECT empno, ename, job, sal, deptno
FROM emp
UNION
SELECT empno, ename, job, sal, deptno
FROM newemp;

SELECT empno, ename, job, sal, deptno
FROM emp
UNION ALL
SELECT empno, ename, job, sal, deptno
FROM newemp;


