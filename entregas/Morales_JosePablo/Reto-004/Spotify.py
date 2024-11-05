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

    def __str__(self):
        return f"{self.nombre} - {self.artista} (Duración total: {self.duracion_total})"

class NodoCola:
    def __init__(self, cancion):
        self.cancion = cancion
        self.siguiente = None

class ColaReproduccion:
    def __init__(self):
        self.frente = None
        self.final = None

    def encolar(self, cancion):
        nuevo_nodo = NodoCola(cancion)
        if not self.frente:
            self.frente = nuevo_nodo
            self.final = nuevo_nodo
        else:
            self.final.siguiente = nuevo_nodo
            self.final = nuevo_nodo

    def desencolar(self):
        if not self.frente:
            return None
        cancion = self.frente.cancion
        self.frente = self.frente.siguiente
        if not self.frente:
            self.final = None
        return cancion

    def esta_vacia(self):
        return self.frente is None

class NodoPila:
    def __init__(self, cancion):
        self.cancion = cancion
        self.siguiente = None

class PilaHistorial:
    def __init__(self):
        self.tope = None

    def apilar(self, cancion):
        nuevo_nodo = NodoPila(cancion)
        nuevo_nodo.siguiente = self.tope
        self.tope = nuevo_nodo
          
    def desapilar(self):
        if not self.tope:
            return None
        cancion = self.tope.cancion
        self.tope = self.tope.siguiente
        return cancion

    def esta_vacia(self):
        return self.tope is None

    def mostrar_historial(self):
        actual = self.tope
        print("Historial de reproducción:")
        while actual:
            print(actual.cancion)
            actual = actual.siguiente

class SistemaReproduccionMusica:
    def __init__(self):
        self.playlists = []
        self.cola_reproduccion = ColaReproduccion()
        self.historial_reproduccion = PilaHistorial()
        self.repetir_playlist = False
        self.repetir_cancion = False
        self.favoritos = []

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

    def reproducir_playlist(self, indice, aleatorio=False):
        playlist = self.seleccionar_playlist(indice)
        if playlist:
            canciones_a_reproducir = []
            actual = playlist.canciones
            while actual:
                canciones_a_reproducir.append(actual)
                actual = actual.siguiente
            if aleatorio:
                import random
                random.shuffle(canciones_a_reproducir)
            for cancion in canciones_a_reproducir:
                self.cola_reproduccion.encolar(cancion)
            while not self.cola_reproduccion.esta_vacia():
                cancion_actual = self.cola_reproduccion.desencolar()
                print(f"Reproduciendo: {cancion_actual}")
                self.historial_reproduccion.apilar(cancion_actual)
                if self.repetir_cancion:
                    self.cola_reproduccion.encolar(cancion_actual)
                if self.repetir_playlist and self.cola_reproduccion.esta_vacia():
                    for cancion in canciones_a_reproducir:
                        self.cola_reproduccion.encolar(cancion)

    def agregar_favorito(self, cancion):
        if cancion not in self.favoritos:
            self.favoritos.append(cancion)
            print(f"Canción '{cancion}' añadida a favoritos.")
        else:
            print("La canción ya está en favoritos.")

    def eliminar_favorito(self, cancion):
        if cancion in self.favoritos:
            self.favoritos.remove(cancion)
            print(f"Canción '{cancion}' eliminada de favoritos.")
        else:
            print("La canción no está en favoritos.")

    def ver_favoritos(self):
        print("Canciones favoritas:")
        for cancion in self.favoritos:
            print(cancion)

    def iniciar(self):
        while True:
            print("\nOpciones del sistema de reproducción:")
            print("1. Mostrar playlists")
            print("2. Ver favoritos")
            print("3. Ver historial de reproducción")
            print("4. Activar/desactivar repetición de playlist")
            print("5. Activar/desactivar repetición de canción")
            print("6. Reproducción aleatoria")
            print("q. Salir")
            seleccion = input("Elige una opción: ")

            if seleccion == '1':
                self.mostrar_playlists()
                try:
                    indice = int(input("Selecciona el número de la playlist para reproducir: ")) - 1
                    playlist = self.seleccionar_playlist(indice)
                    if playlist:
                        print(f"\nCanciones en la playlist '{playlist.nombre}':")
                        playlist.mostrar_canciones()
                        accion = input("¿Quieres reproducir (r), buscar (b), eliminar (e) o marcar como favorito (f)? (Enter para volver): ").lower()
                        if accion == 'r':
                            self.reproducir_playlist(indice)
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
                        elif accion == 'f':
                            titulo = input("Ingresa el título de la canción que deseas marcar como favorito: ")
                            cancion = playlist.buscar_cancion(titulo)
                            if cancion:
                                self.agregar_favorito(cancion)
                            else:
                                print("Canción no encontrada.")
                except ValueError:
                    print("Por favor, ingresa un número válido.")

            elif seleccion == '2':
                self.ver_favoritos()

            elif seleccion == '3':
                self.historial_reproduccion.mostrar_historial()

            elif seleccion == '4':
                self.repetir_playlist = not self.repetir_playlist
                estado = "activada" if self.repetir_playlist else "desactivada

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

sistema = SistemaReproduccionMusica()
sistema.agregar_playlist(playlist_predeterminada)
