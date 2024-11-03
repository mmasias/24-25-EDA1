package romeroAngel.reto003;

class Compresor {

    private Diccionario diccionario;

    public Compresor() {
        this.diccionario = new Diccionario();
    }

    public void esperar(int segundos){
        try {
            
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
    }

    public String[][] comprime(String cadena) {
        String resultadoComprimido = "";
        String letraActual;

        for (int i = 0; i < cadena.length(); i++) {
            letraActual = cadena.substring(i, i + 1);
            int indice = diccionario.estaEnDiccionario(letraActual);

            if (indice == -1) {
                diccionario.agregar(letraActual);
                resultadoComprimido += "(0," + letraActual + ")";
            } else {
                String subcadena = letraActual;

                while (i + 1 < cadena.length()) {
                    letraActual = cadena.substring(i + 1, i + 2); 
                    subcadena += letraActual; 

                    int subIndice = diccionario.estaEnDiccionario(subcadena); 
                    if (subIndice == -1) {
                       
                        diccionario.agregar(subcadena);
                        
                        resultadoComprimido += "(" + diccionario.estaEnDiccionario(subcadena.substring(0, subcadena.length() - 1)) + "," + letraActual + ")";
                        break; 
                    }

                    i++; 
                }
            }
        }

        String[][] conversion = new String[2][];
        conversion[0] = new String[]{resultadoComprimido};
        conversion[1] = diccionario.listar();

        return conversion;
    }
}