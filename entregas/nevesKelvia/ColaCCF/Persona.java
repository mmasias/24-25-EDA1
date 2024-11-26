package entregas.nevesKelvia.ColaCCF;

class Persona {
    private static int contador = 0;
    private int id;

    public Persona() {
        this.id = ++contador;
        System.out.println("Se ha creado la persona con ID: " + id);
    }
}

