# -*- coding: utf-8 -*-
"""
Created on Tue Nov  9 20:31:55 2021

@author: gunca
"""

from xmlrpc.server import SimpleXMLRPCServer
from xmlrpc.server import SimpleXMLRPCRequestHandler

# Restringir a un camino en particular.
class RequestHandler(SimpleXMLRPCRequestHandler):
    rpc_paths = ('/RPC2',)

# Crear servidor
with SimpleXMLRPCServer(('localhost', 8000),
                        requestHandler=RequestHandler) as server:
    server.register_introspection_functions()

    print("Server is listening on port 8000 ... ")
    server.register_function(pow)

    def adder_function(x, y):
        return x + y
    server.register_function(adder_function, 'add')

    # Registre una instancia; todos los métodos de la instancia son
     # publicado como métodos XML-RPC (en este caso, simplemente 'mul').
    class MyFuncs:
        def mul(self, x, y):
            return x * y
    server.register_instance(MyFuncs())
    # Ejecutar el servidor
    server.serve_forever()