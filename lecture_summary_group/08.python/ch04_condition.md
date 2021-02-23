# ch04\_제어문

## IF

```python
if 조건식1 :
    조건식1이 참(True)일 경우 실행할 문장
    …
elif 조건식2 :
    조건식1이 거짓(False)이고 
    조건식2가 참(True)일 경우 실행할 문장
…
elif 조건식3 :
    조건식1, 2가 거짓(False)이고 
    조건식3이 참(True)일 경우 실행할 문장
    …
else :
    모든 조건식이 거짓(False)일 경우 실행할 문장
```

## FOR

```python
for 변수 in 나열가능한자료 :
    변수의 값을 처리할 문장 1
    변수의 값을 처리할 문장 2
    …
else :
    변수에 값이 할당되지 않는 경우 실행할 문장
```

#### range\(from, to, by\)

for 문장의 items 객체 위치에 range\(start, stop, step\)함수를 이용하여 반복방법 지

## WHILE

```python
while 조건문 :
    조건이 참(True)일 동안 반복 실행할 구문
    …
else :
    조건이 거짓(False)일 경우 실행할 문장
```

## BREAK, CONTINUE

break는 반복문을 탈출, continue는 현재의 반복만을 탈출1

