Comentar codigo de compañero:
[Reto Andres Lopez](https://github.com/andreslb9/24-25-EDA1/blob/f17140b9c1426a08a765b9c5513e865e8a848f9b/entregas/lopezAndres/reto-003/Compresor.java#L5)

1. [Clase Resultado](https://github.com/andreslb9/24-25-EDA1/blob/f17140b9c1426a08a765b9c5513e865e8a848f9b/entregas/lopezAndres/reto-003/Compresor.java#L3-L9): Esta clase encapsula el resultado de la compresión, que consiste en dos partes salida comprimida (Array que contiene las tuplas de la compresion) y diccionario (Array que contiene lo que se almacena en el diccionario durante el proceso de compresión).
Se añade un constructor que recibe la salida comprimida y el diccionario para inicializar los atributos.
2. [Diccionario](https://github.com/andreslb9/24-25-EDA1/blob/f17140b9c1426a08a765b9c5513e865e8a848f9b/entregas/lopezAndres/reto-003/Compresor.java#L13-L29) Imprime el diccinario con los datos que se almacenan durante la compresión
3. [Metodo comprime](https://github.com/andreslb9/24-25-EDA1/blob/f17140b9c1426a08a765b9c5513e865e8a848f9b/entregas/lopezAndres/reto-003/Compresor.java#L31-L81)
maxTamano: El tamaño máximo de la cadena, que también se usa para dimensionar los arrays.
salida: Un array para almacenar las tuplas comprimidas.
diccionario: Un array para almacenar las secuencias de texto encontradas
i: El índice actual que recorre la cadena de entrada.
salidaIndex: Índice para llenar el array de salida.
diccionarioIndex: Índice para llenar el array de diccionario.
coincidenciaMasLarga: Se inicializa vacía y se usará para almacenar la coincidencia más larga que se encuentre en el diccionario.
indiceCoincidencia: Almacena el índice de la coincidencia en el diccionario.
El for recorre el diccionario actual buscando si hay alguna secuencia en el diccionario que coincida con la cadena actual empezando en el índice i de la cadena de entrada. Si encuentra una coincidencia, la almacena en coincidenciaMasLarga y también guarda el índice correspondiente en el diccionario.
longitud: Se obtiene la longitud de la coincidencia más larga.
Si no hemos llegado al final de la cadena, se agrega el siguiente carácter después de la coincidencia a la salida y se actualiza el diccionario con esa coincidencia más el siguiente carácter.
Si ya hemos alcanzado el final de la cadena, solo se agrega la tupla (índiceCoincidencia, ).
Se crean nuevos arrays salidaFinal y diccionarioFinal del tamaño correcto (sin elementos nulos) copiando los valores de los arrays originales.
Finalmente, se devuelve un nuevo objeto Resultado con la salida comprimida y el diccionario.
[Main](https://github.com/andreslb9/24-25-EDA1/blob/f17140b9c1426a08a765b9c5513e865e8a848f9b/entregas/lopezAndres/reto-003/Compresor.java#L83-L87) 
En el main, se prueba la función de compresión con la cadena "abababc".
Se llama al método comprime() y se imprime el resultado utilizando el método toString() de la clase Resultado.