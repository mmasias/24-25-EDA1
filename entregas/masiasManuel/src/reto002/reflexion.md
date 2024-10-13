# Referencias: una exploración profunda

El manejo de referencias en estructuras de datos es una técnica poderosa que permite crear representaciones flexibles y eficientes de datos.

## ¿Por qué?

Cuando trabajamos con colecciones de objetos, como listas enlazadas, a menudo necesitamos realizar operaciones como búsquedas o filtrados. La manera en que manejamos estas operaciones puede tener un impacto significativo en el rendimiento y la funcionalidad de nuestros programas.

Tradicionalmente, cuando necesitamos una "sublista" o un conjunto filtrado de elementos, podríamos estar tentados a crear copias de los elementos originales. Sin embargo, este enfoque presenta varios problemas:

|Ineficiencia|Potencial inconsistencia|Mantenimiento|
|-|-|-|
|Duplicar datos consume recursos innecesarios.|Si el objeto original cambia, la copia no se actualiza automáticamente.|Mantener sincronizadas múltiples copias de datos puede ser propenso a errores.|

## ¿Qué?

El manejo de referencias en estructuras de datos se refiere a la práctica de crear nuevas estructuras que contienen punteros o "referencias" a objetos existentes, en lugar de crear copias de esos objetos.

En nuestro ejemplo específico, hemos implementado este concepto a través de dos clases principales:

1. `FoundNodeList`: Una estructura especializada que almacena referencias a nodos encontrados en una búsqueda.
2. `FoundNodeWrapper`: Un contenedor que encapsula una referencia a un nodo original.

Este enfoque nos permite crear una nueva "vista" de los datos originales sin duplicarlos. Cada elemento en `FoundNodeList` es en realidad un `FoundNodeWrapper` que contiene una referencia directa a un nodo en la lista original.

## ¿Para qué?

La implementación de estructuras de datos basadas en referencias ofrece varios beneficios clave:

|Eficiencia|Consistencia|Mantenimiento|
|-|-|-|
|Al no duplicar datos, utilizamos menos memoria.|Cualquier cambio en el objeto original se refleja inmediatamente en todas las referencias.||
||Podemos crear múltiples "vistas" de los mismos datos para diferentes propósitos sin duplicación.||

Este enfoque es particularmente útil en escenarios como:

- Sistemas de filtrado de datos complejos
- Implementación de vistas múltiples de una misma base de datos
- Operaciones de búsqueda en grandes conjuntos de datos
- Sistemas que requieren actualizaciones en tiempo real en múltiples vistas

## ¿Cómo?

La implementación de este concepto implica varios pasos clave:

1. Diseño de la estructura wrapper:

   ```java
   class FoundNodeWrapper {
       private Node foundNode;
       private FoundNodeWrapper next;

       public FoundNodeWrapper(Node foundNode) {
           this.foundNode = foundNode;
           this.next = null;
       }

       ...
   }
   ```

2. Creación de la estructura de lista especializada:

   ```java
   public class FoundNodeList {
       private FoundNodeWrapper first;
       private int size;

       ...
   }
   ```

3. Implementación del método de búsqueda que devuelve referencias:

   ```java
   public FoundNodeList find(String value) {
       FoundNodeList resultList = new FoundNodeList();
       Node node = this.first;
       while (node != null) {
           if (node.getValue().equals(value)) {
               resultList.add(node);
           }
           node = node.getNext();
       }
       return resultList;
   }
   ```

4. Visualización para demostrar la preservación de referencias:

   ```java
   public void showInConsole() {
       ...
   }
   ```

Al implementar y utilizar estas estructuras, podemos demostrar cómo las referencias se mantienen intactas:

```text
Lista original:
[A]Node@18b4aac2 / [C]Node@70dea4e / [D]Node@5c647e05 / [B]Node@33909752 / [A]Node@55f96302 / [B]Node@3d4eac69 / [A]Node@42a57993 /

Lista de nodos encontrados:
[A]Node@18b4aac2 / [A]Node@55f96302 / [A]Node@42a57993 /
```

Esta salida muestra claramente que los nodos en la lista filtrada son los mismos objetos (mismas referencias de memoria) que en la lista original.

