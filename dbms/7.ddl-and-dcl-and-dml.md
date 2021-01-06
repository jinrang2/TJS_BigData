# 7. DDL, DCL,DML

## **DML  :  Data Manipulation Language ;** **데이터 검색, 수정 등**

* **INSERT :** **데이터베이스 객체에 데이터를 입력**
* **DELETE :** **데이터베이스 객체 데이터를 삭제**
* **UPDATE :** **기존에 존재하는 데이터베이스 객체 안의 데이터수정**

```text
// 조인 업데이트 예문 상당히 자주 쓰

MERGE INTO EMP01 E
USING DEPT01 D
ON (D.DEPTNO = E.DEPTNO)
WHEN MATCHED THEN
UPDATE SET E.DNAME=D.DNAME;
```

* **SELECT :** **데이터베이스 객체로부터 데이터를 검색**

## **DDL  :  Data Definition Language ;** **데이터와 그 구조를 정의**

* **CREATE :** **데이터 베이스 객체 생성**
* **DROP :** **데이터 베이스 객체를 삭제**
* **ALTER :** **기존에 존재하는 데이터베이스 객체를 다시 정의**
* **TRUNCATE :** **테이블의 모든 행을 삭제 복구가 안되지만 빠르다.**

## **DCL  :  Data Control Language ;** **데이터베이스 사용자의 권한 제어**

* **GRANT :** **데이터 베이스 객체에 권한 부여**
* **REVOKE :** **이미 부여된 데이터베이스 객체의 권한을 취소**
* **COMMIT :** **트랜잭션 확정** \(TCL\)
* **ROLLBACK :** **트랜잭션 취소** \(TCL\)
* **SAVEPOINT :** **복귀지점 설정** \(TCL\)

