import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class EstructuraSecuencial {
    private List<Elemento> elementos; // Almacenamiento físico
    private LinkedHashMap<String, Elemento> ordenLogico; // Mapa para mantener el orden

    public EstructuraSecuencial() {
        elementos = new ArrayList<>();
        ordenLogico = new LinkedHashMap<>();
    }

    // Agregar un nuevo elemento al final de la estructura física
    public void agregarElemento(String dato) {
        int nuevoId = elementos.size() + 1;
        Elemento nuevoElemento = new Elemento(nuevoId, dato);
        elementos.add(nuevoElemento);
        // Mantener el orden lógico por defecto
        ordenLogico.put(dato, nuevoElemento);
    }

    // Establecer un nuevo orden lógico basado en los datos
    public void establecerOrden(String... orden) {
        LinkedHashMap<String, Elemento> nuevoOrden = new LinkedHashMap<>();
        for (String dato : orden) {
            if (ordenLogico.containsKey(dato)) {
                nuevoOrden.put(dato, ordenLogico.get(dato));
            }
        }
        ordenLogico = nuevoOrden;
    }

    // Eliminar un elemento lógicamente manteniéndolo en la estructura física
    public void eliminarElemento(String dato) {
        ordenLogico.remove(dato);
    }

    // Mostrar el orden actual lógico
    public void mostrarOrdenLogico() {
        System.out.println("Orden Lógico:");
        ordenLogico.values().forEach(System.out::println);
    }

    // Mostrar la estructura física completa
    public void mostrarEstructuraFisica() {
        System.out.println("Estructura Física:");
        elementos.forEach(System.out::println);
    }
}

