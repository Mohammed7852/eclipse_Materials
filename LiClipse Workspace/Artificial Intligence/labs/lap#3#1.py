'''
Created on Mar 15, 2016
@author: mohamed ali shabanah
'''
from lib2to3.pytree import Node
from _tkinter import create
state=[5,6,4,7,0,8,9,1,2,3]


def move_up(state):
    new_state=state[:]
    index=new_state.index(0)
    if  index not in [0,3,6]:
        temp=new_state[index-1]
        new_state[index-1]=new_state[index]
        new_state[index]=temp
        return new_state
    else:
        return None
    
def move_down(state):
    new_state=state[:]
    index=new_state.index(0)
    if index not in [2,5,8]:
        temp=new_state[index+1]
        new_state[index+1]=new_state[index]  
        new_state[index]=temp
        return new_state
    else :return None  



 
class node:
    def __init__(self,state,parent,operator,depth,cost):
        self.state=state
        self.parent=parent
        self.operator=operator
        self.depth=depth
        self.cost=cost
    def create_node(self,state,parent,operator,depth,cost):
        return Node(state,parent,operator,depth,cost)
    def expand_node(self):
        expanded_nodes=[]
        expanded_nodes.append(create_node(move_up(node.state),node,"u",node.depth,+1,0)
                               
                              
           
    
 

            