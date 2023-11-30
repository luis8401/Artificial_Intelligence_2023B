package Hands_On4;

import java.util.*;

public class Grafo {

    private Map<String, Map<String, Integer>> grafo;

    // Constructor que inicializa el grafo
    public Grafo() {
        grafo = new HashMap<>();
    }

    // Método para agregar una conexión entre dos nodos con un peso dado
    public void agregarArista(String nodo1, String nodo2, int peso) {
        grafo.computeIfAbsent(nodo1, k -> new HashMap<>()).put(nodo2, peso);
        grafo.computeIfAbsent(nodo2, k -> new HashMap<>()).put(nodo1, peso);
    }

    // Método para obtener el peso entre dos nodos
    public int obtenerPeso(String nodo1, String nodo2) {
        return grafo.getOrDefault(nodo1, Collections.emptyMap()).getOrDefault(nodo2, 0);
    }

    // Método para obtener el grafo completo
    public Map<String, Map<String, Integer>> obtenerGrafo() {
        return grafo;
    }

}
