/*
그룹함수(==집계함수)
count
sum
avg
max
min
*/

SELECT count(-1) 직원수 FROM emp;
-- 그룹함수는 집계시 null값을 건너뛴다

SELECT count(empno)
FROM emp
WHERE deptno=10 or deptno=20;

SELECT count(empno) c1, count(comm) c2, round(avg(ifnull(comm, 0))) c3
FROM emp;

SELECT count(distinct deptno) c1, count(distinct job) c2 
from emp;

-- 부서별로 평균급여를 조회
/*
그룹함수에 포함되지 않는 컬럼이 select절 뒤에 명시될 수 없다.
아래 sql문이 실행되려면 deptno로 그룹을 세분화시켜야함
*/
SELECT deptno, round(avg(sal))
from emp
group by deptno
order by deptno;

-- step 3. Ailas를 지정
SELECT deptno DNumber, round(avg(sal)) AvgSalary
from emp
WHERE deptno != 10
group by DNumber;

-- step 4.
/*
서버 실행순서
FROM --> WHERE --> GROUP BY --> SELECT
실행순서를 감안하면 GROUP BY절 뒤에 Alias 사용 못 한다.
그런데 MySQL은 실행된다.
*/

-- step 5.
SELECT deptno DNumber, round(avg(sal)) AvgSalary
from emp
WHERE deptno != 10
group by DNumber
ORDER BY 1;

-- 입사년도별 사원수를 출력
SELECT year(hiredate) 입사년도, count(empno) "사원 수"
from emp
group by year(hiredate)
ORDER BY 1;

SELECT substr(hiredate, 1, 4) 입사년도, count(empno) "사원 수"
from emp
group by substr(hiredate, 1, 4)
ORDER BY 1;

SELECT date_format(hiredate, '%Y') 입사년도, count(empno) "사원 수"
from emp
group by date_format(hiredate, '%Y')
ORDER BY 1;

-- 예제3
SELECT job, count(empno), round(avg(sal)), sum(sal)
FROM emp
GROUP BY job;

-- 예제4
SELECT job 업무, deptno 부서번호, count(empno) 직원수, round(avg(sal)) 월급평균, sum(sal) 총월급
FROM emp
GROUP BY job, deptno
ORDER BY 1, 2;

-- 부서별 평균급여가 2000달러 이상인 부서의 부서번호와 평균급여를 검색
-- step 1.
-- where절에서는 alias 사용 못함 / 그룹함수 사용 못함
SELECT deptno, round(avg(sal)) 평균급여
FROM emp
WHERE round(avg(sal)) >= 2000
GROUP BY deptno;

-- step 2.
/*
Grouping을 한 후,
원하는 데이터만 디스플레이하고 싶을 때는
Having 절을 사용해서 한번 더 걸러줄 수 있다.

Where 절은 Grouping하기 전에 실행되는 반면에
Having 절은 Grouping 한 후에 실행된다.

결과적으로
그룹함수는 Where절에서는 사용할 수 없고
Having절에서만 사용된다.
*/
SELECT deptno, round(avg(sal)) 평균급여
FROM emp
GROUP BY deptno
HAVING avg(sal) >= 2000
ORDER BY 1;

-- step 3.
/*
Having 절은 Group by 절 뒤에 오는 것이 의미론적으로 더 맞다
*/
SELECT deptno, round(avg(sal)) 평균급여
FROM emp
HAVING avg(sal) >= 2000
GROUP BY deptno
ORDER BY 1;

-- 최대급여가 2900달러가 넘는 부서들 중에서 최대급여를 조회
SELECT deptno, max(sal)
FROM emp
GROUP BY deptno
HAVING max(sal)>=2900
ORDER BY 2 DESC
LIMIT 1;

-- 예제1
SELECT deptno, count(empno), sum(sal)
FROM emp
GROUP BY deptno
HAVING count(empno)>4;

SELECT deptno, round(avg(sal), 2), sum(sal)
FROM emp
GROUP BY deptno
HAVING max(sal)>2900;

SELECT deptno, sum(sal)
FROM emp
WHERE deptno=10 OR deptno=20
GROUP BY deptno
HAVING sum(sal)>10000
ORDER BY 1;

-- 부서별 평균급여가 1200달러를 넘는 부서의 평균급여를 검색
-- 단, CLERK 업무부서는 제외해라
SELECT deptno, job, avg(sal)
FROM emp
WHERE job!='CLERK'
GROUP BY deptno, job
HAVING avg(sal)>1200
ORDER BY 1;

-- 부서별 급여의 합계 중 최대급여의 합을 검색
-- step 1.
SELECT sum(sal)
FROM emp
GROUP BY deptno
ORDER BY 1
LIMIT 1;

-- step 2.
-- MySQL에서는 그룹함수의 중첩 사용이 안된다.
SELECT max(sum(sal)) "부서별 최대급여"
FROM emp
GROUP BY deptno;

-- Rollup
/*
GROUP BY deptno WITH ROLLUP ~
*/
SELECT deptno, count(*), sum(sal)
FROM emp
GROUP BY deptno WITH ROLLUP;

SELECT job, deptno, sum(sal)
FROM emp
GROUP BY job, deptno WITH ROLLUP;

/*
서버 내부 SQL문 실행순서
FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY -> LIMIT
*/