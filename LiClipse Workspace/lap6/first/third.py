import socket, sys

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
HOST = sys.argv.pop() if len(sys.argv) == 3 else '127.0.0.1'
PORT = 1060
L=0

def recv_all(sock, length):
    data = ''
    while len(data) < length:
        more = sock.recv(length - len(data))
        if not more:
            print('socket closed %d bytes into a %d-byte message'% (len(data), length))
        data += str(more)
        
    return data
 
if sys.argv[1:] == ['server']:

    s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    s.bind((HOST, PORT))
    s.listen(1)
    print('Listening at', s.getsockname())
    sc, sockname = s.accept()

    while True:
        
        print('We have accepted a connection from', sockname)
        print('Socket connects', sc.getsockname(), 'and', sc.getpeername())
        message = recv_all(sc, 16)
        print('The incoming sixteen-octet message says', repr(message))
        sc.sendall(b'Farewell, client')
        s.close()
        
elif sys.argv[1:] == ['client']:
    s.connect((HOST, PORT))
    print('Client has been assigned socket name', s.getsockname())
    while True:
        M=input('enter message::')
        if M=='close':
            s.close()
            print("thank you")
            break; 
        s.sendall(bytes(M,'utf_8'))
        L=len(M) 
        reply = recv_all(s, L)
        print('The server said', repr(reply))
      