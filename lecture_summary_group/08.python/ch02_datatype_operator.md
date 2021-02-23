# ch02\_자료형과연산자

## 변수

할당과 동시에 선언됨 할당만은 할 수 없음

help\(x\) : 함수에 대한 도움

\_  : 최근 표현

```python
a=10
b=20
a+b
print(_)
```

## 화면 입출력

```python
#input은 문자형을 리턴
a = input('아무거나 입력해주세요')
print(a)
```

## 기본 자료형

| 숫자 | 정수\(int\), 실수\(float\), 복소수형\(complex\) |
| :--- | :--- |
| 문자 | 싱글쿼테이션, 더블쿼테이션 |
| 논리형 | True, False |

#### 문자열 슬라이

\[start:stop:step\]

* start, stop, step 은 생략될 수 있음 
* 만일 start와 stop이 생략되면 \[::step\] 형식이 됨 
* 이 형식은 문자열 뿐만 아니라 리스트, 튜플 등에서도 사용할 수 있음
* step 음수 지정 가

자료형 확인 : type\(\)

## 포맷팅

{\[인덱스\]:\[공백대체문자\]\[정렬방법\]\[자릿수\]\[타입\]}.format\(변수명\)

```python
print('출력: [{:0>5d}], [{:0<5d}], [{:0^5d}]'.format(1,1,1))
print('출력: [{:0>5b}], [{:0<5b}], [{:0^5b}]'.format(3,5,7))

#출력: [00001], [10000], [00100]
#출력: [00011], [10100], [01110]
```

## 연산자

| 연산자 |  |
| :--- | :--- |
| + - \* / | 기본 사칙연 |
| // | 몫 |
| % | 나머지 |
| \* | 제곱 |
| & | and 조건 |
| \| | or 조 |
| and | false로 판별되는 첫번째 항 |
| or | true로 판별되는 첫번째 항 |
| not | c , java !와 비슷함 |
| a&b | and 비트연산 |
| a\|b | or 비트연 |
| a^b | xor 비트연 |
| ~a | not 비트연 |
| a &gt;&gt; n | 산술 우측 시프트 |
| a &lt;&lt; b | 산술 좌측 시프 |

## 날짜 다루기

```python
datetime.date(year, month,day)
datetime.time(hour, minute,second, micrsecond, tzinfo)
# tzinfo 타임존
datatime.datetime(year, month, day, hour, minute, second)
```



