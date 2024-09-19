# Documentación del buen uso de referencias, punteros y variables guardadas en memoria.

> pyAspiradora
- Eliminación de constantes que almacenan referencias a valores que no se utilizan en el código.
        final int TILE_CLEAN = 0;
        final int TILE_DIRTY = 1;
        final int TILE_DIRTIER = 2;
        final int TILE_VERY_DIRTY = 3;
        final int TILE_EXTREMELY_DIRTY = 4;
        final int X_AXIS = 0;
        final int Y_AXIS = 1;
- La matriz "surface" está declarada pero no inicializada, ya que no es necesario que su referencia apunte a valores específicos, dado que estos serán asignados de forma aleatoria inmediatamente después.

        int[][] surface = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };
```


- El método "System.arraycopy" realiza la copia directamente de la memoria, lo que significa que evita la gestión de múltiples referencias y logra así una mayor eficiencia.
```
         vacuumPosition[0] = vacuumPosition[0] + movement[0];
        vacuumPosition[1] = vacuumPosition[1] + movement[1];
        if (invalidPosition(vacuumPosition, surface)) {
            vacuumPosition[0] = previousPosition[0];
            vacuumPosition[1] = previousPosition[1];
        }
```