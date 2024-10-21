# Mal uso de punteros, referencias y variables almacenadas en memoria.

- Al emplear el método "prepararHamburguesa" de la clase Cocinero, se crean dos ingredientes que no se usarán en la hamburguesa, generando así referencias a objetos que resultan innecesarias.

Carne segundaCarne = new Pollo("poco hecha");
    Azul quesoAzul = new Azul("Queso Azul");

- Se genera un puntero que no está vinculado a ninguna referencia:


    new Integral();