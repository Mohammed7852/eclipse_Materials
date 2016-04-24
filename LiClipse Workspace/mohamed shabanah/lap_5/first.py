'''
Created on Nov 15, 2015

@author: mohamed ali shabanah
'''
import second

import  multiprocessing as mp


import  math

def first(q,x ):
    x=math.factorial(x)
    q.put(x)
    #print(math.factorial(x))
     
def sec(q ):
    x=input("enter").split()
    q.put(x) 
     

if __name__=='__main__':
    ctx =mp.get_context('spawn')
    q=ctx.Queue()
    p=ctx.Process(target=first(q,4) , args=(q,4))
    p.start() 
    p.join()
    print(q.get())
    p=ctx.Process(target =sec(q ) , args=(q,))
    p.start()
   
    print(q.get())
    p.join()
     
     