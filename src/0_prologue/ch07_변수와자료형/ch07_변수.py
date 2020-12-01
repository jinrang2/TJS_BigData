#!/usr/bin/env python
# coding: utf-8

# In[48]:


print("반지름이 5인 원의 넓이는 ",(5*5*3.14)) # ctrl or Shitf or alt엔터


# ## ESC -> a(윗셀추가), b(아랫셀추가), dd(해당 셀 삭제), m(markdown)
# 
# #ch07 변수와 자료형
# 7-1 변수

# In[61]:


r=1000000000000


# In[62]:


area = r * r * 3.14


# In[63]:


print("원의 넓이는 ",area)


# In[78]:


a=1.2
b=7
print(a+b)


# In[71]:


#변수명은 반드시 알파벳(소문자)으로 시작, 특수문자는 언더바(_ 만 가능), 숫자가능, 
#변수명은 저장될 갓을 대표하는 이름


# In[72]:


a=7
b=7
print("a+b")


# In[91]:


#7-2변수의 기본타입


# In[93]:


name ="홍길동"
print(name)


# <b>숫자형(int, float), 문자형, 불린형</b>

# In[94]:


inta = 5 #정수형(int)
intb = 2 


# In[96]:


print (type(inta), type(intb))


# In[101]:


floata = 1.5 # 실수형(float)
floatb = 2.0 
print( type(floata), type(floatb))


# In[111]:


stra = "ABC" #문자형
strb = '123'
print ( type(stra), type(strb))
print ( stra + strb )


# In[116]:


print (stra, strb, sep=" ~ ")


# In[120]:


booleana = True # 불린형(True, False)
booleanb = False
print( type(boolean), type(boolean))
print( booleana+booleanb)


# #7.3 데이터 타입과 연산자

# In[129]:


print(inta, intb)
print(floata, floatb)
print(stra, strb)
print(booleana, booleanb)


# In[132]:


print("inta+intb",inta+intb)
print("inta-intb",inta-intb)
print("inta*intb",inta*intb)
print("inta/intb",inta/intb)
print("inta//intb", inta // intb) #나누기의 몫
print("inta%intb", inta % intb)  #나누기의 나머지
print("inta ** intb", inta ** intb) #제곱


# In[134]:


print('실행전 원 int a 값 :',inta)
inta += 1 # inta = inta + 1 
print('연산자 수행후 int a 값 :',inta)


# In[135]:


print('실행전 원 int a 값 :',inta)
inta -= 1 # inta = inta - 1 
print('연산자 수행후 int a 값 :',inta)


# In[137]:


#문자 연산
print(stra, strb)


# In[143]:


print(stra+strb) #문자형끼리 더하면 연결
print(stra+str(3))


# In[146]:


print(stra*3) #문자형의 곱셈은 반복을 의미


# ## 7.4 형변환
# 
# - 숫자 <-> 문자형
# - 정수 <-> 실수

# <b> 정수형 <-> 실수형 </b>

# In[152]:


a = 10.7       #실수(float) 형
print(int(a))  #실수형을 정수형으로 형변환(짤림)


# In[156]:


a=10             #정수(int) 형
print(float(a))  #실수형으로 형변환


# <b> 숫자형(int, float) -> 문자형 : str()함수 </b>

# In[161]:


a = 10
b = 10.7
print (type(a), type(b))
a = 10.7
b = 10.0
print (type(a), type(b))
print (str(a), str(b))


# <b>문자 -> 숫자(int, float)
#                 

# In[167]:


stra ="10"
a = int(stra)
print(a, type(a))


# In[173]:


stra = "-10"
a = float(stra)
print(a, type(a))


# #형변환 = 명시적형변환 ( str, int(), float() 함수이용)
#           묵시적형변환

# In[176]:


a=10
b=3
result=a+b
print(result, type(result))


# In[178]:


a=10.1
b=2.9
result=a+b
print(result, type(result))


# In[180]:


a=10
b=3
result=a/b #정수끼리 연산 결과는 정수 => 묵시적으로 실수형으로 변환
print(result, type(result))


# In[ ]:


## 사용자로부터 반지름을 입력받아 원의 넓이를 출력합니다
## 출력받는 함수 : print()
## 사용자로부터 입력받아 str형 값으로 받음: input()


# In[12]:


name = input('이름을 입력하세요 :')
print('입력한 이름은',name)


# In[13]:


r= float(input("반지름을 입력하세요 : "))
print(r**2*3.14)


# In[ ]:




