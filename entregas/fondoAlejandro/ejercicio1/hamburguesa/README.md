# Mal uso de punteros, referencias y variables almacenadas en memoria.

- Al utilizar el método "prepararHamburguesa" de la clase Cocinero, se generan dos ingredientes que no serán utilizados en la hamburguesa, creando así dos referencias a objetos innecesarios:

    Carne segundaCarne = new Pollo("poco hecha");
    Azul quesoAzul = new Azul("Queso Azul");

- Se crea un puntero que no tiene ninguna referencia asociada:

    new Integral();