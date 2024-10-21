# Documentar Código del Reto-003

## Código de <a href="https://github.com/xImRaul/24-25-EDA1/tree/965ceae1c047f9c9ec4f59307fd5263cb2e398fc/entregas/garciaRaul/Reto-003">Raúl garcía Roldán</a>

# Documentación

## Clase CompresorLZ

#### Constructor `CompresorLZ()`
- **Descripción:** Constructor que inicializa el diccionario de tamaño fijo y un contador para seguir cuántas secuencias se han agregado al diccionario.
- **Variables inicializadas:**
  - `diccionario`: Arreglo de cadenas de tamaño 100.
  - `contadorDiccionario`: Contador de elementos en el diccionario, inicializado en 0.

---

#### Método Público `comprime(String cadena)`
- **Descripción:** Método que realiza la compresión de la cadena de entrada utilizando el algoritmo Lempel-Ziv (LZ).
- **Parámetros:**
  - `cadena`: Cadena de texto que se desea comprimir.
- **Proceso:**
  1. Recorre la cadena buscando secuencias que ya existen en el diccionario.
  2. Si la secuencia está en el diccionario, recupera el índice correspondiente.
  3. Si no está en el diccionario, agrega la secuencia.
  4. Para cada secuencia, añade una tupla `(índice, carácter)` al resultado de la compresión, donde `índice` es la posición de la secuencia en el diccionario y `carácter` es el último carácter de la secuencia actual.
- **Devuelve:** Una representación comprimida de la cadena como una serie de tuplas `(índice, carácter)`.

---

#### Método Público `mostrarDiccionario()`
- **Descripción:** Método que devuelve el contenido actual del diccionario en formato de texto legible.
- **Parámetros:** No tiene.
- **Devuelve:** Una cadena que representa el diccionario, mostrando el índice de cada entrada seguido por su contenido.

---

#### Método Privado `contieneEnDiccionario(String secuencia)`
- **Descripción:** Método auxiliar que verifica si una secuencia dada ya está presente en el diccionario.
- **Parámetros:**
  - `secuencia`: La secuencia que se busca en el diccionario.
- **Devuelve:** `true` si la secuencia está en el diccionario, `false` en caso contrario.

---

#### Método Privado `indiceDeSecuencia(String secuencia)`
- **Descripción:** Método auxiliar que devuelve el índice de una secuencia en el diccionario.
- **Parámetros:**
  - `secuencia`: La secuencia cuyo índice se desea obtener.
- **Devuelve:** El índice de la secuencia si está en el diccionario, `-1` si no está.

---

#### Método Privado`agregarAlDiccionario(String secuencia)`
- **Descripción:** Método auxiliar que agrega una secuencia nueva al diccionario si aún hay espacio disponible.
- **Parámetros:**
  - `secuencia`: La secuencia que se desea agregar al diccionario.
- **Devuelve:** No tiene valor de retorno. Agrega la secuencia al diccionario y aumenta el contador de elementos.


## Clase Diccionario

### Constructor `Diccionario()`
- **Descripción:** Constructor que inicializa el diccionario con un tamaño fijo de 100 y un contador para seguir cuántas secuencias se han agregado al diccionario.
- **Variables inicializadas:**
  - `secuencias`: Arreglo de cadenas de tamaño 100.
  - `contadorSecuencias`: Contador de elementos en el diccionario, inicializado en 0.

---

#### Método Público `contiene(String secuencia)`
- **Descripción:** Método que verifica si una secuencia dada está presente en el diccionario.
- **Parámetros:**
  - `secuencia`: La secuencia que se busca en el diccionario.
- **Devuelve:** `true` si la secuencia está en el diccionario, `false` en caso contrario.

---

#### Método Público `obtenerIndice(String secuencia)`
- **Descripción:** Método que devuelve el índice de una secuencia en el diccionario.
- **Parámetros:**
  - `secuencia`: La secuencia cuyo índice se desea obtener.
- **Devuelve:** El índice de la secuencia si está en el diccionario, `-1` si no está.

---

#### Método Público `agregar(String secuencia)`
- **Descripción:** Método que agrega una nueva secuencia al diccionario si hay espacio disponible.
- **Parámetros:**
  - `secuencia`: La secuencia que se desea agregar al diccionario.
- **Devuelve:** No tiene valor de retorno. Agrega la secuencia al diccionario y aumenta el contador de elementos.

---

#### Método Público `mostrar()`
- **Descripción:** Método que devuelve el contenido actual del diccionario en un formato legible.
- **Parámetros:** No tiene.
- **Devuelve:** Una cadena que representa el diccionario, mostrando el índice de cada entrada seguido por su contenido.

## Clase Main

#### `public static void main(String[] args)`
- **Descripción:** Método principal que ejecuta la aplicación. Permite al usuario ingresar una cadena de texto para ser comprimida utilizando la clase `CompresorLZ`.
- **Proceso:**
  1. Crea un objeto `Scanner` para la entrada del usuario.
  2. Solicita al usuario que ingrese una cadena a comprimir.
  3. Crea una instancia de la clase `CompresorLZ`.
  4. Llama al método `comprime` de `CompresorLZ` con la cadena ingresada y almacena el resultado.
  5. Imprime el resultado comprimido en la consola.
  6. Muestra el contenido del diccionario utilizado durante la compresión.
  7. Cierra el objeto `Scanner` para liberar los recursos.