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
