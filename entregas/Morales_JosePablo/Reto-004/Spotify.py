class Cancion:
    def __init__(self, titulo, duracion):
        self.titulo = titulo
        self.duracion = duracion
        self.siguiente = None

    def __str__(self):
        return f"{self.titulo} ({self.duracion})"

class Playlist:
    def __init__(self, nombre, artista):
        self.nombre = nombre
        self.artista = artista
        self.canciones = None
         def agregar_cancion(self, titulo, duracion):
        nueva_cancion = Cancion(titulo, duracion)
        if not self.canciones:
            self.canciones = nueva_cancion
        else:
            actual = self.canciones
            while actual.siguiente:
                actual = actual.siguiente
            actual.siguiente = nueva_cancion

    def mostrar_canciones(self):
        actual = self.canciones
        while actual:
            print(actual)
            actual = actual.siguiente

    def buscar_cancion(self, titulo):
        actual = self.canciones
        while actual:
            if actual.titulo.lower() == titulo.lower():
                return actual
            actual = actual.siguiente
        return None

    def eliminar_cancion(self, titulo):
        actual = self.canciones
        previo = None
        while actual:
            if actual.titulo.lower() == titulo.lower():
                if previo:
                    previo.siguiente = actual.siguiente
                else:
                    self.canciones = actual.siguiente
                print(f"Canción '{titulo}' eliminada de la playlist.")
                return True
            previo = actual
            actual = actual.siguiente
        print(f"Canción '{titulo}' no encontrada en la playlist.")
        return False

    def __str__(self):
        return f"{self.nombre} - {self.artista}"
