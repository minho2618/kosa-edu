/*
서브 쿼리
?에 해당하는 것을 먼저 알아내야 하기에 ( )로 ?에 해당하는 쿼리를 싸준다.
( ) 실행한 결과가 전체 쿼리에서 실행된다.
*/

-- WHERE 절 서브쿼리
-- ADAMS의 급여보다 더 많은 급여를 받는 사원을 검색

-- Step 1.
-- 2번의 질의를 디비에 함(DB Access를 2번 함) --> 효율성, 성능 저하
SELECT sal FROM emp WHERE ename='ADAMS'; -- 1100
SELECT ename, sal FROM emp WHERE sal > 1100;

-- Step 2.
SELECT ename, sal
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename='ADAMS');

SELECT ename, sal
FROM emp
WHERE deptno=10 AND sal>(SELECT avg(sal) FROM emp);

SELECT empno, ename, job, hiredate, sal
FROM emp
WHERE job=(SELECT job FROM emp WHERE empno=7521) 
AND sal>(SELECT sal FROM emp WHERE empno=7934);

SELECT ename, deptno, sal, hiredate
FROM emp
WHERE sal=(SELECT max(sal) FROM emp);

/*
5000, 1300, 1100,
SALESMAN
KIN
1ROW 1COLUMN 같은 값을 스칼라값 혹은 스칼라서브쿼리라 한다.
서브쿼리 수행 결과로 스칼라값이 나오면 단일행 연산자를 사용해야 한다.
=, !=, <>, >, <, >=, <= 
*/

-- HAVING절 서브쿼이
-- HAVING절에 사용되는 서브쿼리
SELECT deptno, min(sal)
FROM emp
GROUP BY deptno
HAVING min(sal)>(SELECT min(sal) FROM emp WHERE deptno=20);

-- MySQL은 그룹함수 중첩이 안됨
-- Step 1.
SELECT job, avg(sal)
FROM emp
GROUP BY job
HAVING avg(sal)=(SELECT min(avg(sal)) from emp GROUP BY job);

-- FROM 절 서브쿼리
-- Step 2.
-- avg(sal)와 테이블 alias를 사용한다
SELECT job, min(avgsal)
FROM (SELECT job, avg(sal) avgsal FROM emp GROUP BY job) e
GROUP BY job;

-- Step 3.
-- LIMIT (서브쿼리 사용 안 함, 정렬 사용)
SELECT job, avg(sal)
FROM emp
GROUP BY job
ORDER BY 2
LIMIT 1;

-- Step 1.
SELECT ename, sal
FROM emp
WHERE sal>(SELECT sal FROM emp WHERE ename='SCOTT');

-- Step 2.
-- Table Alias 사용하는 방법
SELECT a.ename, a.sal, a.job
FROM emp a, (SELECT MAX(sal) AS scott_salary FROM emp WHERE ename = 'SCOTT') b
WHERE a.sal > b.scott_salary;


SELECT ename, sal, mgr
FROM emp a, (SELECT empno FROM emp WHERE ename='KING') b
WHERE a.mgr=b.empno;

-- 2. 다중행 연산자와 함께 사용된 서브쿼리
SELECT empno, ename
FROM emp
WHERE sal=(SELECT min(sal) FROM emp GROUP BY deptno); -- Error

SELECT empno, ename, sal
FROM emp
WHERE sal IN (SELECT min(sal) FROM emp GROUP BY deptno);

/*
다중 행 연산
*/

SELECT ename, job, sal
FROM emp
WHERE sal < ANY(SELECT sal FROM emp WHERE job='CLERK')
AND job <> 'CLERK';

SELECT ename, deptno, sal, job
FROM emp
WHERE sal > ALL(SELECT avg(sal) FROM emp GROUP BY deptno);

SELECT ename, deptno, sal, job
FROM emp
WHERE sal > ANY(SELECT sal FROM emp WHERE deptno=10)
AND deptno <> 10;

-- 
SELECT * FROM emp WHERE deptno=30; -- BLAKE 2850

-- 1) ALL 다중 행 연산자 사용
SELECT empno, ename, sal
FROM emp
WHERE sal > ALL(SELECT sal FROM emp WHERE deptno=30)
ORDER BY empno;

-- 2) max(sal) 그룹함수 사용 + 단일행 함수
SELECT empno, ename, sal
FROM emp
WHERE sal > (SELECT max(sal) FROM emp WHERE deptno=30);

SELECT ename, deptno, sal
FROM emp
WHERE sal > (SELECT min(sal) FROM emp WHERE deptno=30);

SELECT ename, deptno, sal
FROM emp
WHERE sal > ANY(SELECT sal FROM emp WHERE deptno=30);

/*
서브쿼리에서 null 값 다루기
*/
SELECT empno, ename, job
FROM emp 
WHERE empno IN (SELECT mgr FROM emp);

SELECT empno, ename, job
FROM emp e, (SELECT DISTINCT mgr FROM emp) g
WHERE e.empno=g.mgr;

SELECT empno, ename, job
FROM emp 
WHERE empno NOT IN (SELECT ifnull(mgr, '') FROM emp);

SELECT empno, ename, job
FROM emp 
WHERE empno NOT IN (SELECT mgr FROM emp WHERE mgr is not null);
