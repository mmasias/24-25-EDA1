public class Diccionario {

    private String[] secuencias;
    private int contadorSecuencias;

    public Diccionario() {
        this.secuencias = new String[100];  // Tamaño fijo del diccionario
        this.contadorSecuencias = 0;
    }

    public boolean contiene(String secuencia) {
        for (int i = 0; i < contadorSecuencias; i++) {
            if (secuencias[i].equals(secuencia)) {
                return true;
            }
        }
        return false;
    }

    public int obtenerIndice(String secuencia) {
        for (int i = 0; i < contadorSecuencias; i++) {
            if (secuencias[i].equals(secuencia)) {
                return i;
            }
        }
        return -1;
    }

    public void agregar(String secuencia) {
        if (contadorSecuencias < secuencias.length) {
            secuencias[contadorSecuencias] = secuencia;
            contadorSecuencias++;
        }
    }

    public String mostrar() {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < contadorSecuencias; i++) {
            resultado.append(i).append(": ").append(secuencias[i]).append("\n");
        }
        return resultado.toString();
    }
}





