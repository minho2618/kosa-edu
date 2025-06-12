
-- ### equi join ###

-- 1.  emp와 dept Table을 JOIN하여 부서번호, 부서명, 이름, 급여를  출력하라.
SELECT d.deptno, d.dname, e.ename, e.sal
FROM dept d JOIN emp e ON d.DEPTNO=e.DEPTNO;


-- 2.  이름이 ‘SMITH’인 사원의 부서명을 출력하라.
SELECT e.ename, d.dname
FROM emp e JOIN dept d USING (deptno)
WHERE e.ename='SMITH';

 
-- ### outer join ###

-- 1.  dept Table에 있는 모든 부서를 출력하고, emp Table에 있는 DATA와 JOIN하여 
-- 모든 사원의 이름, 부서번호, 부서명, 급여를 출력 하라.
SELECT e.ename, d.deptno, d.dname, e.sal
FROM dept d LEFT OUTER JOIN emp e ON d.DEPTNO=e.DEPTNO;



-- ###self join###
-- 2.  emp Table에 있는 empno와 mgr을 이용하여 서로의 관계를 다음과 같이 출력하라. ‘SMTH의 매니저는 FORD이다’
SELECT concat(e.ename, '의 매니저는 ', m.ename, '이다') info
FROM emp e JOIN emp m ON e.mgr=m.empno;



-- ### join 실습 ###

-- 1. 관리자가 7698인 사원의 이름, 사원번호, 관리자번호, 관리자명을 출력하라.
SELECT e.ename, e.empno, e.mgr, m.ename
FROM emp e JOIN emp m ON e.mgr=m.empno
AND e.mgr=7698;

-- 2. 업무가 MANAGER이거나 CLERK인 사원의 사원번호, 이름, 급여, 업무, 부서명
SELECT e.empno, e.ename, e.sal, e.job, d.dname
FROM emp e JOIN dept d USING (deptno)
WHERE e.job IN ('MANAGER', 'CLERK');


-- ### set 연산자 ### --
-- 1. dept와 동일한 테이블(단 dept테이블의 10, 20부서의 데이터를 입력)을 하나 생성한다.
-- 테이블명은 newdept로 하자  
CREATE TABLE newdept
AS (SELECT DEPTNO, DNAME, LOC
	FROM dept
    WHERE deptno IN (10, 20));
	
select * from newdept;

-- 2. 추가 데이터를 입력한다. 2행입력
INSERT INTO newdept VALUE(50, 'R&D', 'SEOUL');
INSERT INTO newdept VALUE(60, 'QA', 'BUSAN');

-- 3. dept테이블과 newdept 테이블의 모든 행을 출력하라.(단, 중복되는 행은 한번만 출력한다)
SELECT DEPTNO, DNAME, LOC
FROM dept
UNION
SELECT DEPTNO, DNAME, LOC
FROM newdept;


-- 4. dept테이블과 newdept 테이블의 모든 행을 출력하라.
SELECT DEPTNO, DNAME, LOC
FROM dept
UNION ALL
SELECT DEPTNO, DNAME, LOC
FROM newdept;






