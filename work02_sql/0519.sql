SELECT ename, sal, job
FROM emp
WHERE ename LIKE '%A%'
ORDER BY ename, sal DESC;

-- EMP 사원 중에서 S로 시작하는 이름을 가진 사원을 검색
SELECT ename, sal, job
FROM emp
WHERE ename LIKE 'S%';

-- 사원 중에서 80년도에 입사한 사원을 검색
SELECT ename, hiredate, job
FROM emp
WHERE HIREDATE LIKE '198%'
/*
LIKE 
여러개 중에서 어느 하나와 일치하는지의 여부
(a or b or c)

NOT in
(!a AND !b AND !c)
*/
-- 사원번호가 7369이거나 7521이거나 7782번 인 사원을 검색
-- step.1
SELECT *
FROM emp
WHERE empno=7369;
SELECT *
FROM emp
WHERE empno=7521;
SELECT *
FROM emp
WHERE empno=7782;

-- step 2.
SELECT *
FROM emp
WHERE empno=7369 OR empno=7521 OR empno=7782;

-- step 3.
SELECT *
FROM emp
WHERE empno IN (7369, 7521, 7782);

-- 사원 번호가 7369번이 아니고 7521번도, 7782도 아닌 사원을 검색
-- step 4.
SELECT *
FROM emp
WHERE empno!=7369 AND empno!=7521 AND empno!=7782;

-- step 5.
SELECT *
FROM emp
WHERE empno NOT IN (7369, 7521, 7782);

-- 업무, 급여 순으로 정렬, 내림차순정렬
SELECT empno, ename, job, sal
FROM emp
WHERE sal >= 2000 AND job NOT IN ('salesman', 'president')
ORDER BY 3 DESC, 4 DESC;

-- emp 테이블에서 부하직원을 거느리고 있는 사원을 검색
SELECT empno, ename, job
FROM emp
WHERE empno IN (SELECT mgr FROM emp);

-- emp 테이블에서 부하직원을 가지지 않는 사원을 검색
SELECT empno, ename, job
FROM emp
WHERE empno NOT IN (SELECT ifnull(mgr, 0) FROM emp);

-- 
SELECT LOWER(empno), LOWER(ename), LOWER(job)
FROM emp
WHERE deptno=10;

SELECT empno, ename, job, concat(empno, ename) ename, concat(ename, empno) e_empno, concat(ename, job) e_job
FROM emp
WHERE DEPTNO=10;

/*
concat(컬럼, 컬럼)
concat(컬럼, 문자열)
concat(문자열, 문자열)
*/

SELECT concat('Good', 'Morning') from dual; -- Oracle
SELECT concat('Good ', 'Morning') Message; -- MySQL은 dual 필요없다
SELECT concat('Good' , ' ', 'Morning') Message;

-- concat()을 사용해서 Smith is a CLERK
SELECT concat(ename, ' is a ', job) intro
FROM emp;

SELECT substr('HelloWorld', -4);

-- emp 테이블에서 사원들의 업무 중에서 SALESMAN인 업무를 하는 사원 중에서
-- 사원 이름이 'R'로 끝나는 사원의 정보를 출력 (2가지 방법)
SELECT ename, job
FROM emp
WHERE job = 'salesman' AND ename LIKE '%R';

SELECT ename, job
FROM emp
WHERE job = 'salesman' AND substr(ename, -1, 1)='R';

-- emp 테이블에서 SALEMAN 업무가 SALES로만 출력되도록 추출
SELECT ename, substr(job, 6, 3) job
FROM emp
WHERE job = 'salesman';

SELECT substr(hiredate, 1, 4) year, substr(hiredate, 6, 2) month, substr(hiredate, 9, 2) day
from emp
where ename='ALLEN';

-- PAD
SELECT lpad('abc', 6, '*');
SELECT rpad('abc', 6, '*');
SELECT rpad('abc', 6); -- MySQL에서는 적용 안됨
SELECT empno, deptno, LPAD(deptno, 10, ' ') 부서번호 FROM emp;

