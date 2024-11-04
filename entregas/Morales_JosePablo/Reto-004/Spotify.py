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
playlist_sinatra.agregar_cancion("Come Fly With Me", "3:14")
playlist_sinatra.agregar_cancion("My Way", "4:36")
playlist_sinatra.agregar_cancion("(Theme From) New York, New York", "3:25")
playlist_sinatra.agregar_cancion("Chicago", "2:14")
playlist_sinatra.agregar_cancion("Strangers In The Night", "2:38")
playlist_sinatra.agregar_cancion("Moonlight In Vermont", "3:32")
playlist_sinatra.agregar_cancion("Somethin' Stupid", "2:42")
playlist_sinatra.agregar_cancion("The World We Knew (Over and Over)", "2:47")
playlist_sinatra.agregar_cancion("I've Got You Under My Skin", "3:42")
playlist_sinatra.agregar_cancion("The Girl From Ipanema", "3:14")
playlist_sinatra.agregar_cancion("I've Got A Crush On You", "2:17")
playlist_sinatra.agregar_cancion("The Way You Look Tonight", "3:22")
playlist_sinatra.agregar_cancion("Come Dance With Me", "2:31")
playlist_sinatra.agregar_cancion("My Way Of Life", "3:07")
playlist_sinatra.agregar_cancion("Oh! Look At Me Now", "2:50")
playlist_sinatra.agregar_cancion("Young At Heart", "2:49")
playlist_sinatra.agregar_cancion("You’re Getting to Be a Habit With Me", "2:19")
playlist_sinatra.agregar_cancion("Put Your Dreams Away", "3:12")
playlist_sinatra.agregar_cancion("Someone To Watch Over Me", "3:18")
playlist_sinatra.agregar_cancion("It Had To Be You", "3:54")
playlist_sinatra.agregar_cancion("Call Me Irresponsible", "2:56")
playlist_sinatra.agregar_cancion("For Once In My Life", "2:51")
playlist_sinatra.agregar_cancion("I'll Be Seeing You", "2:50")
playlist_sinatra.agregar_cancion("September In The Rain", "2:59")
playlist_sinatra.agregar_cancion("You Make Me Feel So Young", "2:57")
playlist_sinatra.agregar_cancion("Moon River", "3:19")
playlist_sinatra.agregar_cancion("Blue Moon", "2:51")
playlist_sinatra.agregar_cancion("My Kind Of Town", "3:08")

playlist_lost_rhythm = Playlist("Lost in the Rhythm", "Varios")
playlist_lost_rhythm.duracion_total = "1 hora y 41 minutos"

