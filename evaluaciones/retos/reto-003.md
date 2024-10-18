# Reto 003

A continuación se describe un algoritmo de compresión, que trabaja sobre la cadena `abababc`

| Paso | Cadena | Posición actual | Ventana de búsqueda | Coincidencia más larga | Salida | Diccionario después |
|-|-|-|-|-|-|-|
| 1 | a̲bababc | 0 | a | - | (0,a) | 1: a |
| 2 | ab̲ababc | 1 | b | - | (0,b) | 1: a, 2: b |
| 3 | aba̲babc | 2 | a | a (índice 1) | - | 1: a, 2: b |
| 4 | abab̲abc | 3 | ab | a (índice 1) | (1,b) | 1: a, 2: b, 3: ab |
| 5 | ababa̲bc | 4 | a | a (índice 1) | - | 1: a, 2: b, 3: ab |
| 6 | ababab̲c | 5 | ab | ab (índice 3) | - | 1: a, 2: b, 3: ab |
| 7 | abababc̲ | 6 | abc | ab (índice 3) | (3,c) | 1: a, 2: b, 3: ab, 4: abc |

- **Diccionario:** 1:a, 2:b, 3:ab, 4:abc
- **Resultado comprimido:** (0,a)(0,b)(1,b)(3,c)

## Reto

Desarrolle el método `.comprime(String cadena)` que devuelva el resultado comprimido y el diccionario utilizado para comprimirlo.

