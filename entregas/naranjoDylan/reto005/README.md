# Sistema de Control de Versiones Avanzado para Proyecto Java

Este proyecto describe un sistema de control de versiones diseñado específicamente para proyectos de programación en Java. El modelo utiliza conceptos como nodos, ramas y fusiones, organizados como un grafo dirigido para gestionar versiones y ramas de manera eficiente.

## Descripción General

El sistema está compuesto por tres módulos principales:

1. **Nodo**:
   - Representa una versión del proyecto.
   - Cada nodo contiene:
     - `versionId`: Identificador único de la versión.
     - `rama`: Rama a la que pertenece.
     - `cambios`: Descripción de los cambios realizados.
     - `fecha`: Fecha de creación de la versión.
     - `anterior`: Nodo que apunta a la versión anterior.
     - `ramasHijas`: Lista de nodos que representan nuevas ramas creadas desde este nodo.

2. **GrafoVersiones**:
   - Gestiona todas las versiones del proyecto como un grafo dirigido.
   - Características principales:
     - Soporta la creación de nuevas ramas a partir de cualquier nodo.
     - Permite realizar fusiones entre ramas.
     - Registra y muestra el historial completo de versiones, incluyendo ramificaciones y fusiones.

3. **Proyecto**:
   - Es la interfaz principal que encapsula el grafo de versiones.
   - A través de la clase `Proyecto`, los usuarios pueden:
     - Guardar cambios y crear nuevas versiones.
     - Crear y fusionar ramas.
     - Consultar el historial de versiones y ramas.

## Características Clave

1. **Soporte para Ramas**:
   - Se pueden crear nuevas ramas desde cualquier versión existente.
   - Cada rama tiene su propio historial, pero todas comparten un punto de origen común.

2. **Fusiones**:
   - El sistema permite fusionar cambios de una rama de origen en otra de destino.
   - Esto es útil para integrar nuevas características (`feature branches`) en la rama principal (`main`).

3. **Puntero Actual**:
   - El sistema mantiene un puntero a la versión actual, facilitando operaciones como agregar nuevas versiones o crear ramas.

4. **Historial Completo**:
   - Se puede consultar el historial de versiones con detalles sobre cambios, fechas y las ramas involucradas.

## Diseño UML

El siguiente diagrama representa la arquitectura del sistema:

![Diagrama UML](path/to/uml-diagram.png)

## Estructura de Clases

1. **Nodo**
   ```java
   class Nodo {
       int versionId;
       String rama;
       String cambios;
       String fecha;
       Nodo anterior;
       List<Nodo> ramasHijas;

       public Nodo(int versionId, String rama, String cambios, String fecha) {
       }
   }
