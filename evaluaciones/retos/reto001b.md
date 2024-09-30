# El orden (y otras cosas)

Tenemos la siguiente información almacenada en una estructura secuencial:

<div align=center>

|ID|DATO|
|:-:|:-:|
|1|`A`|
|2|`B`|
|3|`C`|

</div>

> [*Enlace a hoja de cálculo*](https://docs.google.com/spreadsheets/d/18YAThWriTL3Dxw9TA8TDU8k5MtkDdbMYCkAH3eaW_XI/edit?usp=sharing)

Características importantes:

- En caso de aparecer nuevos elementos, siempre se agregan al final de la estructura.
- El ID es un número entero que se incrementa automáticamente para cada nuevo elemento.

## Reto 1: el orden

Supongamos que queremos establecer el siguiente orden: `A` -> `C` -> `B`.

¿Cómo modificaría y/o expandiría esta estructura para representar este orden **sin mover** los elementos existentes?

## Reto 2: prueba de *el orden*

Con el planteamiento propuesto, establezca el orden a `B` -> `C` -> `A`.

*NOTA:* A partir de aquí, y para cada uno de los puntos siguientes, si le hace falta, adapte el planteamiento respetando las consideraciones anteriores.

## Reto 3: la eliminación

Después de resolver el reto 2, supongamos que deseamos "eliminar" el elemento `B`.

- ¿Cómo [*se*] reflejaría esta eliminación en su estructura?
- ¿Cómo quedaría reflejado el orden `A` -> `C` después de la eliminación?

## Reto 4: la escalabilidad

Ahora, agregamos dos nuevos elementos:

<div align=center>

|ID|DATO|
|:-:|:-:|
|4|`D`|
|5|`E`|

</div>

Y luego, eliminamos `C`

- ¿Cómo maneja su solución la inserción de estos nuevos elementos en el orden `A` -> `D` -> `E`, respetando la regla de que físicamente siempre se agregan al final?
- Después de "eliminar" `C`, ¿cómo representaría el nuevo orden `A` -> `D` -> `E` en su estructura?

## Reto 5: la flexibilidad

Reflexione sobre cómo su solución maneja la combinación de agregar nuevos elementos al final, eliminar elementos existentes y mantener un orden específico.

## 2***Think***

- ¿Qué ventajas ofrece su solución en comparación con simplemente reordenar o eliminar físicamente los elementos?
- ¿Puede identificar alguna desventaja en su enfoque?
- ¿Cómo afecta la eliminación de elementos a la eficiencia de su solución para recorrer la lista en orden?
- ¿Se le ocurre algún ejemplo de la vida real donde este tipo de estructura con adición secuencial, eliminación y reordenación podría ser útil?

## Bonus

Piense en cómo podría modificar su solución para permitir recorrer los elementos en ambas direcciones (adelante y atrás), manteniendo las restricciones de adición al final y la posibilidad de eliminación.
