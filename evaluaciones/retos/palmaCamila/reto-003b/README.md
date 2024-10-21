# Reto 003: Compresor de String

## Descripción

El reto consiste en implementar un compresor de una secuencia de strings utilizando un enfoque basado en un diccionario. El proceso de compresión sigue las siguientes reglas:

1. Si un string no está en el diccionario, se añade y se codifica como `(0, caracter)`, donde `0` indica que el carácter es nuevo.
2. Si un string ya está en el diccionario, se codifica utilizando el índice en el diccionario más el siguiente carácter de la cadena.

## Detalles del Reto

- **Repositorio a analizar**: [24-25-EDA1](https://github.com/mmasias/24-25-EDA1/pull/216/files#diff-8f3dd15277d8e93266bcce90ee8aab4ee83770cc695e8a437982bab47e9f652f)

### Objetivo del reto

El objetivo es comprimir una secuencia de caracteres usando un diccionario que almacena las subcadenas previamente vistas y genera una secuencia comprimida. El resultado comprimido es una serie de tuplas que indican el índice del diccionario o una nueva entrada.

### Proceso esperado:

![Proceso de compresión](https://www.planttext.com/api/plantuml/png/XP112i8m403lUSNIKuKAwh47gPe71FE2xIQ7WCsM97sO-8H-p4IaAYBUbfs1MRQB2KEQXej0IXn0Mvgi9uU04RGOCtJaHlG9AXMOR6Gm5auyZC56DzzyLKprOKf7vDXZS5oW54B3UW-gXGeheSeiMpXEaJ0yLXBM2mVFa2zWdm8QNkp3V4NZ0jJRfbYh0ZBHBPnjFZp7eDuyqIlNV-Vwzrp_DxThYlKpLv3eh3VbXNS0)

## Funcionamiento

El programa está compuesto por dos clases principales:

1. **Clase `Compresor`**: Se encarga de la lógica de compresión.
2. **Clase `Main`**: Gestiona la entrada de datos y llama a los métodos de compresión.

### Clase `Compresor`

La clase `Compresor` tiene las siguientes características:

#### Variables privadas:

- `private String[] diccionario`: Arreglo que almacena los strings del diccionario.
- `private int indexDiccionario`: Índice que mantiene el seguimiento del último elemento añadido al diccionario.

#### Constructor:

El constructor inicializa el diccionario con un tamaño especificado y asigna el valor de `indexDiccionario` en 1, de modo que el primer índice sea 1.

## Método `comprimir(String cadena)`

El método `comprimir` es el **núcleo del proceso de compresión**. Recibe una cadena de texto como entrada, la procesa carácter por carácter y genera una representación comprimida usando un diccionario dinámico. 

### ¿Qué hace este método?

1. **Inicializa las estructuras necesarias**:
   - Crea un `StringBuilder` llamado `resultadoFinal` para almacenar el resultado comprimido.
   - Define una variable `ventana` para manejar las subcadenas que se extraen de la cadena original.

2. **Itera a través de la cadena**:
   - A través de un bucle `for`, recorre cada carácter de la cadena de entrada, construye subcadenas (ventanas) y las busca en el diccionario.

3. **Busca en el diccionario**:
   - Usa el método `buscaEnDiccionario` para determinar si la subcadena formada (ventana) ya está presente en el diccionario.

4. **Codifica las subcadenas nuevas**:
   - Si la subcadena **no está en el diccionario**:
     - Si es un nuevo carácter (ventana vacía), lo codifica como `(0, c)`.
     - Si es una subcadena existente pero que se extiende con un nuevo carácter, la codifica como `(índice, c)`, donde `índice` es el lugar de la subcadena anterior en el diccionario.

5. **Actualiza el diccionario**:
   - Si la subcadena no está en el diccionario, la añade y actualiza el índice del diccionario (`indexDiccionario`).

6. **Procesa subcadenas existentes**:
   - Si la subcadena ya está en el diccionario, actualiza `ventana` para extenderla con el próximo carácter en la siguiente iteración.

7. **Procesa la última subcadena**:
   - Al finalizar el bucle, si queda alguna subcadena sin procesar en `ventana`, la añade al resultado comprimido.

8. **Imprime los resultados**:
   - Imprime la cadena original, el contenido del diccionario y la representación comprimida final.

---

## Método `buscaEnDiccionario(String ventana)`

Este método **busca una subcadena** (ventana) en el diccionario y devuelve el índice donde se encuentra, si existe.

### ¿Qué hace este método?

1. **Itera por el diccionario**:
   - Utiliza un bucle `for` para recorrer el diccionario desde el índice `1` (asumiendo que el índice `0` no se usa).

2. **Compara las subcadenas**:
   - Compara la subcadena actual (`ventana`) con cada entrada del diccionario. Si encuentra una coincidencia exacta, devuelve el índice de esa subcadena.

3. **Maneja subcadenas no encontradas**:
   - Si la subcadena no se encuentra en ninguna entrada del diccionario, devuelve `-1`, lo que indica que la subcadena es nueva y aún no ha sido añadida al diccionario.

```java
private int buscaEnDiccionario(String ventana) {
    for (int i = 1; i < indexDiccionario; i++) {
        if (diccionario[i] != null && diccionario[i].equals(ventana)) {
            return i;  // Devuelve el índice de la ventana en el diccionario
        }
    }
    return -1;  // No se encontró la ventana en el diccionario
}
