# 2.SELECT

## SQL

DBMS의 데이터를 여러 가지로 취급하지만 가장 많이 사용되는 것은 데이터를 가져오는 SQL이다.

* NOT IN,  NOT EXISTS :  IN은 NULL을 제외하고 EXISTS는 가져온다.  대개는 NOT EXISTS가 빠르다.
* DATE 의 비교 가급적 조건에 TO\_DATE\(....\)를  사용하여 인덱스를 사용하도록 작성
* LIKE는 가급적  "찾을문자열%" 형식을 유지해야 인덱스를 사용한다.





