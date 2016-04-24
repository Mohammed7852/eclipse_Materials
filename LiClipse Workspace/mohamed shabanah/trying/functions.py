'''
Created on Oct 18, 2015

@author: mohamed ali shabanah
'''

 
def max(x ,y ):
    if x>y :
        return x
    else :
        return y
 

def min(x ,y):
    if x<y:
        return x
    else :
        return y
 

def add(x ,y  ):
    return x+y
def sub(x ,y ):
    return x-y   

def mult(x ,y):
    return x*y

def div(x ,y ):
    if y==0 :
        print("error")
    else :
        return x/y
                 
                 
class person :
    def check(self , x ):
        if x>=18 :
            return True
        else: 
            return False  
                         
                 
                 