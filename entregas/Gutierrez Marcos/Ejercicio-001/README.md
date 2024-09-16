# Documentación Aspiradora

- Eliminación de 2 variables que no se utilizan:<br>
        `final int X_AXIS = 0;`<br>
        `final int Y_AXIS = 1;`<br><br>
- La matriz `surface` se ha declarado pero no inicializado. Ahora se ha inicializado con las dimensiones correspondientes: <br>
        `int[][] surface = new int[10][25];`<br><br>
- Uso del método  `System.arraycopy()` para una mayor eficiencia en la copia de arrays.