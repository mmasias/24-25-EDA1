# Búsqueda en listas

Dada la lista que trabajamos en el ejercicio anterior, se trata de establecer una manera de devolver todos los elementos que cumplen una condición dada. 

- Se discutió en clase qué inconvenientes tenía el resolverlo con un array
- Se acordó que la forma natural de hacerlo sería mediante otra lista, pero!
  - Se vió como el manejo inadecuado de listas podía afectar (y de hecho, afectaba) la lista original.
 
## Reto

Implemente una forma en la que se pueda responder a la búsqueda sin afectar la lista original.

La vista pública del método sería: 

```java
  public FoundNodeList find(String value) {}
```

Que devuelve la lista de nodos que responden al criterio consultado. 
