'''
Created on Oct 18, 2015

@author: mohamed ali shabanah
'''


from laps.second import person
from _overlapped import NULL
 
p = person

f=open('file.txt','w')
f.write("0")

while(True): 
    message=input("enter age of person")
    x=int(message)
    
    f=open('file.txt','r+')
     
    f.seek(0)
    y=f.read()
    
    print(int(y))
    
    b=p.check_age(NULL , x)
    
    if(b==True):
        f.seek(0)
        y=int(f.read())
        z=int(y)+1;
        f.seek(0)
        f.write("")
        f.write(str(z))      
        y=f.read()
        f.close()
        print("in file  we  have this number :"+y)
    else:
        print("to be accepted you need "+18-x)
        
        
