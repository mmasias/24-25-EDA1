# Compresor de cadenas 
### Algoritmo del Codigo:
Este algoritmo utilizar un diccionario para almacenar y reutilizar subcadenas de texto previamente encontradas. La coompresión se logra reemplazando las subcadenas repetidas con tuplas que contienen: 
1. El indice de la subcadena en el diccionario.
2. El siguiente caracter, que no esta en la subcadena.

## Hace uso de 2 clases:
### Compress 
Se encarga de la logica de la compresión. Itera sobre la cadena a comprimir y busca en el diccionario las subcadenas que hayan aparecido antes.

### StringStorage
Hace la funcion del diccionario, donde se almacenan las subcadenas de caracteres para la posterior reutilización en la compresión.

## Funciones
### Método 'public String _compress(String stringToCompress)_'
Este metodo requisita una entrada tipo String para comprimir, compresión que sería devuelta en una cadena String formada por tuplas (indice, caracter) donde:
- **Indice** Es la posicion en el diccionario de la subcadena que ya ha sido almacenada
- **Caracter** Es el primer caracter que sigue la subcadena encontrada y que aun no esta en el diccionario.

### Proceso de Compresión:
## Inicialización
- Se inicializa con una cadena compressedString para luego almacenar la compresión.
- Se crea una instancia de ___StringStorage myDictionary___ para almacenar las subcadenas ya encontradas.
- Se utiliza una variable ___searchWindow___ para mantener la subcadena que se esta buscando en el diccionario

## Iteración
- Se recorre cada posición de la cadena con ___actualPosition___.
    - Se empieza una ventana de busqueda de un solo caracter (___windowLength=1___) y se crea ___searchWindow___ que inicialmente contiene un unico caracter.
    - Se verifica si la cadena almacenada en ___searchWindow___ ya está en el diccionario.
    - **SI ESTA EN EL DICCIONARIO** se expande la ventana de busqueda y se sigue buscando una subcadena que también este almacenada.
    - Cuando se encuentra la secuencia más larga posible en el diccionario, se guarda el indicie correspondiente a esta y el siguiente caracter (que no esta en el diccionario) 
    - **SI NO ESTA EN EL DICCIONARIO** se agrega como una nueva entrada y se almacena una tupla (0, caracter) en el resultado comprimido.