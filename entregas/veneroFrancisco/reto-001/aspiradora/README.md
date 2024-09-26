# Punteros, referencias y variables almacenadas en memoria.

- Eliminación de constantes que almacenan referencias a valores no utilizados en el código:

        final int TILE_CLEAN = 0;
        final int TILE_DIRTY = 1;
        final int TILE_DIRTIER = 2;
        final int TILE_VERY_DIRTY = 3;
        final int TILE_EXTREMELY_DIRTY = 4;
        final int X_AXIS = 0;
        final int Y_AXIS = 1;


- La matriz "surface" se define pero no se inicializa, puesto que sus valores serán asignados de manera aleatoria poco después.


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


- El método "System.arraycopy" realiza copias directamente desde la memoria, lo que ayuda a evitar el manejo de referencias múltiples y, como resultado, mejora la eficiencia.


static void moveVacuum(int[] vacuumPosition, int[][] surface) {

        int[] previousPosition = new int[2];
        vacuumPosition[0] = previousPosition[0];
        vacuumPosition[1] = previousPosition[1];

        .
        .
        .

        int[] movement = directions[(int) (Math.random() * directions.length)];
        vacuumPosition[0] = vacuumPosition[0] + movement[0];
        vacuumPosition[1] = vacuumPosition[1] + movement[1];
        if (invalidPosition(vacuumPosition, surface)) {
            vacuumPosition[0] = previousPosition[0];
            vacuumPosition[1] = previousPosition[1];
        }
    }

- Metodo "isDirty" arreglado:

    static boolean isDirty(int[][] surface) {
        for (int i = 0; i < surface.length; i++){
            for (int j = 0; j < surface[i].length; j++){
                if (surface[i][i] != 0){
                    return true;
                }
            }
        }
        return false;
    }