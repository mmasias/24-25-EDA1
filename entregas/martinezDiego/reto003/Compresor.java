package entregas.martinezDiego.reto003;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Compresor {

    public static class CompressedResult {
        List<String> output;
        Map<Integer, String> dictionary;

        public CompressedResult(List<String> output, Map<Integer, String> dictionary) {
            this.output = output;
            this.dictionary = dictionary;
        }

        @Override
        public String toString() {
            return "Output: " + output.toString() + "\nDictionary: " + dictionary.toString();
        }
    }

    public static CompressedResult comprime(String cadena) {
        Map<String, Integer> diccionario = new HashMap<>();
        int dictSize = 1;
        List<String> salida = new ArrayList<>();
        StringBuilder w = new StringBuilder();

        for (char c : cadena.toCharArray()) {
            String wc = w.toString() + c;
            if (diccionario.containsKey(wc)) {
                w.append(c);
            } else {
                if (w.length() > 0) {
                    int index = diccionario.getOrDefault(w.toString(), 0);
                    salida.add("(" + index + "," + c + ")");
                } else {
                    salida.add("(0," + c + ")");
                }
                diccionario.put(wc, dictSize++);
                w = new StringBuilder(String.valueOf(c));
            }
        }

        if (w.length() > 0) {
            salida.add("(" + diccionario.getOrDefault(w.toString(), 0) + ",)");
        }

        Map<Integer, String> diccionarioFinal = new HashMap<>();
        for (Map.Entry<String, Integer> entry : diccionario.entrySet()) {
            diccionarioFinal.put(entry.getValue(), entry.getKey());
        }

        return new CompressedResult(salida, diccionarioFinal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la cadena original para comprimir: ");
        String cadena = scanner.nextLine();

        CompressedResult resultado = comprime(cadena);

        System.out.println("\n--- Resultados ---");
        System.out.println("Cadena original: " + cadena);
        System.out.println("Diccionario final: " + resultado.dictionary);
        System.out.println("Cadena comprimida: " + resultado.output);
    }
}





