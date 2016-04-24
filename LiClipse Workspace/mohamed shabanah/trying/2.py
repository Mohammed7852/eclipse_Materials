'''
Created on Oct 18, 2015

@author: mohamed ali shabanah
'''

import functions
from trying.functions import add
from trying.functions import sub 

from _overlapped import NULL
from pip._vendor.pkg_resources import null_ns_handler
 



from trying.functions import person

p=person

file="Myfile.txt"
 

while True:
    message=input("enter the age:")
    num=int(message)
    temp=person.check(NULL, num)
      
    if person.check(NULL, num):
        f=open(file , 'r+')
        f.seek(0)
        r=f.read()
        y=int(r)+1
        f.seek(0)
        f.write(str(y))
        print("the age added succefully.")
    else :
        y= 18-num 
        print("to be accepted you need :" , y , "\n\n") 
        
        
        
        
        
        
        
        