
class Compresor {
    private String[] diccionario;
    private int indexDiccionario;

    public Compresor(int tamañoDiccionario) {
        diccionario = new String[tamañoDiccionario]; 
        indexDiccionario = 1; 
    }

    public void comprimir(String cadena) {
        StringBuilder resultadoFinal = new StringBuilder(); 
        String ventana = ""; 

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            String nuevaVentana = ventana + c; 

            int indice = buscaEnDiccionario(nuevaVentana);

            if (indice == -1) { 
                if (ventana.isEmpty()) {
                    resultadoFinal.append("(0," + c + ")");
                } else {
                    int indiceVentana = buscaEnDiccionario(ventana);
                    resultadoFinal.append("(" + indiceVentana + "," + c + ")");
                }


                diccionario[indexDiccionario] = nuevaVentana;
                indexDiccionario++; 
                ventana = ""; 
            } else {
                ventana = nuevaVentana; 
            }
        }

        if (!ventana.isEmpty()) {
            int indiceVentana = buscaEnDiccionario(ventana);
            resultadoFinal.append("(" + indiceVentana + ",)"); 
        }

        System.out.println("Cadena original: " + cadena);

        System.out.println("Diccionario:");
        for (int i = 1; i < indexDiccionario; i++) {
            System.out.println(i + ": " + diccionario[i]);
        }

        System.out.println("Resultado comprimido: " + resultadoFinal.toString());
    }

    private int buscaEnDiccionario(String ventana) {
        for (int i = 1; i < indexDiccionario; i++) {
            if (diccionario[i] != null && diccionario[i].equals(ventana)) {
                return i; 
            }
        }
        return -1; 
    }
}

