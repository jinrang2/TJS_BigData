-- SQL = DDL(테이블생성, 삭제, 구조변경, 테이블 데이터 제거)
-- +DML(SELECT, INSERT, UPDATE, DELETE)
-- +DCL(사용자계정 생성 , 사용자에게 권한부여, 권한박탈, 트랜잭션 명령어)

--DDL
CREATE TABLE BOOK(
    BOOKID      NUMBER(4),      --도서번호
    BOOKNAME    VARCHAR2(20),   --도서이름
    PUBLISHIER  VARCHAR2(20),   --출판사
    RDATE       DATE,           --출판일
    PRICE       NUMBER(8),      --가격
    PRIMARY KEY(BOOKID)         --테이블 내 주키(PRIMARY KEY) = 유일, NOT NULL
);

DROP TABLE BOOK;

CREATE TABLE BOOK(
    BOOKID      NUMBER(4)   PRIMARY KEY,
    BOOKNAME    VARCHAR2(20),
    PUBLISHIER  VARCHAR2(20),   
    RDATE       DATE,
    PRICE       NUMBER(8)
);


DESC EMP;

SELECT * FROM BOOK;
-- EMP와 유사한 EMP01 : EMPNO NUMBER(4), ENAME VARCHAR2(20) , SAL NUMBER(7,2)
CREATE TABLE EMP01(
    EMPNO   NUMBER(4),
    ENAME   VARCHAR2(20),
    SAL     NUMBER(7,2)
);

CREATE TABLE DEPT01 (
    DEPTNO  NUMBER(2),
    DNAME   VARCHAR2(14),
    LOC     VARCHAR2(13)
);

CREATE TABLE EMP02 AS
SELECT * FROM EMP;

SELECT * FROM EMP02;

INSERT INTO EMP02 SELECT * FROM EMP02 WHERE EMPNO=7369;

CREATE TABLE EMP03 AS
SELECT EMPNO, ENAME, DEPTNO FROM EMP;

CREATE TABLE EMP04 AS
SELECT * FROM EMP WHERE DEPTNO=10;

CREATE TABLE EMP05 AS
SELECT * FROM EMP WHERE 1=0;

-- 테이블 구조 변경(ALTER TABLE)
-- (1) 필드 추가 (ADD)
ALTER TABLE EMP03 ADD (JOB VARCHAR2(10), SAL NUMBER(7,2));
ALTER TABLE EMP03 ADD (MGR NUMBER(4));
-- (2) 필드 타입 수정
ALTER TABLE EMP03 MODIFY(EMPNO VARCHAR2(5));

ALTER TABLE EMP03 MODIFY(ENAME VARCHAR2(200));
ALTER TABLE EMP03 MODIFY(ENAME VARCHAR2(5));

ALTER TABLE EMP03 MODIFY(JOB VARCHAR2(5));
-- (3) 필드 삭제 (DROP)
-- ALTER TABLE 테이블명
-- ADD,MODIFY,DROP
ALTER TABLE EMP03 DROP COLUMN JOB;

ALTER TABLE EMP03 DROP UNUSED COLUMNS;


--
DROP TABLE EMP01;

TRUNCATE TABLE EMP02;

SELECT * FROM TABS;
--DBA_TABLES, DBA_INDEXES, DBA_CONSTRAINTS, DBA_VIEWS
--USER_TABLES, USER_INDEXES, USER_CONSTRAINTS, USER_VIEWS
--ALL_TABLES, ALL_INDEXES, ALL_CONSTRAINTS, ALL_VIEWS

SELECT * FROM ALL_TABLES;

SELECT * FROM ALL_VIEWS;

SELECT * FROM USER_INDEXES;

DROP TABLE BOOK;

CREATE TABLE BOOK(
    BOOKID      NUMBER(4),      --도서번호
    BOOKNAME    VARCHAR2(20),   --도서이름
    PUBLISHIER  VARCHAR2(20),   --출판사
    RDATE       DATE,           --출판일
    PRICE       NUMBER(8),      --가격
    PRIMARY KEY (BOOKID)         --테이블 내 주키(PRIMARY KEY) = 유일, NOT NULL
);

SELECT * FROM DBA_VIEWS;


DESC DBA_VIEWS;

