'''
Created on Nov 5, 2015

@author: mohamed ali shabanah
'''
#import urllib

import json

import urllib.request
import urllib.parse

googleGeocodeUrl = 'http://maps.googleapis.com/maps/api/geocode/json?'

def get_coordinates(query): #, from_sensor=False
    query = query.encode('utf-8')
    params = {'address': query}#,'sensor': "false"} #"true" if from_sensor else 
    url = googleGeocodeUrl + urllib.parse.urlencode(params) 
    json_response = urllib.request.urlopen(url)
     
    hold = json_response.read()
   # print(str(hold,'utf-8'))
    response = json.loads(str(hold,'utf-8'))
    if response['results']:
      #  print (response['results'])
        location = response['results'][0]['geometry']['location']
        latitude, longitude = location['lat'], location['lng']
        print ( latitude, longitude) #str(query,'utf-8'),
    else:
        latitude, longitude = None, None
        print (query, "<no results>")
    return latitude, longitude

get_coordinates('207 N. Defiance St, Archbold, OH')


