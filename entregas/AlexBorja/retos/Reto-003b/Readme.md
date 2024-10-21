---

# Documentación de la Clase Compressor

La clase `Compressor` proporciona funcionalidades para comprimir y descomprimir cadenas de texto utilizando un algoritmo de compresión personalizado. Mantiene un diccionario de segmentos de cadenas para optimizar el proceso de compresión, codificando segmentos repetidos en una representación más compacta.

## Resumen

La clase `Compressor` tiene dos métodos principales:
- `zip(String toZip)`: Comprime una cadena dada.
- `unzip(String zipped)`: Descomprime una cadena comprimida, devolviéndola a su forma original.

La clase utiliza un objeto `Dictionary` para almacenar y recuperar segmentos de cadenas durante la compresión y descompresión. Comprime los segmentos almacenando su índice y el siguiente carácter, permitiendo una representación reducida del texto de entrada.

## Métodos de la Clase

### 1. `String zip(String toZip)`

- **Propósito**: Comprime la cadena de entrada usando un enfoque basado en un diccionario.
- **Parámetros**:
  - `toZip`: La cadena que se va a comprimir.
- **Retorna**: Una representación comprimida de la cadena de entrada.

**Algoritmo**:
- Itera a través de cada carácter en la cadena de entrada.
- Construye un segmento de caracteres y verifica si existe en el diccionario.
  - Si el segmento no se encuentra, lo agrega al diccionario y genera una representación comprimida de él.
  - Si el segmento se encuentra, continúa extendiéndolo.
- Codifica los segmentos usando un formato como `(índice,carácter)`.

### 2. `String unzip(String zipped)`

- **Propósito**: Descomprime una cadena comprimida para devolverla a su forma original.
- **Parámetros**:
  - `zipped`: La cadena comprimida que se va a descomprimir.
- **Retorna**: La cadena original descomprimida.

**Algoritmo**:
- Analiza cada segmento comprimido en la entrada.
- Recupera el segmento del diccionario utilizando su índice.
- Reconstruye la cadena original agregando caracteres y segmentos.
- Añade cada nuevo segmento al diccionario para su uso futuro.

## Dependencias

- **Clase [`Dictionary`](https://github.com/mmasias/24-25-EDA1/blob/4f94d08c76d97fcbe3045a3da8457933c2fedf6b/entregas/brunoMaciejewski/reto-003/Dictionary.java#L1)**: La clase `Compressor` depende de una clase `Dictionary` para gestionar los segmentos de las cadenas durante el proceso de compresión y descompresión. Esta clase debe proporcionar métodos como `getSegmentIndex`, `getSegmentAt` y `addElement`.

## Ejemplo de Uso

```java
public class Main {
    private static String TO_ZIP="abababc";
    public static void main(String[] args) {
        Compressor compressor=new Compressor();
        String zipped=compressor.zip(TO_ZIP);
        String unzipped=compressor.unzip(zipped); 
        System.out.println(TO_ZIP);
        System.out.println(zipped);
        System.out.println(unzipped);
    }
}
```
