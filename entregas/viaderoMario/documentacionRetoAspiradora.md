# Documentación del buen uso de referencias, punteros y variables guardadas en memoria.

> pyAspiradora
<br>
- Eliminación de constantes que almacenan referencias a valores que no se utilizan en el código.
- La matriz "surface" está declarada pero no inicializada, ya que no es necesario que su referencia apunte a valores específicos, dado que estos serán asignados de forma aleatoria inmediatamente después.
- El método "System.arraycopy" realiza la copia directamente de la memoria, lo que significa que evita la gestión de múltiples referencias y logra así una mayor eficiencia.