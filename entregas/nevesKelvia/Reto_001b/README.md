# Solución de los Retos

## Reto 1: El orden

Se establece el orden: `A -> C -> B`.

### Solución:

Manteniendo los elementos en su lugar, usé una lista de referencias por ID para representar el nuevo orden:

1. El nuevo orden sería `1 -> 3 -> 2` (A -> C -> B).

Enlace a la hoja de cálculo:

[Reto_1](https://docs.google.com/spreadsheets/d/1gwnUO32EMNt-OIX8mieZ0NJMMjg1BTzQAYFWFFeXwlY/edit?hl=es&gid=0#gid=0)

## Reto 2: Prueba de *el orden*

Para establecer el orden: `B -> C -> A`.

### Solución:

Reorganizé la lista de referencias de ID para representar este nuevo orden:

1. El nuevo orden sería `2 -> 3 -> 1` (B -> C -> A).

Enlace a la hoja de cálculo:

[Reto_2](https://docs.google.com/spreadsheets/d/1gwnUO32EMNt-OIX8mieZ0NJMMjg1BTzQAYFWFFeXwlY/edit?hl=es&gid=1398488876#gid=1398488876)

## Reto 3: La eliminación

Eliminación del elemento `B`.

### Solución:

1. Eliminé la referencia al ID 2 (`B`) en la lista de orden lógico.
2. Si queremos el orden `A -> C`, la lista de referencias sería `1 -> 3`.

Enlace a la hoja de cálculo:

[Reto_3](https://docs.google.com/spreadsheets/d/1gwnUO32EMNt-OIX8mieZ0NJMMjg1BTzQAYFWFFeXwlY/edit?hl=es&gid=1731596540#gid=1731596540)

## Reto 4: La escalabilidad

Se agrega dos nuevos elementos `D` y `E` y luego se elimina `C`.

### Solución:

1. Los nuevos elementos se agregan al final con los IDs 4 (`D`) y 5 (`E`).
2. Eliminé la referencia al ID 3 (`C`).
3. El nuevo orden sería `1 -> 4 -> 5` (A -> D -> E).

Enlace a la hoja de cálculo:

[Reto_4](https://docs.google.com/spreadsheets/d/1gwnUO32EMNt-OIX8mieZ0NJMMjg1BTzQAYFWFFeXwlY/edit?hl=es&gid=1791620123#gid=1791620123)

## Reto 5: La flexibilidad

### Para agregar nuevos elementos

Se añaden físicamente los elementos al final, pero su posición en el orden lógico puede ser ajustada en la lista de referencias.

### Para la eliminación de elementos existentes

Solo se elimina la referencia del elemento, manteniéndolo físicamente en la estructura.

### Para mantener un orden específico

Se controla mediante la lista de referencias, permitiendo un orden flexible e independiente del almacenamiento físico.

### Ventajas:

- No es necesario mover los elementos físicamente para reordenarlos.
- La eliminación de elementos no afecta su existencia física, por lo que se pueden recuperar si es necesario.
- Mantener un orden lógico flexible es simple usando una lista de referencias.

### Desventajas:

- Se necesita una estructura adicional para las referencias, lo que consume más memoria.
- La complejidad puede aumentar a medida que se agregan más elementos y se eliminan otros.

### Impacto de la eliminación:

La eliminación de elementos solo afecta el orden lógico, lo que implica que las búsquedas en este orden pueden verse afectadas, pero la eficiencia de la inserción no se altera.

### Aplicaciones en la vida real:

Este tipo de estructura es útil en casos como:
- Sistemas de gestión de tareas con prioridades cambiantes.
- Listas de reproducción de música que pueden ser reordenadas sin afectar el orden de adición.
- Sistemas de mensajería donde se manejan respuestas en diferentes órdenes.

## Bonus: Recorrido bidireccional

Para recorrer los elementos en ambas direcciones (adelante y atrás), usé una **lista doblemente enlazada** para representar el orden lógico. Esto permitirá ir de un nodo al siguiente o al anterior sin modificar la regla de adición secuencial al final.

Enlace a la hoja de cálculo:

[Reto_Bonus](https://docs.google.com/spreadsheets/d/1gwnUO32EMNt-OIX8mieZ0NJMMjg1BTzQAYFWFFeXwlY/edit?hl=es&gid=1772551828#gid=1772551828)
