# Documentación de código del Reto-003b

### https://github.com/andreslb9/24-25-EDA1/blob/f17140b9c1426a08a765b9c5513e865e8a848f9b/entregas/lopezAndres/reto-003/Compresor.java

## Estructura del Proyecto

### 1. Clase `Compresor`

#### Métodos Públicos

- **<a href="https://github.com/andreslb9/24-25-EDA1/blob/f17140b9c1426a08a765b9c5513e865e8a848f9b/entregas/lopezAndres/reto-003/Compresor.java#L31" target="_blank">Comprime</a>** 

  - Es el método principal encargado de comprimir la cadena de entrada utilizando el algoritmo LZ.
  - **Parámetro**: 
    - `cadena`: La cadena de texto que se quiere comprimir.
  - **Salida**: 
    - Devuelve un objeto de la clase interna `Resultado`, que contiene la versión comprimida de la cadena y el diccionario utilizado.

- **<a href="https://github.com/andreslb9/24-25-EDA1/blob/f17140b9c1426a08a765b9c5513e865e8a848f9b/entregas/lopezAndres/reto-003/Compresor.java#L3" target="_blank">Clase interna Resultado</a>** 
  - Esta clase almacena los resultados de la compresión y permite imprimirlos.
  - Contiene dos propiedades:
    - `salidaComprimida`: Un array de cadenas que contiene la representación comprimida de la cadena de entrada.
    - `diccionario`: Un array de cadenas que contiene las secuencias almacenadas durante la compresión.
  - **<a href="https://github.com/andreslb9/24-25-EDA1/blob/f17140b9c1426a08a765b9c5513e865e8a848f9b/entregas/lopezAndres/reto-003/Compresor.java#L13" target="_blank">Metodo toString</a>** 
    - Este método formatea los resultados, incluyendo la salida comprimida y el diccionario, para una fácil visualización.

### 2. Ejemplo de Uso

El método `main` ejecuta un ejemplo del uso de la clase `Compresor`. En este caso, se comprime la cadena `"abababc"`.

```java
public static void main(String[] args) {
    String cadena = "abababc";
    Resultado resultado = comprime(cadena);
    System.out.println(resultado);
}