playlist_lost_rhythm.agregar_cancion("As It Was - Harry Styles", "2:47")
playlist_lost_rhythm.agregar_cancion("Flowers - Miley Cyrus", "3:20")
playlist_lost_rhythm.agregar_cancion("SNAP - Rosa Linn", "3:00")
playlist_lost_rhythm.agregar_cancion("THAT'S WHAT I WANT - Lil Nas X", "2:24")
playlist_lost_rhythm.agregar_cancion("Heat Waves - Glass Animals", "3:59")
playlist_lost_rhythm.agregar_cancion("STAY (with Justin Bieber) - The Kid LAROI, Justin Bieber", "2:22")
playlist_lost_rhythm.agregar_cancion("Kill Bill - SZA", "2:34")
playlist_lost_rhythm.agregar_cancion("Another Love - Tom Odell", "4:04")
playlist_lost_rhythm.agregar_cancion("Chandelier - Sia", "3:36")
playlist_lost_rhythm.agregar_cancion("Bam Bam (feat. Ed Sheeran) - Camila Cabello, Ed Sheeran", "3:26")
playlist_lost_rhythm.agregar_cancion("Watermelon Sugar - Harry Styles", "2:54")
playlist_lost_rhythm.agregar_cancion("Just Us - James Arthur", "3:35")
playlist_lost_rhythm.agregar_cancion("Kiss Me More (feat. SZA) - Doja Cat, SZA", "3:29")
playlist_lost_rhythm.agregar_cancion("Something Just Like This - The Chainsmokers, Coldplay", "4:08")
playlist_lost_rhythm.agregar_cancion("One Kiss (with Dua Lipa) - Calvin Harris, Dua Lipa", "3:35")
playlist_lost_rhythm.agregar_cancion("Firestone - Kygo, Conrad Sewell", "4:32")
playlist_lost_rhythm.agregar_cancion("Faded - Alan Walker", "3:33")
playlist_lost_rhythm.agregar_cancion("Under The Influence - Chris Brown", "3:05")
playlist_lost_rhythm.agregar_cancion("CUFF IT - Beyoncé", "3:45")
playlist_lost_rhythm.agregar_cancion("Water - Tyla", "3:20")
playlist_lost_rhythm.agregar_cancion("Sure Thing - Miguel", "3:15")
playlist_lost_rhythm.agregar_cancion("Wake Me Up - Avicii", "4:07")
playlist_lost_rhythm.agregar_cancion("Sweater Weather - The Neighbourhood", "4:00")
playlist_lost_rhythm.agregar_cancion("Angels Like You - Miley Cyrus", "3:16")
playlist_lost_rhythm.agregar_cancion("Used To Be Young - Miley Cyrus", "3:11")
playlist_lost_rhythm.agregar_cancion("Stronger - The Score", "3:11")
playlist_lost_rhythm.agregar_cancion("The Fear - The Score", "3:04")
playlist_lost_rhythm.agregar_cancion("Escapism. - RAYE, 070 Shake", "4:32")
playlist_lost_rhythm.agregar_cancion("I Ain't Worried - OneRepublic", "2:28")
playlist_lost_rhythm.agregar_cancion("Like a Prayer - Madonna", "5:43")

playlist_un_poco_de_todo = Playlist("Un Poco de Todo", "Varios")
playlist_un_poco_de_todo.duracion_total = "2 horas y 16 minutos"

