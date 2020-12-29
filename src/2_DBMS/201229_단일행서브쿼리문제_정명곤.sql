-- ★ 총 연습문제
--1. 사원테이블에서 가장 먼저 입사한 사람의 이름, 급여, 입사일
SELECT ENAME, SAL, HIREDATE
  FROM EMP
 WHERE HIREDATE = (
                    SELECT MIN(HIREDATE)
                      FROM EMP
                );

-- 2. 회사에서 가장 급여가 적은 사람의 이름, 급여

SELECT ENAME, SAL
  FROM EMP
 WHERE SAL = (
            SELECT MIN(SAL)
              FROM EMP
        );

-- 3. 회사 평균보다 급여를 많이 받는 사람의 이름, 급여, 부서코드

SELECT ENAME, SAL, DEPTNO
  FROM EMP
 WHERE SAL > (
            SELECT AVG(SAL)
              FROM EMP
        );

--4. 회사 평균 이하의 급여를 받는 사람의 이름, 급여, 부서명

SELECT ENAME, SAL, DNAME
  FROM EMP E, DEPT D
 WHERE E.DEPTNO = D.DEPTNO
   AND SAL <= (
    SELECT AVG(SAL)
      FROM EMP
);

--5. SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급

SELECT ENAME, SAL, HIREDATE, GRADE
  FROM EMP E, SALGRADE S
 WHERE SAL BETWEEN LOSAL AND HISAL
   AND HIREDATE < (
                    SELECT HIREDATE
                      FROM EMP
                     WHERE ENAME = 'SCOTT'
);
    
--6. 5번(SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급)에 부서명 추가하고 
    --급여가 큰 순 정렬

SELECT ENAME, SAL, HIREDATE, GRADE, DNAME
  FROM EMP E, SALGRADE S, DEPT D
 WHERE SAL BETWEEN LOSAL AND HISAL
   AND E.DEPTNO = D.DEPTNO
   AND HIREDATE < (
                    SELECT HIREDATE
                      FROM EMP
                     WHERE ENAME = 'SCOTT'
                )
 ORDER BY SAL DESC;

--7. 사원테이블에서 BLAKE 보다 급여가 많은 사원들의 사번, 이름, 급여를 검색

SELECT EMPNO, ENAME, SAL
  FROM EMP
 WHERE SAL > (
                SELECT SAL
                  FROM EMP
                 WHERE ENAME = 'BLAKE'
);

--8. 사원테이블에서 MILLER보다 늦게 입사한 사원의 사번, 이름, 입사일을 검색하시오

SELECT EMPNO, ENAME, HIREDATE
  FROM EMP
 WHERE HIREDATE > (
                    SELECT HIREDATE
                      FROM EMP
                     WHERE ENAME = 'MILLER'
);


--9. 사원테이블에서 사원전체 평균 급여보다 급여가 많은 사원들의 사번, 이름, 급여를 검색
SELECT EMPNO, ENAME, SAL
  FROM EMP
 WHERE SAL > (
            SELECT AVG(SAL)
              FROM EMP
);

--10. 사원테이블에서 CLARK와 같은 부서며, 사번이 7698인 직원의 급여보다 
        -- 많은 급여를 받는 사원들의 사번, 이름, 급여 검색
SELECT EMPNO, ENAME, SAL
  FROM EMP
 WHERE DEPTNO = (
                SELECT DEPTNO
                  FROM EMP
                 WHERE ENAME = 'CLARK'
                )
   AND SAL > (
                SELECT SAL
                  FROM EMP
                 WHERE EMPNO = '7698'
);

--11.  응용심화. 사원테이블에서 CLARK와 같은 부서명이며, 사번이 7698인 직원의 급여보다 
    --  많은 급여를 받는 사원들의 사번, 이름, 급여 검색
SELECT EMPNO, ENAME, SAL
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
  AND D.DNAME = (
                SELECT D.DNAME
                  FROM EMP E, DEPT D
                 WHERE E.DEPTNO = D.DEPTNO AND ENAME = 'CLARK'
                )
  AND SAL > (
                SELECT SAL
                  FROM EMP
                 WHERE EMPNO = '7698'
);
    
    

--12.  사원 테이블에서 BLAKE와 같은 부서에 있는 모든 사원의 이름과 입사일자를 출력하는 SELECT문을 작성하시오.

SELECT ENAME, HIREDATE
  FROM EMP
 WHERE DEPTNO = (
                SELECT DEPTNO
                  FROM EMP
                 WHERE ENAME = 'BLAKE'
);

--13.  사원 테이블에서 평균 급여 이상을 받는 모든 종업원에 대해서 사원번호와 이름을 출력
        --(단 급여가 많은 순으로 출력하여라.)
        
SELECT EMPNO, ENAME
  FROM EMP
 WHERE SAL > (
                SELECT AVG(SAL)
                  FROM EMP
)
 ORDER BY SAL DESC;
