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

    def calcular_duracion_total(self):
        total_minutos = 0
        total_segundos = 0
        actual = self.canciones
        while actual:
            minutos, segundos = map(int, actual.duracion.split(":"))
            total_minutos += minutos
            total_segundos += segundos
            actual = actual.siguiente
        total_minutos += total_segundos // 60
        total_segundos = total_segundos % 60
        self.duracion_total = f"{total_minutos}:{str(total_segundos).zfill(2)}"
        return self.duracion_total

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

    def reproducir_cancion(self, titulo):
        cancion = self.buscar_cancion(titulo)
        if cancion:
            print(f"Reproduciendo: {cancion}")
        else:
            print(f"La canción '{titulo}' no se encuentra en esta playlist.")

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

    def reproducir_playlist(self, indice):
        playlist = self.seleccionar_playlist(indice)
        if playlist:
            print(f"\nReproduciendo todas las canciones de la playlist '{playlist.nombre}':")
            actual = playlist.canciones
            while actual:
                print(f"Reproduciendo: {actual}")
                actual = actual.siguiente

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
                    accion = input("¿Quieres reproducir (r), buscar (b), o eliminar (e) una canción? (Enter para volver): ").lower()
                    if accion == 'r':
                        playlist.reproducir_playlist()
                    elif accion == 'b':
                        titulo = input("Ingresa el título de la canción que deseas buscar: ")
                        cancion = playlist.buscar_cancion(titulo)
                        if cancion:
                            print(f"Canción encontrada: {cancion}")
                        else:
                            print("Canción no encontrada.")
                    elif accion == 'e':
                        titulo = input("Ingresa el título de la canción que deseas eliminar: ")
                        playlist.eliminar_cancion(titulo)
                    input("\nPresiona Enter para volver al menú principal.")
            except ValueError:
                print("Por favor, ingresa un número válido.")
