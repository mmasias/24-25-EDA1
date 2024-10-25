# Constructores en Javascript

JavaScript permite una amplia flexibilidad de los constructores. Vamos a analizarlo paso a paso. Primero el constructor:

```javascript
class Persona {
    constructor(nombreOPersona, dni) {
        if (nombreOPersona instanceof Persona) {
            return nombreOPersona;  // Retorna el objeto original
        }
        this.nombre = nombreOPersona;
        this.dni = dni;
    }
}
```

El constructor está diseñado para funcionar de dos maneras diferentes:

```javascript
// Primera forma: crear una nueva persona
const juan = new Persona("Juan", "1234");

// Segunda forma: obtener una referencia a una persona existente
const referenciaJuan = new Persona(juan);
```

La línea clave es:

```javascript
if (nombreOPersona instanceof Persona)
```

Este `if` comprueba si el primer parámetro que recibimos es ya una instancia de `Persona`.

Los dos casos posibles:

```javascript
// CASO 1: Parámetros normales
const juan = new Persona("Juan", "1234");
// - nombreOPersona es "Juan" (un string)
// - No es instanceof Persona
// - Por tanto, crea un nuevo objeto con this.nombre y this.dni

// CASO 2: Pasando una Persona existente
const referenciaJuan = new Persona(juan);
// - nombreOPersona es juan (una Persona)
// - Sí es instanceof Persona
// - Por tanto, return nombreOPersona devuelve la referencia original
```

Lo interesante es que en JavaScript, esto:

```javascript
const referenciaJuan = new Persona(juan);
```

A pesar de usar la palabra `new`, NO crea un nuevo objeto porque el constructor retorna la referencia al objeto existente.

Podemos comprobarlo:

```javascript
const juan = new Persona("Juan", "1234");
const referenciaJuan = new Persona(juan);

console.log(juan === referenciaJuan); // true
```

Esto es algo que NO se puede hacer en Java: en Java, `new` **siempre** crea un nuevo objeto. No hay forma de hacer que el constructor retorne una referencia a un objeto existente.
