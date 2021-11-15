
class Persona:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad =edad
    
    def __str__(self):
        return self.nombre

    def presentarse(self):
        print("Me llamo {}. Como te llamas?". format(self.nombre))

    def  responder(self, otro):
        print("Hola {}, me llamo {}.".format(otro.nombre, self.nombre))

    def preguntar_edad(self, otro):
        print(" {}:, cuantos años tienes?. " .format(otro.nombre))

    def respoder_edad(self, otro):
        print(" {}:, tengo {} años ".format(otro.nombre, self.edad))


william = Persona("Jessica",22)
jessica = Persona("William",23)
        
william.presentarse()
jessica.responder(william)

jessica.preguntar_edad(william)
william.respoder_edad(jessica)
