# Aproximación del ejercicio

## Parte #1
Supongamos que tenemos la siguiente tabla con registros:

| Id | Dato | 
|----------|----------|
| 1    | A   |
| 2    | B   |
| 3    | C   | 

Características importantes:

- En caso de aparecer nuevos elementos, siempre se agregan al final de la estructura.


- El ID es un número entero que se incrementa automáticamente para cada nuevo elemento.

Ejemplo:

| Id | Dato | 
|----------|----------|
| 1    | A   |
| 2    | B   |
| 3    | C   | 
| **4**    | **D**   | 


## Supongamos que queremos establecer el siguiente orden: A -> C -> B.

¿Cómo modificaría y/o expandiría esta estructura para representar este orden sin mover los elementos existentes?

- Yo lo haría de la siguiente manera: 
    - Crearía una tabla con dos columnas más que guarden la pocisión del siguiente y del anterior.

    | Id | Dato | Anterior | Siguiente |
    |----|----------|----|----|
    | 1    | A   | A   | A   |
    | 2    | B   | A   | A   |
    | 3    | C   |  A  | A   |
    | **4**| **D**   | A   | A   | 



