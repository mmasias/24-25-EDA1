package entregas.lopezMartin.reto_003;

public class CompresorLZ {

    List diccionario;
    
    public CompresorLZ(){
        this.diccionario = new List();
    }

    public String comprime(String cadena) {

        String compresion = "";
        String diccionarioEnTexto= "";

        for(int i = 0; i<cadena.length();i++){
            if (diccionario.incluye(String.valueOf(cadena.charAt(i)))) {
                compresion = compresion + "(" + diccionario.getIndiceOf(String.valueOf(cadena.charAt(i))) + "," + diccionario.getValueOf(String.valueOf(cadena.charAt(i))) + ") ";
                
            }else{
                diccionario.insertEnd(String.valueOf(cadena.charAt(i)));
                compresion = compresion + "(" + Integer.toString(diccionario.obtenerUltimo().getIndice()) + "," + diccionario.obtenerUltimo().getValue() + ") , ";
                //diccionarioEnTexto = diccionarioEnTexto + diccionario.;
                
            }
        }

        return compresion + "\n" + diccionarioEnTexto;
        
    }
    
}
