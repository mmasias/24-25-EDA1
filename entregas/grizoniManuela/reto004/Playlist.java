package entregas.grizoniManuela.reto004;

class Playlist {
    private String nombre;
    private Cancion[] canciones;
    private int tamaño;
    private int capacidad;

    public Playlist(String nombre, int capacidad){
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.canciones = new Cancion[capacidad];
        this.tamaño = 0; 
    }

    public void adicionarCancion(Cancion cancion){
        if(tamaño < capacidad){
            canciones[tamaño] = cancion;
            tamaño++;
        }/*else{
            System.out.println("");
        }*/
    }

    public void eliminarCancion(String titulo){
        for (int i = 0; i < tamaño; i++){
            if(canciones[i].getTitulo().equals(titulo)){
                for(int j = i; j < tamaño - 1; j++){
                    canciones[j] = canciones[j + 1];
                }
                canciones[tamaño - 1] = null;
                tamaño--;
                break; 
            }
        }
    }

    public Cancion[] getCanciones(){
        return canciones;
    }

    public void reproduccionAleatoria(){
        for (int i = 0; i < tamaño; i++){
            
        }
         
    }
    
}
