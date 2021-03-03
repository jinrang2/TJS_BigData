# -*- coding: utf-8 -*-
"""
Created on Tue Mar  2 14:59:04 2021

@author: tjoeun
"""
import csv
import cx_Oracle
import sqlite3

class Customer:
    
    def __init__(self, name, tel, email, age, grade, etc):
        self.name = name
        self.tel = tel
        self.email = email
        self.age = age
        self.grade = grade
        self.etc = etc
        
    def __str__(self):
        return '{:>5}\t{}\t{}\t{:14}\t{:4}\t{}'.format(  '*'*self.grade, 
                                                 self.name,
                                                 self.tel,
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
    customer_list = []
    customer_list = init_customer()
    
    while(True):
        try:
            print('1:입력|2:전체출력|3:삭제|4:이름찾기|5:내보내기(CSV)|9:종료')
            menu = int(input('메뉴 선택:'))
        except Exception as e:
            print(e.__str__())
            print('메뉴에 있는 숫자를 입력하세요')
            continue            
        
        if(menu==1):
            customer_list.append(customer_input())
        elif(menu==2):
            customer_all_print(customer_list)
        elif(menu==3):
            customer_delete(customer_list)
        elif(menu==4):
            customer_find_byname(customer_list)
        elif(menu==5):
            customer_export(customer_list)
        elif(menu==9):
            exit_app(customer_list)
            break
        else:
            print('메뉴에 있는 숫자를 입력하세요')
        
def customer_input():
    print('메뉴1')
    
    name=input('이름:')
    tel=input('전화번호:')
    email=input('이메일:')
    age=int(input('나이:'))
    grade=int(input('고객등급(1-5):'))
    etc=input('기타정보:')

    return Customer(name, tel, email, age, grade, etc)
    
    
def customer_all_print(customer_list):    
    print('메뉴2')
    if(len(customer_list)==0):
        print('고객이 없습니다')
        return
            
    Customer.print_header()
    
    for c in customer_list:
        print(c)
        
    Customer.print_footer()


def customer_delete(customer_list):
    print('메뉴3')
    name = input('삭제할 고객 이름은 ? : ')
    find = False
    del_idx = []
    
    for idx, c in enumerate(customer_list):
        if (c.name == name):
            del_idx.append(idx)
            find=True
            
    del_idx.reverse()
    
    for i in del_idx:
        del customer_list[i]
    
    if (find==False):
        print(name + ' 고객이 없습니다')
    else:
        print(name + ' 고객을 삭제 했습니다')

def customer_find_byname(customer_list):
    print('메뉴4')
    
    name = input('찾을 고객 이름은 ? : ')
    find = False
    find_idx = []
    
    Customer.print_header()
    for cl in customer_list:
        if (cl.name == name):            
            print(cl)            
            find = True
    Customer.print_footer()
    
    if (find==False):
        print(name + ' 고객이 없습니다')

def customer_export(customer_list):
    print('메뉴5')
    
    try:
        with open('data/ch09_customer.csv','w',newline='', encoding='CP949') as f:
            writer=csv.writer(f)
            for cl in customer_list:
                temp = []
                temp.append(cl.name)
                temp.append(cl.tel)
                temp.append(cl.email)
                temp.append(cl.age)
                temp.append(cl.grade)
                temp.append(cl.etc)
                
                writer.writerow(temp)
    except Exception as e:
        print(e)
        
    

def exit_app(customer_list):    
    print('메뉴9')
    try:
        with open('data/ch09_customer.txt','w',encoding='utf8') as f:
            
            for cl in customer_list:
                f.write('{},{},{},{},{},{}\n'.format(cl.name,
                                                     cl.tel,
                                                     cl.email,
                                                     cl.age,
                                                     cl.grade,
                                                     cl.etc))
       
    except Exception as e:
        print(e.__str__())

def init_customer():
    
    try:
        with open('data/ch09_customer.txt','r',encoding='utf8') as f:
            lines =f.readlines()
            
            customer_list = []
            
            for line in lines:
                data = line.strip().split(',')
                name = data[0]
                tel = data[1]
                email =data[2]
                age = int(data[3])
                grade = int(data[4])
                etc = data[5]
                
                customer_list.append(Customer(name, tel, email, age, grade, etc))
                
            return customer_list                  
        
    except Exception as e:
        print(e.__str__())        
        print('고객이 없습니다')
        return []

            
main()    
    

