# 5.그룹 함수

결과 행을 모두 조회하여 집계하는 함수 더많은 함수는 아래 링크를 확인

[https://docs.oracle.com/cd/E11882\_01/server.112/e41084/functions003.htm\#SQLRF20035](https://docs.oracle.com/cd/E11882_01/server.112/e41084/functions003.htm#SQLRF20035)

* SUM : 그룹의 누적 합계
* AVG : 그룹의 평균
* COUNT : 그룹의 총 개수
* MAX : 그룹의 최대값
* MIN : 그룹의 최소값
* STDDEV : 그룹의 표준편차
* VARIANCE : 그룹의 분산

## GROUP BY

특정 열을 기준으로 집계시 열을 GROUP BY 절에 명시해야 함

## HAVING

GROUP BY한 결과를 다시 검색할때 사용 Alias는 사용할 수 없다.

