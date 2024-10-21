# Documentación del codigo del reto 003

### Enlace al código (https://github.com/Maritoz/24-25-EDA1/blob/aebc72957c43e2ba213ae409a10dce0858dabb6d/entregas/osorioMario/Reto-003/Comprimidor.java)


## Documentación de la Clase Comprimidor

## Estructuras de Datos Utilizadas

1. **Listas (`List`)**
   - `List<Par<Integer, Character>>`: Almacena el resultado comprimido, donde cada elemento es un par que contiene un índice y un carácter.

2. **Mapas (`Map`)**
   - `Map<String, Integer>`: Mapa que asocia subcadenas con índices enteros. Se utiliza para verificar rápidamente si una subcadena ya ha sido vista.
   - `Map<Integer, String>`: Mapa que almacena índices asociados a subcadenas originales, permitiendo recuperar la subcadena a partir de un índice.

3. **Clases Personalizadas**
   - `Par<K, V>`: Clase para representar un par de valores (índice y carácter).

## Funciones de la Clase Comprimidor

### 1. Definición de Estructuras de Datos

- **Clase Interna `Resultado`**
  - Encapsula el resultado de la compresión, con los atributos:
    - `resultadoComprimido`: Lista de pares representando la salida comprimida.
    - `diccionario`: Mapa que relaciona índices con subcadenas originales.
  - Métodos:
    - Constructor para inicializar los atributos.
    - Getters para acceder a los atributos.
    - Método `toString` para imprimir el resultado.

- **Clase Interna `Par<K, V>`**
  - Representa un par de valores, conteniendo:
    - Atributos `primero` y `segundo`.
    - Constructor y método `toString` para representar el par.

### 2. Método `comprime(String cadena)`

- **Descripción**: Este método realiza la compresión de la cadena de entrada.
- **Lógica**:
  - Recorre la cadena buscando coincidencias en el diccionario.
  - Si encuentra una subcadena existente, almacena su índice; de lo contrario, agrega el carácter actual como nuevo elemento.
  - Almacena pares en una lista que representa el resultado comprimido.
- **Retorno**: Devuelve un objeto `Resultado` que contiene:
  - La lista de pares.
  - El diccionario inverso.

