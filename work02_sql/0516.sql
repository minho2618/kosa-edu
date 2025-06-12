-- Projection 원하는 컬럼만 명시
SELECT empno, ename, job
FROM emp;

-- Selection 원하는 행만 가져옴
SELECT empno, ename, job
FROM emp
WHERE deptno=10;

-- ｅｍｐ　테이블에서　모든　사원의　이름과　입사일을　검색
SELECT ename, hiredate
FROM emp;

-- emp테이블에서 업무가 SALESMAN인 사원의 이름과 업무, 급여를 검색
SELECT ename, job, sal
FROM emp
WHERE job='SALESMAN';

-- emp테이블에서 급여가 2500 이상을 받는 직원의 직원번호, 이름, 업무, 급여를 검색
SELECT empno, ename, job, sal
FROM emp
WHERE sal >= 2500;

/*
비교연산자 | 논리연산자
*/
-- emp 테이블에서 급여가 1200 이상, 2500 미만의 급여를 받는 직원을 검색
SELECT ename, job, sal
FROM emp
WHERE sal >= 1200 AND sal < 2500;

-- 1.
SELECT ename, job, sal
FROM emp
WHERE sal >= 1200 AND sal < 2500;

-- 2.
SELECT ename, job, sal
FROM emp
WHERE sal BETWEEN 1200 AND 2500; -- 1200 <= sal <= 2500

-- 3.
/*
1) Syntax Error -- 에러 발생
2) Semantic Error -- No Records
BETWEEN 적은값 AND 큰 값 -- 적은값 <= x <= 큰 값
*/
SELECT ename, job, sal
FROM emp
WHERE sal BETWEEN 2500 AND 1200;

-- emp 테이블에서 업무가 점원이거나 영업사원인 직원을 검색
-- 단, 급여가 1000달러 미만의 직원은 제외
/*
논리 연산자 우선순위
!=, <>
and
or
=
*/
SELECT ename, job, sal
FROM emp
WHERE (job='CLERK' OR job='SALESMAN') AND sal >= 1000;

-- emp 테이블에서 직원의 번호, 이름, 입사년도, 급여를 검색
-- 단, 20번 부서의 사원은 제외
SELECT empno, ename, hiredate, sal, deptno
FROM emp
WHERE deptno <> 20; -- !=와 동일한 표현이다.

/*
ORDER BY 절
정렬은 오름차순(기본 ASC) | 내림차순(DESC)
ORDER BY sal;
ORDER BY sal ASC;

ORDER BY sal DESC;
*/
-- emp 테이블에서 급여 순으로 정렬
-- ORDER BY sal
SELECT empno, ename, sal
FROM emp
ORDER BY sal;

SELECT empno, ename, sal
FROM emp
ORDER BY sal DESC;

-- emp 테이블에서 급여 순으로 정렬 10번 부서는 제외하고 정령
SELECT empno, ename, sal, deptno
FROM emp
WHERE deptno != 10
ORDER BY sal;

-- emp 테이블에서 comm 값으로 정렬, 내림차순으로 정렬
/*
MySQL에서는 null값이 가장 작은 값
반면에
Oracle에서는 null값이 가장 큰 값
그렇다고 해서 null값이 비교할 수 있는 일종의 숫자는 아니다.
*/
-- 1.
SELECT empno, ename, job, comm
FROM emp
ORDER BY comm DESC;

-- 2.
SELECT empno, ename, job, comm
FROM emp
ORDER BY comm;

-- 3. null은 비교할 수 없음
-- null은 비교연산자를 사용할 수 없다.
SELECT empno, ename, job, comm
FROM emp
WHERE comm 
ORDER BY comm;

-- 4.
SELECT empno, ename, job, comm
FROM emp
WHERE comm is not null
ORDER BY comm;

-- 직원 중에서 입사일이 가장 빠른 사원 순으로 검색
-- 1.
SELECT empno, ename, job, hiredate
FROM emp
ORDER BY hiredate DESC;

-- 직원의 이름, 급여, 급여 + 300 출력
/*
컬럼에 연산이 적용되는 경우 Alias가 필요
Alias에 공백이 있을때 " " 묶어준다.
이때 정렬에서 Alias 사용 안된다.
*/
-- 1.
SELECT ename, sal, sal + 300
FROM emp;

-- 2.
SELECT ename, sal, sal + 300 AS 급여인상
FROM emp;

