'''
Created on Nov 8, 2015

@author: mohamed ali shabanah
'''
import zlib

def one(x  ):
    y=x.encode('utf-8')
    print("encode :",y)
    z=zlib.compress(y)
    print("comp: ",z)
    return z

def  two(x):
    y=zlib.decompress(x)
    print("decomp :",y)
    z=y.decode('utf-8')
    print("decode :",z)
    return z
