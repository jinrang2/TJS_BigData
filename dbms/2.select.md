# 2.SELECT

## SQL

DBMS의 데이터를 취급하는 언어이다. 가장 많이 사용하는 것은 역시 SELECT 이다.

{% hint style="info" %}
대부분의 DBMS는 ANSI SQL 표준을 따르지만 국내에서 가장 많이 사용하는 Oracle의 SQL은

문법이 약간 다르다. 대표적인 차이점은 JOIN 문법의 차이다.
{% endhint %}

```text
SELECT [DISTINCT] {*, column [Alias], ….}
  FROM 테이블명
[WHERE condition]
[ORDER BY {column, expression} [ASC|DESC]] ;

```

SELECT 는  SELECT , FROM, WHERE 3개의 절로 나뉜다.

SELECT는 가져올 칼럼 FROM은 테이블 WHERE는 조건을 쓴다.

## 연산

| 종 | 문법 |
| :--- | :--- |
| 비교연산자 | =, &gt;, &gt;= , &lt;, &lt;=, !=, &lt;&gt; |
| 논리 연산자 | OR, AND |
| 산술표현식 | +, - , \*, / |
| 연결 연산자 | \|\|   두개의 값을 연결하여 한문자 |
| 중복제거 | DISTINCT |
| BETWEEN A AND B | A이상 B이 |
| LIKE | \_ 하나의 문자가 어떤값이 와도 됨      |
|  | % 문자가 없거나 어떤값이 와도됨 |
| ORDER BY | ASC 오름차순 DESC 내림차 |

