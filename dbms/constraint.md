# 8.제약조건

## 데이터 무결성 제약조건의 종류

* **NOT NULL** : 이열은 NULL값을 포함하지 않음을 지정
* **UNIQUE**  : 모든 행에 대해 유일해야 하는 값을 가진 열 또는 열의 조합을 지정\(null 중복 가능\)
*  **PRIMARY KEY** : 유일하게 테이블의 각 행을 식별
* **FOREIGN KEY** : 열과 참조된 테이블의 열 사이의 외래키 관계를 적용하고 설정                                       REFERENCES 예약어 사용: 참조 무결성 제약 조건 지정
*  **CHECK** : 참이어야 하는 조건을 지정
* 제약조건은 아니나 쓸 수 있는 것 : **DEFAULT**

{% hint style="danger" %}
오라클에서는 NOT NULL과 DEFAULT를 같이 쓸때

\(O\) DEFAULT 표현식 NOT NULL 

\(X\) NOT NULL DEFAULT 표현식
{% endhint %}

```text
// 제약조건을 칼럼마다 명시 하는 경우
CREATE TABLE1 테이블명 (
    칼럼1  타입 [CONSTRAINT 제약조건이름] PRIMARY KEY,
    칼럼2  타입 [CONSTRAINT 제약조건이름] UNIQUE,
    칼럼3  타입 DEFAULT 표현식 [CONSTRAINT 제약조건이름] NOT NULL,
    칼럼4  타입 [CONSTRAINT 제약조건이름] CHECK 표현식,
    칼럼5  타입 [CONSTRAINT 제약조건이름] REFERENCES 참조테이블명(참조칼럼명)
);


// 제약조건을 칼럼의 맨 밑에 쓰는 경우
CREATE TABLE2 테이블명 (
    칼럼1  타입 ,
    칼럼2  타입 ,
    칼럼3  타입 DEFAULT 표현식 NOT NULL,
    칼럼4  타입 ,
    칼럼5  타입 ,
    [CONSTRAINT 제약조건이름] PRIMARY KEY (칼럼명),
    [CONSTRAINT 제약조건이름] UNIQUE (칼럼명),
    [CONSTRAINT 제약조건이름] CHECK 표현식,
    [CONSTRAINT 제약조건이름] FOREIGN KEY REFERENCES 참조테이블명(참조칼럼명),
);

```

