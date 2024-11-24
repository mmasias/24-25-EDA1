# Implementación del Árbol de Versiones

implementación de un sistema de control de versiones utilizando un árbol de versiones. La estructura principal está compuesta por las clases `Arbol`, `NodoVersion` y `Estado`.

## Diagrama UML

![Diagrama UML](/24-25-EDA1/entregas/saucedoIan/reto-005/control%20de%20versiones%20arbol.png)

## Descripción de Clases

### Clase `Arbol`

La clase `Arbol` representa la estructura principal del árbol de versiones. Contiene los siguientes métodos:

- **`crearRama(nodoPadre : NodoVersion, comentario : String) : NodoVersion`**: Crea una nueva rama desde el `nodoPadre` y la inserta en el atributo `izquierda` con el comentario especificado. Si `izquierda` ya está ocupado, no realiza la operación.
- **`insertarEnRama(nodoPadre : NodoVersion, nuevaVersion : NodoVersion, comentario : String)`**: Agrega una nueva versión en la misma rama del `nodoPadre`, conectándola al atributo `derecha`. Si `derecha` ya está ocupado, encuentra el último nodo disponible en la rama.
- **`saltarARama(nodo : NodoVersion) : NodoVersion`**: Devuelve el nodo conectado al atributo `izquierda`. Si no existe una rama, retorna `NULL`.
- **`saltarAVersion(nodo : NodoVersion) : NodoVersion`**: Devuelve el nodo conectado al atributo `derecha`. Si no existe una versión siguiente, retorna `NULL`.
- **`visualizarArbol() : String`**: Genera una representación textual del árbol, mostrando las versiones y sus relaciones (izquierda para ramas, derecha para versiones en la rama).

### Clase `NodoVersion`

La clase `NodoVersion` representa cada nodo del árbol de versiones. Contiene los siguientes atributos y métodos:

- **Atributos**:

  - `id`: Identificador único de la versión.
  - `estado`: Estado asociado a esta versión.
  - `comentario`: Comentario asociado a esta versión.
  - `izquierda`: Apunta a una rama derivada. `NULL` si no existe una rama creada desde este nodo.
  - `derecha`: Apunta a la siguiente versión en la misma rama. `NULL` si no existe una versión posterior.

- **Métodos**:
  - **`agregarComentario(comentario : String)`**: Asocia un comentario a esta versión.
  - **`compararEstado(estado : Estado) : Boolean`**: Compara el estado actual del nodo con otro estado. Retorna `TRUE` si son diferentes.

### Clase `Estado`

La clase `Estado` representa el estado de una versión. Contiene los siguientes atributos y métodos:

- **Atributos**:

  - `cantidadArchivos`: Número total de archivos en el estado.
  - `pesoTotal`: Peso total de los archivos en el estado.

- **Métodos**:
  - **`comparar(otroEstado : Estado) : Boolean`**: Compara este estado con otro. Retorna `TRUE` si `cantidadArchivos` o `pesoTotal` son diferentes.

## Relaciones

- La clase `Arbol` tiene una relación de composición con `NodoVersion`, donde `NodoVersion` es la raíz del árbol.
- Cada `NodoVersion` tiene una relación de agregación con `Estado`.
- Cada `NodoVersion` puede tener una relación con otro `NodoVersion` a través de los atributos `izquierda` y `derecha`.

Esta implementación permite gestionar versiones y ramas de manera eficiente, facilitando la comparación de estados y la navegación entre diferentes versiones y ramas del árbol.
