# Documentación Aspiradora

- Eliminación de 2 variables que no se utilizan:<br>
```
    final int X_AXIS = 0;
    final int Y_AXIS = 1;
```
- La matriz `surface` se ha declarado pero no inicializado. Ahora se ha inicializado con las dimensiones correspondientes: <br>
```
    int[][] surface = new int[10][25];
```
- Uso del método  `System.arraycopy()` para una mayor eficiencia en la copia de arrays.
- Metodo `isDirty(int[][] surface)` correctamente formado, ya que antes solo retornaba true:<br>
```
for(int i=0; i<surface.length;i++){
            for(int j=0; j<surface[i].length;j++){
                if(surface[i][i]!=0){
                    return true;
                }
            }
        }
    return false;
```
- Mejora del metodo de `contaminate` ya que ahora usa constantes definidas en lugar de numeros random
```
static void contaminate(int[][] aMap) {
    for (int row = 0; row < aMap.length; row++) {
        for (int column = 0; column < aMap[row].length; column++) {
            aMap[row][column] = (int) (Math.random() * (TILE_EXTREMELY_DIRTY + 1)); // Usa constante
        }
    }
}
```
- Optimización del método `cleanWorld` En lugar de realizar una resta si el valor es mayor que 0, puedes asegurarte de no tener valores negativos:

```
static void cleanWorld(int[][] surface, int[] vacuumPosition) {
    int row = vacuumPosition[0];
    int col = vacuumPosition[1];
    surface[row][col] = Math.max(surface[row][col] - 1, TILE_CLEAN); // Evita valores negativos
}
```
