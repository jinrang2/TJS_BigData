# -*- coding: utf-8 -*-
"""
Created on Tue Feb 23 15:05:27 2021

@author: tjoeun
"""
'''
태어난 연도 입력 
나이와 성일 인지 
'''

import sys


if(len(sys.argv) >= 2):
    year = int(sys.argv[1])
else:
    year = int (input('you 년도 입력? '))
    44
age = 2020-year+2
    

if (age <= 14):
    grade='아동'
elif (15 <= age <=19):
    grade='청소년'
elif (20 <= age):
    grade='성인'
else:
    grade='너 뭐얏!'    
    
print ("당신의 나이는 {}이고 {}입니다".format(age, grade))



    

