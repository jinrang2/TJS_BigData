# ch06\_모듈과패키지

## 파이썬 모듈

* 정의와 문장을 담고 있는 파일이름은 모듈명.py 

## 파이썬 표준 모듈

{% embed url="https://docs.python.org/3/library/index.html" %}

## import 방법

```python
import A               # a모듈 가져옴
import A as B          # a모듈을 B이름으로 가져옴
from A import B        # a모듈의 B함수를 가져옴
from A import B as c   # a모듈의 b함수를 c의 이름으로 가져옴
from A.B import C      # A패키지안에 B모듈안에 C함수를 가져옴
from A.B import C as D # A패키지 안의 B모듈의 C함수를 D의 별칭으로 가져옴
```

## import 디렉토리

현재 작업 디렉토리 외의 디렉토리에 모듈이 있을때

sys.path.append\('모듈디렉토리 절대경로'\)

## \_\_main\_\_

import 될때는 실행 안하고 

모듈을 직접 실행 할때만 실행되게 할때 이

## 컴파일된 파이선 파일

모듈 로드 속도를 높이기 위해 파이썬은 각 모듈의 컴파일 된 버전을

**pycache** 디렉토리에 module.version.pyc라는 이름으로 캐시

## 패키

* “점으로 구분 된 모듈 이름”을 사용하여 모듈 네임 스페이스를 구조화하는 방법 
* 모듈 이름 A.B는 A라는 패키지에 B라는 서브 모듈을 지정
* 패키지의 하위 패키지는 자동으로 임포트 되지 않는다
*  \_\_all_\_\__ 속성에 명시하면 하위 모듈도 임포트 된
* .\(현재 패키지\) .. \(부모 패키지\) 상대적인 가져오기 가
* A 패키지에서 B패키지를 불러오면 A패키지를 불러오면 B패키지도 사용 가능





## 서드파티 패키지

{% embed url="http://pypi.org" %}



