# Referencias de objetos y constructores

## ¿Por qué?

La gestión de referencias a objetos es un concepto fundamental en la programación orientada a objetos que afecta directamente a cómo escribimos y organizamos nuestro código. Entender las diferencias entre cómo los lenguajes de programación manejan las referencias en sus constructores es crucial porque:

1. Impacta en el diseño de nuestras clases y objetos
1. Afecta a la gestión de memoria y el rendimiento
1. Determina los patrones de diseño que podemos implementar
1. Influye en cómo compartimos estado entre diferentes partes de nuestra aplicación

## ¿Qué?

Cuando hablamos de referencias a objetos en constructores, nos referimos a la capacidad de un constructor para:

- Crear un nuevo objeto con propiedades copiadas de otro objeto
- Mantener una referencia al objeto original
- Modificar el comportamiento predeterminado del constructor

Veamos cómo se comporta cada lenguaje:

### Java

- Los constructores siempre crean un nuevo objeto
- El operador `this` no puede ser reasignado
- La referencia al nuevo objeto se establece antes de que se ejecute el constructor

```java
public class Persona {
    private String nombre;
    private String dni;
    
    // Constructor normal
    public Persona(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
    
    // Constructor copia - SIEMPRE crea un nuevo objeto
    public Persona(Persona persona) {
        this.nombre = persona.nombre;  // Copia valores
        this.dni = persona.dni;        // Copia valores
    }
}
```

### JavaScript

- Los constructores pueden retornar un objeto diferente
- Se puede modificar completamente el comportamiento del constructor
- Permite mayor flexibilidad en el manejo de referencias

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

> Profundizamos esto en: **[JavaScript vs Java](jsvsj.md)**

### PHP

- Proporciona un operador `clone` nativo
- Permite personalizar el comportamiento de clonación
- Referencias explícitas usando `&`

```php
class Persona {
    private $nombre;
    private $dni;
    
    public function __construct($nombre, $dni) {
        $this->nombre = $nombre;
        $this->dni = $dni;
    }
    
    public function __clone() {
        // Personalizar comportamiento de clonación
    }
}
```

### Python

- Permite control total sobre la instanciación mediante `__new__`
- Referencias implícitas para todos los objetos
- Métodos de copia personalizables

```python
class Persona:
    def __init__(self, nombre, dni):
        self.nombre = nombre
        self.dni = dni
    
    def __new__(cls, nombre_o_persona, dni=None):
        if isinstance(nombre_o_persona, Persona):
            return nombre_o_persona
        return super().__new__(cls)
```

### Comparativa de Características

||Creación de Objetos|Referencias|Clonación|
|-|-|-|-|
|**Java**|Siempre nuevo objeto en constructor|Explícitas y directas|Manual mediante constructor copia|
|**JavaScript**|Flexible, puede retornar existente|Implícitas|Spreading operator o Object.assign|
|**PHP**|Nuevo objeto en constructor|Explícitas con &|Operador clone nativo|
|**Python**|Controlable vía __new__|Implícitas|Métodos copy() personalizables|

## ¿Para qué?

Esta diferencia en el manejo de referencias tiene varios usos prácticos:

||Diseño|Memoria|Estado|Inmutabilidad|
|-|-|-|-|-|
|**Java**|Las referencias directas y constructores copia cubren la mayoría de los casos de uso|Mayor control sobre la creación de objetos|Referencias directas proporcionan una forma clara y simple|Más fácil de garantizar por su naturaleza estricta|
|**JavaScript**|Podemos implementar patrones más flexibles directamente en el constructor|Flexibilidad para reutilizar objetos existentes|Se puede hacer tanto por referencia directa como en el constructor|Requiere consideraciones adicionales|
|**PHP**|Similar a Java, pero permite clonar objetos con el operador `clone`|Gestión automática de memoria con conteo de referencias|Referencias explícitas usando `&` en parámetros|Se puede implementar pero requiere métodos específicos (`__clone`)|
|**Python**|Constructor `__new__` permite control total sobre la instanciación|Gestión automática de memoria con conteo de referencias|Referencias son implícitas, todo es objeto|Requiere implementación explícita (`@property`, etc.)|

## ¿Cómo?

### Implementaciones

Veamos cómo implementar diferentes estrategias en cada lenguaje:

#### Java - Aproximaciones básicas

```java
public class Persona {
    private String nombre;
    private String dni;

    public Persona(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public Persona(Persona persona) {
        this.nombre = persona.nombre;
        this.dni = persona.dni;
    }
}

// Uso:
Persona original = new Persona("Juan", "1234");
Persona copia = new Persona(original);     // Nuevo objeto
Persona referencia = original;             // Misma referencia
```

#### JavaScript - Diferentes aproximaciones

```javascript
class Persona {
    constructor(nombreOPersona, dni) {
        if (nombreOPersona instanceof Persona) {
            return nombreOPersona;  // Retorna referencia existente
        }
        this.nombre = nombreOPersona;
        this.dni = dni;
    }
}

// Uso:
const original = new Persona("Juan", "1234");
const referencia = new Persona(original);       // Misma referencia
const copia = { ...original };                  // Nuevo objeto
```

#### PHP - Aproximaciones

```php
class Persona {
    private $nombre;
    private $dni;

    public function __construct($nombre, $dni) {
        $this->nombre = $nombre;
        $this->dni = $dni;
    }

    // PHP tiene clonación automática con el operador clone
    public function __clone() {
        // Personalizar el comportamiento de clonación si es necesario
    }
}

// Uso:
$original = new Persona("Juan", "1234");
$copia = clone $original;           // Nuevo objeto
$referencia = $original;            // Misma referencia
```

#### Python - Aproximaciones

```python
class Persona:
    def __init__(self, nombre, dni):
        self.nombre = nombre
        self.dni = dni
    
    def __new__(cls, nombre_o_persona, dni=None):
        if isinstance(nombre_o_persona, Persona):
            return nombre_o_persona  # Retorna referencia existente
        return super().__new__(cls)
    
    def clone(self):
        return Persona(self.nombre, self.dni)

# Uso:
original = Persona("Juan", "1234")
referencia = Persona(original)      # Misma referencia
copia = original.clone()            # Nuevo objeto
```

### Características Distintivas

|Java|JavaScript|PHP|Python|
|-|-|-|-|
|Sintaxis clara y explícita|Alta flexibilidad en constructores|Operador `clone` nativo|Control total con `__new__`|
|Comportamiento predecible|Spreading operator para copias superficiales|Referencias explícitas con `&`|Todo es objeto y referencia|
|Sin operador de clonación nativo|Referencias implícitas|Método mágico `__clone()`|Métodos personalizables de copia|
|*¿Cuándo?*: Cuando la claridad y tipo estático son prioritarios|*¿Cuándo?*: Cuando se necesita flexibilidad máxima|*¿Cuándo?*: Cuando se requiere clonación simple y explícita|*¿Cuándo?*: Cuando se necesita control total sobre la instanciación|

- ***Muy importante:***
  - Mantener consistencia con las convenciones del lenguaje
  - Documentar el comportamiento esperado
  - Considerar implicaciones de rendimiento
