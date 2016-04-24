import  socket , sys

s=socket.socket(socket.AF_INET, socket.SOCK_DGRAM) 

MAX=5535#message  length 
PORT=1060


if sys.argv[1]=='server':
    s.bind(('127.0.0.1', PORT))
    print("Listen=ning at ", s.getsockname())
    
    while True:
            #1  server
        data,address=s.recvfrom(MAX)
            
        print("The  Client at ", address,'  says',repr(data))
            
        s.sendto(b'your  data was %d bytes'%len(data), address)#نرد عليه ب  رساله وعنوان معين #لا Bytes
            #نرد عليه بطول  الداتا  المرسله 
elif sys.argv[1]=='client':
       s.bind(('127.0.0.1',0))
       print('My address  is  :',s.getsockname())
       s.sendto(b'this is my  message',('127.0.0.1',PORT))
       data ,address =s.recvfrom(MAX)
       print('The server ',address , ' says :',repr(data))
    


#print(socket.getservbyname('http'))
#print(socket.getservbyname('telnet'))
