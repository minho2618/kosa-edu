-- 1) emp 테이블 정보를 확인하세요.
DESC emp;

-- 2) 부서번호가 20번인 부서의 사람 중 사원번호, 이름, 월급을 출력하세요.
SELECT empno, ename, sal
FROM emp
WHERE deptno=20;

-- 3) 사원번호가 7521인 사람 중 이름, 입사일, 부서번호를 출력하세요
SELECT ename, hiredate, deptno
FROM emp
WHERE empno=7521;

-- 4) 이름이 JONES인 사람의 모든 정보를 출력하세요
SELECT EMPNO, ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO
FROM emp
WHERE ENAME='JONES';

-- 5) 직업이 MANAGER인 사람의 모든 정보를 출력하세요
SELECT EMPNO, ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO
FROM emp
WHERE job='MANAGER';

-- 6)직업이 MANAGER가 아닌 사람의 모든 정보를 출력하세요
SELECT EMPNO, ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO
FROM emp
WHERE job<>'MANAGER';

-- 7) 급여가 $1000 이상인 사람의 이름, 급여, 부서번호를 출력하세요
SELECT ename, sal, deptno
FROM emp
WHERE sal>=1000;

-- 8) 급여가 $1,600보다 크고 $3,000보다 작은 사람의 이름, 직업, 급여를 출력하세요.
SELECT ename, job, sal
FROM emp
WHERE sal > 1600 AND sal < 3000;

-- 9) 입사일이 80년도인 사람의 모든 정보를 출력하세요
SELECT EMPNO, ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO
FROM emp
WHERE hiredate BETWEEN '1980-01-01' AND '1980-12-31';

-- 10) 입사일이 81/12/09 보다 먼저 입사한 사람들의 모든 정보를 출력하세요.
SELECT EMPNO, ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO
FROM emp
WHERE hiredate < '1981-12-01';

-- 11) 이름이 S로 시작하는 사원의 사원번호, 이름, 입사일, 급여을 출력하세요.

-- 12) 이름 중 S자가 들어가 있는 사람만 모든 정보를 출력하세요.

-- 13) 커미션이 NULL인 사람의 정보를 출력하세요.
SELECT empno, ename, job, deptno
FROM emp
WHERE comm is null;

-- 14) 커미션이 NULL이 아닌 사람의 모든 정보를 출력하세요.
SELECT  EMPNO, ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO
FROM emp
WHERE comm is not null;

-- 15) 부서가 30번 부서이고 급여가 $1,500 이상인 사람의 이름, 부서 ,월급을 출력하세요.
SELECT ename, deptno, sal
FROM emp
WHERE deptno=30 AND sal>=1500;

-- 16) 부서번호가 30인 사람 중 사원번호 순으로 정렬하세요.
SELECT empno, ename, deptno
FROM emp
WHERE deptno=30
ORDER BY empno;

-- 17) 급여가 많은 순으로 정렬하세요.
SELECT empno, ename, sal
FROM emp
ORDER BY sal DESC;

-- 18) 부서번호로 ASCENDING 정렬한 후 급여는 많은 사람 순으로  출력하세요.
SELECT empno, ename, sal, deptno
FROM emp
ORDER BY deptno, sal DESC;

-- 19) emp Table에서 이름, 급여, 커미션 금액(sal*comm/100), 총액(sal + comm)을  구하여 총액이 많은 순서로 출력하세요. 
-- 단, 커미션이 NULL인 사람은 제외한다.
SELECT ename, sal, sal*comm/100 "커미션 금액", sal + comm 총액
FROM emp
WHERE comm is not null
ORDER BY 4 DESC;

-- 20)  10번 부서의 모든 사람들에게 급여의 13%를 보너스로 지불하기로 하였다. 이름, 급여, 보너스 금액, 부서번호를 출력하세요.
SELECT ename, sal, sal*0.13 "보너스 금액", deptno
FROM emp
WHERE deptno=10;


