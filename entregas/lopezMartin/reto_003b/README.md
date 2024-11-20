# Documentación del reto003 de Jaime Linares Balbás por Martín López de Novales Gurruchaga

> (https://github.com/jaimelinares6/24-25-EDA1/blob/a81c99ed73bf6f42f158da52a7a2eff9e5567704/entregas/linaresJaime/Reto003/Cadena.java)

### La solución que ha propuesto Jaime Linares se basa en programación estructurada, luego solo ha implementado la clase "Cadena.java".

Se importa la clase ArrayList y la interfaz List del paquete java.util para manejar listas, y Scanner para leer las entradas del usuario.

La clase contiene dos métodos principales, `main` y `comprime`

## Método `main`:
- Se le pide al usuario que ingrese una cadena de texto que posteriormente se comprimirá.

- Se llama al método `comprime` con la cadena previa.

- Imprime la compresión final y su diccionario respectivo.

## Método `comprime`: 

### Parámetros de entrada: `String cadena`

### Variables locales:
- `List<String> diccionario`
- `List<String> resultado`
- `int posicionActual`

### Funcionamiento del Bucle while

Este bucle principal se ejecuta mientras no se haya procesado toda la cadena de entrada.

```java
while (posicionActual < cadena.length()) {
    String coincidencia = "";
    int longitud = 0;
```

`coincidencia`: Almacena la mayor coincidencia encontrada en el diccionario.
<br>
`longitud`: Almacena la longitud de la coincidencia encontrada.

### Búsqueda de la mayor coincidencia

```java
for (int i = 1; i <= cadena.length() - posicionActual; i++) {
    String ventana = cadena.substring(posicionActual, posicionActual + i);
    if (diccionario.contains(ventana)) {
        coincidencia = ventana;
        longitud = ventana.length();
    } else {
        break;
    }
}
```

`ventana`: Subcadena de la cadena original que se compara con las entradas del diccionario.
<br>
<br>
Se busca la subcadena más larga en el diccionario. Si se encuentra una coincidencia, se actualiza la variable `coincidencia` con la subcadena más larga. Si no hay coincidencia, el bucle se rompe.

### Manejo de la Coincidencia

Si se encuentra una coincidencia en el diccionario `(longitud > 0)`, se procesa de la siguiente manera:

```java
int indice = diccionario.indexOf(coincidencia);
if (posicionActual + longitud < cadena.length()) {
    char siguienteCaracter = cadena.charAt(posicionActual + longitud);
    resultado.add("(" + (indice + 1) + "," + siguienteCaracter + ")");
    diccionario.add(coincidencia + siguienteCaracter);
    posicionActual += longitud + 1;
} else {
    resultado.add("(" + (indice + 1) + ",)");
    posicionActual += longitud;
}
```

`indice`: Es el índice en el diccionario donde se encontró la coincidencia.
<br>
<br>
Si la coincidencia no es al final de la cadena, se agrega el siguiente carácter a la coincidencia, se actualiza el diccionario y se agrega un nuevo par al resultado.
<br>
<br>
Si la coincidencia está al final de la cadena, simplemente se agrega el índice al resultado.

### Manejo de Nuevos Caracteres
Si no se encuentra ninguna coincidencia en el diccionario:
```java
char actual = cadena.charAt(posicionActual);
diccionario.add(String.valueOf(actual));
resultado.add("(0," + actual + ")");
posicionActual++;
```
Se añade el carácter actual al diccionario y al resultado con un índice de 0, indicando que es un carácter nuevo.
### Retorno del Resultado
```java
return new String[] { String.join("", resultado), diccionario.toString() };
```
El método devuelve dos valores:
- `String.join("", resultado)`: La cadena comprimida en formato (índice, carácter)
- `diccionario.toString()`: El diccionario resultante al final del proceso.