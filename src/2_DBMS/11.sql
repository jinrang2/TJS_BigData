-- 조건1 CUSTOMER TABLE이 있을시 테이블 삭제 하고 테이블 생성
-- 테이블 삭제 
DROP TABLE CUSTOMER;

--조건3 
/*  CUS_LEVEL 테이블은 필드별로 다음의 제약조건을 지킨다
	LEVELNO : 주키
	LEVELNAME : NULL값을 입력할 수 없다
*/

CREATE TABLE CUS_LEVEL(
    LEVELNO     NUMBER(4),
    LEVELNAME   VARCHAR2(10) NOT NULL,
    CONSTRAINT PK_LEVELNO PRIMARY KEY (LEVELNO)
);


-- 조건2
/*  CUSTOMER 테이블은 필드별로 다음의 제약조건을 지킨다.
	CNO : 주키
	CNAME : NULL값을 입력할 수 없다
	JOINDATE : 입력하지 않을 시, 기본적으로 현재날짜로 입력된다
	PHONE : 모든 데이터는 PHONE 값이 모두 다르게 입력된다
	LEVELNO : CUS_LEVEL 테이블의 LEVELNO 필드를 참조하는 외래키
*/

CREATE TABLE CUSTOMER (
    CNO         NUMBER(4),
    CNAME       VARCHAR2(20) NOT NULL,
    JOINDATE    DATE DEFAULT SYSDATE,
    PHONE       VARCHAR2(20),
    POINT       NUMBER(10),
    LEVELNO     NUMBER(4),
    CONSTRAINT PK_CNO PRIMARY KEY (CNO),
    CONSTRAINT UQ_PHONE UNIQUE (PHONE),
    CONSTRAINT FK_CUS_LEVEL_LEVELNO FOREIGN KEY (LEVELNO)
    REFERENCES CUS_LEVEL(LEVELNO)
);





--조건4 
--USTOMER 테이블의 CNO번호는 시퀀스(CUS_SQ)를 생성한 뒤 자동생성 번호로 입력되도록 한다.
