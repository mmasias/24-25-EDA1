# Compressor Class

Este código implementa una clase `Compressor` que tiene dos métodos principales: `zip` (para comprimir una cadena de texto) y `unzip` (para descomprimir una cadena comprimida). Se trata de una técnica de compresión basada en un diccionario.

[Repositorio Original](https://github.com/Bruno-MBl/24-25-EDA1/tree/4f94d08c76d97fcbe3045a3da8457933c2fedf6b/entregas/brunoMaciejewski/reto-003)

## 1. Método `zip(String toZip)`

Este método comprime una cadena utilizando una estructura de diccionario.

### Variables principales:

- **`zip`**: Cadena resultante que contendrá el texto comprimido.
- **`dictionary`**: Un diccionario que mantiene segmentos de texto.
- **`actualChar`**: El carácter actual de la cadena que se está procesando.
- **`actualSegment`**: El segmento actual de texto que se está comparando con el diccionario.
- **`lastIndex`**: El último índice en el diccionario donde se encontró el segmento anterior.

### Ciclo `for`:

- Itera sobre cada carácter de `toZip`.
- Concadena los caracteres en `actualSegment` y busca este segmento en el diccionario.
- Si el segmento no está en el diccionario (`index == 0`), lo añade y genera una representación comprimida de ese segmento usando `generateSegment`, luego reinicia `actualSegment`.
- Si el segmento ya existe en el diccionario, actualiza `lastIndex` y sigue extendiendo el segmento hasta que se encuentre uno nuevo.

### Método auxiliar `generateSegment(int index, char actualChar)`:

Genera un segmento comprimido que consiste en un par `(índice, carácter)`.

### Estructura de datos utilizada:

- **Diccionario**: Es utilizado para almacenar segmentos de la cadena de texto y buscar coincidencias de manera eficiente. Aunque no se proporciona su implementación, se asume que tiene métodos como `getSegmentIndex` (que devuelve el índice de un segmento) y `addElement` (que añade un nuevo segmento al diccionario).

---

## 2. Método `unzip(String zipped)`

Este método descomprime una cadena comprimida generada por `zip`.

### Variables principales:

- **`unzip`**: Cadena resultante con el texto descomprimido.
- **`dictionary`**: Mantiene los segmentos mientras se descomprime el texto comprimido.

### Ciclo `while`:

- Extrae segmentos comprimidos uno por uno de `zipped`.
- Obtiene el índice y el último carácter del segmento comprimido con los métodos `getNextIndex` y `getNextCharacter`.
- Usa el índice para obtener el segmento correspondiente del diccionario y añade el nuevo carácter para formar el segmento descomprimido.
- Añade el segmento descomprimido a `unzip` y lo almacena en el diccionario.

### Métodos auxiliares:

- **`deleteFirstSegment(String zipped)`**: Elimina el primer segmento comprimido de la cadena.
- **`getNextCharacter(String zipped)`**: Obtiene el carácter del próximo segmento comprimido.
- **`getNextIndex(String zipped)`**: Obtiene el índice del próximo segmento comprimido.

### Estructura de datos utilizada:

- **Diccionario**: Similar al método `zip`, el diccionario se usa para almacenar y recuperar segmentos durante la descomposición.
