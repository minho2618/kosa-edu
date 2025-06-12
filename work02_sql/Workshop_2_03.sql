-- ##################  지난 시간 리뷰 ######################
/*
1) 급여가 $1,500부터 $3,000 사이의 사람은 급여의 15%를 회비로 지불하기로 하였다. 
   이를 이름, 급여, 회비(소수점 두 자리 아래에서 반올림)를 출력하라.
   -->
   위 문제에 해당하는 SQL문은 
   select ename, sal, round(sal*0.15, 2) 회비
   from emp
   where sal between 1500 and 3000;
   이다. 해당 SQL 문을 MySQL에서 제공하는 if문을 이용해서 다시 수정해본다.
*/
select ename, sal, round(sal*0.15, 2) 회비
from emp
WHERE IF (sal >= 1500 AND sal <= 3000, sal, null) is not null;


-- 2) 급여가 $2,000 이상인 모든 사람은 급여의 5%를 경조비로 내기로 하였다. 
-- 이름, 급여, 경조비(소수점 이하 절삭)를 출력하라. (if문을 이용해서 sql문을 작성한다)
SELECT ename, sal, floor(sal*0.05) 경조비
FROM emp
WHERE IF (sal >= 2000, sal, null) is not null;

 -- 3) 이익을 배분하기 위해 comm의 150%를 보너스로 지급하려 한다. comm이 있는 직원들을 대상으로 
 -- 직원번호, 직원명, 급여, comm의 150%를 소숫점이하 올림하여 출력하라. (comm이 0이거나, null이면 제외)
SELECT empno, ename, sal, ceiling(comm*1.5) bonus
FROM emp
WHERE comm is not null AND comm!=0;


-- ##################  날짜 함수 실습 ######################

-- 1)입사일로부터 100일이 지난 후를 구해보자. 
-- 이름, 입사일, 입사일로부터 100일 후, 급요를 출력한다.
-- 별칭은 사원이름, 입사일, 100일 후의 날, 사원급여로 한다.
SELECT ename 사원이름, hiredate 입사일, date_add(hiredate, interval 100 day) "100일 후의 날", sal 사원급여
FROM emp;


-- 2) 입사일로부터 6개월이 지난 후의 날짜를 구하려고 한다.  입사일, 6개월 후의 날짜, 급여를 출력하라
SELECT hiredate 입사일, date_add(hiredate, interval 6 month) "6개월 후의 날짜", sal 급여
FROM emp;


-- 3) 입사한 달의 근무일수를 계산하여 부서번호, 이름, 근무일수를 출력하라.(last_day() 함수  사용)
SELECT deptno 부서번호, ename 이름, day(last_day(hiredate)) - day(hiredate) 근무일수
FROM emp;

-- 4) 모든 사원의 입사일 기준으로 100일이 지난 후의 월요일의 날짜를 구해서 이름, 입사일,’MONDAY’를 출력하라.
SELECT ename 이름, hiredate 입사일, 
	date_add(
		date_add(hiredate, interval 100 day), interval (9 - dayofweek(date_add(hiredate, interval 100 day))) % 7 day
	) MONDAY
FROM emp;

-- 5) 입사일로부터 오늘까지의 일수를 구하여 이름, 입사일, 근무일수를 출력하라.
SELECT ename 이름, hiredate 입사일, datediff(curdate(), hiredate) 근무일수
FROM emp;

-- 6) 직원의 이름, 근속년수를 구하여 출력하라.
SELECT ename 이름, ceiling((datediff(curdate(), hiredate))/365) 근속년수
FROM emp;

SELECT ename 이름, year(curdate()) -  year(hiredate) 근속년수
FROM emp;

SELECT 
  ename,
  TIMESTAMPDIFF(YEAR, hiredate, CURDATE()) AS years_of_service
FROM emp;