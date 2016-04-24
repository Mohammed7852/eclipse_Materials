'''
Created on Oct 11, 2015

@author: mohamed ali shabanah
'''
  

radfan =[1,2,3,4]
x = {1,2 , "Mpohann",3}
 

while True:
    n1=input("Enter the  first number :")
    op=input("Enter the  operation :")
    n2=input("Enter the second number:")

    if op=='+':
        print(int(n1)+int(n2))
    if op=='-':
        print(int(n1)-int(n2))
    if op=='*':
        print(int(n1)*int(n2))
    if op=='/':
        print(int(n1)/int(n2))
    if op=='**':
        print(int(n1)**int(n2))
    if op=='^':
        print(int(n1)^int(n2))
        
    
                 