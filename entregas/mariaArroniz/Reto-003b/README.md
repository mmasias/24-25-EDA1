# Documentación del código reto-003

Código de Alejandro Juarez:  
https://github.com/Alejandrojuarez0105/24-25-EDA1/tree/3f1f11057bb858d25b70a80c344293a0d53601d9/entregas/juarezAlejandro/reto-003

# Clases del código 
**Main**:   
Se crean un nuevo compresor, se comprime la cadena definida al inicio y luego imprimirla.   
      
      String texto = "abababcbdc";  
      Compresor compresor = new Compresor();  
      String comprimir = compresor.comprimir(texto);  
      System.out.println("Texto comprimido" + comprimir);  
**Diccionario**:   
El diccionario consiste en un array de 100 elementos con los siguientes métodos:  

      public int getIndexSecuencia(String ultimaSecuencia)
      public void añadirAlDiccionario(String nuevoEspacio)
      public boolean estáEnDiccionario(String nuevoEspacio)
      public String getDictionary()

Los métodos están bastante claros, en orden el primero te da el indice, el segundo se añade
un nuevo elemento al diccionario, el tercero comprueba con un boolean si el elemento está en 
el diccionario y el siguiente te devuelve el diccionario.   

**Compresor**:  
Esta clase se encarga de lo más importante, comprimir la cadena.  
      
      public String comprimir(String texto)  







