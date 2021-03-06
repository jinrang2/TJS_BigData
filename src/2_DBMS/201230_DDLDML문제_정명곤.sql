-- 1. 테이블 생성 ID가 PK

CREATE TABLE MY_DATA (
    ID      NUMBER(4)   NOT NULL,
    NAME    VARCHAR2(10),
    USERID  VARCHAR2(30),
    SALARY  NUMBER(10,2),
    CONSTRAINT PK_ID PRIMARY KEY (ID)
);
-- 1. 테이블 확인
DESC MY_DATA;

-- 2. 자료입력
INSERT INTO MY_DATA VALUES (1,'SCOTT','SSCOTT',10000.00);
INSERT INTO MY_DATA VALUES (2,'FORD','FFORD',13000.00);
INSERT INTO MY_DATA VALUES (3,'PATEL','PPATEL',33000.00);
INSERT INTO MY_DATA VALUES (4,'REPORT','RREPORT',23500.00);
INSERT INTO MY_DATA VALUES (5,'GOOD','GGOD',44450.00);

-- 3. 2번 입력 자료 확인
SELECT * FROM MY_DATA;
-- 4. 2번자료를 등록
COMMIT;

--6. ID가 3번인 사람의 급여를 65,000.00으로 갱신하고 데이터베이스에 반영
UPDATE MY_DATA SET SALARY=65000.00 WHERE ID=3;
COMMIT;

-- 7. 이름이 FORD인 사원을 영구 제명하여라;;
DELETE FROM MY_DATA WHERE NAME='FORD';
COMMIT;


--8. 급여가 15000 이하인 사람의 급여를 15000으로 변경하여라
UPDATE MY_DATA SET SALARY=15000 WHERE SALARY <= 15000;

-- 9. 1번에서 생성한 테이블을 삭제 하여라
DROP TABLE MY_DATA;


