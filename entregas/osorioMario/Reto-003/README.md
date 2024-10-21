# Extracto de lo que  le he dicho a chat gpt para hacer el codigo y lo que me ha respondido
- Dada la imagen A continuación se describe un algoritmo de compresión, que trabaja sobre la cadena abababc
# Paso Cadena 	Posición actual 	Ventana de búsqueda 	Coincidencia más larga 	Salida 	Diccionario después
   1 	a̲bababc 	0 	a 	- 	(0,a) 	1: a
   2 	ab̲ababc 	1 	b 	- 	(0,b) 	1: a, 2: b
   3 	aba̲babc 	2 	a 	a (índice 1) 	- 	1: a, 2: b
   4 	abab̲abc 	3 	ab 	a (índice 1) 	(1,b) 	1: a, 2: b, 3: ab
   5 	ababa̲bc 	4 	a 	a (índice 1) 	- 	1: a, 2: b, 3: ab
   6 	ababab̲c 	5 	ab 	ab (índice 3) 	- 	1: a, 2: b, 3: ab
   7 	abababc̲ 	6 	abc 	ab (índice 3) 	(3,c) 	1: a, 2: b, 3: ab, 4: abc

    Diccionario: 1:a, 2:b, 3:ab, 4:abc
    Resultado comprimido: (0,a)(0,b)(1,b)(3,c)

- Desarrolle el método .comprime(String cadena) que devuelva el resultado comprimido y el diccionario utilizado para comprimirlo.

## Respuesta dada por chat gpt

- Explicación del código:

- Estructuras de Datos Utilizadas:

  - diccionario: Map que relaciona subcadenas con índices.
  - diccionarioInverso: Map que relaciona índices con subcadenas, para mostrar el diccionario final.
  - salida: Lista de pares que representan el resultado comprimido.
  
- Algoritmo de Compresión:

 - Inicialización:
 - indiceDiccionario: Inicia en 1, se incrementa cada vez que se añade una nueva entrada al diccionario.
 - posicion: Posición actual en la cadena de entrada.
- Bucle Principal:
- Mientras posicion sea menor que la longitud de la cadena:
- Busca la coincidencia más larga que ya esté en el diccionario.
- Si no hay coincidencia, añade el carácter actual al diccionario y a la salida como (0, carácter).
- Si hay coincidencia y aún hay caracteres por procesar, añade (índiceCoincidencia, siguienteCarácter) a la salida y añade la nueva subcadena al diccionario.
- Si la coincidencia llega al final de la cadena, simplemente avanza la posición.
Salida:
- Devuelve un objeto Resultado que contiene la lista de pares comprimidos y el diccionario utilizado.
- Ejemplo con la cadena "abababc":

Salida comprimida: [(0,a), (0,b), (1,b), (3,c)]
Diccionario:
1: a
2: b
3: ab
4: abc
Esto coincide con el ejemplo proporcionado en el enunciado.

 - Nota: Este código está escrito en Java y puede ser ejecutado tal cual. Asegúrese de importar las clases necesarias y ejecutar el método main para ver el resultado.

 ### PD: hubiera preferido compartir la conversacion pero chatgpt no deja compartir conversaciones con imagenes