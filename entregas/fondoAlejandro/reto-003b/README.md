https://github.com/inigovaqueroo04/24-25-EDA1/blob/12e446e4df79759ac111acf18c9d8d261817a5c7/entregas/vaqueroInigo/reto003/Compresor.java#L1


Primero se importan Arraylist y List para manejar colecciones de elementos y el Scanner para leer la entrada del usuario.

Define la clase Compresor y dentro de ella la clase interna Resultado, que se usa para almacenar el string comprimido y el diccionario.

Define el método comprime que toma como entrada una cadena.

Se inicializa la lista diccionario y la lista resultadoComprimido y la posicionActual para rastrear la posición en la cadena original.

Crea un bucle while para procesar todos los caracteres de la cadena y se inicializan ventanaBusqueda, coincidenciaMasLarga y indiceCoincidencia para buscar coincidencias en el diccionario.

Para la busqueda de coincidencias, se utiliza un bucle anidado para buscar la más larga y va construyendo ventanaBusqueda añadiendo caracteres desde la posición actual y, si se encuentra coincidencias, se actualizan coincidenciaMasLarga y indiceCoincidencia. Si no las hay y se ha superado posicionActual se sale del bucle.

Para la generación del resultado comprimido, si se encontró una coincidencia, se añade un par (índice, nuevo carácter) a resultadoComprimido y se actualiza el diccionario. Si no se encontró coincidencia, se añade el carácter actual como (0, carácter) y se incrementa posicionActual para continuar con la siguiente parte de la cadena.

Para la cración del resultado final, se convierte la lista diccionario a un array. Se crea el string comprimido uniendo todos los elementos de resultadoComprimido y se devuelve un objeto Resultado con la cadena comprimida y el diccionario.

Dentro del método main, se inicializa un objeto Scanner para leer la entrada del usuario. Se le pide al usuario que ingrese una cadena para comprimir y se llama al método comprime, que imprime el resultado comprimido y el diccionario.
