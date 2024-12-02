# Algoritmo de compresión

Las clases Compresor y Main utilizan un algoritmo de compresión basado en una variación del algoritmo LZ77. Este algoritmo se basa en encontrar secuencias repetidas dentro de los datos que se van a comprimir, y luego representar esas secuencias mediante referencias a posiciones anteriores en los datos, en lugar de almacenarlas de nuevo.  LZ77 utiliza una "ventana" que recorre los datos de entrada para encontrar patrones repetidos. La ventana contiene secuencias ya procesadas que se pueden reutilizar.

El algoritmo codifica las repeticiones de las secuencias como un par (desplazamiento, longitud), donde, el desplazamiento indica cuántos caracteres atrás se encuentra la secuencia repetida y la longitud especifica cuántos caracteres de la secuencia deben copiarse desde esa posición. Si no se encuentra ninguna repetición, se codifica el siguiente carácter literal, como en los pasos del algoritmo del código que voy a comentar.

## Ejemplo de codificación

[Enlace al código a comentar, clase Compresor](https://github.com/enmabry/24-25-EDA1/blob/feature/reto-003/entregas/baquedanoBryan/reto-003/Compresor.java)  
[Enlace al código a comentar, clase Main](https://github.com/enmabry/24-25-EDA1/blob/feature/reto-003/entregas/baquedanoBryan/reto-003/Main.java)

El código implementa una variación sencilla de LZ77, donde, en lugar de usar un desplazamiento y longitud para codificar secuencias repetidas, utiliza un diccionario que almacena secuencias ya vistas y les asigna un índice. Durante la compresión, la cadena de entrada se recorre carácter por carácter y se va construyendo una "ventana" que se compara con el diccionario. Si la ventana ya está en el diccionario, se amplía la ventana añadiendo más caracteres. Si no está en el diccionario, se codifica la ventana como una tupla (<índice>, <carácter>), donde: <índice> es el índice en el diccionario de la última subcadena válida; <carácter> es el siguiente carácter no visto.

### Clase Compresor

| Clase      | Método                | Tipo    | Descripción                                                                 |
|------------|-----------------------|---------|-----------------------------------------------------------------------------|
| **Compresor** | `Compresor(int tamañoDiccionario)` | Público | Constructor que inicializa el diccionario y el índice del diccionario.      |
|            | `comprimir(String cadena)`   | Público | Comprime la cadena de texto utilizando un diccionario de secuencias.        |
|            | `buscaEnDiccionario(String ventana)` | Privado | Busca si una subcadena está presente en el diccionario.                     |
| **Main**   | `main(String[] args)`         | Público | Método principal que ejecuta la aplicación.                                 |
|            | `leerCadenaDelUsuario()`      | Privado | Solicita al usuario que ingrese una cadena desde la consola.                |
|            | `esCadenaValida(String cadena, int maxLength)` | Privado | Verifica si la cadena cumple con la longitud máxima permitida.              |