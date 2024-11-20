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
- Matriz "surface" declarada pero no inicializada ya que no tiene sentido que la referencia apunte a unos valores los cuales van a volver a ser declarados de manera random inmediatamente después.

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
static void moveVacuum(int[] vacuumPosition, int[][] surface) {

        int[] previousPosition = new int[2];
        vacuumPosition[0] = previousPosition[0];
        vacuumPosition[1] = previousPosition[1];

        int[][] directions = {
                { -1, 1 }, { 0, 1 }, { 1, 1 },
                { -1, 0 }, { 0, 0 }, { 1, 0 },
                { -1, -1 }, { 0, -1 }, { 1, -1 }
        };

        int[] movement = directions[(int) (Math.random() * directions.length)];
        vacuumPosition[0] = vacuumPosition[0] + movement[0];
        vacuumPosition[1] = vacuumPosition[1] + movement[1];
        if (invalidPosition(vacuumPosition, surface)) {
            vacuumPosition[0] = previousPosition[0];
            vacuumPosition[1] = previousPosition[1];
        }
```}
- Método "isDirty" correctamente formado, ya que antes solo retornaba true.
```java
for(int i=0; i<surface.length;i++){
            for(int j=0; j<surface[i].length;j++){
                if(surface[i][i]!=0){
                    return true;
                }
            }
        }
    return false;