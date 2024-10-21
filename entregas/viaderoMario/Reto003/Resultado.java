package Reto003;
public class Resultado {
    String[] salidaComprimida;
    String[] diccionario;
    int tamañoDiccionario;

    public Resultado(String[] salidaComprimida, String[] diccionario, int tamañoDiccionario) {
        this.salidaComprimida = salidaComprimida;
        this.diccionario = diccionario;
        this.tamañoDiccionario = tamañoDiccionario;
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Resultado comprimido: ");
        for (String parte : salidaComprimida) {
            resultado.append(parte);
        }
        resultado.append("\nDiccionario: ");
        for (int i = 1; i < tamañoDiccionario; i++) {
            resultado.append("\n" + i + ":" + diccionario[i]);
        }
        return resultado.toString().replaceAll(", $", ""); 
    }
}