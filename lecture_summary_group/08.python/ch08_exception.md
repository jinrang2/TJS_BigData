# ch08\_예외처리

## 예외 처리 기

```python
try:
    예외가능성 문장
    # 예외를 만
    raise Exception('예외내')
except:
    예외 발생시 실행할 문장
finally:
    무조건 실행할 문장


```

## 추상 클래스 흉내내기

생성자와 메서드에서 예외를 발생시켜 강제로 추상클래스화 되게 

```python
class abstractClass:
    
    __init__(self,args):
        raise NotImplementError
        
    def method(self,args):
        raise NotImplementError
```

