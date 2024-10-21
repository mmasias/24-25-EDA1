https://github.com/rubentresgallob/24-25-EDA1/blob/bd611472794308919f5036d1f39d372d815b2aec/entregas/reto-003/CompresionDiccionario.java

# Reto 003: Rubén Tresgallo, hecho por Celia Becerril



```bash
static class Par {
    int p;  
    char c; 

    Par(int p, char c) {
        this.p = p;
        this.c = c;
    }

    @Override
    public String toString() {
        return "(" + p + "," + c + ")";
    }
}
```

### Clase `Par`

- **Descripción:** Clase estática que representa los datos pares que se generan durante la compresión de la cadena.
  
#### Atributos:
- **`int p`:** Índice que representa una secuencia en el diccionario.
- **`char c`:** Carácter que sigue a la secuencia registrada en el diccionario.

#### Método:
- **`toString`:** Método que sobrescribe la representación del objeto para imprimirlo en formato `(p, c)`.


### Metodo comprimir
```bash
public static Par[] comprimir(String cadena) 
```
Recibe cadena como argumento y devuelve un array de objetos de tipo Par (cadena comprimida)

### Variables:
```bash
String[] diccionario = new String[100]; 
Par[] salida = new Par[100]; 
int valor = 1; 
int contadorSalida = 0;
int contadorDiccionario = 0; 
String w = ""; 
````
### Variables del Método `comprimir`

- **`diccionario`:** Arreglo de tamaño 100 que almacena secuencias de caracteres descubiertas durante la compresión.
- **`salida`:** Arreglo de tamaño 100 que almacena los pares generados como resultado de la compresión.
- **`valor`:** Contador que representa el número de entradas en el diccionario, comenzando en 1.
- **`contadorSalida`:** Número de pares que se han creado durante la compresión.
- **`contadorDiccionario`:** Número de secuencias que se han añadido al diccionario.
- **`w`:** Cadena que acumula la secuencia de caracteres actual que está siendo evaluada.


Bucle: 
```bash
for (int i = 0; i < cadena.length(); i++)
char c = cadena.charAt(i);
    String wc = w + c; 
    int indice = buscarEnDiccionario(diccionario, contadorDiccionario, wc);
````

### Iteración sobre cada carácter de la cadena

- **`c`:** Extrae el carácter actual de la cadena que está siendo procesado.
- **`wc`:** Forma una nueva cadena concatenando `w` (la secuencia actual) y `c` (el carácter actual).
- **`indice`:** Se utiliza el método `buscarEnDiccionario` para verificar si la secuencia `wc` ya existe en el diccionario.
  
Si `wc` ya existe, se sigue acumulando la secuencia; de lo contrario, se crea un nuevo par.

`
```bash
if (indice == -1) { 
    int p = w.isEmpty() ? 0 : buscarEnDiccionario(diccionario, contadorDiccionario, w);
    salida[contadorSalida++] = new Par(p, c); 

    diccionario[contadorDiccionario] = wc;
    System.out.println("Agregado al diccionario: " + wc + " -> " + valor); 
    valor++;
    contadorDiccionario++;
    w = "";
} else {
    w = wc;
}
````

### Condicionales de Compresión

- **Si `indice == -1`:** 
  - Significa que la secuencia `wc` no está en el diccionario.
  - Se busca el índice de `w` en el diccionario.
  - Se crea un nuevo objeto `Par` con el índice `p` (de `w`) y el carácter `c`.
  - Se añade la secuencia `wc` al diccionario y se imprime el mensaje: `"Agregado al diccionario: "` junto con el valor.
  - Se incrementan los contadores: `valor` y `contadorDiccionario`.
  - Se reinicia la secuencia `w`.

- **Si `indice != -1`:** 
  - Indica que la secuencia `wc` ya existe en el diccionario.
  - Se actualiza `w` a `wc` para seguir acumulando la secuencia.

---

### Finalización de la Compresión

```java
Par[] salidaFinal = new Par[contadorSalida];
for (int i = 0; i < contadorSalida; i++) {
    salidaFinal[i] = salida[i];
}
return salidaFinal;
 ````

Se crea un nuevo array salidaFinal del tamaño de contadorSalida para poder guardar los pares válidos
Se copian los pares del array salida a salidaFinal 
Se devuelve salidaFinal 

### Método buscarEnDiccionario
```bash
public static int buscarEnDiccionario(String[] diccionario, int contador, String secuencia) {
    for (int i = 0; i < contador; i++) {
        if (diccionario[i].equals(secuencia)) {
            return i + 1; 
        }
    }
    return -1; 
}

````

### Método `buscarEnDiccionario`

- **Función:** Busca una secuencia en el diccionario.
- **Proceso:**
  - Itera sobre el diccionario hasta el valor de `contador`.
  - Verifica si alguna entrada del diccionario coincide con la secuencia.
- **Resultado:**
  - Si encuentra la secuencia, devuelve su índice +1.
  - Si no encuentra la secuencia, devuelve `-1`.

---

### Método `main`

Este es el punto de entrada del programa, donde se define la cadena que se va a comprimir y se llama al método `comprimir` para obtener el resultado de la compresión.
```java
public static void main(String[] args) {
    String cadena = "abababcbdc";
    Par[] resultado = comprimir(cadena);

    System.out.println("\nCadena original: " + cadena);
    System.out.println("Compresión: ");
    for (Par p : resultado) {
        System.out.print(p + " ");
    }
}
````

### Proceso en el Método `main`

- Se define la cadena que se va a comprimir.
- Se llama al método `comprimir` para obtener la cadena comprimida y mostrarla por pantalla.
- Se imprime la cadena original y el resultado de la compresión, incluyendo los pares generados.
