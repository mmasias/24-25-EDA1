## CODIGO DE ANGEL ROMERO

### Elementos
El código esta compuesto por 7 clases, siendo estas un Main, un Node, una clase List (que usa Node para crearse), un compresor (que permite crear un esquema de la cadena teniendo en cuenta un Diccionario), una clase diccionario, una clase FoundNodeList y una última clase FoundNodeWrapper

#### NODE y LIST

Son dos clases que van unidas ya que la clase Node genera cada elemento individual de la lista y la clase List los aglutina, incluyendo esta última metodos para mostrar, mover, eliminar y añadir elementos de la lista.

#### COMPRESOR
Esta es la clase que permite, dada una cadena de string, comprobar su existencia en el diccionario y , en caso de que no este y utilizando los métodos presentes en dicha clase (Diccionario) añadir los elementos al diccionario de forma que se pueda despues mostrar la cadena de forma comprimida a partir de los índices que se han creado en el diccionario.

### DICCIONARIO
Clase que permite crear una lista de índices y elementos de la cadena dada de forma que el compresor pueda consultarlo y, en caso de nos estar dicha parte de la cadena, añadir nuevos elementos e índices.

### FOUNDNODELIST
Es una clase que crea uan lista con los nodos primeros nodos de la lista

### FOUND NODE WRAPPER
Permite añadir los primeros nodos de una lista dada a otra lista

### MAIN
Utilixa las clases anteriores para, una vez dada una cadena, la cual es introducida por el usuario, utiliza el compresor para mostrar una version comprimida de la misma asi como muestra el diccionario para demostrar los índices utilizados en la compresion






