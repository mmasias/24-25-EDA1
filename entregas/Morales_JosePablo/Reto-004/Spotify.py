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

playlist_sabaton = Playlist("Sabaton", "Sabaton")
playlist_sabaton.duracion_total = "1 hora y 59 minutos"
playlist_sabaton.agregar_cancion("Uprising", "4:56")
playlist_sabaton.agregar_cancion("Fields of Verdun", "3:17")
playlist_sabaton.agregar_cancion("Winged Hussars", "3:52")
playlist_sabaton.agregar_cancion("Defence of Moscow", "4:09")
playlist_sabaton.agregar_cancion("Stalingrad", "5:18")
playlist_sabaton.agregar_cancion("Coat of Arms", "3:35")
playlist_sabaton.agregar_cancion("Primo Victoria", "4:11")
playlist_sabaton.agregar_cancion("Bismarck", "5:14")
playlist_sabaton.agregar_cancion("Panzerkampf", "5:16")
playlist_sabaton.agregar_cancion("The Red Baron", "3:22")
playlist_sabaton.agregar_cancion("The Last Stand", "3:56")
playlist_sabaton.agregar_cancion("Sparta", "4:24")
playlist_sabaton.agregar_cancion("The White Death", "4:10")
playlist_sabaton.agregar_cancion("Panzer Battalion", "5:10")
playlist_sabaton.agregar_cancion("Stormtroopers", "3:56")
playlist_sabaton.agregar_cancion("To Hell and Back", "3:27")
playlist_sabaton.agregar_cancion("Soldier of 3 Armies", "3:38")
playlist_sabaton.agregar_cancion("82nd All the Way", "3:31")
playlist_sabaton.agregar_cancion("Shiroyama", "3:34")
playlist_sabaton.agregar_cancion("Great War", "4:28")
playlist_sabaton.agregar_cancion("Wehrmacht", "4:14")
playlist_sabaton.agregar_cancion("The Attack of the Dead Men", "3:56")
playlist_sabaton.agregar_cancion("Swedish Pagans", "4:13")
playlist_sabaton.agregar_cancion("Aces in Exile", "4:23")
playlist_sabaton.agregar_cancion("Soldier of Heaven", "3:38")
playlist_sabaton.agregar_cancion("The Ballad of Bull", "3:53")
playlist_sabaton.agregar_cancion("Night Witches", "3:01")
playlist_sabaton.agregar_cancion("The Unkillable Soldier", "4:11")
playlist_sabaton.agregar_cancion("The Last Battle", "3:12")
playlist_sabaton.agregar_cancion("The Final Solution", "4:56")
playlist_sabaton.agregar_cancion("Midway", "2:29")
playlist_sabaton.agregar_cancion("Hearts of Iron", "4:28")

playlist_sinatra = Playlist("Frank Sinatra", "Frank Sinatra")
playlist_sinatra.duracion_total = "1 hora y 16 minutos"
playlist_sinatra.agregar_cancion("That's Life", "3:07")
playlist_sinatra.agregar_cancion("Fly Me To The Moon (in other words)", "2:27")
