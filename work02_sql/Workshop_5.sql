-- ################## SubQuery ##################

-- 1.  ‘SMITH'의 직무와 같은 사람의 이름, 부서명, 급여, 직무를  출력하라.
SELECT ename, d.dname, sal, job
FROM emp e, dept d
WHERE job=(SELECT job FROM emp WHERE ename='SMITH') 
AND e.deptno=d.deptno;


-- 2.  ‘JONES’가 속해있는 부서의 모든 사람의 사원번호, 이름, 입사일, 급여를 출력하라.
SELECT empno, ename, hiredate, sal
FROM emp
WHERE deptno=(SELECT deptno FROM emp WHERE ename='JONES');

-- 3.  전체 사원의 평균급여보다 급여가 많은 사원의 사원번호, 이름,부서번호, 입사일,급여를 출력하라.
SELECT empno, ename, deptno, hiredate, sal
FROM emp
WHERE sal > (SELECT avg(sal) FROM emp);


-- 4. 10번 부서와 같은 일을 하는 사원의 사원번호, 이름, 급여를 검색..급여가 많은 순으로 출력하라.
SELECT empno, ename, sal
FROM emp
WHERE job IN (SELECT job FROM emp WHERE deptno=10)
ORDER BY sal DESC;

-- 5.  10번 부서 중에서 30번 부서에는 없는 업무를 하는 사원의 사원번호, 이름, 부서번호,업무, 입사일을 출력하라.
SELECT empno, ename, job, hiredate
FROM emp
WHERE deptno=10
AND job NOT IN (SELECT job FROM emp WHERE deptno=30);


-- 6.  ‘SCOTT’이나 ‘ADAMS'의 급여와 같은 사원의 사원번호, 이름,급여를 출력하라.
SELECT empno, ename, sal
FROM emp
WHERE sal IN (SELECT sal FROM emp WHERE ename='SCOTT' OR ename='ADAMS');


-- 7.  급여가 30번 부서의 최고 급여보다 높은 사원의 사원번호,이름, 급여를 출력하라.
SELECT empno, ename, sal
FROM emp
WHERE sal > ALL(SELECT sal FROM emp WHERE deptno=30);


-- 8. SCOTT의 급여보다 더많은 급여를 받는 사원을 검색
SELECT ename, sal
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename='SCOTT');


-- 9. 부서별 최소급여 중에서 20번 부서의 최소급여보다 더 큰 최소급여를 검색
SELECT deptno, min(sal)
FROM emp
GROUP BY deptno
HAVING min(sal) > ANY (SELECT sal FROM emp WHERE deptno=20);

-- 10. 급여가 10번부서에 속한 어떤 사원의 급여보다 더 많은 급여를 받는 사원을 검색. 
-- 이때 10번 부서에 속한 사원은 제외 
-- 정렬은 사원번호순으로 한다. 
SELECT e.empno, e.ename, e.sal, e.deptno
FROM (SELECT  empno, ename, sal, deptno FROM emp WHERE deptno!=10) e
WHERE sal > ANY (SELECT sal FROM emp WHERE deptno=10)
ORDER BY 1;


-- 11. 30번 소속 사원들 중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사원의 이름과 급여를 검색 
-- 2가지 방법 사용
SELECT ename, sal
FROM emp
WHERE sal > ALL (SELECT sal FROM emp WHERE deptno=30);

SELECT ename, sal
FROM emp
WHERE sal > (SELECT max(sal) FROM emp WHERE deptno=30);


-- 12. 부하직원을 거느린 사원을 검색 . 상사이름과 상사의 사원번호가 검색되도록(알리야스 상사이름, 상사사원번호)
SELECT e.ename 상사이름, e.empno 상사사원번호
FROM emp e, (SELECT DISTINCT mgr FROM emp) m
WHERE e.empno=m.mgr;