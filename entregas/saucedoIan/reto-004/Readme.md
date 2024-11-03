![Diagrama de Clases](path/to/your/diagram.png)

# Reto 004 - Sistema de Gestión de Música

## Clases y Métodos

### Sistema

- **Sistema(String nombreUsuario)**: Constructor que inicializa el sistema con un usuario.
- **void verPlaylists()**: Muestra las playlists del usuario.
- **void activarAleatorio()**: Activa o desactiva el modo aleatorio.
- **void activarRepeticion()**: Activa o desactiva el modo repetición.
- **void verHistorial()**: Muestra el historial de reproducción.
- **void añadirCancion(Cancion cancion)**: Añade una canción a la lista de canciones.
- **void verCancionActual()**: Muestra la canción actual en reproducción.
- **void reproducirSiguiente()**: Reproduce la siguiente canción en la lista.
- **void añadirCancionAFavoritos(Cancion cancion)**: Añade una canción a la lista de favoritas.
- **void eliminarCancionDeFavoritos(Cancion cancion)**: Elimina una canción de la lista de favoritas.
- **void verCancionesFavoritas()**: Muestra las canciones favoritas del usuario.
- **void añadirPlaylist(Playlist playlist)**: Añade una playlist a la lista de playlists.
- **void eliminarCancionDePlaylist(String nombrePlaylist, Cancion cancion)**: Elimina una canción de una playlist específica.
- **void verCancionesDePlaylist(String nombrePlaylist)**: Muestra las canciones de una playlist específica.
- **Cacion buscarCancion(String titulo)**: Busca una canción por título.
- **void reproducirFavoritos()**: Reproduce las canciones favoritas del usuario.
- **void reproducirPlaylist(String nombrePlaylist)**: Reproduce las canciones de una playlist específica.

### Usuario

- **Usuario(String nombre)**: Constructor que inicializa el usuario con un nombre.
- **String getNombre()**: Devuelve el nombre del usuario.
- **NodoDoble getCancionesFavoritas()**: Devuelve la lista de canciones favoritas.
- **NodoPlaylist getPlaylists()**: Devuelve la lista de playlists.
- **void añadirCancionAFavoritos(Cancion cancion)**: Añade una canción a la lista de favoritas.
- **void eliminarCancionDeFavoritos(Cancion cancion)**: Elimina una canción de la lista de favoritas.
- **void verCancionesFavoritas()**: Muestra las canciones favoritas del usuario.
- **void añadirPlaylist(Playlist playlist)**: Añade una playlist a la lista de playlists.
- **void eliminarCancionDePlaylist(String nombrePlaylist, Cancion cancion)**: Elimina una canción de una playlist específica.
- **void verPlaylists()**: Muestra las playlists del usuario.
- **void verCancionesDePlaylist(String nombrePlaylist)**: Muestra las canciones de una playlist específica.

### NodoDoble

- **NodoDoble(Cancion cancion)**: Constructor que inicializa el nodo con una canción.

### NodoPlaylist

- **NodoPlaylist(Playlist playlist)**: Constructor que inicializa el nodo con una playlist.

### Cancion

- **Cancion(String nombre)**: Constructor que inicializa la canción con un nombre.
- **String getNombre()**: Devuelve el nombre de la canción.
- **boolean isFavorita()**: Devuelve si la canción es favorita.
- **void setFavorita(boolean favorita)**: Establece si la canción es favorita.

### Playlist

- **Playlist(String nombre)**: Constructor que inicializa la playlist con un nombre.
- **String getNombre()**: Devuelve el nombre de la playlist.
- **ListaDobleCancion getCanciones()**: Devuelve la lista de canciones de la playlist.
- **void añadirCancion(Cancion cancion)**: Añade una canción a la playlist.
- **void eliminarCancion(Cancion cancion)**: Elimina una canción de la playlist.
- **void verCanciones()**: Muestra las canciones de la playlist.

---

> **Authors**: Ian Saucedo y Jose Pablo Morales
