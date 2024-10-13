# Una lista

## Vista pública clases List, Node, FoundNodeList & FoundNodeWrapper

|[List](List.java)|[Node](Node.java)|[FoundNodeList](FoundNodeList.java)|[FoundNodeWrapper](FoundNodeWrapper.java)|
|-|-|-|-|
|`public List()`|`public Node(String value)`|`public FoundNodeList()`|`public FoundNodeWrapper(Node foundNode)`|
|`public int size()`|`public String getValue()`|`public void add(Node node)`|`public Node getFoundNode()`|
|`public boolean isEmpty()`|`public void setValue(String newValue)`|`public FoundNodeWrapper getFirst()`|`public FoundNodeWrapper getNext()`|
|`public void insertEnd(String value)`|`public Node getNext()`|`public int size()`|`public void setNext(FoundNodeWrapper next)`|
|`public void insertFront(String value)`|`public void setNext(Node next)`|`public void showInConsole()`||
|`public void deleteEnd()`|`public void showInConsole()`|||
|`public void deleteFront()`||||
|`public void deleteAll()`||||
|`public String[] listAll()`||||
|`public FoundNodeList find(String value)`||||
|`public void showInConsole()`||||

|||
|-|-|
|![](/images/modelosUML/unaLista-dC.svg)|![](/images/modelosUML/unaLista-dO.svg)