-- TRIM
SELECT trim(replace('   ㅁㄴㅇㄹ     ㅁㄴㅇㄹ     ', '    ', ''));

/*
숫자함수

round: 반올림(자릿수 지정)
truncate: 버림(자릿수 지정)
ceiling: 올림
floor: 버림
sign: 양수면 1 | 음수면 -1 | 0이면 0
--------------------------------
MySQL에서만 제공
greatest(숫자1, 숫자2, 숫자3, ...): 주어진 숫자 중에서 가장 큰 수 반환
least(숫자1, 숫자2, 숫자3, ...): 주어진 숫자 중에서 가장 작은 수 반환
*/
-- ROUND
-- 소숫점 이하 2자리까지 표시
-- 소숫점이하 3자리에서 반올림이 진행
SELECT ROUND(45.923, 2);
SELECT ROUND(45.923, 0); -- 디폴트
SELECT ROUND(45.923);

-- TRUNCATE
-- 소숫점 이하 첫번째 자리까지 표시
SELECT truncate(19.412, 1);
SELECT truncate(19.412, 2);
SELECT truncate(19.412, 0);
SELECT truncate(19.412); -- 반드시 자릿수를 지정해야 한다.

-- CEILING
SELECT ceil(12.11) a, ceil(12.59) b, ceil(19.0) c;

-- FLOOR
SELECT floor(12.11) a, floor(19.0) b, floor(19.9) c;

SELECT greatest(1, 2, 3) 큰수;
SELECT least(1, 2, 3) 작은수;

SELECT ename, sal, sign(sal - 2975)
FROM emp
WHERE deptno=20;

/*
날짜함수
*/
SELECT curdate();
SELECT current_date();
SELECT date('2025-05-19');

SELECT sysdate();
SELECT now();

SELECT substr(curdate(), 1, 4) Year;
SELECT year(curdate());
SELECT month(curdate());
SELECT day(curdate());
-- 오늘 요일을 출력
SELECT dayname(sysdate());
/*
월요일(0), 화요일(1), ... 일요일(6) 
*/
SELECT weekday(sysdate());

SELECT time(sysdate());

SELECT hour(sysdate());
SELECT minute(sysdate());
SELECT second(sysdate());

SELECT curdate() + 1 Tomorrow;
SELECT curdate() - 1 Yesterday;

-- 소유나님이 지금까지 살아온 생애

SELECT curdate() - date('2002-09-14'); -- 날짜 - 날짜 = 숫자
SELECT datediff(curdate(), date('2002-09-14'));
SELECT datediff(curdate(), date('1994-11-28'));

-- step 1.
SELECT curdate() - '2002-09-14';

-- step 2.
SELECT curdate() - str_to_date('2025-05-18', '%Y-%m-%d');

-- step 3.
SELECT datediff(curdate(), date('2025-05-18'));

-- emp 테이블에서 MANAGER업무에 관해서
-- 입사한 날부터 오늘 현재까지 근무할 일수를 출력
SELECT ename, job, datediff(curdate(), hiredate) 근무일수
FROM emp
WHERE job='MANAGER';

SELECT ename, job, ceil(datediff(curdate(), hiredate)/7) Weekends
FROM emp
WHERE job='MANAGER';

SELECT date_add(now(), interval 10 minute);

-- emp 테이블에서 사원들이 입사한 월을 검색, alias는 입사월로 지정(2가지)
SELECT hiredate, month(hiredate) 입사월
FROM emp;

SELECT hiredate, substr(hiredate, 6, 2) 입사월
FROM emp;

SELECT hiredate, substr(hiredate, -5, 2) 입사월
FROM emp;

-- emp테이블에서 5월에 입사한 사원의 이름과 입사년도, 입사월, 업무
-- 입사년도 순으로 정렬, 입사월로 다시 정렬
SELECT ename 이름, year(hiredate) 입사년도, month(hiredate) 입사월, job 업무
FROM emp
WHERE month(hiredate)=5
ORDER BY 2, 3;

