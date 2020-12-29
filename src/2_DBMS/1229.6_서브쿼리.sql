-- 서브쿼리 : 쿼리안에 쿼리가 내포
--단일행 서브쿼리 ; 서브쿼리의 결과가 단일 행
--단일 행 연산자 : =, >, >=, <, <=, <>
--다중행 서브쿼리 ; 서브쿼리의 결과가 2행 이상의 행
--복수 행 연산자 : IN, NOT IN, ANY, SOME, ALL, EXISTS

-- SCOTT이 근무하는 부서 이름 출력
SELECT DNAME
  FROM EMP E, DEPT D
 WHERE E.DEPTNO = D.DEPTNO
   AND E.ENAME = 'SCOTT';

SELECT DNAME
  FROM DEPT D
 WHERE D.DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT');
 
 -- JOB이 'MANAGER'인 사람의 부서이름
 
 SELECT DNAME
 FROM DEPT
 WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB='MANAGER');
 
 
 -- 단일행 서브쿼리
 -- 회사에서 급여를 제일 많이 받는 사람의 이름과 급여
 SELECT ENAME, SAL FROM EMP WHERE SAL = (SELECT MAX(SAL) FROM EMP);
 -- SCOTT과 같은 부서번호인 사람들
 SELECT * FROM EMP WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT');
 -- SCOTT과 같은 근무지인 사람들
 
SELECT *
  FROM EMP A, DEPT B
 WHERE A.DEPTNO = B.DEPTNO
   AND LOC IN (
                SELECT  LOC
                FROM    EMP A, DEPT B
                WHERE   A.DEPTNO = B.DEPTNO
                AND     A.ENAME = 'SCOTT');
                     
SELECT SUM(SAL)
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT');
 
SELECT *
FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME='SCOTT');

SELECT ENAME, DEPTNO FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');

SELECT ENAME, SAL FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');

SELECT ENAME, SAL FROM EMP
WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME='KING');
-- 평균 급여 이하로 받는 사원의 이름 , 급여를 ㅜ출력

SELECT * FROM EMP WHERE SAL < (SELECT AVG(SAL) FROM EMP);

-- SCOTT과 JOB과 부서 번호가 같은 직원의 모든 필드 출력
SELECT * FROM EMP
WHERE (JOB, DEPTNO) = (SELECT JOB ,DEPTNO FROM EMP WHERE ENAME='SCOTT');

SELECT DNAME, CURSOR(SELECT SAL, COMM
   FROM EMP e
   WHERE e.DEPTNO = d.DEPTNO)
   FROM DEPT d;
   
-- IN 서브쿼리 결과중 하나라도 일치하면 참
-- ALL 서브쿼리 결과 모두가 일치하면 참
-- ANY=SOME
-- EXITSTS 
--부서별로 입사일이 가장 늦은 사람의 부서번호, 이름, 입사일 출력
SELECT * 
FROM EMP
WHERE (DEPTNO, HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO);

SELECT *
  FROM EMP
 WHERE JOB IN (
    SELECT JOB 
      FROM EMP
     WHERE SAL >= 3000
);

-- ALL
-- 30번 소속 사원들 중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사람의 이름, 급여를 출력
SELECT * FROM EMP WHERE SAL >
  ALL(SELECT SAL FROM EMP WHERE DEPTNO=30);
  
SELECT * FROM EMP WHERE SAL >
  ALL(SELECT SAL FROM EMP WHERE DEPTNO=:a);  

-- ANY = SOME

-- EXISTS
SELECT EMPNO, ENAME, SAL
  FROM EMP E1
WHERE EXISTS
(
    SELECT 1
      FROM EMP
     WHERE E1.EMPNO = MGR
);

SELECT * FROM EMP E WHERE EXISTS (SELECT 1 FROM EMP WHERE E.EMPNO = MGR);


--	직급(JOB)이 MANAGER인 사람의 속한 부서의 부서 번호와 부서명과 지역을 출력(IN)
SELECT DEPTNO, DNAME, LOC
  FROM DEPT
 WHERE DEPTNO IN (
    SELECT DEPTNO
      FROM EMP
     WHERE JOB = 'MANAGER'
);
	
--	연봉이 3000이상인 사람들 중 연봉 등급을 나누어서 해당 등급별 최고 연봉을 받는 사람들의 사번, 이름, 직업, 입사일, 급여, 급여등급을 출력

SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE
  FROM EMP E, SALGRADE S
 WHERE SAL BETWEEN LOSAL AND HISAL 
   AND ( GRADE, SAL ) IN (
    SELECT GRADE, MAX(SAL)
      FROM EMP E, SALGRADE S
     WHERE SAL BETWEEN LOSAL AND HISAL
       AND SAL >= 3000
     GROUP BY GRADE
);
	
--	응용심화 : 입사일 분기별로 가장 높은 연봉을 받는 사람들의 분기, 사번, 이름, JOB, 상사사번, 입사일, 급여, 상여를 출력하세요

SELECT TO_CHAR(E1.HIREDATE, 'Q'), E1.EMPNO, E1.ENAME, E1.JOB, E2.EMPNO, E1.HIREDATE, E1.SAL, E1.COMM
  FROM EMP E1, EMP E2
 WHERE E1.MGR = E2.EMPNO (+)
   AND ( TO_CHAR(E1.HIREDATE, 'Q'), E1.SAL ) IN (
    SELECT TO_CHAR(E3.HIREDATE, 'Q'), MAX(E3.SAL)
      FROM EMP E3
     GROUP BY TO_CHAR(E3.HIREDATE, 'Q')
)
 ORDER BY 1;

	
--	SALESMAN 모든 사원들 보다 급여를 많이 받는 사원들의 이름과 급여와 직급(담당 업무)를 출력하되 영업 사원은 출력하지 않는다.(ALL이용)

SELECT ENAME, JOB
  FROM EMP
 WHERE SAL > ALL (
    SELECT SAL
      FROM EMP
     WHERE JOB = 'SALESMAN'
)
   AND JOB <> 'SALESMAN';
	
--	SALESMAN 일부 어떤 한 사원보다 급여를 많이 받는 사원들의 이름과 급여와 직급(담당 업무)를 출력하되 영업 사원은 출력(ANY)

SELECT ENAME, SAL, JOB
  FROM EMP
 WHERE SAL > ANY (
    SELECT SAL
      FROM EMP
     WHERE JOB = 'SALESMAN'
)
    OR JOB = 'SALESMAN';
	
--	연봉이 3000미만인 사람 중에 가장 최근에 입사한 사람의 사원번호와 이름, 연봉, 입사일을 출력

SELECT ENAME, SAL, HIREDATE
  FROM EMP
 WHERE HIREDATE IN (
    SELECT MAX(HIREDATE)
      FROM EMP
     WHERE SAL < 3000
);

	
--	직급이 ‘SALESMAN’인 사원이 받는 급여의 최소 급여보다 많이 받는 사원들의 이름, 급여, 직급, 부서번호를 출력하되 부서번호가 20번인 사원은 제외한다(ANY 연산자 이용)

SELECT ENAME, SAL, JOB, DEPTNO
  FROM EMP
 WHERE SAL > ANY (
    SELECT SAL
      FROM EMP
     WHERE JOB = 'SALESMAN'
)
   AND DEPTNO <> 20;