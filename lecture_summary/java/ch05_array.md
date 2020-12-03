# 05. 배열

동일 자료형의 집합이다.

배열이 저장된 주소에 값이 있는게 아니라 값이 저장된  주소를  가지고 있는 참조형식이다. 배열은 생성시 크기가 설정되고 그 후에는 변경이 불가하다.

```text
// 배열 생성 3가지 타입
int[] iArr = {10,20,30,40,50};  // 대입하는 값들로 크기 결정
int[] iArr = new int[5];       // new를 이용한 크기 결정
int[] iArr; iArr = new int[5]  // 배열을 먼저 선언후 나중에 크기 결정

// 다른 배열을 참조하면 원래의 데이터의 주소를 잃어버린다.
int[] iArr = new int[5];    // iArr.length = 5
int[] iArr2 = new int[10];  // iArr2.length = 10
iArr = iArr2                // iArr.length = 10


```
