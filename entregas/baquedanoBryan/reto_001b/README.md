# Aproximación del ejercicio

## Contexto del problema
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


## Reto 1: Supongamos que queremos establecer el siguiente orden: A -> C -> B.

¿Cómo modificaría y/o expandiría esta estructura para representar este orden sin mover los elementos existentes?

- Yo lo haría de la siguiente manera: 
    - Crearía una tabla con dos columnas más que guarden la pocisión del siguiente y del anterior.

    | Id | Dato | Anterior | Siguiente |
    |----|----------|----|----|
    | 1    | A   | null   | 3   |
    | 2    | B   |  3  | null   |
    | 3    | C   |  1  | 2  |

## Reto 2: prueba de el orden
Con el planteamiento propuesto, establezca el orden a B -> C -> A. A partir de aquí, y para cada uno de los puntos siguientes, si le hace falta, adapte el planteamiento respetando las consideraciones anteriores.

- Yo haría lo mismo que anteriormente, solo actualizaría los valores de la tabla para que está tenga los valores correctos que hagan referencia al orden que se quiere alcanzar
    
    - Lo haría con la siguiente tabla:
    
    | Id | Dato | Anterior | Siguiente |
    |----|----------|----|----|
    | 1    | A   |   3 | null   |
    | 2    | B   |  null  | 3   |
    | 3    | C   |  2  | 1  |

    Algo importante de esta estructura, es que es fácil identificar al prumero y al último, ya que, el primero tendrá la columna de anterior null, y el último la columna de siguiente en null.

## Reto 3: la eliminación
Después de resolver el reto 2, supongamos que deseamos "eliminar" el elemento B.

¿Cómo [se] reflejaría esta eliminación en su estructura?
¿Cómo quedaría reflejado el orden A -> C después de la eliminación?

- Pues es muy sencillo, usando mi estructura, ya que queremos eliminarlo, lo que habría que hacer es que nadie apunte a él, lo que se vería reflejado así:

    | Id | Dato | Anterior | Siguiente |
    |----|----------|----|----|
    | 1    | A   |   null | 3   |
    | 2    | B   |  null  | null  |
    | 3    | C   |  1  | null  |

    Al estar B ámbos en null, su valor anterior y siguiente, pues sabemos que no tiene relación con nadie, porque debes al menos tener un valor anterior o siguiente para ser parte de la secuencia, como a B nadie lo esta "viendo", el garbage collecter se lo lleva y lo mata.

## Reto 4: la escalabilidad
Ahora, agregamos dos nuevos elementos:

| Id | Dato |
|----|----- |
| 4  | D   |
| 5  | E   |

Y luego, eliminamos C

¿Cómo maneja su solución la inserción de estos nuevos elementos en el orden A -> C -> D -> E, respetando la regla de que físicamente siempre se agregan al final?

- Pues esto, aunque parece algo díficil, no lo es, de hecho el que se tengan que agregar al final lo hace muy sencillo. Primero agregamos los dos registros a la tabla original

    | Id | Dato | Anterior | Siguiente |
    |----|----------|----|----|
    | 1    | A   |   null | 3   |
    | 2    | B   |  null  | null  |
    | 3    | C   |  1  | 4  |
    | 4    | D   |  3  | 5  |
    | 5    | E   |  4  | null  |


Después de "eliminar" C, ¿cómo representaría el nuevo orden A -> D -> E en su estructura?

- Aquí es dónde se encuentra la parte más difícil, al eliminar C, se ven afectados D y E, pero lo que se haría en este caso es que el que acabamos de eliminar, comprobamos el que esta relacionado anteriormente- en este caso "A"- y a ese específico le asignamos el valor siguiente del que acabamos de eliminar, la tabla quedaría de esta forma:

    | Id | Dato | Anterior | Siguiente |
    |----|----------|----|----|
    | 1    | A   |   null | 4   |
    | 2    | B   |  null  | null  |
    | 3    | C   |  null  | null  |
    | 4    | D   |  1  | 5  |
    | 5    | E   |  4  | null  |

## Reto 5: la flexibilidad
Reflexione sobre cómo su solución maneja la combinación de agregar nuevos elementos al final, eliminar elementos existentes y mantener un orden específico.

 - Creo que el comprobar el anterior y siguiente, es aún mas eficiente que solo comprobar uno de los dos, en este punto sabes exactamente a quien tienes detrás y adelante, eso hace fácil la eliminación de registros en medio de la relación. Y el agregar elementos al final, como ya se vió, es un trabajo sumamente sencillo para esta aproximación.







