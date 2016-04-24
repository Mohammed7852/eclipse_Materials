'''
Created on Mar 1, 2016

@author: mohamed ali shabanah
'''
class shape :
    def area(self,x,y):
        print("Area=")
            
            
class rectangle (shape):
    def area(self,x,y):
        print("rectangle  area  is  =", x*y)
    
class circle(shape):
    def area(self,x):
        print("circle  area  is  =",3.14*x*x)
            
        


        