-- step 2.
-- 
SELECT ename 이름, year(hiredate) 입사년도, month(hiredate) 입사월, job 업무
FROM emp
WHERE 입사월=5 -- where 절에서는 alias가 못 온다.
ORDER BY 입사년도, 입사월;

/*
변환함수
가장 일반적으로 MySQL에서 사용되는 형변환 함수는 CONVERT, CAST이다.
이 둘은 형식만 조금 다를 뿐 거의 비슷한 기능을 수행한다.

CAST(expression AS 데이터형식[길이])
CONVERT(expression, 데이터형식[길이])

이외에도
STR_TO_DATE
DATE_FORMAT

위 4가지 함수는 반드시 기억하자
*/

-- 1. DATE_FORMAT
SELECT date_format(curdate(), '%Y-%m-%d') today;
SELECT date_format(curdate(), '%Y.%m.%d') today;

SELECT ename, hiredate, date_format(hiredate, '%Y년 %m월 %d일') 입사일
FROM emp
WHERE deptno=20
ORDER BY 2 DESC;

-- 2. STR_TO_DATE
SELECT curdate()-'2025-05-18' 기간; -- 잘못된 값이 출력
SELECT curdate()-str_to_date('2025-05-18', '%Y-%m-%d') 기간;

-- 3. CONVERT
SELECT curdate()-convert('2025-05-18', date) 기간;

-- 사원의 연봉을 구함 (모든 연봉에 해당하는 값을 INTEGER로 변환)
-- SAL*12+ifnull(comm, 33.2)
SELECT ename, sal, SAL*12+ifnull(comm, 33.2) 연봉, convert(SAL*12+ifnull(comm, 33.2), signed integer) 연봉
FROM emp;

-- 4. CAST
SELECT curdate()-cast('2025-05-18' AS date) 기간;

-- 5. FORMAT
-- emp테이블에서 사원들의 월급과 연봉을 출력...숫자 3자리 수마다 , 를 찍어서 출력
SELECT ename, sal 월급, sal*12+ifnull(comm, 0) 연봉, format(sal, 0) 월급, format(sal*12+ifnull(comm, 0), 0) 연봉
FROM emp;

/*
IFNULL()
*/
SELECT ename, job, ifnull(mgr, '없음') CEO
FROM emp
WHERE job='PRESIDENT';

SELECT ename, job, ifnull(convert(mgr, char), '없음') CEO
FROM emp
WHERE job='PRESIDENT';

-- CASE
/*

여러 조건을 지정할 때 사용
WHEN과 THEN은 반드시 한쌍이어야 한다.
WHEN과 THEN은 다수가 존재할 수 있다.
ELSE가 존재하면 위 조건에 해당되지 않는 경우 반환값을 책임진다.
반면에 ELSE가 존재하지 않고, 위 조건에 해당되지 않는 경우 NULL 반환
*/
SELECT empno, ename, job, sal,
	 CASE job WHEN 'ANALYST' THEN sal*1.1
			WHEN 'CLERK' THEN sal*1.2
            WHEN 'MANAGER' THEN sal*1.3
            WHEN 'PRESIDENT' THEN sal*1.4
            WHEN 'SALESMAN' THEN sal*1.5
            ELSE sal
		END salary
FROM emp;

-- 모든 직원의 이름, 업무, 급여, 커미션, 보너스를 검색
-- 보너스는 업무가 MANAGER인 직원에 적용, 급여에 15%를 책정
-- 그외 업무의 직원은 급여의 13%
SELECT ename, job, sal, ifnull(comm, 0), 
	CASE job
		WHEN 'SALESMAN' THEN 0
		WHEN 'MANAGER' THEN convert(sal*0.15, signed integer)
		ELSE convert(sal*0.13, signed integer)
	END bonus
FROM emp;

    