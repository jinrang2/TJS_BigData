# -*- coding: utf-8 -*-
"""
Created on Thu Feb 25 14:34:05 2021

@author: tjoeun
"""
def fibo_print(n):
    'n미만의 피보나치 수열 print'
    for i in fibo_return(n):
        print(i, end=' ')
    print()
    

def fibo_return(n):
    'n미만의 피보나치 수열 리스트 리턴'
    result = []
    a,b=0,1    
    while(a<n):
        result.append(a)
        a , b =  b, a+b
    return result

if __name__ == '__main__':
    fibo_print(10)

