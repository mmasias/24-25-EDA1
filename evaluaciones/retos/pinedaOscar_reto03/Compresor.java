package evaluaciones.retos.pinedaOscar_reto03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Compresor {

    public ResultadoCompresion comprime(String cadena) {
        Map<String, Integer> diccionario = new HashMap<>();
        Map<Integer, String> diccionarioInverso = new HashMap<>();
        List<Entrada> comprimido = new ArrayList<>();

        int indiceDiccionario = 1;
        String w = "";

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            String wc = w + c;

            if (diccionario.containsKey(wc)) {

                w = wc;
            } else {

                int indiceW = w.isEmpty() ? 0 : diccionario.get(w);
                comprimido.add(new Entrada(indiceW, c));

                diccionario.put(wc, indiceDiccionario);
                diccionarioInverso.put(indiceDiccionario, wc);
                indiceDiccionario++;

                w = "";
            }
        }

        return new ResultadoCompresion(comprimido, diccionarioInverso);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Por favor, ingrese la cadena a comprimir: ");
        String cadena = scanner.nextLine();

        Compresor compresor = new Compresor();
        ResultadoCompresion resultado = compresor.comprime(cadena);

        System.out.println(resultado);

        scanner.close();
    }
}