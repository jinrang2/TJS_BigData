-- 10 view, inline view , topn 구문
-- 1. view : 가상의 테이블 (1)단순뷰 (2)복합뷰
CREATE OR REPLACE VIEW EMPV0
AS SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP;



SELECT * FROM EMPV0;

INSERT INTO EMPV0 VALUES (1111,'홍','IT',40);


SELECT * FROM EMPV0;

UPDATE EMPV0 SET JOB='ANALYST' WHERE EMPNO=1111;

DELETE FROM EMPV0 WHERE EMPNO=1111;

CREATE OR REPLACE VIEW EMPV0
AS SELECT * FROM EMP WHERE DEPTNO=30;


SELECT * FROM USER_VIEWS;

DELETE FROM EMP WHERE EMPNO<1113;
COMMIT;
INSERT INTO EMPV0 VALUES (1112,'홍',NULL,NULL,NULL,NULL,NULL,40);
-- EMP 테이블 30분 부서의 가상의 테이블(30번 부서만 INSERT가능)
CREATE OR REPLACE VIEW EMPV0
AS SELECT * FROM EMP WHERE DEPTNO=30 WITH CHECK OPTION;

SELECT * FROM EMPV0;

INSERT INTO EMPV0 VALUES (1111,'홍',NULL,NULL,NULL,NULL,NULL,30);


INSERT INTO EMPV0 VALUES (1112,'홍',NULL,NULL,NULL,NULL,NULL,40);


DELETE FROM EMP WHERE EMPNO=1111;

--(2) 복합뷰

CREATE OR REPLACE VIEW EMPV3 
AS SELECT EMPNO, ENAME, ROUND(SAL,-3) SAL FROM EMP;


SELECT * FROM EMPV3;

INSERT INTO EMPV3 VALUES (1115,'홍',1000);

--부서 번호, 부서명, 최소급여, 최대급여, 부서평균을 포함한 DEPTV1 뷰 생성
CREATE OR REPLACE VIEW DEPTV1 AS 
SELECT DEPTNO, MIN(SAL) MINSAL , MAX(SAL) MAXSAL, ROUND(AVG(SAL),1) AVGSAL FROM EMP GROUP BY DEPTNO;

SELECT D1.DEPTNO, DNAME, MINSAL, MAXSAL, AVGSAL FROM DEPTV1 D1, DEPT D2
WHERE D1.DEPTNO = D2.DEPTNO;

INSERT INTO DEPTV1 VALUES (40, 700, 9000, 4000);

SELECT COUNT(*) FROM EMP;

CREATE OR REPLACE VIEW EMPV3 
AS SELECT EMPNO, ENAME, ROUND(SAL,-3) SAL FROM EMP;




-- 2. INLINE VIEW : SQL문 수행하는 한줄의 명령어에서만 유용한 뷰
SELECT AVG(SAL) FROM EMP WHERE SAL>2000;

SELECT AVG(SAL) FROM (SELECT SAL FROM EMP WHERE SAL >2000);


SELECT ENAME, SAL, DEPTNO, (SELECT ROUND(AVG(SAL),1) FROM EMP WHERE DEPTNO=E.DEPTNO) AS AVGSAL
FROM EMP E;

-- 이름 , 급여, 부서번호
SELECT ENAME, SAL, DEPTNO FROM EMP A;

SELECT DEPTNO , ROUND(AVG(SAL)) FROM EMP GROUP BY DEPTNO;


SELECT ENAME, SAL, E.DEPTNO, S.DEPTNO, AVGSAL
  FROM EMP E,
(
    SELECT DEPTNO, ROUND(AVG(SAL)) AS AVGSAL
      FROM EMP
     GROUP BY DEPTNO
) S
 WHERE E.DEPTNO = S.DEPTNO;
   

-- 3. TOPN 구문 (TOP 1~10등 , TOP 11~20등 TOP 6~10등)
-- ROWNUM : 테이블에서 가져온 순서. 테이블에서 행의 논리적인 출력 순서
SELECT ROWNUM, ENAME, SAL FROM EMP;

SELECT ROWNUM, ENAME, SAL FROM EMP WHERE DEPTNO=30;

SELECT ROWNUM, ENAME, SAL FROM EMP ORDER BY SAL;

SELECT ROWNUM, ENAME, SAL FROM EMP ORDER BY SAL;

SELECT ROWNUM, ENAME, SAL FROM
(SELECT * FROM EMP ORDER BY SAL);

SELECT ROWNUM, ENAME, SAL FROM
(SELECT * FROM EMP ORDER BY SAL)
WHERE ROWNUM < 6;

SELECT ROWNUM, ENAME, SAL FROM
(SELECT * FROM EMP ORDER BY SAL)
WHERE ROWNUM BETWEEN 6 AND 10;

-- 함수를 이용한 RANK 출력
SELECT RANK() OVER(ORDER BY SAL ) RANK,
       DENSE_RANK() OVER(ORDER BY SAL) DRANK,
       ROW_NUMBER() OVER(ORDER BY SAL) ROW_NUM,
       ENAME, SAL
FROM EMP;

SELECT INDEX_NAME FROM USER_INDEXES WHERE TABLE_NAME='EMP';

/*SYS_C006998
IDX_HDATE
IDX_SAL*/

SELECT /*+ INDEX_ASC (EMP IDX_HDATE) */ HIREDATE
FROM EMP;


SELECT ROWNUM, RN, ENAME, SAL
  FROM (
    SELECT ROWNUM RN, ENAME, SAL
      FROM (
        SELECT *
          FROM EMP
         ORDER BY SAL
    )
)
 WHERE RN BETWEEN 6 AND 10;

SELECT ROWNUM, RN, ENAME
  FROM (
    SELECT ROWNUM RN, ENAME
      FROM (
        SELECT *
          FROM EMP
         ORDER BY ENAME
    )
)
 WHERE RN BETWEEN 6 AND 10;


SELECT * FROM USER_INDEXES;

SELECT /*+ INDEX_DESC (EMP SYS_C006998) */ 
      * 
 FROM EMP;

SELECT /*+ INDEX_ASC (EMP SYS_C006998) */ 
      * 
 FROM EMP;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 