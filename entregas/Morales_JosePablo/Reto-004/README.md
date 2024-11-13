### Clase `Cancion`
Esta clase representa una canción individual en la playlist.
- **Atributos**:
  - `titulo`: el título de la canción.
  - `duracion`: la duración de la canción.
  - `siguiente`: referencia a la siguiente canción en la lista enlazada de canciones.
- **Métodos**:
  - `__str__`: método de representación en texto de la canción, que muestra el título y la duración.

### Clase `Playlist`
Esta clase gestiona una lista de canciones usando una lista enlazada.
- **Atributos**:
  - `nombre`: nombre de la playlist.
  - `artista`: artista o descripción general de la playlist.
  - `canciones`: referencia a la primera canción de la lista enlazada.
- **Métodos**:
  - `agregar_cancion`: añade una nueva canción al final de la playlist.
  - `mostrar_canciones`: imprime todas las canciones en la playlist.
  - `buscar_cancion`: busca una canción en la playlist por título.
  - `eliminar_cancion`: elimina una canción de la playlist por título.

### Clase `NodoCola`
Esta clase representa un nodo en la cola de reproducción.
- **Atributos**:
  - `cancion`: contiene la canción a reproducir.
  - `siguiente`: referencia al siguiente nodo en la cola.

### Clase `ColaReproduccion`
Administra la cola de reproducción, que es una estructura de datos FIFO.
- **Atributos**:
  - `frente`: el primer nodo de la cola.
  - `final`: el último nodo de la cola.
  - `cancion_actual`: la canción que se está reproduciendo actualmente.
- **Métodos**:
  - `encolar`: añade una canción a la cola.
  - `desencolar`: elimina y retorna la canción al frente de la cola.
  - `siguiente_cancion`: reproduce la siguiente canción en la cola.
  - `esta_vacia`: verifica si la cola está vacía.
  - `ver_cancion_actual`: muestra la canción actual en reproducción.
  - `mostrar_cola`: imprime todas las canciones en la cola.

### Clase `NodoPila`
Representa un nodo en la pila de historial.
- **Atributos**:
  - `cancion`: la canción reproducida.
  - `siguiente`: referencia al siguiente nodo en la pila.

### Clase `PilaHistorial`
Administra el historial de reproducción con una estructura de datos tipo pila (LIFO).
- **Atributos**:
  - `tope`: referencia al último nodo añadido en la pila.
- **Métodos**:
  - `apilar`: añade una canción al historial.
  - `desapilar`: elimina y retorna la última canción del historial.
  - `mostrar_historial`: imprime todas las canciones en el historial.

### Clase `SistemaReproduccionMusica`
Esta clase principal contiene las funcionalidades del sistema de reproducción.
- **Atributos**:
  - `playlists`: lista de playlists en el sistema.
  - `cola_reproduccion`: instancia de `ColaReproduccion`.
  - `historial_reproduccion`: instancia de `PilaHistorial`.
  - `repetir_playlist`, `repetir_cancion`: opciones de repetición de playlist y canción.
  - `favoritos`: lista de canciones favoritas.
  - `modo_aleatorio`: modo de reproducción aleatoria.
- **Métodos**:
  - `agregar_playlist`: añade una playlist al sistema.
  - `crear_playlist`: permite al usuario crear una nueva playlist.
  - `eliminar_playlist`: permite eliminar una playlist seleccionada.
  - `buscar_cancion`: busca una canción en todas las playlists.
  - `agregar_cancion_a_playlist`: permite al usuario añadir una canción a una playlist específica.
  - `mostrar_playlists`: muestra todas las playlists en el sistema.
  - `seleccionar_playlist`: selecciona una playlist por índice.
  - `reproducir_playlist`: añade todas las canciones de una playlist a la cola de reproducción y comienza a reproducir.
  - `reproducir_siguiente`: reproduce la siguiente canción en la cola.
  - `ver_cancion_actual`: muestra la canción actual en reproducción.
  - `ver_cola_reproduccion`: muestra todas las canciones en la cola.
  - `agregar_favorito`: añade una canción a favoritos.
  - `eliminar_favorito`: elimina una canción de favoritos.
  - `ver_favoritos`: muestra las canciones en favoritos.
  - `iniciar`: ciclo principal que muestra el menú de opciones y permite al usuario interactuar con el sistema.

### Ejecución del sistema
1. Se crea una instancia de `SistemaReproduccionMusica`.
2. Se define una playlist predeterminada con varias canciones.
3. Se inicia el sistema, lo que permite al usuario interactuar con el sistema de reproducción a través del menú en consola.
