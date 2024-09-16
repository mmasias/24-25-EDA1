# Documentación del buen uso de referencias, punteros y variables guardadas en memoria.

> pyAspiradora
<br>
- Eliminación de constantes que guardan referencias a valores los cuales no se usan en el código.
- Matriz "surface" declarada pero no inicializada ya que no tiene sentido que la referencia apunte a unos valores los cuales van a ser declarados de manera random inmediatamente después.
- El método "System.arraycopy" realiza la copia directamente de la memoria, lo que significa que evita la gestión de múltiples referencias y una mayor eficiencia.