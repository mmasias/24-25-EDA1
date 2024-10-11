
> [*Enlace a hoja de cálculo del reto*](https://docs.google.com/spreadsheets/d/1vY2KAMWSkYjN98Rl1JMyZNe7k7agMx1-yrgAgAZna6Q/edit?usp=sharing)

**Reto 1 y 2**  
Se ha agregado una nueva columna que indica la secuencia de cada número en relación con el anterior. El valor 0 en esta columna señala el inicio de la secuencia. Los números siguientes en esta columna corresponden al ID o índice del número anterior en la secuencia. Esto permite reconstruir el orden de los elementos o identificar cómo están relacionados entre sí.

**Reto 3: La eliminación**  
Siguiendo el mismo formato propuesto, se identifica que un elemento está eliminado cuando es -1.

**Reto 4: La escalabilidad**  
Siguiendo lo anteriormente mencionado, se elimina el dato con valor -1 y se aplica el formato adecuado con el objetivo de relacionar únicamente los elementos solicitados.

**Reto 5: la flexibilidad**  
La combinación de agregar nuevos elementos al final, eliminar elementos existentes y mantener un orden específico plantea varios desafíos, pero también ofrece oportunidades para crear estructuras eficientes y flexibles.

**2Think**  
1. ¿Qué ventajas ofrece su solución en comparación con simplemente reordenar o eliminar físicamente los elementos?

La solución que planteo (donde se usa una secuencia o referencia entre los elementos en lugar de simplemente reordenarlos o eliminarlos físicamente) ofrece varias ventajas:

- Menor complejidad en las operaciones
- Preservación del historial o estructura
- Mayor flexibilidad

2. ¿Puede identificar alguna desventaja en su enfoque?

Sí, como mayor uso de memoria, si mantienes referencias a los elementos anteriores en lugar de eliminarlos completamente, estarás ocupando más memoria, pero esto solo se tomaría en cuenta si se programara.

3. ¿Cómo afecta la eliminación de elementos a la eficiencia de su solución para recorrer la lista en orden?

- Eliminación física: Si eliminas físicamente los elementos (es decir, eliminarlos de la estructura de datos), la eficiencia de recorrer la lista puede verse afectada si los elementos están dispersos o fragmentados. La eliminación podría requerir compactar la lista, lo que es costoso.

- Marcado de eliminación (sin borrado físico): Si solo marcas los elementos como eliminados y los "saltas" durante el recorrido, puedes mantener la eficiencia al recorrer la lista, pero esto requeriría más trabajo en la gestión de las referencias o índices de los elementos eliminados.

4. ¿Se le ocurre algún ejemplo de la vida real donde este tipo de estructura con adición secuencial, eliminación y reordenación podría ser útil?
Sí, este tipo de estructura es útil en sistemas de control de versiones como en Git, se crean "commits" secuenciales donde cada uno apunta al anterior. Aunque los cambios o eliminaciones de archivos no se borran físicamente del repositorio, se pueden recorrer las versiones anteriores y recuperar el historial completo.

**Bonus** ¿Cómo podría modificar su solución para permitir recorrer los elementos en ambas direcciones (adelante y atrás), manteniendo las restricciones de adición al final y la posibilidad de eliminación?

Para permitir el recorrido en ambas direcciones, se puede modificar la estructura de datos para que cada elemento contenga:

Referencia al elemento anterior (como está actualmente)
Referencia al elemento siguiente (agregando un puntero o referencia adicional)