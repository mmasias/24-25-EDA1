class Cancion:
    def __init__(self, nombre, duracion):
        self.nombre = nombre
        self.duracion = duracion

class Playlist:
    def __init__(self, nombre):
        self.nombre = nombre
        self.canciones = []
    
    def agregar_cancion(self, cancion):
        self.canciones.append(cancion)
    
    def eliminar_cancion(self, index):
        if 0 <= index < len(self.canciones):
            return self.canciones.pop(index)
        return None
    
    def mostrar_playlist(self):
        print(f"=== Playlist: {self.nombre} ===")
        for idx, cancion in enumerate(self.canciones):
            print(f"{idx + 1}. {cancion.nombre} ({cancion.duracion}s)")
        print("==============================")