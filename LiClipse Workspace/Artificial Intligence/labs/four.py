'''
Created on Mar 8, 2016
@author: mohamed ali shabanah
'''
#Table_Based
loc_A,loc_B='A','B'
from smtpd import program
 
class agent :
    def __init__(self,program=None):
        if program is None:
             def program(percept):
                 return input('Percept=%3; action? ' %percept)
        self.program=program     



def ReflexVacuumAgent():
    def program(percept):
        a=percept[0]
        b=percept[1]
        if a=='A':
            if b=='clean':
                return "go to right";
            else:
                return "be in your location";
        if a=='B':#i can use  lif
            if b=='clean':
                return  "go to left";
            if b=='dirty':
                return "be in your location";    
    return agent(program)     
    
a=ReflexVacuumAgent()
print(a.program([loc_A,'clean']))
print(a.program([loc_B,'clean']))
print(a.program([loc_A,'dirty']))
print(a.program([loc_B,'dirty']))

