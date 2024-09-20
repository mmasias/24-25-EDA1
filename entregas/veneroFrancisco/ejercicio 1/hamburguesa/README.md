Carpeta para incluir el codigo fuente

Comenzamos por una estructuración erronea de el codigo en base a las clases del proyecto, en vez de separar las diferentes clases en archivos distintos, yo cree una clase principal para cada elemento y a partir de ahi empecé a crear subclases dentro de esa clase principal, cosa que es erronea porque dificulta el mantenimiento de el codigo ya que puede resultar dificil de leer y de entender.

El segundo error se encuentra en la clase extra a partir de la linea 26 donde se crea la subclase SalsaMayonesa ya que hay codigo duplicado, he declarado un campo privado 'cantidad' de tipo String pero ademas de ello el constructor tambien inicializa 'cantidad'. Lo que deberia hacer es mover la declaracion del campo 'cantidad' y el constructor que lo inicializa a una clase base que es común para ambos. De esta manera, tanto SalsaMayonesa como SalsaKetchup pueden heredar esta funcionalidad común.

Un tercer error que he cometido en la clase Hamburguesa concretamente linea 7, es utilizar un ArrayList, el cual no lo hemos visto en clase y no hacia falta utilizar ya que con un simple array unidimensional iniciandolo para 'Pan' y para 'Extra'.
Ademas el fallo de no hacer el Array unidimensional me hizo arrastrar otro error mas abajo en la linea 9, donde declaré panInferior en el constructor de Hamburguesa pero al no tener un Array de 'Pan' deberia haber metido panInferior para inicializar el array 'panes' de la hamburguesa. Ese array contendria los dos panes de la hamburguesa permitiendo que panInferior sea almacenado y accedido como el segundo elemento del array.

Otro error cometido en el examen fue el de no crear las clases suficientes para el correcto desarrollo de el ejericio, me faltó crear una clase 'Ingrediente' de la cual heredasen todos los demas ingredientes y asi tambien agregar en esta clase el metodo para describir el contenido de la hamburguesa. La clase 'Salsa' debió de estar en el ejercicio, es una clase que hereda de la clase 'Extra' y en la que se inicializa la cantidad de salsa que se pone en la hamburguesa, inicializandola en el constructor de esa misma clase, y con ese metodo permite que en las clases 'Mayonesa' y 'Ketchup' solo haria falta pasarle el valor cantidad al constructor ya que heredan de la clase Salsa.

Otro error que hace mas engorroso el desarrollo de el ejercicio es el no haber creado un metodo 'String representacion()' que serviria para tener acceso a la representacion visual de un extra además de ser reutilizable para los demas extras, que habria sido lo idoneo para mantener el codigo limpio y asi permitir que otros componentes o extras obtengan la representacion visual  sin depender directamente de el campo 'REPRESENTACION'



