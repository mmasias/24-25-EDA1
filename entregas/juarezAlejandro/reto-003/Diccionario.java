class Diccionario {
    private String[] diccionario = new String[100];

    public int getIndexSecuencia(String ultimaSecuencia) {
        int index = 0;
        while (diccionario[index] != null) {
            if (diccionario[index].equals(ultimaSecuencia)) {
                return index + 1;
            }
            index++;
        }
        return -1;
    }

    public void añadirAlDiccionario(String nuevoEspacio) {
        for (int i = 0; i < diccionario.length; i++) {
            if (diccionario[i] == null) {
                diccionario[i] = nuevoEspacio;
                break;
            }
        }
    }

    public boolean estáEnDiccionario(String nuevoEspacio) {
        for (String secuencia : diccionario) {
            if (secuencia != null && secuencia.equals(nuevoEspacio)) {
                return true;
            }
        }
        return false;
    }

    public String getDictionary() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < diccionario.length; i++) {
            if (diccionario[i] != null) {
                result.append(i + 1).append(":").append(diccionario[i]).append(" ");
            }
        }
        return result.toString();
    }

    public String getSecuenciaIndex(int index) {
        return diccionario[index - 1];
    }
}
