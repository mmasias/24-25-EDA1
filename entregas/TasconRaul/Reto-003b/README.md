# Documentación de código reto-003b

## Código de [Martin Lopez de Novales](https://github.com/martinlopez7/24-25-EDA1/blob/858755f8f9f8bef99ef7450f7cd6fb25fa382603/entregas/lopezMartin/reto_003/CompresorLZ.java)

La clase `CompresorLZ` Este algoritmo codifica una cadena de caracteres reemplazando subcadenas repetidas con referencias a su primera aparición.

## Atributos

- `diccionario`: Una lista que guarda las subcadenas encontradas en el proceso de compresión. Esta lista se utiliza para identificar repeticiones y comprimir eficientemente.

### `CompresorLZ()`
Crea una instancia de la clase y inicializa el diccionario como una nueva lista vacía.

## Constructor
El constructor inicializa la lista diccionario, que se utilizará para almacenar las subcadenas que aparecen en el texto a medida que se va comprimiendo [(línea 7)](https://github.com/martinlopez7/24-25-EDA1/blob/858755f8f9f8bef99ef7450f7cd6fb25fa382603/entregas/lopezMartin/reto_003/CompresorLZ.java#L7).

## Métodos

### `String comprime(String cadena)`
Este método comprime la cadena recibida utilizando el algoritmo de compresión LZ [(Linea 10)](https://github.com/martinlopez7/24-25-EDA1/blob/858755f8f9f8bef99ef7450f7cd6fb25fa382603/entregas/lopezMartin/reto_003/CompresorLZ.java#L11). Recorre la cadena buscando secuencias de caracteres que ya existan en el diccionario. Si las encuentra, guarda la referencia a la posición en el diccionario; si no, inserta la nueva secuencia en el diccionario.

- **Parámetros:**
  - `cadena`: La cadena de texto que se desea comprimir.

- **Retorno:**
  - Devuelve una cadena que contiene la versión comprimida en forma de tuplas `(indice, último_caracter)`. Además, al final de la salida, muestra el contenido del diccionario con todas las subcadenas que se han encontrado.

#### Proceso de compresión:
1. Inicializa una variable `compresion` como cadena vacía.
2. Recorre la cadena carácter por carácter.
3. Si encuentra una secuencia ya existente en el diccionario, agrega el índice correspondiente a `compresion`.
4. Si la secuencia no existe en el diccionario, la inserta.
5. El proceso continúa hasta recorrer completamente la cadena.

### `String ultimoChar(String cadena, String caracteresParaAnalizar)`
Este método retorna el último carácter de la subcadena que se está analizando. Si la subcadena tiene más de un carácter, retorna el último; de lo contrario, devuelve la subcadena completa.

- **Parámetros:**
  - `cadena`: La cadena original.
  - `caracteresParaAnalizar`: La subcadena que se está analizando en ese momento.

- **Retorno:**
  - Devuelve un `String` con el último carácter de la subcadena.

### `boolean comprobarCadena(int longitudCadena, int indice)`
Este método verifica si se ha recorrido toda la cadena.

- **Parámetros:**
  - `longitudCadena`: La longitud total de la cadena original.
  - `indice`: El índice actual en el proceso de compresión.

- **Retorno:**
  - Devuelve `true` si el índice ha alcanzado o superado la longitud de la cadena, lo que indica que el proceso ha terminado. Devuelve `false` si aún quedan caracteres por analizar.


