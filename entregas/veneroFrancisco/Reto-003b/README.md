El [codigo](https://github.com/maariiooo/24-25-EDA1/tree/5405f4eca84361107da023dbd9ab9bc48f436835/entregas/viaderoMario/Reto003)

Se compone de dos clases, la clase Compresor y la clase Resultado.
Comenzando con la clase [Compresor](https://github.com/maariiooo/24-25-EDA1/blob/5405f4eca84361107da023dbd9ab9bc48f436835/entregas/viaderoMario/Reto003/Compresor.java) en la tambien está contenido el metodo main.

El primer [metodo](https://github.com/maariiooo/24-25-EDA1/blob/236f32702165f0dedae0b7cda4d4b4d9161b5af6/entregas/viaderoMario/Reto003/Compresor.java#L4) en el que toma una cadena como entrada y la comprime usando un diccionario, devolviendo un objeto de tipo Resultado, que contiene la cadena comprimida y el diccionario final. inicializacion de las variables de este metodo: 
        - salida: un arreglo de String de tamaño 100 donde se almacenan los resultados de la compresión.
        - diccionario: un arreglo de String de tamaño 100 que actua como diccionario para almacenar las subcadenas encontradas durante la compresión.
        - indiceDiccionario: un entero que mantiene el índice actual del diccionario (inicialmente en 1, ya que el índice 0 no se usa).
        - i: índice que recorre la cadena de entrada que empieza en 0.
        - tamañoSalida: tamaño actual de la salida comprimida.

El segundo [metodo](https://github.com/maariiooo/24-25-EDA1/blob/236f32702165f0dedae0b7cda4d4b4d9161b5af6/entregas/viaderoMario/Reto003/Compresor.java#L11) es el bucle principal :

En donde este bucle recorre la cadena de entrada carácter por carácter hasta que llega al final.
Dentro de el bucle podemos encontrar que se inicializan dos variables: coincidenciaMasLarga (cadena vacía) y indiceCoincidencia (0).
El bucle for recorre el diccionario buscando la subcadena más larga que coincida con la cadena actual a partir de la posición i.
cadena.startsWith(diccionario[j], i) se usa para verificar si la subcadena en la posición j del diccionario coincide con la cadena desde la posición i.

En el caso en el que si se encuentra una coincidencia (coincidenciaMasLarga no está vacía), se calcula su longitud.
Se verifica si hay un carácter siguiente después de la coincidencia en la cadena:

    Si hay, se guarda en salida un par del tipo (indiceCoincidencia, siguienteCaracter) y se agrega la combinación de la coincidencia más larga y el siguiente carácter al diccionario.
    Si no hay más caracteres, simplemente se guarda (indiceCoincidencia,), que indica el final.
    Luego, se avanza el índice i de la cadena.

Si no se encuentra coincidencia:

    Si no se encuentra ninguna coincidencia, se guarda el carácter actual en salida como (0, siguienteCaracter) y se agrega este carácter al diccionario.
    Se avanza el índice i al siguiente carácter.

Finalización del proceso:

    Una vez que el bucle termina (es decir, cuando se ha procesado toda la cadena), se crea una copia exacta de salida y diccionario para ajustar sus tamaños reales usando System.arraycopy.
    El método devuelve un objeto Resultado que contiene la salida comprimida, el diccionario final y el tamaño del diccionario.


En la segunda clase [Resultado](https://github.com/maariiooo/24-25-EDA1/blob/5405f4eca84361107da023dbd9ab9bc48f436835/entregas/viaderoMario/Reto003/Resultado.java)

[Atributos](https://github.com/maariiooo/24-25-EDA1/blob/5405f4eca84361107da023dbd9ab9bc48f436835/entregas/viaderoMario/Reto003/Resultado.java#L3) de la clase Resultado  

    String[] salidaComprimida:
        Almacena la salida comprimida generada por el algoritmo. Es un arreglo de cadenas que contiene las parejas (índice, carácter) resultantes del proceso de compresión.

    String[] diccionario:
        Almacena el diccionario que el algoritmo fue construyendo a lo largo del proceso de compresión. Es un arreglo de cadenas donde cada entrada representa una subcadena que se ha ido acumulando durante la compresión.

    int tamañoDiccionario:
        Indica el número real de entradas en el diccionario (el tamaño efectivo del diccionario). Este valor se usa para evitar recorrer posiciones no utilizadas del arreglo.

Constructor Resultado(String[] salidaComprimida, String[] diccionario, int tamañoDiccionario)

    Este constructor recibe los tres parámetros necesarios para inicializar los atributos de la clase:
        salidaComprimida: el arreglo que contiene la cadena comprimida.
        diccionario: el arreglo de cadenas que actúa como el diccionario construido durante la compresión.
        tamañoDiccionario: el tamaño del diccionario que fue utilizado durante la compresión.

Método [toString()](https://github.com/maariiooo/24-25-EDA1/blob/5405f4eca84361107da023dbd9ab9bc48f436835/entregas/viaderoMario/Reto003/Resultado.java#L14)

Este método sobrescribe el método toString de la clase Object para generar una representación en formato de cadena de los resultados de la compresión. Veamos los pasos:

Inicialización del StringBuilder:

    Se utiliza un objeto StringBuilder llamado resultado para construir la cadena de texto resultante. StringBuilder es más eficiente que concatenar cadenas directamente en un bucle.

Agrega la salida comprimida:

    Se empieza agregando el texto "Resultado comprimido: " al StringBuilder.
    Luego, se recorre el arreglo salidaComprimida usando un bucle for, agregando cada elemento de la salida al StringBuilder.

Agrega el diccionario:

    Después de la salida comprimida, se agrega el texto "\nDiccionario: " para introducir la sección que muestra el diccionario.
    El bucle for comienza en 1 y recorre el diccionario hasta el valor de tamañoDiccionario (evitando la posición 0 del diccionario, que no se usa). Para cada entrada del diccionario, se agrega una línea en el formato índice: valor.

Retorna el resultado final:

    Finalmente, se retorna el contenido del StringBuilder convertido a String usando toString().
    Además, se usa replaceAll(", $", "") para eliminar cualquier coma final sobrante en caso de que se haya añadido una de más en la salida comprimida.