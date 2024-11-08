# Explicación del Desarrollo del Código

Este código fue creado con la ayuda de ChatGPT, y posteriormente modificado por mí. Para iniciar el desarrollo, le envié el enunciado del reto (disponible en el repositorio de la asignatura) y le expliqué lo que entendí de la explicación en clase, proporcionándole muchos detalles.

Esto fue lo que le escribí:

> "Desarrolla un código en Java que implemente un algoritmo de compresión para la cadena `abababc`. + el enunciado + la explicación(lo que entendí) de los 3 primeros casos: 

#### Mi explicación de los tres primeros casos:

1. Se toma el primer elemento (en este caso, "a") y se busca en el diccionario (que al principio está vacío). Si el elemento no está, se agrega al diccionario con el índice `1 -> a`.  
   En `(0,a)`, el `0` significa que es la primera vez que aparece este elemento.

2. Se sigue con el siguiente elemento, "b", y se repite el mismo proceso: `(0,b)`.

3. Cuando vuelve a aparecer el elemento "a", se busca en el diccionario y se encuentra con el índice 1. Luego, se toma "a" y se marca como `(1,...)`. El siguiente elemento es "b", que también está en el diccionario, por lo que se representa como `(1,b)` porque el segundo elemento del par debe ser una string. Y así sucesivamente.

### Modificaciones Realizadas

Aunque el código proporcionado por ChatGPT funcionaba correctamente y incluso noto sin que le diga que el algoritmo es similar a una variación del algoritmo de LZ77, realicé algunas modificaciones para ajustarlo a mis conocimientos:

- **Uso de ArrayList en lugar de HashMap**: No entendía qué era un `HashMap` ni cómo funcionaba, así que le pregunté a ChatGPT. Me explicó con ejemplos que el `HashMap` en el código era una estructura que realiza un seguimiento eficiente de las subcadenas y sus índices en el diccionario, lo que permite la compresión de la cadena de manera más rápida.

 Vi que era posible usar un `ArrayList` en lugar del `HashMap` porque estoy más familiarizada con él y porque es mas simple. En el `ArrayList` use el método `indexOf()`, que recorre secuencialmente la lista de subcadenas. Por otro lado, un `HashMap` podría ofrecer búsquedas más rápidas. A pesar de que el `HashMap` es más eficiente, opté por el `ArrayList`. El código será más lento a medida que la cadena crece o si se trabaja con cadenas más largas pero como es una cadena corta opté por lo mas simple.

- **Uso de `imprimir()` en lugar de `toString()` para imprimir atributos**: ChatGPT llamaba al método `toString()` para imprimir. En su lugar, creé un método personalizado llamado `imprimir()`, que hace lo mismo: organiza la impresión de los objetos de manera automática y mantiene el codigo organizado. Esto facilita la legibilidad y evita tener que escribir muchas líneas adicionales cada vez que quiero imprimir un objeto, con un `System.out.println()`.

- **Cambios en los nombres de variables**: Hice otros cambios como en el nombre de algunas variables, para que el codigo sea mas legible, y leí el codigo varias veces buscando entender que hace cada linea y preguntando que hacia cada cosa cuando no entendia.

EL código funciona bien y lo he probado adicionando más elementos a la cadena y todo salió correctamente.
