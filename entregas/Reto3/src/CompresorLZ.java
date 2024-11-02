public class CompresorLZ {

    private List diccionario;

    public CompresorLZ(){
        this.diccionario = new List();
    }

    public String comprime(String cadena) {

        String compresion = "";
        boolean cadenaRecorrida = false;

        int indice = 0;

        while (!cadenaRecorrida) {

            String caracteresParaAnalizar = String.valueOf(cadena.charAt(indice));
            String indiceCompresion = "0";

            while (diccionario.incluye(caracteresParaAnalizar)) {
                indiceCompresion = diccionario.getIndiceOf(caracteresParaAnalizar);
                indice++;
                if (indice < cadena.length()) {
                    caracteresParaAnalizar += String.valueOf(cadena.charAt(indice));
                } else {
                    break;
                }
            }

            diccionario.insertEnd(caracteresParaAnalizar);

            compresion += "(" + indiceCompresion + "," + ultimoChar(cadena, caracteresParaAnalizar) + ") ";
            indice++;
            cadenaRecorrida = comprobarCadena(cadena.length(), indice);
        }

        return compresion + "\n" + diccionario.mostrar();
    }


    private String ultimoChar(String cadena, String caracteresParaAnalizar){
        if(caracteresParaAnalizar.length() > 1){
            return String.valueOf(caracteresParaAnalizar.charAt(caracteresParaAnalizar.length() - 1));
        }else{
            return caracteresParaAnalizar;
        }

    }

    private boolean comprobarCadena(int longitudCadena, int indice) {
        if(indice >= longitudCadena){
            return true;
        }else{
            return false;
        }
    }

}
