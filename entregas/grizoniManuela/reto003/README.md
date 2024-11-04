# [Documentación](https://github.com/celiabecerril/24-25-EDA1/blob/c5d978446ff1b6a80d0d296ed2e5b4e08ffc9fc9/entregas/BecerrilCelia/Reto003/comprimir.java)



- [El método comprimir cadena](https://github.com/celiabecerril/24-25-EDA1/blob/c5d978446ff1b6a80d0d296ed2e5b4e08ffc9fc9/entregas/BecerrilCelia/Reto003/comprimir.java#L7) implementa el proceso de compresión de la cadena. 
- Se declara un dicionario hecho con un array de strings para almacenar las secuencias de caracteres.
- Usa el StringBuilder para construir la cadena comprimida.
- El buffer se usa para almacenar la secuencia de caracteres de cada iteración. 
-indice es un contador para contar las entradas en el diccionario.  
- El bucle while recorre la cadena, buscar en el diccionario con buscarEnDiccionario, si está en el diccionario adiciona un caracter. Si no está en el diccionario pone un resultado (0, carácter) y volver a buscar.



- [El método descomprimir](https://github.com/celiabecerril/24-25-EDA1/blob/c5d978446ff1b6a80d0d296ed2e5b4e08ffc9fc9/entregas/BecerrilCelia/Reto003/comprimir.java#L55) toma la cadena comrpimida y la descomprime 
- En el (índice, carácter), si el índice es 0, el carácter es nuevo y se añade al resultado y al diccionario. Si es mayor que 0, se concatena la secuencia en el diccionario en la posición indice - 1 con el carácter


- [El método buscarEn Diccionario](https://github.com/celiabecerril/24-25-EDA1/blob/c5d978446ff1b6a80d0d296ed2e5b4e08ffc9fc9/entregas/BecerrilCelia/Reto003/comprimir.java#L85) busca una secuencia en el diccionario y devuelve su posición o -1 si no se encuentra 