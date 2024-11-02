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
class SistemaReproduccionMusica:
    def __init__(self):
        self.playlists = []

    def agregar_playlist(self, playlist):
        self.playlists.append(playlist)

    def mostrar_playlists(self):
        print("Playlists disponibles:")
        for i, playlist in enumerate(self.playlists):
            print(f"{i + 1}. {playlist}")

    def seleccionar_playlist(self, indice):
        if 0 <= indice < len(self.playlists):
            return self.playlists[indice]
        else:
            print("Índice de playlist inválido.")
            return None

    def iniciar(self):
        while True:
            self.mostrar_playlists()
            seleccion = input("Selecciona el número de la playlist que deseas escuchar (o 'q' para salir): ")
            if seleccion.lower() == 'q':
                print("Saliendo del sistema de reproducción de música.")
                break
            try:
                indice = int(seleccion) - 1
                playlist = self.seleccionar_playlist(indice)
                if playlist:
                    print(f"\nCanciones en la playlist '{playlist.nombre}':")
                    playlist.mostrar_canciones()
                    input("\nPresiona Enter para volver al menú principal.")
            except ValueError:
                print("Por favor, ingresa un número válido.")
