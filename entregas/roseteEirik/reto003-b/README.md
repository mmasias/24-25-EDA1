## Explicación paso a paso: Solución de reto 003 de Alex Borja

[\[Link al repositorio\]](https://github.com/alex-borja/24-25-EDA1/tree/4950838b0d73e996b809b755a7f5c292ce6cc634/entregas/AlexBorja/retos/Reto-003)

### [Compressor class](https://github.com/alex-borja/24-25-EDA1/blob/4950838b0d73e996b809b755a7f5c292ce6cc634/entregas/AlexBorja/retos/Reto-003/Compressor.java#L1)

| Función | Explicación |
|---------|-------------|
| _public String compress(String str)_ | Comprime una secuencia de caracteres |
| _public Dictionary getDictionary()_ | Muestra el diccionario de caracteres |

### [Decompressor class](https://github.com/alex-borja/24-25-EDA1/blob/fb028b5b5ebf52654bcdce07bf11204d4f3f7159/entregas/AlexBorja/retos/Reto-003/Decompressor.java#L1)

| Función | Explicación |
|---------|-------------|
| _public String decompress(String compressed, Dictionary dictionary)_ | Decomprime una secuencia de caracteres a partir del index del diccionario |

### [Dictionary class](https://github.com/alex-borja/24-25-EDA1/blob/fb028b5b5ebf52654bcdce07bf11204d4f3f7159/entregas/AlexBorja/retos/Reto-003/Dictionary.java#L1)

| Función | Explicación |
|---------|-------------|
| _public int getIndexOfSequence(String sequence)_ | Obtiene el número donde se encuentra cierta secuencia |
| _public void addToDictionary(String sequence)_ | Añade al diccionario los elementos de la secuencia |
| _public boolean isOnDictionary(String sequence)_ | Identifica si el diccionario tiene una secuencia de caracteres |
| _public String getDictionary()_ | Muestra el diccionario de caracteres |
| _public String getSequenceByIndex(int idx)_ | Obtiene la secuencia de caracteres a partir de un número |

### [Main class](https://github.com/alex-borja/24-25-EDA1/blob/fb028b5b5ebf52654bcdce07bf11204d4f3f7159/entregas/AlexBorja/retos/Reto-003/Main.java#L1)

| Función | Explicación |
|---------|-------------|
| _ public static void main(String[] args)_ | Ejecuta el código con un ejemplo |

### Observaciones

- Falta de dinamismo: En la clases de Decompressor y Dictionary:
   - En Decompressor al querer encontrar un número de dos dígitos, puede fallar debido a que la posición del index, de donde se obtiene la secuencia de caracteres, es de solo un dígito.
   - En Dictionary hay un límite de caracteres de 100.

En general, es un código limpio y sencillo de comprender, aunque puede tener ciertos inconvenientes al hacer un uso a gran escala.