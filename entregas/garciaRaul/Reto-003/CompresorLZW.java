public class CompresorLZW {

    Diccionario diccionario;
    String salida = "";
    int indice = 0;

    public CompresorLZW() {
        this.diccionario = new Diccionario();
    }

    public String comprimir(String cadena) {
        String salida = "";
    public void comprimir(String cadena) {
        String value = "";

        for (int i = 0; i < cadena.length(); i++){
            while(diccionario.contiene(String.valueOf(cadena.charAt(i)))){
                value += String.valueOf(cadena.charAt(i));

            value = String.valueOf(cadena.charAt(i));

            while(diccionario.contiene(value)){
                this.salida += indice + " " + value;
                System.out.println("Entra");
                i++;
                value += String.valueOf(cadena.charAt(i));
                indice++;
            }
            diccionario.agregar(value);
            this.salida += "(" + indice + " " + value + "), ";
       }

        return salida;
       System.out.println(salida);
    }
}
    }
}



