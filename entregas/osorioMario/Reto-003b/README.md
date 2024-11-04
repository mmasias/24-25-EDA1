 # Documentación Reto 003

## Código https://github.com/diegojiimenez/24-25-EDA1/blob/22b3823890a082d1a88a63cd7879fe0d05f0b356/entregas/DiegoJimenez/reto-003/Compresor.java

## Descripción del Código

La clase Compresor tiene dos métodos principales:

1. **comprime(String cadena)**: Este método recibe una cadena de entrada y la comprime utilizando un diccionario para almacenar subcadenas que se repiten.
2. **buscaEnDiccionario(String[] diccionario, String ventana, int tamañoDiccionario)**: Método auxiliar que busca una subcadena (ventana) en el diccionario y retorna el índice donde se encuentra.

### Atributos y Variables

- **diccionario**: Un array que almacena las subcadenas que se han encontrado.
- **indices**: Un array que almacena los índices de las subcadenas en el diccionario.
- **indexDiccionario**: Contador que indica el próximo índice disponible en el diccionario.
- **resultado**: Un array que almacena la salida comprimida.
- **indexResultado**: Contador para indicar el índice en el que se insertarán las compresiones.
- **ventana**: Variable temporal para construir subcadenas de la cadena original.

### Algoritmo

1. Inicializa el diccionario y los arrays **resultado y ventana**.
2. Recorre la cadena original carácter por carácter:
   - Se genera una nueva ventana sumando el carácter actual a la ventana previa.
   - Si la nueva ventana no está en el diccionario, se agrega al diccionario.
   - Si la ventana ya está en el diccionario, se sigue expandiendo hasta que no coincida.
3. Cada vez que se encuentra una nueva subcadena, se genera un par de valores: el índice de la subcadena anterior en el diccionario y el siguiente carácter.
4. Si la cadena termina y queda una subcadena no procesada, se añade al resultado con el índice correspondiente.
5. Al final, se imprime el diccionario y el resultado comprimido.

### Ejemplo de uso
```java
public static void main(String[] args) {
    String cadena = "abababcbdc";
    String comprimido = comprime(cadena);
    System.out.println(comprimido);
}
```


