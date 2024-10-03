## Enlace a mi solución
(https://docs.google.com/spreadsheets/d/1U4vNi8gRqaUJARYBYDfQJqqwVwuYKPPYItCzXKz01hE/edit?gid=1178866724#gid=1178866724)


## Solución Explicada
Yo implemente una nueva columna la cual indica el ID del siguinete elemento, por lo que cada elemento sabe su posición y quien esta después de ellos, de esta manera se sabrá cual elemento es el último por que esa columna estará vacía.

Con la eliminación, al eliminar un registro se tendra que actualizar el id del anterior o anteriores al registro eliminado, los posteriores no ya que como lo que importa es el elemento que les sigue.

Perfectamente se pueden agregar elementos al final de la tabla y nada más se editaria del penúltimo elemnto, osea el que antes era el último ya no estará vacia la columna que agregamos ya que ahora tendra un elemento despues.