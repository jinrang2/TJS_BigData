# 조건문

## IF

if 뒤의 조건문의 참 거짓 여부에 따라 각각의 구문을 실행한다.

```java
if(조건식1) {
		조건식1이 참일 때 실행할 명령문;
	}else if(조건식2){
		조건식1이 거짓이고 조건식2가 참일 때 실행할 명령문;
	}else{
		위의 조건식 둘 다 참이 아닐 때 실행할 명령문;
}

```

{% hint style="warning" %}
if 뒤에 else if를 하지 않고 if를 쓰면 다른 조건이라고 생각하므로 주의
{% endhint %}

## SWITCH 문

if else if문과 비슷한 유형

```java
switch(변수) {
case 1:
    변수의 값이 1일때 실행할 명령문; break;
case 2:
    변수의 값이 2일때 실행할 명령문; break;
...
default:
    변수가 그 외의 값이 1일때 실행할 명령문;
}
```

{% hint style="danger" %}
switch문 뒤에 break를 붙이지 않으면 실행 시점에서 아래쪽으로 쭉 실행하므로 주
{% endhint %}





