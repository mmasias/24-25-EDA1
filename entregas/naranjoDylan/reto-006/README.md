# Edlin: Editor de Texto en Consola
Este proyecto es una implementación simple de un editor de texto basado en líneas, diseñado para ejecutarse en la consola. Permite realizar diversas operaciones como edición, copia, pegado, deshacer y rehacer acciones, entre otras. Este editor es interactivo y utiliza un menú de comandos para gestionar las funcionalidades.

## Estructura del Proyecto
El proyecto está compuesto por tres clases principales:
1. **`Edlin`**: Contiene el método principal y configura la cantidad de líneas que tendrá el documento.
2. **`Editor`**: Gestiona las operaciones principales de edición en el documento.
3. **`Menu`**: Proporciona un menú interactivo para que el usuario elija acciones a realizar.

## Cómo Funciona
1. **Inicio**:
   - El programa solicita al usuario la cantidad de líneas del documento.
   - Se inicializa un editor vacío con las líneas especificadas.

2. **Interacción**:
   - Se muestra el contenido del documento y un menú con los comandos disponibles.
   - El usuario puede ingresar comandos para editar texto, copiar/pegar, borrar, deshacer, rehacer, y más.

3. **Operaciones**:
   - **Edición**: Cambiar el contenido de una línea activa.
   - **Gestión de Portapapeles**: Copiar y pegar contenido.
   - **Deshacer/Rehacer**: Permite retroceder o repetir acciones.
   - **Intercambio de Líneas**: Cambiar el contenido entre dos líneas.
   - **Salir**: Termina la ejecución del programa.

## Comandos Disponibles
- **`L`**: Cambiar la línea activa.
- **`E`**: Editar el contenido de la línea activa.
- **`I`**: Intercambiar la línea activa con otra línea.
- **`B`**: Borrar el contenido de la línea activa.
- **`C`**: Copiar el contenido de la línea activa al portapapeles.
- **`P`**: Pegar el contenido del portapapeles en la línea activa.
- **`Z`**: Deshacer la última acción.
- **`Y`**: Rehacer la última acción deshecha.
- **`S`**: Salir del programa.

## Cómo Ejecutar
1. Compila el programa usando un compilador de Java:
   ```bash
   javac Edlin.java
