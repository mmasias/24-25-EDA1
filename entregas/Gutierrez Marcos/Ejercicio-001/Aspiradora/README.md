# Documentación del buen uso de referencias, punteros y variables guardadas en memorias

> PyAspiradora

- Eliminación de 2 variables que no se utilizan:<br>
```java
    final int X_AXIS = 0;
    final int Y_AXIS = 1;
```
- La matriz `surface` se ha declarado pero no inicializado. Ahora se ha inicializado con las dimensiones correspondientes: <br>
```java
    int[][] surface = new int[10][25];
```
- Uso del método  `System.arraycopy()` para una mayor eficiencia en la copia de arrays.
- Metodo `isDirty(int[][] surface)` correctamente formado, puesto que antes solo retornaba true:<br>
```java
for(int i=0; i<surface.length;i++){
            for(int j=0; j<surface[i].length;j++){
                if(surface[i][i]!=0){
                    return true;
                }
            }
        }
    return false;
```