class Descompresor {
    private final int POSICION_INDEX = 1;
    private final int POSICION_CHAR = 3;

    public String descomprimir(String comprimido, Diccionario diccionario) {
        String[] elementos = comprimido.split(" ");
        StringBuilder output = new StringBuilder();

        for (String elemento : elementos) {
            int index = Integer.parseInt(String.valueOf(elemento.charAt(POSICION_INDEX)));
            char character = elemento.charAt(POSICION_CHAR);
            if (index == 0) {
                output.append(character);
            } else {
                output.append(diccionario.getSecuenciaIndex(index)).append(character);
            }
        }
        return output.toString();
    }
}