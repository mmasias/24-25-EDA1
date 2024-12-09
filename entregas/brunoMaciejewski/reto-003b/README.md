# Documentación Reto 003 Alex Borja
|Indice|
|-|
|[Compressor](#compressor)|
|▪️ [compress](#public-string-compressstring-str)|
|▪️ [getDictionary](#public-dictionary-getdictionary)|
|[Decompressor](#decompressor)
|▪️ [decompress](#public-string-decompressstring-compressed-dictionary-dictionary)|
|[Main](#Main)|


## Compressor
### [Código](https://github.com/alex-borja/24-25-EDA1/blob/4950838b0d73e996b809b755a7f5c292ce6cc634/entregas/AlexBorja/retos/Reto-003/Compressor.java)

Esta clase guarda como atributos un diccionario y una secuencia.
Tiene los métodos públicos comprimir y devolver el diccionario
### public String compress(String str)
Este método recibe una cadena y devuelve la cadena comprimida
### public Dictionary getDictionary()
Este método devuelve el diccionario que guarda la clase como atributo
## Decompressor
### [Código](https://github.com/alex-borja/24-25-EDA1/blob/d22856c42e4027d174e1ca3a63d3f9f6d35ceef9/entregas/AlexBorja/retos/Reto-003/Decompressor.java)

Esta clase guarda dos constantes que usa para acceder a las posiciones donde deberían estar el indice y el caracter del primer segmento de la cadena comprimida
### public String decompress(String compressed, Dictionary dictionary)
Este método recibe una cadena y un diccionario y devuelve la cadena descomprimida

## Main
### [Código](https://github.com/alex-borja/24-25-EDA1/blob/d22856c42e4027d174e1ca3a63d3f9f6d35ceef9/entregas/AlexBorja/retos/Reto-003/Main.java)
Esta clase instancia un compresor y le pasa una cadena e imprime el resultado,
luego instancia un descompresor, le pasa la cadena comprimida e imprime el resultado