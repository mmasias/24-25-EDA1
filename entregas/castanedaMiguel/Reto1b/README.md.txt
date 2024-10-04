https://docs.google.com/spreadsheets/d/12yrMFPe1NjFfiFnvadUEtdr_0ow-O8-VxnvfQ4L_NFk/edit?gid=0#gid=0


Reto 1: el orden
¿Cómo modificaría y/o expandiría esta estructura para representar este orden sin mover los elementos existentes?

El orden se puede formar con una columna nueva. Esa columna indicaría el dato al que hay que ir, indicado por su id.

Reto 2: prueba del orden
Con el planteamiento propuesto, establezca el orden a B -> C -> A.

Puedo hacerlo cambiando los valores en "siguiente".

Reto 3: eliminación
Después de resolver el reto 2, supongamos que deseamos "eliminar" el elemento B.
¿Cómo [se] reflejaría esta eliminación en su estructura?
¿Cómo quedaría reflejado el orden A -> C después de la eliminación?

Se quedaría como C->A
Se pueden intercambiar los valores de “siguiente” para formar A->C

Reto 4: la escabilidad
¿Cómo maneja su solución la inserción de estos nuevos elementos en el orden A -> D -> E, respetando la regla de que físicamente siempre se agregan al final?
Después de "eliminar" C, ¿cómo representaría el nuevo orden A -> D -> E en su estructura?

No habría problema porque me fijo en el id y no en la fila para indicar el orden.

Reto 5: la flexibilidad
Reflexione sobre cómo su solución maneja la combinación de agregar nuevos elementos al final, eliminar elementos existentes y mantener un orden específico.

La agregación de elementos no sería un problema.
Tendría problemas al eliminar elementos en medio del orden completo.
Tampoco se podría mantener un orden específico.

2Think
¿Qué ventajas ofrece su solución en comparación con simplemente reordenar o eliminar físicamente los elementos?

Reordenarlo puede llevar un tiempo sumamamente innecesario, ya que es buscar y recolocar constantemente.

¿Puede identificar alguna desventaja en su enfoque?
Podría haber más de un orden por error.

¿Se le ocurre algún ejemplo de la vida real donde este tipo de estructura con adición secuencial, eliminación y reordenación podría ser útil?
Quizas a la hora de manerar cualquier especie de cola con mayor facilidad.
