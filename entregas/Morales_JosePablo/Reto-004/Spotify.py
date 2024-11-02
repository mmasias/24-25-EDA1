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
        self.duracion_total = "0:00"

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

    def __str__(self):
        return f"{self.nombre} - {self.artista} (Duración total: {self.duracion_total})"
