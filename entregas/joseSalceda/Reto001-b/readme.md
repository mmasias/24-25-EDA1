-Retos del 1 al 4: (https://docs.google.com/spreadsheets/d/1uygR7vOtfnCLRYdraGJdlnRCjhYzO8ZQc6hqSSqEy_o/edit?usp=sharing)

# Reto 5: La Flexibilidad

## Ventajas

1.  **Historial completo**: Mantiene todos los elementos, incluso los "eliminados".
2.  **Fácil reordenación**: Cambia el orden sin mover datos.
3.  **Adición rápida**: Nuevos elementos siempre al final.
4.  **IDs estables**: Los identificadores originales no cambian.

## Desventajas

1.  **Más memoria**: Necesita campos extra por elemento.
2.  **Recorrido más lento**: Debe saltar elementos eliminados.
3.  **Mantenimiento**: Requiere cuidado al actualizar enlaces.


# 2THINK

## Impacto de la eliminación en la eficiencia de recorrido

-   **Aumento de pasos**: Cada elemento eliminado añade un paso extra al recorrido.
-   **Lentitud progresiva**: A medida que se acumulan elementos eliminados, el recorrido se vuelve más lento.
-   **Complejidad cambiante**: El rendimiento depende de la distribución de elementos eliminados, no solo de la cantidad total.
-   **Pelea de tiempo vs espacio**: Mantener elementos eliminados ahorra tiempo en reinserciones pero ralentiza lecturas.

## Ejemplo de la vida real

**Sistema de Gestión de Contenido para un blog o sitio de noticias**:

-   **Adición secuencial**: Nuevos artículos se agregan cronológicamente.
-   **Reordenación flexible**: Los editores pueden cambiar el orden de presentación sin alterar la cronología original.
-   **Semi-eliminación**: Artículos "eliminados" se ocultan pero se mantienen para referencia o posible republicación.
-   **Historial**: Mantiene un registro completo de todos los cambios y versiones de artículos.
-   **Categorización rápida**: Permite múltiples categorizaciones y reordenaciones sin duplicar contenidos.