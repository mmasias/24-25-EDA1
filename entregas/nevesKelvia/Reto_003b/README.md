Voy a documentar el codigo de Alejandro Juárez ([Alejandrojuarez0105](https://github.com/Alejandrojuarez0105))

El a dividido su código en 4 clases:

[Compresor](https://github.com/Alejandrojuarez0105/24-25-EDA1/blob/3f1f11057bb858d25b70a80c344293a0d53601d9/entregas/juarezAlejandro/reto-003/Compresor.java)

En la clase `Compresor` tiene la función `comprimir` que es el método principal que realiza el proceso de compresión.
Usa un `StringBuilder` llamado `comprimir` para obtener el resultado comprimido y recorre el texto carácter por carácter. 

`getDiccionario()`:
Función: Este método simplemente retorna el objeto diccionario actual. Esto permite acceder al diccionario externo a la clase Compresor, quizás para fines de depuración o verificación

Métodos Públicos:

public String comprimir(String texto)
public Diccionario getDiccionario()

Atributos Privados: 

`private String ultimaSecuencia`

`private Diccionario diccionario`

[Descompresor](https://github.com/Alejandrojuarez0105/24-25-EDA1/blob/3f1f11057bb858d25b70a80c344293a0d53601d9/entregas/juarezAlejandro/reto-003/Descompresor.java)

Esta clase `Descompresor` tiene como objetivo descomprimir una cadena que fue comprimida utilizando el algoritmo de compresión basado en un diccionario (como el que implementa la clase Compresor).

`Atributos Privados`:

`POSICION_INDEX` (Define la posición dentro de cada elemento comprimido donde se encuentra el índice del diccionario.)

`POSICION_CHAR`: (Define la posición dentro de cada elemento comprimido donde se encuentra el carácter.)

`Método Público`:

`public String descomprimir(String comprimido, Diccionario diccionario)`: Este método toma una cadena comprimida y el diccionario que contiene las secuencias usadas en el proceso de compresión, y devuelve la cadena original descomprimida.

[Diccionario](https://github.com/Alejandrojuarez0105/24-25-EDA1/blob/3f1f11057bb858d25b70a80c344293a0d53601d9/entregas/juarezAlejandro/reto-003/Diccionario.java)

Vista publica:

`public int getIndexSecuencia(String ultimaSecuencia)`

`public void añadirAlDiccionario(String nuevoEspacio)`

`public boolean estáEnDiccionario(String nuevoEspacio)`

`public String getDictionary()`

`public String getSecuenciaIndex(int index)`

[Main](https://github.com/Alejandrojuarez0105/24-25-EDA1/blob/3f1f11057bb858d25b70a80c344293a0d53601d9/entregas/juarezAlejandro/reto-003/Main.java)

Vista Pública:

`public static void main(String[] args)`: Método principal que actúa como punto de entrada de la aplicación. 

Se define un texto a comprimir ("abababcbdc").
Se instancia un objeto `Compresor` y se utiliza para comprimir el texto.
El resultado comprimido se imprime en la consola.
Se instancia un objeto Descompresor para descomprimir el texto utilizando el diccionario del Compresor.
El texto descomprimido se imprime en la consola.

Aquí se controla el flujo del programa, ejecutando tanto la compresión como la descompresión del texto.
