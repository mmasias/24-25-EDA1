# *Sigue...*

## Llegados a este punto

1. Definimos la interfaz.
1. Implementamo(s) las estrategia(s).
1. Ajustamos el árbol para que pueda recibir la estrategia...
1. Que se la pasará el que lo use, en este caso, el Jardinero.


### Definimos la interfaz

> Clase [InsertionStrategy.java](v010i/InsertionStrategy.java)

```java
interface InsertionStrategy {
    boolean goLeft(Node current, int value);
}
```

### Implementamos la(s) estrategia(s)

> Clase [NormalBSTStrategy.java](v010i/NormalBSTStrategy.java)

```java
class NormalBSTStrategy implements InsertionStrategy {
    @Override
    public boolean goLeft(Node current, int value) {
        return value < current.value;
    }
}
```

> Clase [InvertedBSTStrategy.java](v010i/InvertedBSTStrategy.java)

```java
class InvertedBSTStrategy implements InsertionStrategy {
    @Override
    public boolean goLeft(Node current, int value) {
        return value > current.value;
    }
}
```

> Clase [BalancedStrategy.java](v010i/BalancedStrategy.java)

```java
class BalancedStrategy implements InsertionStrategy {
    @Override
    public boolean goLeft(Node current, int value) {
        return countNodes(current.left) <= countNodes(current.right);
    }
    
    private int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}
```

### El árbol ahora recibe (*necesita*) la estrategia

> Clase [Tree.java](v010i/Tree.java)

```java
class Tree {
    private Node root;
    private InsertionStrategy strategy;
    
    public Tree(InsertionStrategy strategy) {
        this.root = null;
        this.strategy = strategy;
    }
    
    (...)
    
    private Node recursiveInsert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        
        if (strategy.goLeft(node, value)) {
            node.left = recursiveInsert(node.left, value);
        } else {
            node.right = recursiveInsert(node.right, value);
        }
        
        return node;
    }
    
    (...)
}
```

### Y es el jardinero quién se la proporciona

```java
class Jardinero {
    public static void main(String[] args) {
        Tree normalTree = new Tree(new NormalBSTStrategy());
        Tree balancedTree = new Tree(new BalancedStrategy());
        Tree invertedTree = new Tree(new InvertedBSTStrategy());
            
        System.out.println("Árbol BST Normal:");
        normalTree.insert(2);
        normalTree.insert(6);
        (...)
        normalTree.print();
        
        System.out.println("Árbol Balanceado:");
        balancedTree.insert(2);
        balancedTree.insert(6);        
        (...)
        balancedTree.print();
        
        System.out.println("Árbol BST Invertido:");
        invertedTree.insert(2);
        invertedTree.insert(6);        
        (...)
        invertedTree.print();
    }
}
```
