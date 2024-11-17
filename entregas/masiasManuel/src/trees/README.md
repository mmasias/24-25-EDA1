# Árboles

## Diferentes versiones

### [v000](v000)

Versión de partida, implementeción base / básica de un BST normal.

Clases [Tree](v000/Tree.java), [Node](v000/Node.java) y [Jardinero](v000/Jardinero.java)

Secuencia de inserción: `[2, 6, 5, 3, 7, 1, 9, 10]`

```
Árbol resultante:
                10
            9
        7
    6
        5
            3
2
    1
```

#### Refactoring

||[v000b](v000b)|[v000r](v000r)|
|-|-|-|
|Clases ajustadas|[Tree](v000b/Tree.java)|[Tree](v000r/Tree.java)
|Consideraciones|Se explicitó la condición que gobierna el control del flujo.|Se aplicó recursividad para gestionar la inserción.
||Limpia el código de impresión|Ya en este punto, también se aplicó recursividad a la impresión.

### [v001r](v001r)

Clases [Tree](v001r/Tree.java), [Node](v001r/Node.java) y [Jardinero](v001r/Jardinero.java)

Esta implementación implementa otra forma de construir el arbol, balanceándolo en función a la cantidad de nodos en cada subárbol.

Misma estructura base que v000r (recursiva), cambiando solo la estrategia de inserción y manteniendo la secuencia de inserción.

```
Árbol resultante:
            9
        7
    6
        5
2
        3
    1
        10
```

|Consideraciones|Evolución|
|-|-|
|Mantiene la clase Node sin modificar|Partimos de v000r (versión recursiva limpia)
|Añade método auxiliar para tomar decisiones de inserción|Solo cambiamos la lógica de inserción
|Menos eficiente (recuenta en cada inserción) pero más didáctico|Añadimos método auxiliar para contar
|Produce un árbol más balanceado pero pierde la propiedad de ordenación|Mantenemos la impresión recursiva

#### 🚬 de diseño

> ***#2think:*** Guardar el número de nodos de cada subárbol como atributo adicional en Node permitiría mejorar drásticamente la eficiencia: en lugar de recorrer todo el subárbol cada vez, simplemente consultaríamos el valor almacenado y lo actualizaríamos en las inserciones.

|¿Por qué no guardar el conteo en Node?|¿Por qué aceptar la ineficiencia?|¿Qué ganamos/perdemos?|
|-|-|-|
|Mantener Node simple y reutilizable.|Claridad sobre rendimiento en esta fase.|**Ganamos**: mejor distribución espacial.|
|Preparar para la abstracción de reglas.|Valor didáctico del proceso.|**Perdemos**: ordenación y eficiencia.|
|Permitir cambiar estrategias fácilmente.|Simplicidad de implementación.|**Mantenemos**: código limpio y extensible.|

### [v002r](v002r)

Clases [Tree](v002r/Tree.java), [Node](v002r/Node.java) y [Jardinero](v002r/Jardinero.java)

Implementación que invierte la regla del BST: mayores a la izquierda, menores a la derecha.

Misma estructura base que v000r (recursiva), cambiando solo la regla de comparación.

La secuencia de inserción se mantiene.

```
Árbol resultante:
    1
2
            3
        5
    6
        7
            9
                10
```

|Consideraciones|Evolución|
|-|-|
|Mantiene la clase Node sin modificar|Partimos de v000r (versión recursiva limpia)
|Solo invierte la condición de comparación en la inserción|Único cambio: la condición de inserción
|Produce un árbol que es imagen en espejo del BST normal|Mantenemos todo lo demás idéntico
|Mantiene las propiedades de BST pero en orden inverso|

### Recapitulando

> ***#2think:*** La simplicidad del cambio produce estructuras completamente diferentes!!!

||Normal|Balanceado|Invertido|
|-|-|-|-|
|**Estrategia**|Menores a la izquierda, mayores a la derecha|Inserción basada en conteo de nodos para mantener balance|Mayores a la izquierda, menores a la derecha|
|**Ordenación resultante**|Inorden produce secuencia ascendente|No garantiza ninguna ordenación específica|Inorden produce secuencia descendente|
|**Secuencia de inserción:**<br>**[2,6,5,3,7,1,9,10]**|![](/images/modelosUML/arbolesBST.svg)|![](/images/modelosUML/arbolesBalanceado.svg)|![](/images/modelosUML/arbolesBSTInvertido.svg)|
|**Peor caso**|Degenera en lista si los datos vienen ordenados|No degenera en lista aunque los datos vengan ordenados|Degenera en lista si los datos vienen ordenados|
|**Mejor caso**|Árbol perfectamente balanceado si los datos vienen alternados|Siempre tiende al balance|Árbol perfectamente balanceado si los datos vienen alternados|
|**Uso de memoria**|No requiere información adicional|Requiere recálculo constante de conteos|No requiere información adicional|
|**Casos de uso ideales**|Datos aleatorios o pre-procesados para evitar secuencias|Cuando el balance es más importante que el orden||
|**Ventaja principal**|Mantiene orden total y permite búsqueda binaria|Garantiza mejor uso del espacio vertical|Es un espejo del BST normal, útil para recorridos invertidos|
|**Desventaja principal**|Vulnerable a degeneración con datos ordenados|Pierde la propiedad de ordenación del BST|Vulnerable a degeneración con datos ordenados|
|**Variantes conocidas**|AVL, Rojo-Negro (añaden auto-balance)|Árboles peso-balanceados||
|**Operaciones eficientes**|Búsqueda, mínimo, máximo, sucesor, predecesor|Inserción balanceada, altura controlada|Búsqueda, mínimo, máximo, sucesor, predecesor (invertidos)|
|**Recorridos naturales**|Inorden para obtener elementos ordenados ascendentemente||Inorden para obtener elementos ordenados descendentemente|
|**Observaciones**|Subárboles son BSTs. Inorden = ordenado|Diferencia máxima de nodos entre ramas minimizada|Subárboles son BSTs invertidos. Inorden = ordenado inversamente|
|**Complejidad búsqueda**|O(h) donde h es altura, O(n) en peor caso|O(h) pero h más controlada, cerca a O(log n)|O(h) donde h es altura, O(n) en peor caso|
|**Complejidad inserción**|O(h) donde h es altura|O(h) pero con overhead por contar nodos|O(h) donde h es altura|

> *Continúa en la* [***Parte II***](2Think.md)