# Control de versiones

## El estado tan solo consiste en el número de archivos de un directorio determinado, para simplificar esto solamente vamos a trabjar con un único directorio.

1. Árbol General (Inicialmente Vacio)
1.1. El árbol contiene nodos, el nodo en sí hereda de estado y ese estado contiene un número entero de archivos presentes en el directorio
1.2. La primera versión es el nodo raíz
1.3. Cada Nodo guarda el Nodo padre además de su ID
1.4. Te puedes quedar en ese Nodo y añadir una versión más o cambiarte de rama

2. Directorio (Inicialmente su estado es 0)
2.1. Se pueden crear y eliminar archivos (Mínimo 0 archivos)
