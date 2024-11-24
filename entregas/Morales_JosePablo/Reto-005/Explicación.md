### Explicación de las Clases

1. **Archivo**:
   - Representa un archivo dentro del sistema.
   - Tiene un `nombre`, `contenido`, `fechaCreacion` y `fechaModificacion`.
   - Con `obtenerHistorial()`, se pueden ver todas las versiones pasadas del archivo.

2. **Directorio**:
   - Representa un directorio que puede contener archivos y otros directorios.
   - Tiene una lista de `archivos` y otra de `subdirectorios`.
   - Los métodos permiten agregar, eliminar y obtener archivos dentro del directorio.

3. **VersionArchivo**:
   - Guarda una versión específica de un archivo, con el `contenido` y la `fecha` en que se guardó.

4. **Commit**:
   - Es una captura del estado de los archivos en un momento específico.
   - Contiene un `mensaje`, la `fecha` del commit y un `archivosGuardados`, que es un mapa de archivos con sus versiones.
   - `mostrarArchivos()` permite listar los archivos guardados en ese commit.

5. **Rama**:
   - Representa una rama del control de versiones.
   - Tiene una lista de `commits` y métodos para crear y cambiar commits en esa rama.

6. **ControlVersiones**:
   - Es la clase principal que gestiona las ramas y el historial de versiones.
   - Tiene la `ramaActual` y una lista de `ramas`.
   - Se pueden crear nuevas ramas, cambiar entre ellas y ver el historial de los commits.

### Relaciones

- `Archivo` guarda varias `VersionArchivo`, ya que un archivo puede tener múltiples versiones.
- `Directorio` contiene múltiples `Archivo` y también otros `Directorio`, permitiendo una estructura jerárquica.
- `Commit` incluye varias `VersionArchivo` para registrar el estado de los archivos en ese momento.
- `Rama` contiene una lista de `Commit`, representando el historial de la rama.
- `ControlVersiones` maneja múltiples `Rama` y siempre tiene una `ramaActual` la cual es la rama en la que estoy en ese momento.