--INSERT INTO 테이블 이름(필드명1, 필드명2,..)
--VALUES (값1, 값2, ....
--INSERT INTO 테이블 이름 VALUES (값1, 값2, ....

SELECT * FROM DEPT01;

INSERT INTO DEPT01 (DEPTNO, DNAME, LOC)
VALUES (10, 'ACCOUNTING','NEW YORK');

INSERT INTO DEPT01 (DNAME, LOC, DEPTNO)
VALUES ('SALES','BOSTON',20);

INSERT INTO DEPT01 (DEPTNO, DNAME, LOC)
VALUES (30, 'IT',NULL);

INSERT INTO DEPT01(DEPTNO, DNAME) VALUES (40,'OPERATION');

SELECT * FROM DEPT01;

INSERT INTO DEPT01 VALUES  (50,'설계');

DESC BOOK;

INSERT INTO BOOK 
SELECT 11,'스포츠의학', '한솔출판',SYSDATE, 90000 FROM DUAL;

SELECT * FROM BOOK;


CREATE TABLE SAM01 (
    EMPNO       NUMBER(4),
    ENAME       VARCHAR2(10),
    JOB         VARCHAR2(9),
    SAL         NUMBER(7,2)
);

ALTER TABLE SAM01 ADD CONSTRAINTS PK_EMPNO PRIMARY KEY (EMPNO);


INSERT INTO SAM01 
SELECT 1000, 'APPLE','POLICE', 10000 FROM DUAL
UNION ALL
SELECT 1010, 'BANANA','NURSE', 15000 FROM DUAL
UNION ALL
SELECT 1020, 'ORANGE','DOCTOR', 25000 FROM DUAL
UNION ALL
SELECT 1030, 'VERY','', 25000 FROM DUAL
UNION ALL
SELECT 1040, 'CAT','', 2000 FROM DUAL;

INSERT INTO SAM01
SELECT EMPNO, ENAME, JOB,SAL FROM EMP WHERE ENAME IN ('CLARK','KING','MILLER');


-- UPDATE 테이블 이름 SET 필드명1=값1, 필드명2=값2, ...][WHERE조건]


CREATE TABLE EMP01 AS
SELECT * FROM EMP;


SELECT * FROM EMP01;

-- 부서 번호를 30으로 수정
UPDATE EMP01 SET DEPTNO=30;


UPDATE EMP01 SET SAL = SAL * 1.1;

UPDATE EMP01 SET DEPTNO=300 , HIREDATE = SYSDATE
WHERE DEPTNO=10;


-- SCOTT 사원의 부서번호는 20으로 JOB은 MANAGER로 수정하는 SQL
UPDATE EMP01 SET DEPTNO=20, JOB='MANAGER'
WHERE ENAME='SCOTT';


UPDATE DEPT01 SET (DNAME,LOC)= (SELECT DNAME ,LOC FROM DEPT01 WHERE DEPTNO=40)
WHERE DEPTNO=20;


UPDATE EMP01 SET (SAL, HIREDATE) = (SELECT SAL, HIREDATE FROM EMP01 WHERE ENAME='KING');


DELETE FROM EMP01;


-- EMP01 테이블에서 30부서 직웜만 삭제

DELETE FROM EMP01 WHERE DEPTNO=30;

DELETE FROM SAM01 WHERE JOB IS NULL;

SELECT * FROM SAM01;

DELETE FROM EMP01 WHERE DEPTNO =  (SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');

DELETE FROM EMP01 WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME='RESEARCH');



DROP TABLE EMP01;
DROP TABLE DEPT01;

CREATE TABLE EMP01 AS SELECT * FROM EMP;
CREATE TABLE DEPT01 AS SELECT * FROM DEPT;

ALTER TABLE EMP01 ADD COLUMNS DNAME VARCHAR2(20);


MERGE INTO EMP01 E
USING DEPT01 D
ON (D.DEPTNO = E.DEPTNO)
WHEN MATCHED THEN
UPDATE SET E.DNAME=D.DNAME;

-- ERD : 구조화된 데이터를 저장하기 위해 DB를 사용하는데, DB의구조와 제약조건등 다양한 기법을 설계하는 툴


INSERT INTO DEPT1 VALUES (10, '회계', '신촌');
INSERT INTO DEPT1 VALUES (20, '설계', '마포');
INSERT INTO DEPT1 VALUES (30, '영업', '이대');
INSERT INTO DEPT1 VALUES (40, '전산', '공덕');

COMMIT;

INSERT INTO EMP1 (EMPNO, ENAME, JOB, MGR, SAL, DEPTNO) VALUES (1111,'홍가','회장',NULL, 9000, 40);

INSERT INTO EMP1 (EMPNO, ENAME, JOB, MGR, SAL, DEPTNO) VALUES (1112,'홍군','전무',1111, 1000, 30);

INSERT INTO EMP1 (EMPNO, ENAME, JOB, MGR, SAL, DEPTNO) VALUES (1113,'홍가','회장',8000, 200, 40);

INSERT INTO EMP1 (EMPNO, ENAME, JOB, MGR, SAL, DEPTNO) VALUES (1111,'홍가','회장',NULL, 9000, 40);
INSERT INTO EMP1 (EMPNO, ENAME, JOB, MGR, SAL, DEPTNO) VALUES (1111,'홍가','회장',NULL, 9000, 40);



CREATE TABLE MAJOR (
    MAJOR_CODE          NUMBER(2),
    MAJOR_NAME          VARCHAR2(100),
    MAJOR_OFFICE_NUM    VARCHAR2(255),
    PRIMARY KEY(MAJOR_CODE)
);

alter table "SCOTT"."STUDENT" add constraint FK_MAJOR_CODE foreign key("MAJOR_CODE") references "MAJOR"("MAJOR_CODE")

CREATE TABLE STUDENT (
    STUDENT_CODE          VARCHAR2(10),
    STUDENT_NAME          VARCHAR2(100),
    SCORE                 NUMBER(3),
    MAJOR_CODE            NUMBER(2), 
    PRIMARY KEY(STUDENT_CODE),
    FOREIGN KEY(MAJOR_CODE) REFERENCES MAJOR(MAJOR_CODE)
);

ALTER TABLE STUDENT MODIFY STUDENT_CODE VARCHAR2(10);

INSERT INTO MAJOR VALUES(1,'경영정보', '3층 인문실');
INSERT INTO MAJOR VALUES(2,'소프트웨어공학', '3층 인문실');
INSERT INTO MAJOR VALUES(3,'디자인', '4층 과학실');
INSERT INTO MAJOR VALUES(4,'경제', '4층 과학실');

INSERT INTO STUDENT VALUES('A01','김길동',100 , 1);

INSERT INTO STUDENT VALUES('A02','문길동',90,2);

INSERT INTO STUDENT VALUES('A03','홍길동',95,1);


CREATE TABLE BOOK_CATEGORY (
    CATEGORY_CODE   NUMBER(3) NOT NULL,
    CATEGORY_NAME   VARCHAR2(100) NOT NULL,
    OFFICE_LOC      VARCHAR2(100) NOT NULL,
    CONSTRAINT PK_CATEGORY_CODE PRIMARY KEY (CATEGORY_CODE)    
);


CREATE TABLE BOOK (
    CATEGORY_CODE   NUMBER(3) NOT NULL,
    BOOK_NO         VARCHAR2(6) NOT NULL,
    BOOK_NAME       VARCHAR(100) NOT NULL,
    PUBLISHER       VARCHAR(100) NOT NULL,
    PUBYEAR         VARCHAR(4) DEFAULT TO_CHAR(SYSDATE,'YYYY') NOT NULL  ,
    CONSTRAINT PK_BOOK_NO PRIMARY KEY (BOOK_NO),
    CONSTRAINT FK_BOOKCATEGORY_CATEGORY_CODE 
    FOREIGN KEY (CATEGORY_CODE) REFERENCES BOOK_CATEGORY(CATEGORY_CODE)
);




DROP TABLE BOOK;

CREATE TABLE TEST (
    ABC VARCHAR(40) DEFAULT TO_CHAR(SYSDATE,'YYYYMMDD')
);


INSERT INTO BOOK_CATEGORY VALUES (100,'철학','3층인문실');

INSERT INTO BOOK_CATEGORY VALUES (200,'인문','3층인문실');

INSERT INTO BOOK_CATEGORY VALUES (300,'자연과학','4층과학실');

INSERT INTO BOOK_CATEGORY VALUES (400,'IT','4층과학실');

INSERT INTO BOOK VALUES (100,'100A01','철학자의 삶','더존출판','2017');

INSERT INTO BOOK VALUES (400,'400A01','이것이 DB다','더존출판','2018');


