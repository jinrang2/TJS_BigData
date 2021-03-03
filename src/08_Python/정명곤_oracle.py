# -*- coding: utf-8 -*-
"""
Created on Tue Mar  2 14:59:04 2021

@author: tjoeun
"""
import csv
import cx_Oracle
import sqlite3

class Customer:
    
    def __init__(self, name, phone, email, age, grade, etc):
        self.name = name
        self.phone = phone
        self.email = email
        self.age = age
        self.grade = grade
        self.etc = etc
        
    def __str__(self):
        return '{:>5}\t{}\t{}\t{:14}\t{:4}\t{}\n'.format(  '*'*self.grade, 
                                                 self.name,
                                                 self.phone,
                                                 self.email,
                                                 self.age,                                                 
                                                 self.etc)
    
    def print_customer(self):
        print(self.__str__(),end='')        
        
    def print_header():
        print('=================================================================')
        print('                            고객  정보                            ')
        print('=================================================================')
        print('{:^5}\t{:^3}\t{:^12}\t{:^14}\t{:^}\t\t{:^5}'.format(
            'GRADE','이 름','전화','메일','나이','기타'))        
        
    def print_footer():
        print('=================================================================')


def main():
    global conn
    global cursor
    init_customer()
    
    while(True):
        try:
            print('1:입력|2:전체출력|3:이름찾기|4:이메일삭제|5:내보내기(CSV)|9:종료')
            menu = int(input('메뉴 선택:'))
        except Exception as e:
            print(e.__str__())
            print('메뉴에 있는 숫자를 입력하세요')
            continue            
        
        if(menu==1):
            customer_input()
        elif(menu==2):
            customer_all_print()
        elif(menu==3):
            customer_find_byname()            
        elif(menu==4):
            customer_delete()
        elif(menu==5):
            customer_export()
        elif(menu==9):
            exit_app()
            break
        else:
            print('메뉴에 있는 숫자를 입력하세요')
        
def customer_input():
    
    name=input('이름:')
    phone=input('전화번호:')
    email=input('이메일:')
    age=int(input('나이:'))
    grade=int(input('고객등급(1-5):'))
    etc=input('기타정보:')
   
    try:
        cursor.execute('INSERT INTO MEMBER VALUES (:name, :phone, :email, :age, :grade, :etc)',
         {'name':name, 'phone':phone, 'email':email, 'age':age, 'grade':grade, 'etc':etc})
    
    except AttributeError as e:
        print(e.message)
        print(e.__str__())
        
    conn.commit()
    
    
def customer_all_print():    
    
    cursor.execute('SELECT NAME,PHONE,EMAIL,AGE,GRADE,ETC FROM MEMBER')
    clist = cursor.fetchall()
    
    Customer.print_header()
    
    for c in clist:
        name = c[0]
        phone = c[1]
        email = c[2]
        age = c[3]
        grade = c[4]
        etc = c[5]
        
        temp = Customer(name, phone, email, age, grade, etc)
        
        temp.print_customer()
        
    
    Customer.print_footer()
    


def customer_delete():
    email = input('삭제할 이메일은 ? : ')
    
    cursor.execute('DELETE FROM MEMBER WHERE EMAIL=:email',{'email':email})    
    conn.commit()

def customer_find_byname():
    
    name = input('찾을 고객 이름은 ? : ')
    
    cursor.execute('''
                   SELECT NAME,PHONE,EMAIL,AGE,GRADE,ETC 
                   FROM MEMBER 
                   WHERE NAME = :name
                   ''',{'name':name})
                   
    clist = cursor.fetchall()
    
    if len(clist) == 0:
        print(name + ' 고객이 없습니다')
    else:
    
        Customer.print_header()
        
        for c in clist:
            name = c[0]
            phone = c[1]
            email = c[2]
            age = c[3]
            grade = c[4]
            etc = c[5]
            
            temp = Customer(name, phone, email, age, grade, etc)
            
            temp.print_customer()
            
        
        Customer.print_footer()

def customer_export():
    
    name = input('내보낼 파일 이름은 ? : ')
    
    try:
        with open(name+'.csv','w',newline='', encoding='CP949') as f:
            writer=csv.writer(f)
            
            cursor.execute('SELECT NAME,PHONE,EMAIL,AGE,GRADE,ETC FROM MEMBER')
            clist = cursor.fetchall()            
            writer.writerow(['이름','전화번호','이메일','나이','등급','기타'])
    
            for c in clist:
                temp = []
                
                temp.append(c[0])
                temp.append(c[1])
                temp.append(c[2])
                temp.append(c[3])
                temp.append(c[4])
                temp.append(c[5])
        
                writer.writerow(temp)
    except Exception as e:
        print(e)
        
    

def exit_app():        
    cursor.close()
    conn.close()

def init_customer():
    
    
    try:
        cursor.execute('SELECT NAME FROM MEMBER')
        clist = cursor.fetchall()
        
    except Exception as e:
        print(e.__str__())
        print('테이블이 없으므로 테이블을 생성합니다')
        cursor.execute('''
            CREATE TABLE member (
                name varchar2(30),
                phone varchar2(30),
                email varchar2(30),
                age number(5),
                grade number(1),
                etc varchar2(30))
        '''
        )
        
    
    
conn = cx_Oracle.connect('scott','tiger','localhost:1521/xe')
cursor = conn.cursor()
main()    
    