playlist_un_poco_de_todo.agregar_cancion("Nunca es Suficiente - Los Angeles Azules, Natalia Lafourcade", "4:26")
playlist_un_poco_de_todo.agregar_cancion("17 Años - Los Angeles Azules", "3:01")
playlist_un_poco_de_todo.agregar_cancion("La Vida Es Un Carnaval - Celia Cruz", "4:39")
playlist_un_poco_de_todo.agregar_cancion("Celia’s Oye Cómo Va (Oye cómo va) - Celia Cruz", "4:18")
playlist_un_poco_de_todo.agregar_cancion("Yo Viviré - Celia Cruz", "4:31")
playlist_un_poco_de_todo.agregar_cancion("De Música Ligera - Soda Stereo", "3:33")
playlist_un_poco_de_todo.agregar_cancion("Cuando Seas Grande - Miguel Mateos - Zas", "4:26")
playlist_un_poco_de_todo.agregar_cancion("En Algún Lugar - Ducan Dhu", "3:56")
playlist_un_poco_de_todo.agregar_cancion("Mi Primer Millón - Bacilos", "3:57")
playlist_un_poco_de_todo.agregar_cancion("Caraluna - Bacilos", "4:26")
playlist_un_poco_de_todo.agregar_cancion("La Cosa Mas Bella - Eros Ramazzotti", "4:26")
playlist_un_poco_de_todo.agregar_cancion("Pepas - Farruko", "4:47")
playlist_un_poco_de_todo.agregar_cancion("La Flaca - Jarabe de Palo", "4:21")
playlist_un_poco_de_todo.agregar_cancion("El Ataque de las chicas cocodrilo - Hombres G", "3:04")
playlist_un_poco_de_todo.agregar_cancion("Devuélveme a mi chica - Hombres G", "3:14")
playlist_un_poco_de_todo.agregar_cancion("Te Quiero - Hombres G", "3:45")
playlist_un_poco_de_todo.agregar_cancion("Voy a pasármelo bien - Hombres G", "3:55")
playlist_un_poco_de_todo.agregar_cancion("Venezia - Hombres G", "4:30")
playlist_un_poco_de_todo.agregar_cancion("Como camarón - Estopa", "3:28")
playlist_un_poco_de_todo.agregar_cancion("I Love Rock 'N Roll - Joan Jett & the Blackhearts", "2:55")
playlist_un_poco_de_todo.agregar_cancion("Carry on Wayward Son - Kansas", "5:23")
playlist_un_poco_de_todo.agregar_cancion("Danger Zone - Kenny Loggins", "3:36")
playlist_un_poco_de_todo.agregar_cancion("Sweet Home Alabama - Lynyrd Skynyrd", "4:43")
playlist_un_poco_de_todo.agregar_cancion("They Don't Care About Us - Michael Jackson", "4:45")
playlist_un_poco_de_todo.agregar_cancion("Beat It - Michael Jackson", "4:18")
playlist_un_poco_de_todo.agregar_cancion("Live Is Life - Opus", "4:15")
playlist_un_poco_de_todo.agregar_cancion("Radio Ga Ga - Queen", "5:48")
playlist_un_poco_de_todo.agregar_cancion("Another One Bites The Dust - Queen", "3:35")
playlist_un_poco_de_todo.agregar_cancion("Bohemian Rhapsody - Queen", "5:55")
playlist_un_poco_de_todo.agregar_cancion("Crazy Little Thing Called Love - Queen", "2:43")
playlist_un_poco_de_todo.agregar_cancion("Somebody To Love - Queen", "4:56")
playlist_un_poco_de_todo.agregar_cancion("Fat Bottomed Girls - Queen", "4:16")
playlist_un_poco_de_todo.agregar_cancion("We Built This City - Starship", "4:56")
playlist_un_poco_de_todo.agregar_cancion("Nothing's Gonna Stop Us Now - Starship", "4:30")
playlist_un_poco_de_todo.agregar_cancion("Eye Of The Tiger - Survivor", "4:04")
playlist_un_poco_de_todo.agregar_cancion("Karma Chameleon - Culture Club", "4:12")
playlist_un_poco_de_todo.agregar_cancion("Dreams - Van Halen", "4:54")
playlist_un_poco_de_todo.agregar_cancion("Jump - Van Halen", "4:02")
playlist_un_poco_de_todo.agregar_cancion("Africa - TOTO", "4:56")
playlist_un_poco_de_todo.agregar_cancion("Rasputin - Boney M.", "3:41")
playlist_un_poco_de_todo.agregar_cancion("Runaway - Bon Jovi", "3:51")
playlist_un_poco_de_todo.agregar_cancion("It's My Life - Bon Jovi", "3:44")
playlist_un_poco_de_todo.agregar_cancion("You Give Love a Bad Name - Bon Jovi", "3:43")
playlist_un_poco_de_todo.agregar_cancion("Livin' On a Prayer - Bon Jovi", "4:09")
playlist_un_poco_de_todo.agregar_cancion("Born In The U.S.A - Bruce Springsteen", "4:39")
playlist_un_poco_de_todo.agregar_cancion("Dancing In The Dark - Bruce Springsteen", "4:01")
playlist_un_poco_de_todo.agregar_cancion("Venite Volando - Los Iracundos", "2:36")
playlist_un_poco_de_todo.agregar_cancion("Alto al Fuego - Alux Nahual", "3:37")
playlist_un_poco_de_todo.agregar_cancion("Como un Duende - Alux Nahual", "4:36")
playlist_un_poco_de_todo.agregar_cancion("Thank You For The Music - ABBA", "3:49")

sistema = SistemaReproduccionMusica()
sistema.agregar_playlist(playlist_sabaton)
sistema.agregar_playlist(playlist_sinatra)
sistema.agregar_playlist(playlist_lost_in_the_rhythm)
sistema.agregar_playlist(un_poco_de_todo)
