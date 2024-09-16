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