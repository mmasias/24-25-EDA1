import java.util.Scanner;

class MenuReproduccion {

    public void imprimir() {
        System.out.print("""
                === MENÚ REPRODUCCIÓN ===
                1. Ver canción actual
                2. Reproducir siguiente
                3. Reproducir anterior
                4. Ver cola de reproducción
                5. Ver historial
                6. Activar/desactivar aleatorio
                7. Activar/desactivar repetición
                8. Volver al menú principal
                """);
    }

    public void seleccionar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una opcion: ");
        int seleccion = scanner.nextInt();
        switch(seleccion){
            case 1:
            break;
            case 2:
            break;
            case 3:
            break;
            case 4:
            break;
            case 5:
            break;
            case 6:
            break;
            case 7:
            break;
            case 8:
            break;
        }
    }    


}
