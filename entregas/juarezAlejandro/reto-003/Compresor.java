class Compresor {
    private String ultimaSecuencia = "";
    private Diccionario diccionario = new Diccionario();

    public String comprimir(String texto) {
        StringBuilder comprimir = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            String secuenciaActual = String.valueOf(texto.charAt(i));

            if (ultimaSecuencia.length() > 0) {
                String nuevoEspacio = ultimaSecuencia + secuenciaActual;

                if (diccionario.estáEnDiccionario(nuevoEspacio)) {
                    ultimaSecuencia += secuenciaActual;
                    continue;
                } else {
                    diccionario.añadirAlDiccionario(nuevoEspacio);
                    int index = diccionario.getIndexSecuencia(ultimaSecuencia);
                    comprimir.append("(").append(index).append(",").append(secuenciaActual).append(")");
                    ultimaSecuencia = "";
                    continue;
                }
            }

            if (diccionario.estáEnDiccionario(secuenciaActual)) {
                ultimaSecuencia = secuenciaActual;
                continue;
            } else {
                diccionario.añadirAlDiccionario(secuenciaActual);
                comprimir.append("(0,").append(secuenciaActual).append(")");
            }
        }
        return comprimir.toString();
    }

    public Diccionario getDiccionario() {
        return diccionario;
    }
}