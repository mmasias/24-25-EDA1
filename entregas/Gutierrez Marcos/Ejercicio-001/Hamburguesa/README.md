# Documentación del mal uso de referencias, punteros y variables guardadas en memorias

> PyHamburguesa

- En la `Clase Cocinero` sea crean 2 ingredientes. La referencia de estos ingredientes se guardan en una variable, y esta variable no es utilizada.
```java
    Queso Azul = new Azul();
    Carne otraCarne = new Pollo("muy hecho");
```

- En la `Clase Cocinero` se crea un puntero el cual no esta referenciado, este se queda guardado en la memoria.
```java
    new Integral();
```