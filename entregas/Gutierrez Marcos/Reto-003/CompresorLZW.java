public class CompresorLZW {

    Diccionario diccionario;

    public CompresorLZW() {
        this.diccionario = new Diccionario();
    }

    public String comprimir(String cadena) {
        String salida = "";
        String value = "";

        for (int i = 0; i < cadena.length(); i++){
            while(diccionario.contiene(String.valueOf(cadena.charAt(i)))){
                value += String.valueOf(cadena.charAt(i));
                i++;
            }
            diccionario.agregar(value);
       }

        return salida;
    }
}