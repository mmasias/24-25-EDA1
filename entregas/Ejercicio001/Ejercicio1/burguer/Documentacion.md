# Documentación del mal uso de referencias, punteros y variables guardadas en memoria.

> pyBurger
- Al usar el método "prepararHamburguesa" del cocinero este crea dos ingredientes (un queso azul y un filete de pollo muy hecho) que no se van a usar como ingredientes de la hamburguesa, luego se están creando dos referencias a dos objetos que no se van a usar.

```java
    Queso azul = new Azul();
    Carne otraCarne = new Pollo("muy hecho");
```

- Se crea un puntero que no esta referenciado.
```java
    new Integral();
```