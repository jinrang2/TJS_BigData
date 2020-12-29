-- 14. 사원 테이블에서 이름에 “T”가 있는 사원이 근무하는 부서에서 근무하는 모든 종업원에 대해
    --사원 번호,이름,급여를 출력하는 SELECT문을 작성하시오. 단 사원번호 순으로 출력하여라.
SELECT EMPNO, ENAME, SAL
  FROM EMP
 WHERE DEPTNO IN (
    SELECT DEPTNO
      FROM EMP
     WHERE ENAME LIKE ( '%T%' )
);

-- 15. 사원 테이블에서 부서 위치가 Dallas인 모든 종업원에 대해 이름,업무,급여를 출력

SELECT ENAME, JOB, SAL
  FROM EMP
 WHERE DEPTNO IN (
    SELECT DEPTNO
      FROM DEPT
     WHERE LOC = 'DALLAS'
);

-- 16. EMP 테이블에서 King에게 보고하는 모든 사원의 이름과 급여를 출력하는 SELECT문

SELECT ENAME, SAL
  FROM EMP
 WHERE MGR IN (
    SELECT EMPNO
      FROM EMP
     WHERE ENAME = 'KING'
);

-- 17. 사원 테이블에서 SALES부서 사원의 이름,업무를 출력하는 SELECT문을 작성하시오.

SELECT ENAME, JOB
  FROM EMP E, DEPT D
 WHERE E.DEPTNO = D.DEPTNO
   AND DNAME = 'SALES';
-- 18. 사원 테이블에서 월급이 부서 30의 최저 월급보다 높은 사원을 출력

SELECT *
  FROM EMP
 WHERE SAL > (
    SELECT MIN(SAL)
      FROM EMP
     WHERE DEPTNO = 30
);

-- 19. 부서 10에서 부서 30의 사원과 같은 업무를 맡고 있는 사원의 이름과 업무를 출력

SELECT ENAME, JOB, DEPTNO
  FROM EMP
 WHERE JOB IN (
    SELECT JOB
      FROM EMP
     WHERE DEPTNO = 30
) AND DEPTNO=10;

-- 20. 사원 테이블에서 FORD와 업무도 월급도 같은 사원의 모든 정보를 출력
SELECT *
  FROM EMP
 WHERE ( JOB, SAL ) IN (
    SELECT JOB, SAL
      FROM EMP
     WHERE ENAME = 'FORD'
);

-- 21. 이름이 JONES인 직원의 JOB과 같거나 
    --월급이 FORD 월급 이상인 사원의 정보를 이름,업무,부서번호,급여를 출력하는 SELECT문을 작성.
    -- 단, 업무별 알파벳 순, 월급이 많은 순으로 출력하여라.
    
SELECT ENAME, JOB, DEPTNO, SAL
FROM EMP
WHERE 
JOB = (SELECT JOB FROM EMP WHERE ENAME='JONES')
OR
SAL > (SELECT SAL FROM EMP WHERE ENAME='FORDS');

-- 22. 사원 테이블에서 SCOTT 또는 WARD와 월급이 같은 사원의 정보를 이름,업무,급여를 출력하는 SELECT문을 작성하시오.
SELECT ENAME, JOB, SAL
  FROM EMP
 WHERE SAL IN (
    SELECT SAL
      FROM EMP
     WHERE ENAME IN ('SCOTT', 'WARD')
);
-- 23. 사원 테이블에서 CHICAGO에서 근무하는 사원과 같은 업무를 하는 사원들의 이름,업무를 출력하는 SELECT문을 작성하시오.
SELECT ENAME, JOB
  FROM EMP
 WHERE JOB IN (
    SELECT JOB
      FROM EMP E, DEPT D
     WHERE E.DEPTNO = D.DEPTNO
       AND LOC = 'CHICAGO'
);

-- 24. 사원 테이블에서 부서별로 월급이 평균 월급보다 높은 사원을 사원번호,이름,급여를 출력하는 SELECT문을 작성하시오.
SELECT EMPNO, ENAME, JOB, A.SAL, ROUND(B.AVGSAL),A.DEPTNO
  FROM EMP A, (
    SELECT DEPTNO, AVG(SAL) AVGSAL
      FROM EMP
     GROUP BY DEPTNO
) B
 WHERE A.DEPTNO = B.DEPTNO
AND A.SAL > B.AVGSAL;

-- 25. 사원 테이블에서 업무별로 월급이 평균 월급보다 낮은 사원을 부서번호,이름,급여를 출력하는 SELECT문을 작성하시오.
SELECT EMPNO, ENAME, JOB
  FROM EMP A, (
    SELECT JOB, AVG(SAL) AVGSAL
      FROM EMP
     GROUP BY JOB
) B
 WHERE A.JOB = B.JOB
   AND A.SAL < B.AVGSAL;

-- 26 사원 테이블에서 적어도 한 명 이상으로부터 보고를 받을 수 있는 사원을 업무,이름,사원번호,부서번호를 출력(단, 부서번호 순으로 오름차순 정렬)
SELECT JOB, ENAME, EMPNO, DEPTNO
  FROM EMP E
 WHERE EXISTS (SELECT 1 FROM EMP WHERE MGR=E.EMPNO)
ORDER BY DEPTNO;

-- 27. 사원 테이블에서 말단 사원의 사원번호, 이름, 업무, 부서번호를 출력하는 SELECT문을 작성하시오.
SELECT EMPNO, ENAME, JOB, DEPTNO
  FROM EMP E
 WHERE NOT EXISTS (SELECT 1 FROM EMP WHERE MGR=E.EMPNO);
 
 
