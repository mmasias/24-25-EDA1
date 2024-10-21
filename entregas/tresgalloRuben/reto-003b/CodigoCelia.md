 [Codigo Celia](https://github.com/celiabecerril/24-25-EDA1/blob/c5d978446ff1b6a80d0d296ed2e5b4e08ffc9fc9/entregas/BecerrilCelia/Reto003/comprimir.java)

# 📄 **Documentación de Celia**

## 🛠️ **Clase** `comprimir`

La clase implementa un algoritmo de compresión y descompresión de cadenas basado en el esquema **LZ78**. Se comprime la cadena en pares `(índice, caracter)` y se descomprime reconstruyendo la cadena original.

---

### 📋 **Métodos Principales**

| **Método**                                                      | **Descripción**                                                             |
| ---------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `comprimirCadena(String cadena)`                                 | Comprime una cadena en pares `(índice, caracter)`.                          |
| `descomprimir(String comprimida)`                                | Descomprime la cadena comprimida en su formato original.                    |
| `buscarEnDiccionario(String[] diccionario, int limite, String secuencia)` | Busca una subcadena en el diccionario y devuelve su índice o `-1` si no está.|

---

### 🔑 **Método:** `comprimirCadena(String cadena)`

Este método toma una cadena original y la comprime generando pares `(índice, caracter)`.

| **Entrada**           | `String cadena` - La cadena que se desea comprimir.              |
| --------------------- | ---------------------------------------------------------------- |
| **Salida**            | Cadena comprimida en el formato `(índice, caracter)`.            |

#### 📝 **Proceso**:

1. **Inicialización**: Se utiliza un diccionario vacío.
2. **Búsqueda**: Se buscan subcadenas ya vistas en el diccionario.
3. **Compresión**: Si la subcadena no está en el diccionario, se añade y se genera un par `(índice, caracter)`.
4. **Resultado**: Devuelve la cadena comprimida.

#### 📘 **Ejemplo**:

```java
comprimirCadena("ABABABABA"); 
// Resultado: "(0,A)(0,B)(1,B)(2,A)(3,B)(4,A)"
```

---

### 🔑 **Método:** `descomprimir(String comprimida)`

Este método toma una cadena comprimida en el formato `(índice, caracter)` y la convierte nuevamente en la cadena original.

| **Entrada**           | `String comprimida` - La cadena comprimida.                       |
| --------------------- | ---------------------------------------------------------------- |
| **Salida**            | Cadena original descomprimida.                                    |

#### 📝 **Proceso**:

1. **Lectura**: Se leen los pares `(índice, caracter)`.
2. **Reconstrucción**: Usando el diccionario, se reconstruyen las subcadenas originales.
3. **Resultado**: Devuelve la cadena descomprimida.

#### 📘 **Ejemplo**:

```java
descomprimir("(0,A)(0,B)(1,B)(2,A)(3,B)(4,A)"); 
// Resultado: "ABABABABA"
```

---

### 🔑 **Método:** `buscarEnDiccionario(String[] diccionario, int limite, String secuencia)`

Busca si una subcadena existe en el diccionario hasta un límite dado. Si la subcadena se encuentra, retorna su índice; si no, retorna `-1`.

| **Entrada**           | `String[] diccionario`, `int limite`, `String secuencia`          |
| --------------------- | ---------------------------------------------------------------- |
| **Salida**            | Índice de la subcadena en el diccionario, o `-1` si no se encuentra.|
