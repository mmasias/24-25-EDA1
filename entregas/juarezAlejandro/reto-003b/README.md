# Documentación del reto 003 de Celia Becerril

[Link hacia el repo de Celia](https://github.com/mmasias/24-25-EDA1/blob/c5d978446ff1b6a80d0d296ed2e5b4e08ffc9fc9/entregas/BecerrilCelia/Reto003/comprimir.java)

- Es una sola clase la que se crea, llamada comprimir. - [Clase comprimir](https://github.com/mmasias/24-25-EDA1/blob/c5d978446ff1b6a80d0d296ed2e5b4e08ffc9fc9/entregas/BecerrilCelia/Reto003/comprimir.java#L5)

- Se crea un bucle que sea menor que la distancia de la cadena y luego, al iniciar, se posiciona en el diccionario, para luego buscarla. - [Creación bucle](https://github.com/mmasias/24-25-EDA1/blob/c5d978446ff1b6a80d0d296ed2e5b4e08ffc9fc9/entregas/BecerrilCelia/Reto003/comprimir.java#L14). [Busca la palabra](https://github.com/mmasias/24-25-EDA1/blob/c5d978446ff1b6a80d0d296ed2e5b4e08ffc9fc9/entregas/BecerrilCelia/Reto003/comprimir.java#L17)

- Al momento de comprimir la cadena, se utiliza un array para poder crear el diccionario en dado caso no se encuentre la letra dentro del mismo. - [Crea array del diccionario](https://github.com/mmasias/24-25-EDA1/blob/c5d978446ff1b6a80d0d296ed2e5b4e08ffc9fc9/entregas/BecerrilCelia/Reto003/comprimir.java#L8)

- Se inicializa un arreglo de cadenas (diccionario) para almacenar secuencias encontradas y un índice (indice) para rastrear la posición del último elemento agregado. - [Inicializa](https://github.com/mmasias/24-25-EDA1/blob/c5d978446ff1b6a80d0d296ed2e5b4e08ffc9fc9/entregas/BecerrilCelia/Reto003/comprimir.java#L10)

- Se utiliza un búfer (buffer) para almacenar temporalmente la secuencia de caracteres actual que se está explorando. -[Buffer](https://github.com/mmasias/24-25-EDA1/blob/c5d978446ff1b6a80d0d296ed2e5b4e08ffc9fc9/entregas/BecerrilCelia/Reto003/comprimir.java#L15)

- El buffer almacena hasta el penúltimo carácter, debido a que se supone que el prefijo ya debería de estár y el último caracter se agrega [Penúltimo](https://github.com/mmasias/24-25-EDA1/blob/c5d978446ff1b6a80d0d296ed2e5b4e08ffc9fc9/entregas/BecerrilCelia/Reto003/comprimir.java#L26)

- Se añade el nuevo carácter [Añadir](https://github.com/mmasias/24-25-EDA1/blob/c5d978446ff1b6a80d0d296ed2e5b4e08ffc9fc9/entregas/BecerrilCelia/Reto003/comprimir.java#L31)

- Se crea el método de descomprimir y se vuelve a crear un diccionario nuevo (Cosa que no entiendo, el porqué no se reutiliza el anterior) lineas 55 y 56 [Descomprimir](https://github.com/mmasias/24-25-EDA1/blob/c5d978446ff1b6a80d0d296ed2e5b4e08ffc9fc9/entregas/BecerrilCelia/Reto003/comprimir.java#L55)

- Método estático que se encarga de buscar la palabra y si no se encuentra se agrega al siguiente al diccionario [Método de diccionario](https://github.com/mmasias/24-25-EDA1/blob/c5d978446ff1b6a80d0d296ed2e5b4e08ffc9fc9/entregas/BecerrilCelia/Reto003/comprimir.java#L85)

- Se manda a llamar en un método estático a lo principal, que compila (Lo cual, tengo entendido que no sería correcto, ya que lo principal sería crear lo más importante luego mande a llamar) [Principal](https://github.com/mmasias/24-25-EDA1/blob/c5d978446ff1b6a80d0d296ed2e5b4e08ffc9fc9/entregas/BecerrilCelia/Reto003/comprimir.java#L94)
