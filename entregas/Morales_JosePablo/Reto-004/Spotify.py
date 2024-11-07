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

class NodoCola:
    def __init__(self, cancion):
        self.cancion = cancion
        self.siguiente = None

class ColaReproduccion:
    def __init__(self):
        self.frente = None
        self.final = None
        self.cancion_actual = None

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

    def siguiente_cancion(self):
        self.cancion_actual = self.desencolar()
        return self.cancion_actual

    def esta_vacia(self):
        return self.frente is None

    def ver_cancion_actual(self):
        return self.cancion_actual

    def mostrar_cola(self):
        actual = self.frente
        print("Cola de reproducción:")
        while actual:
            print(actual.cancion)
            actual = actual.siguiente

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
        self.modo_aleatorio = False

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
            actual = playlist.canciones
            while actual:
                self.cola_reproduccion.encolar(actual)
                actual = actual.siguiente
            self.reproducir_siguiente()

    def reproducir_siguiente(self):
        cancion = self.cola_reproduccion.siguiente_cancion()
        if cancion:
            print(f"Reproduciendo: {cancion}")
            self.historial_reproduccion.apilar(cancion)

    def ver_cancion_actual(self):
        cancion = self.cola_reproduccion.ver_cancion_actual()
        if cancion:
            print(f"Reproduciendo actualmente: {cancion}")
        else:
            print("No hay canción en reproducción.")

    def ver_cola_reproduccion(self):
        self.cola_reproduccion.mostrar_cola()

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
            print("2. Ver canción actual")
            print("3. Reproducir siguiente canción")
            print("4. Ver cola de reproducción")
            print("5. Ver favoritos")
            print("6. Salir")
            seleccion = input("Elige una opción: ")

            if seleccion == '1':
                self.mostrar_playlists()
                try:
                    indice = int(input("Selecciona el número de la playlist para reproducir: ")) - 1
                    self.reproducir_playlist(indice)
                except ValueError:
                    print("Por favor, ingresa un número válido.")
                    
            elif seleccion == '2':
                self.ver_cancion_actual()
            elif seleccion == '3':
                self.reproducir_siguiente()
            elif seleccion == '4':
                self.ver_cola_reproduccion()
            elif seleccion == '5':
                self.ver_favoritos()
            elif seleccion.lower() == 'q':
                print("Saliendo del sistema de reproducción de música.")
                break
            else:
                print("Opción no válida, intenta de nuevo.")

def mostrar_menu_principal():
    print("\n=== MENÚ PRINCIPAL ===")
    print("1. Reproducción")
    print("2. Biblioteca")
    print("3. Salir")
    return int(input("Seleccione una opción: "))

def mostrar_menu_reproduccion():
    print("\n=== MENÚ REPRODUCCIÓN ===")
    print("1. Ver canción actual")
    print("2. Reproducir siguiente")
    print("3. Reproducir anterior")
    print("4. Ver cola de reproducción")
    print("5. Ver historial de reproducción")
    print("6. Activar/desactivar aleatorio")
    print("7. Activar/desactivar repetición")
    print("8. Volver al menú principal")
    return int(input("Seleccione una opción: "))

def mostrar_menu_biblioteca():
    print("\n=== MENÚ BIBLIOTECA ===")
    print("1. Añadir canción a favoritos")
    print("2. Eliminar canción de favoritos")
    print("3. Ver canciones favoritas")
    print("4. Crear nueva playlist")
    print("5. Añadir canción a playlist")
    print("6. Eliminar canción de playlist")
    print("7. Ver playlists")
    print("8. Ver canciones de una playlist")
    print("9. Volver al menú principal")
    return int(input("Seleccione una opción: "))

def ejecutar_menu_principal():
    while True:
        opcion = mostrar_menu_principal()
        
        if opcion == 1:
            ejecutar_menu_reproduccion()
        elif opcion == 2:
            ejecutar_menu_biblioteca()
        elif opcion == 3:
            print("Saliendo del sistema...")
            break
        else:
            print("Opción no válida. Intente nuevamente.")

def ejecutar_menu_reproduccion():
    while True:
        opcion = mostrar_menu_reproduccion()
        
        if opcion == 1:
            if player.cancion_actual:
                print(f"▶ Reproduciendo: {player.cancion_actual}")
            else:
                iniciar_reproduccion()
        
        elif opcion == 2:
            player.siguiente_cancion()
            print(f"▶ Reproduciendo siguiente: {player.cancion_actual}")
        
        elif opcion == 3:
            player.cancion_anterior()
            print(f"▶ Reproduciendo anterior: {player.cancion_actual}")
        
        elif opcion == 4:
            print("COLA DE REPRODUCCIÓN:")
            player.mostrar_cola()
        
        elif opcion == 5:
            print("HISTORIAL DE REPRODUCCIÓN:")
            player.mostrar_historial()
        
        elif opcion == 6:
            player.toggle_shuffle()
            estado = "ON" if player.shuffle else "OFF"
            print(f"Modo aleatorio: {estado}")
        
        elif opcion == 7:
            player.toggle_repeat()
            estado = "ON" if player.repeat else "OFF"
            print(f"Modo repetición: {estado}")
        
        elif opcion == 8:
            break
        else:
            print("Opción no válida. Intente nuevamente.")

def iniciar_reproduccion():
    respuesta = input("No hay canción en reproducción. ¿Desea comenzar a reproducir? (S/N): ")
    if respuesta.upper() == 'S':
        player.iniciar_reproduccion()

def ejecutar_menu_biblioteca():
    while True:
        opcion = mostrar_menu_biblioteca()
        
        if opcion == 1:
            player.agregar_favorito()
        
        elif opcion == 2:
            player.eliminar_favorito()
        
        elif opcion == 3:
            player.mostrar_favoritos()
        
        elif opcion == 4:
            nombre = input("Nombre de la nueva playlist: ")
            biblioteca.crear_playlist(nombre)
        
        elif opcion == 5:
            biblioteca.agregar_cancion_a_playlist()
        
        elif opcion == 6:
            biblioteca.eliminar_cancion_de_playlist()
        
        elif opcion == 7:
            biblioteca.mostrar_playlists()
        
        elif opcion == 8:
            biblioteca.ver_canciones_playlist()
        
        elif opcion == 9:
            break
        else:
            print("Opción no válida. Intente nuevamente.")

ejecutar_menu_principal()

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
