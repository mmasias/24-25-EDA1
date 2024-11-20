# Codigo Reto003 Bruno Maciejewski explicado

Este código implementa un algoritmo de compresión basado en un diccionario. Comprime cadenas transformándolas en segmentos de la forma (índice, carácter) donde el índice refiere a un segmento previamente visto. Para la descompresión, reconstruye la cadena original utilizando el diccionario. Se usan cuatro clases principales: Compressor , Dictionary, DictionaryElement  y Main.

## Clase Compressor:
- [Linea 3](https://github.com/Bruno-MBl/24-25-EDA1/blob/94c26f93e35b949301ec59ab50be2f8ef65fc65d/entregas/brunoMaciejewski/reto-003/Compressor.java#L3): zip() recorre la cadena de entrada, creando segmentos y utilizando un diccionario para comprimir.

- [Linea 30](https://github.com/Bruno-MBl/24-25-EDA1/blob/94c26f93e35b949301ec59ab50be2f8ef65fc65d/entregas/brunoMaciejewski/reto-003/Compressor.java#L30): unzip() descomprime una cadena comprimida utilizando un diccionario para reconstruir la original.

## Clase Diccionary:
- [Linea 9](https://github.com/Bruno-MBl/24-25-EDA1/blob/94c26f93e35b949301ec59ab50be2f8ef65fc65d/entregas/brunoMaciejewski/reto-003/Dictionary.java#L9): getSegmentIndex() busca un segmento en el diccionario y devuelve su índice, o 0 si no lo encuentra.

- [Linea 21](https://github.com/Bruno-MBl/24-25-EDA1/blob/94c26f93e35b949301ec59ab50be2f8ef65fc65d/entregas/brunoMaciejewski/reto-003/Dictionary.java#L21): addElement() añade un nuevo segmento al diccionario.

## Clase DictionaryElement:
- [Linea 6](https://github.com/Bruno-MBl/24-25-EDA1/blob/94c26f93e35b949301ec59ab50be2f8ef65fc65d/entregas/brunoMaciejewski/reto-003/DictionaryElement.java#L6): Constructor, inicializa un nuevo elemento del diccionario con un índice y un segmento.

- Linea [11](https://github.com/Bruno-MBl/24-25-EDA1/blob/94c26f93e35b949301ec59ab50be2f8ef65fc65d/entregas/brunoMaciejewski/reto-003/DictionaryElement.java#L11) y [14](https://github.com/Bruno-MBl/24-25-EDA1/blob/94c26f93e35b949301ec59ab50be2f8ef65fc65d/entregas/brunoMaciejewski/reto-003/DictionaryElement.java#L14): getElement() y getIndex() devuelven el segmento y su índice respectivamente.

## Clase Main:
- [Main](https://github.com/Bruno-MBl/24-25-EDA1/blob/94c26f93e35b949301ec59ab50be2f8ef65fc65d/entregas/brunoMaciejewski/reto-003/Main.java#L1): Prueba el proceso de compresión y descompresión, imprimiendo los resultados.