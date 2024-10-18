public class Compresor {

    private Diccionario diccionario;
    private String secuencia;

    public Compresor(Diccionario diccionario) {
        this.diccionario = diccionario;
        this.secuencia = "";
    }

    public String imprimir(String texto) {
        String textoComprimido = "";
        int longitud = 0;
        
        String subcadenaActual = "";
        int codigoNuevo = 7; 

        while (longitud < texto.length()) {
            subcadenaActual = String.valueOf(texto.charAt(longitud)); 
            int codigo = obtenerCodigo(subcadenaActual);
            
            while (codigo != 0 && longitud + 1 < texto.length()) {
                longitud++;
                subcadenaActual += texto.charAt(longitud);
                int nuevoCodigo = obtenerCodigo(subcadenaActual);
                if (nuevoCodigo == 0) {
                    
                    diccionario.agregarPalabra(codigoNuevo, subcadenaActual);
                    codigoNuevo++;
                    break;
                }
                codigo = nuevoCodigo;
            }
            
            String subString = subcadenaActual.substring(0, subcadenaActual.length() - 1);
            int codigoFinal = obtenerCodigo(subString);
            textoComprimido += String.valueOf(codigoFinal);
            agregarSecuencia(String.valueOf(codigoFinal), String.valueOf(subString.charAt(subString.length() - 1)));
            longitud++;
        }
        return textoComprimido;
    }

    private String obtenerCodigo(String texto) {
        for (int i = 1; i <= 6; i++) {
            if (diccionario.obtenerPalabra(i).equals(texto)) {
                return String.valueOf(i);
            }
        }
        return "0";
    }

    private void agregarSecuencia(String codigo, String texto) {
        secuencia += "(" + codigo + "," + texto + ") ";
    }

    public void imprimirSecuencia() {
        System.out.println(secuencia.trim());
    }
}