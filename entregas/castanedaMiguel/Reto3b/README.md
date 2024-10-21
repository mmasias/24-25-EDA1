El objetivo era comprimir texto y recibir tanto la forma comprimida como el diccionario

Clases

Compressor.java

El compresor contiene un array para el último valor leído y el diccionario. Con el método de la clase se forma el diccionario y se devuelve el String de la compresión.

compress(String) es el método principal, y hace varios pasos sucesivamente:

-Extrae un valor del string
https://github.com/alex-borja/24-25-EDA1/blob/4950838b0d73e996b809b755a7f5c292ce6cc634/entregas/AlexBorja/retos/Reto-003/Compressor.java#L24
-Comprueba si el valor está en el diccionario, sino lo almacena en lastKnownSequence para leerlo en el próximo ciclo

https://github.com/alex-borja/24-25-EDA1/blob/4950838b0d73e996b809b755a7f5c292ce6cc634/entregas/AlexBorja/retos/Reto-003/Compressor.java#L7

-Si lastKnownSequence contiene algo, se trata como en el paso anterior pero con la union de lastKnownSequence y el valor.

-Devuelve el valor resultante

Dictionary.java

Contiene un array y tres métodos para añadir al diccionario, buscar en el diccionario y obtener el diccionario (add, is y get). Tambien hay un getSequenceByIndex el cual entiendo que es para obtener un único valor del diccionario.


