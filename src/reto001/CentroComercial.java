class CentroComercial {
    public static void main(String[] args) {

        Fila fila = new Fila(100);

        fila.entrar(new Persona("John"));
        fila.entrar(new Persona("Paul"));
        fila.entrar(new Persona("George"));
        fila.entrar(new Persona("Ringo"));
        fila.entrar(new Persona("David"));
        fila.entrar(new Persona("Roger"));
        fila.entrar(new Persona("Richard"));

        fila.mostrar();

        fila.salir();
        fila.mostrar();

        fila.salir();
        fila.mostrar();

        fila.abandonar();
        fila.mostrar();

        fila.entrar(new Persona("Nick"));
        fila.entrar(new Persona("Keith"));
        fila.mostrar();

        fila.traerCosas("Mick");
        fila.traerCosas("Ibuprofeno");

        fila.colarseLicitamente(new Persona("Dalsy"), 1);
        fila.mostrar();

        fila.colarseIlicitamente(new Persona("Apiretal"), 0);
        fila.entrar(new Persona("Fucsio"));

        fila.mostrar();

        Fila fila2 = fila.dividir();

        fila.mostrar();
        fila2.mostrar();

        Fila fila3 = fila2.dividir();
        fila3.mostrar();
        
    }
}