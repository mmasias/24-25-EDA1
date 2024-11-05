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

playlist_predeterminada = Playlist("Predeterminada", "Varios")
playlist_predeterminada.duracion_total = "1 hora, 35 minutos"

playlist_predeterminada.agregar_cancion("Caraluna - Bacilos", "4:26")
playlist_predeterminada.agregar_cancion("STAY (with Justin Bieber) - The Kid LAROI, Justin Bieber", "2:22")
playlist_predeterminada.agregar_cancion("It's My Life - Bon Jovi", "3:44")
playlist_predeterminada.agregar_cancion("Karma Chameleon - Culture Club", "4:12")
playlist_predeterminada.agregar_cancion("Nunca es Suficiente - Los Angeles Azules, Natalia Lafourcade", "4:26")
playlist_predeterminada.agregar_cancion("Carry on Wayward Son - Kansas", "5:23")
playlist_predeterminada.agregar_cancion("Somebody To Love - Queen", "4:56")
playlist_predeterminada.agregar_cancion("Bam Bam (feat. Ed Sheeran) - Camila Cabello, Ed Sheeran", "3:26")
playlist_predeterminada.agregar_cancion("THAT'S WHAT I WANT - Lil Nas X", "2:24")
playlist_predeterminada.agregar_cancion("Yo Viviré - Celia Cruz", "4:31")
playlist_predeterminada.agregar_cancion("Jump - Van Halen", "4:02")
playlist_predeterminada.agregar_cancion("Nothing's Gonna Stop Us Now - Starship", "4:30")
playlist_predeterminada.agregar_cancion("Livin' On a Prayer - Bon Jovi", "4:09")
playlist_predeterminada.agregar_cancion("Under The Influence - Chris Brown", "3:05")
playlist_predeterminada.agregar_cancion("Flowers - Miley Cyrus", "3:20")
playlist_predeterminada.agregar_cancion("CUFF IT - Beyoncé", "3:45")
playlist_predeterminada.agregar_cancion("I Ain't Worried - OneRepublic", "2:28")
playlist_predeterminada.agregar_cancion("Live Is Life - Opus", "4:15")
playlist_predeterminada.agregar_cancion("Another Love - Tom Odell", "4:04")
playlist_predeterminada.agregar_cancion("Venite Volando - Los Iracundos", "2:36")
playlist_predeterminada.agregar_cancion("Just Us - James Arthur", "3:35")
playlist_predeterminada.agregar_cancion("Rasputin - Boney M.", "3:41")
playlist_predeterminada.agregar_cancion("Born In The U.S.A - Bruce Springsteen", "4:39")
playlist_predeterminada.agregar_cancion("Eye Of The Tiger - Survivor", "4:04")
playlist_predeterminada.agregar_cancion("Thank You For The Music - ABBA", "3:49")
