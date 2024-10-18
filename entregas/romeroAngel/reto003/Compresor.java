package romeroAngel.reto003;

class Compresor {

    private Diccionario diccionario;

    public Compresor() {
        this.diccionario = new Diccionario();
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
                String subcadena = letraActual; // Comenzamos con la letra actual

                while (i + 1 < cadena.length()) {
                    letraActual = cadena.substring(i + 1, i + 2); // Obtenemos la siguiente letra
                    subcadena += letraActual; // Añadimos la letra a la subcadena

                    int subIndice = diccionario.estaEnDiccionario(subcadena); // Verificamos si la subcadena existe
                    if (subIndice == -1) {
                        // Agregar la nueva subcadena al diccionario
                        diccionario.agregar(subcadena);
                        // Añadir el resultado comprimido usando el último carácter añadido
                        resultadoComprimido += "(" + diccionario.estaEnDiccionario(subcadena.substring(0, subcadena.length() - 1)) + "," + letraActual + ")";
                        break; // Salimos del bucle una vez que agregamos
                    }

                    i++; // Avanzamos al siguiente índice
                }
            }
        }

        String[][] conversion = new String[2][];
        conversion[0] = new String[]{resultadoComprimido};
        conversion[1] = diccionario.listar();

        return conversion;
    }
}