package entregas.nevesKelvia.Reto_003;

import java.util.ArrayList;

public class Compresor {
    
    public static Resultado comprime(String cadena) {

        ArrayList<String> diccionario = new ArrayList<>();
        ArrayList<ParSalida> salida = new ArrayList<>();
        
        int posicion = 0;
        while (posicion < cadena.length()) {
            String coincidenciaMasLarga = "";
            int indiceCoincidencia = 0;

            for (int i = posicion + 1; i <= cadena.length(); i++) {
                String subcadena = cadena.substring(posicion, i);
                int indice = diccionario.indexOf(subcadena);
                if (indice != -1) {
                    coincidenciaMasLarga = subcadena;
                    indiceCoincidencia = indice + 1; 
                } else {
                    break;
                }
            }

            if (coincidenciaMasLarga.isEmpty()) {
                String nuevoElemento = cadena.substring(posicion, posicion + 1);
                salida.add(new ParSalida(0, nuevoElemento));
                diccionario.add(nuevoElemento);
                posicion++;
            } else {
                int longitudCoincidencia = coincidenciaMasLarga.length();
                if (posicion + longitudCoincidencia < cadena.length()) {
                    String siguienteCaracter = cadena.substring(posicion + longitudCoincidencia, posicion + longitudCoincidencia + 1);
                    salida.add(new ParSalida(indiceCoincidencia, siguienteCaracter));
                    diccionario.add(coincidenciaMasLarga + siguienteCaracter);
                }
                posicion += longitudCoincidencia + 1;
            }
        }
        
        return new Resultado(salida, diccionario);
    }

    public static class ParSalida {
        int indice;
        String caracter;
        
        public ParSalida(int indice, String caracter) {
            this.indice = indice;
            this.caracter = caracter;
        }

        public void imprimir() {
            System.out.print("(" + indice + "," + caracter + ") ");
        }
    }

    public static class Resultado {
        ArrayList<ParSalida> salida;
        ArrayList<String> diccionario;
        
        public Resultado(ArrayList<ParSalida> salida, ArrayList<String> diccionario) {
            this.salida = salida;
            this.diccionario = diccionario;
        }

        public void imprimir() {
           
            System.out.print("Resultado comprimido: ");
            for (ParSalida par : salida) {
                par.imprimir();
            }
            System.out.println(); 

            
            System.out.println("Diccionario: ");
            for (int i = 0; i < diccionario.size(); i++) {
                System.out.println((i + 1) + ":" + diccionario.get(i));
    }

        }
    }

    public static void main(String[] args) {
        String cadena = "abababc";
        Resultado resultado = comprime(cadena);
        resultado.imprimir(); 
    }
}
