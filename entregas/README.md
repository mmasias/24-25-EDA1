# Documentación del Compresor LZW

## Descripción General

El Compresor LZW es una implementación del algoritmo de compresión LZW (Lempel-Ziv-Welch). Este algoritmo permite comprimir cadenas de caracteres utilizando un diccionario que se construye dinámicamente mientras se procesa la cadena. A continuación se documentan las diferentes clases que componen esta implementación.


## Estructura del Código

### Clase Main

- **Descripción**: Punto de entrada de la aplicación.
- **Método main**:
  - Utiliza un escáner para leer una cadena de entrada del usuario.
  - Instancia un objeto de CompresorLZW para comprimir la cadena ingresada.
  - Imprime el resultado de la compresión.

### Clase CompresorLZW

- **Descripción**: Implementa el algoritmo de compresión LZW.
- **Atributos**:
  - `Map<String, Integer> diccionario`: Mapa que relaciona secuencias de caracteres con índices únicos.
  - `List<Tupla> resultado`: Lista que almacena las tuplas generadas durante la compresión.

- **Métodos**:
  - **Constructor CompresorLZW()**: Inicializa el diccionario y la lista de resultados.
  - **Método ResultadoCompresion comprime(String cadena)**:
    - **Parámetros**: 
      - `cadena`: La cadena de caracteres a comprimir.
    - **Retorno**: Un objeto ResultadoCompresion que contiene la lista de tuplas y el diccionario utilizado.
    - **Descripción**: Implementa el algoritmo LZW, construyendo un diccionario de secuencias de caracteres y generando una lista de tuplas que representan la cadena comprimida.

### Clase Tupla

- **Descripción**: Representa una tupla que asocia un índice del diccionario con un carácter.
- **Atributos**:
  - `int indice`: Índice del diccionario asociado a la secuencia de caracteres.
  - `char caracter`: Carácter que sigue al índice en la secuencia.

- **Métodos**:
  - **Constructor Tupla(int indice, char caracter)**: Inicializa el índice y el carácter.
  - **Método toString()**: Devuelve una representación en cadena de la tupla en el formato `(indice, caracter)`.

### Clase ResultadoCompresion

- **Descripción**: Encapsula el resultado de la compresión, incluyendo el resultado comprimido y el diccionario utilizado.
- **Atributos**:
  - `List<Tupla> resultado`: Lista de tuplas que representa el resultado comprimido.
  - `Map<String, Integer> diccionario`: Diccionario utilizado durante la compresión.

- **Métodos**:
  - **Constructor ResultadoCompresion(List<Tupla> resultado, Map<String, Integer> diccionario)**: Inicializa el resultado y el diccionario.
  - **Método toString()**: Devuelve una representación en cadena del resultado comprimido y el diccionario.

## Uso

1. Ejecutar la clase Main para iniciar la aplicación.
2. Ingresar la cadena que se desea comprimir cuando se solicite.
3. El resultado de la compresión se mostrará en la consola.





