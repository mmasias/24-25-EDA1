import java.util.Scanner;

public class CompresorLZ {

    private String[] diccionario;
    private int contadorDiccionario;

    public CompresorLZ() {
        this.diccionario = new String[100];  // Tamaño fijo de diccionario
        this.contadorDiccionario = 0;
    }

    public String comprime(String cadena) {
        StringBuilder compresion = new StringBuilder();
        int indice = 0;

        while (indice < cadena.length()) {
            String secuencia = String.valueOf(cadena.charAt(indice));
            String indiceCompresion = "0";

            while (contieneEnDiccionario(secuencia)) {
                indiceCompresion = String.valueOf(indiceDeSecuencia(secuencia));
                indice++;
                if (indice < cadena.length()) {
                    secuencia += cadena.charAt(indice);
                } else {
                    break;
                }
            }

            agregarAlDiccionario(secuencia);
            compresion.append("(").append(indiceCompresion).append(",")
                      .append(secuencia.charAt(secuencia.length() - 1)).append(") ");
            indice++;
        }

        return compresion.toString();
    }

    private boolean contieneEnDiccionario(String secuencia) {
        for (int i = 0; i < contadorDiccionario; i++) {
            if (diccionario[i].equals(secuencia)) {
                return true;
            }
        }
        return false;
    }

    private int indiceDeSecuencia(String secuencia) {
        for (int i = 0; i < contadorDiccionario; i++) {
            if (diccionario[i].equals(secuencia)) {
                return i;
            }
        }
        return -1;
    }

    private void agregarAlDiccionario(String secuencia) {
        if (contadorDiccionario < diccionario.length) {
            diccionario[contadorDiccionario] = secuencia;
            contadorDiccionario++;
        }
    }

    public String mostrarDiccionario() {
        StringBuilder diccionarioStr = new StringBuilder();
        for (int i = 0; i < contadorDiccionario; i++) {
            diccionarioStr.append(i).append(": ").append(diccionario[i]).append("\n");
        }
        return diccionarioStr.toString();
    }
}
