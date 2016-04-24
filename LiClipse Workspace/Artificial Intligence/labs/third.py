from filecmp import cmp

#Lists
list1=[1,2,3,4,5]
list2=[5,6,7,8,9]

print(len(list1+list2))
print("-----------------------------------------")

print(2 in list1)
print("-----------------------------------------")

print(list1*3)
print("-----------------------------------------")

i=0
while i<len(list1):
    print(list1[i]," ")
    i+=1
    
    
print("-----------------------------------------")
for i in range(len(list2)):
    print(list2[i])    
    
    
print("-----------------------------------------")
#List Methhods
print(max(list2), min(list1),len(list1))#cmp does not work with this version of  python'
list1.append(list2)
print("-----------------------------------------")
print(list1)
print("-----------------------------------------")
print(list1.count(5))
print("-----------------------------------------")
list1.extend(list2)
print(list1)
print("-----------------------------------------")
print(list1.index(7))
list(list2)
print("-----------------------------------------")
#list1.remove()
print(list1)
print("-----------------------------------------")
#list1.reverse()
print(list1)
print("-----------------------------------------")
#list1.sort(key=None, reverse=True)
print(list1)
print("-----------------------------------------")
print(list1.pop())
print(list1)
print("-----------------------------------------")
"""def check_dublicates(list):
    for i in range(len(list)):
        count=list.count(list[i])
        if(count>1):
          return True

    return False
"""
def anyduplicates(thelist):
    seen = set()
    for x in thelist:
        if x in seen: return True
        seen.add(x)
    return False

#list=[1,2,3,4,5,6,1]
#print(anyduplicates(list))
print("-----------------------------------------")
                    #Tubles 

tuble1=(1,2,3,4,5,6)
Tuble2=()
print(tuble1[2])
print("-----------------------------------------")
#tuble1[2]=8
tup=tuple(list1)
print(tup)
print("-----------------------------------------")
lis=list(tuble1)
print(lis)
























