# -*- coding: utf-8 -*-
"""
Created on Tue Nov  9 20:37:25 2021

@author: gunca
"""
import xmlrpc.client

s = xmlrpc.client.ServerProxy('http://localhost:8000')
print("Message from Server ... ")
print(s.pow(2,3))  # Returns 2**3 = 8
print(s.add(2,3))  # Returns 5
print(s.mul(5,2))  # Returns 5*2 = 10

# Print list of available methods
print(s.system.listMethods())