'''
Created on Nov 1, 2015

@author: FCI-Laps
'''
import http.client
try:
    import json
except ImportError: # for Python 2.5
    import simplejson as json
path = 'maps/api/geocode/json?address=207+N.+Defiance+St%2c+Archbold%2c+OH&sensor=false'
connection = http.client.HTTPConnection('maps.googleapis.com')
connection.request('GET', path)
rawreply = connection.getresponse().read()
reply = json.loads(str(rawreply,'utf-8'))
location = reply[['results'][0]['geometry']['location']]
print (location['lat'],location['lng'])
