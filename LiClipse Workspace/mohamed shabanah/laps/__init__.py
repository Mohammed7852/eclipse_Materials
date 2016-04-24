'''
Created on Nov 1, 2015

@author: FCI-Laps
'''
import socket

sock = socket.socket()
sock.connect(('maps.googleapis.com', 80))
message='GET maps/api/geocode/json?address=207+N.+Defiance+St%2c+Archbold%2c+OH&sensor=false HTTP/1.1\r\n+Host: maps.google.com:80\r\n+User-Agent: latlong4_Complete_PY3.py\r\n+Connection: close\r\n+\r\n'
sock.sendall(message.encode('utf-8'))
rawreply = sock.recv(80)
print (rawreply) 

