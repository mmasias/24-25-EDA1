# *Sigue...*

## Llegados a este punto

Tenemos tres implementaciones diferentes de Tree:

<div align=center>

|[Tree v000r](v000r/Tree.java)|[Tree v001r](v001r/Tree.java)|[Tree v002r](v002r/Tree.java)||
|-|-|-|-|
|`public Tree()`|`public Tree()`|`public Tree()`|🟰|
|`public void insert(int value)`|`public void insert(int value)`|`public void insert(int value)`||
|`public void print()`|`public void print()`|`public void print()`|🟰|
|`private Node root`|`private Node root`|`private Node root`|🟰|
|`private Node recursiveInsert(Node node, int value)`|`private Node recursiveInsert(Node node, int value)`|`private Node recursiveInsert(Node node, int value)`|🟰|
|`private void recursivePrint(Node nodo, int nivel)`|`private void recursivePrint(Node nodo, int nivel)`|`private void recursivePrint(Node nodo, int nivel)`|🟰|
||`private int countNodes(Node node)`|

</div>

- Estamos repitiendo mucho código.
- Si queremos añadir una nueva regla, tenemos que copiar toda la clase.
- Si encontramos un bug en print(), hay que corregirlo en tres sitios.

## ¿Qué hacer?

### ¿Herencia?

```java
class TreeBSTNormal extends Tree { ... }
class TreeBSTBalanced extends Tree { ... }
class TreeBSTInverted extends Tree { ... }
```

|||
|-|-|
|Tree ya es una clase concreta y funcional|Estaríamos heredando de una clase que ya funciona perfectamente por sí misma, lo cual viola el principio de herencia
|Tendríamos que hacer overrides de insert()|Esto sugiere que quizás no estamos ante una verdadera relación de herencia, sino solo queriendo modificar un comportamiento específico
|No tiene sentido decir que TreeBSTNormal "es un" Tree|La herencia modela relaciones "es un", pero aquí realmente tenemos "es un Tree que inserta de forma diferente"
|Estaríamos forzando una jerarquía que no es natural|Todos son realmente el mismo tipo de árbol, solo cambia la forma de insertar elementos

### ¿Clases abstractas?

```java
abstract class AbstractTree {
    abstract void insert(int value);
    ...
}
```

|||
|-|-|
|Forzamos a heredar toda la estructura|Cada nueva implementación debe cargar con todos los métodos aunque solo quiera cambiar la inserción
|Las subclases terminan siendo árboles|Estamos forzando a que cualquier clase que quiera usar estas reglas de inserción tenga que ser un árbol
|La regla de inserción podría ser útil en otras estructuras|Por ejemplo, podríamos querer usar la misma regla de balanceo en una estructura diferente
|No estamos modelando diferentes "tipos" de árboles|Todos son el mismo tipo de árbol con diferentes comportamientos de inserción

### Entonces, ¿qué estamos modelando realmente?

||
|-|
|No se trata de diferentes tipos de árboles: es el mismo árbol en todos los casos!|
|Son diferentes **comportamientos de inserción**: es la regla de inserción lo que cambia!|
|La estructura del árbol es la misma: atributos y todas las operaciones son idénticas.|
|Solo cambia una "estrategia": finalmente es un comportamiento intercambiable.|

## Ya ¿y? ¿qué hacer?

Una **interfaz** es un contrato que define **QUÉ** debe hacer una clase, pero no **CÓMO** debe hacerlo.

En nuestro caso:

- **Qué**: insertar un valor en el árbol según cierta estrategia
- **Cómo**: cada implementación de la interfaz definirá sus reglas

### Características principales

||Define comportamiento|Es un contrato|Permite intercambiar implementaciones|Desacopla el QUÉ del CÓMO|
|-|-|-|-|-|
||Una interfaz especifica métodos que las clases deben implementar|Las clases que implementan la interfaz DEBEN proporcionar todos los métodos|Diferentes clases pueden implementar la misma interfaz||
|**En nuestro caso**|Necesitamos definir cómo decidir dónde insertar un nuevo valor|Cada estrategia de inserción debe poder decidir dónde va un nuevo valor|Podremos intercambiar las reglas de BST normal, balanceado e invertido|La clase Tree no necesita saber cómo se decide la inserción: solo necesita saber que existe un método que toma esa decisión

#### 🚬 de diseño

> *Termina (ja!) en la* [***Parte III***](2Work.md)