-- 3.
SELECT ename, sal, sal + 300 급여인상
FROM emp;

-- 4.
SELECT ename, sal, sal + 300 급여인상
FROM emp
ORDER BY 급여인상 DESC;

SELECT ename, sal, sal + 300 급여인상
FROM emp
ORDER BY 3 DESC; -- SELECT의 3번째 컬럼

-- 5.
SELECT ename, sal, sal + 300 "인상된 급여"
FROM emp
ORDER BY "인상된 급여" DESC; -- 정렬 안 된다. "" 이게 안 먹힌다.

SELECT ename, sal, sal + 300 "인상된 급여"
FROM emp
ORDER BY 3 DESC;

/*
Distinct
중복을 제거할 때 사용하는 키워드
1) SELECT 절 뒤에 바로 나온다
2) 정렬이 안된다. 별도로 정렬을 해야한다.
3) 중복값을 제거하는 연산은 서버내부에서 연산하는데 많은 시간이 걸린다.
   불가피하게 사용해야 하는 경우라느 distinct를 대체하는 방법을 생각하거나
   대상이 되는 테이블의 크기를 최소화시켜놓고 사용하는 방법을 고민해야한다.
   가장 대표적인 방법으로 EXITS를 활용하는 방법이 있다.
*/

-- emp 테이블에서 부서번호를 검색
-- 오름차순 정렬
SELECT DISTINCT deptno
FROM emp
ORDER BY 1;

-- emp 테이블에서 사원의 이름, 업무, 급여, 연봉을 검색
-- 연봉은 alias AnnualSalary 라고 칭하고 연봉 순으로 검색

-- 1.
-- null 값은 연산이 안된다.
-- null --> 0으로 치환하고 연산을 진행해야 한다.
-- ifnull() (MySQL) | nvl() (Oracle)
SELECT ename, job, sal, sal*12+comm  AnnualSalary
FROM emp
ORDER BY 4;

-- 2. ifnull() 사용
-- ifnull(comm, 0)
-- comm이 null이 아니면 comm값 자체가 반환
-- comm이 null이면 0이 반환
SELECT ename, job, sal, sal*12+ifnull(comm, 0)  AnnualSalary
FROM emp
ORDER BY 4;

/*
null 정리
1) 0이나 공백이 아니다.
2) 일종의 의미를 가지는 값이다.
   '자격없음'이나 '미확정'을 뜻하는 값일때 주로 쓰인다
3) null 값은 연산적용(+, -, /, *) 안되고
	비교(=, !=, >, <)를 할 수 없다.
    ifnull() | is NULL, is not NULL 을 사용해야 한다
4) MySQL에서는 NULL값은 가장 작은 값으로 취급된다.
	Oracle에서는 NULL값은 가장 큰 값으로 취급된다.
*/

-- emp 테이블에서 상사번호를 검색
SELECT DISTINCT mgr 상사번호
FROM emp
ORDER BY 1;

-- emp 테이블에서 사원이름, 업무, 급여, 연봉 검색
-- 부서번호 10번 부서와 20번 부서의 사원만을 대상
-- 연봉이 높은 사람부터 검색되도록 정렬
-- 연봉의 alias를 '연봉'으로 지정
SELECT ename, job, sal, sal*12+ifnull(comm, 0) 연봉
FROM emp
WHERE deptno=10 or deptno=20
ORDER BY 4 DESC;

/*
LIMIT
출력하는 행의 갯수를 제한
limit 0, 5 : (시작은 0부터 5개만 출력)
limit 5 : (상위 5개만 출력)

ORDER BY 절 뒤에 실행됨

SELECT문 실행순서(서버)
FROM -> WHERE -> SELECT -> ORDER BY -> LIMIT

!!!
LIMIT 절을 사용할 때 한가지 주의할 점이 있다.
LIMIT 절의 offset이 클 경우 성능에 큰 문제를 일으킬 수 있다.
아래의 경우를 보자

SELECT * FROM stable ORDER BY sal LIMIT 0,10;
--> 10 rows (0.00 sec)

SELECT * FROM stable ORDER BY sal LIMIT 200000000,10;
--> 10 rows (2.5 sec)

해결책
SELECT * FROM stable
WHERE sal < 3450
ORDER BY sal desc
LIMIT 10;
*/
-- emp 테이블에서 급여를 가장 많이 받는 사람 3명만 검색
SELECT ename, job, sal
FROM emp
ORDER BY 3 DESC
LIMIT 3;