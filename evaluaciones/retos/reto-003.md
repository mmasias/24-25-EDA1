# Reto 003

> Basado en el algoritmo de Lempel Ziv y Welch, o abreviadamente (y como mejor se le conoce) Algoritmo LZW, algoritmo de compresión sin pérdidas basado en diccionario. ***[Wikipedia](https://es.wikipedia.org/wiki/LZW)***

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

Desarrolle el método `.comprime(String cadena)` que devuelva el resultado comprimido y el diccionario utilizado para comprimirlo. Use el  método en un programa que devuelva una salida como la presentada a continuación:

```text
c:\>Comprimir

Ingrese la cadena a comprimir:
abababc

El resultado comprimido es:
  (0,a)(0,b)(1,b)(3,c)
El diccionario es:
 1:a
 2:b
 3:ab
 4:abc

```


![](https://private-user-images.githubusercontent.com/144820426/377839705-2cc8120d-2c06-4905-ab5c-875e9d267ded.jpeg?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MjkyNDkzNjgsIm5iZiI6MTcyOTI0OTA2OCwicGF0aCI6Ii8xNDQ4MjA0MjYvMzc3ODM5NzA1LTJjYzgxMjBkLTJjMDYtNDkwNS1hYjVjLTg3NWU5ZDI2N2RlZC5qcGVnP1gtQW16LUFsZ29yaXRobT1BV1M0LUhNQUMtU0hBMjU2JlgtQW16LUNyZWRlbnRpYWw9QUtJQVZDT0RZTFNBNTNQUUs0WkElMkYyMDI0MTAxOCUyRnVzLWVhc3QtMSUyRnMzJTJGYXdzNF9yZXF1ZXN0JlgtQW16LURhdGU9MjAyNDEwMThUMTA1NzQ4WiZYLUFtei1FeHBpcmVzPTMwMCZYLUFtei1TaWduYXR1cmU9NDNhZDFjZjcwZjFiMDIzNzViNmU5MGRmNTNhZjU1Nzk3OWMwOGQxNjZhYzU1NjY2YTMyYTlmZjA2ODZjN2ZkZSZYLUFtei1TaWduZWRIZWFkZXJzPWhvc3QifQ.DeyBBwqJvBBRT1kCBD1-pH4irEW4ZbHir4dx5YMrjHQ)
