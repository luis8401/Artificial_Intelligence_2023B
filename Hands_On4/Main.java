package Hands_On4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto Grafo
        Grafo grafo = new Grafo();

        // Agregar aristas al grafo
        grafo.agregarArista("a", "b", 200);
        grafo.agregarArista("a", "c", 125);
        grafo.agregarArista("a", "d", 100);
        grafo.agregarArista("a", "e", 175);

        grafo.agregarArista("b", "a", 200);
        grafo.agregarArista("b", "c", 50);
        grafo.agregarArista("b", "d", 75);
        grafo.agregarArista("b", "e", 125);

        grafo.agregarArista("c", "a", 125);
        grafo.agregarArista("c", "b", 50);
        grafo.agregarArista("c", "d", 100);
        grafo.agregarArista("c", "e", 125);

        grafo.agregarArista("d", "a", 100);
        grafo.agregarArista("d", "b", 75);
        grafo.agregarArista("d", "c", 100);
        grafo.agregarArista("d", "e", 50);

        grafo.agregarArista("e", "a", 175);
        grafo.agregarArista("e", "b", 125);
        grafo.agregarArista("e", "c", 125);
        grafo.agregarArista("e", "d", 50);

        // Crear un objeto HillClimbing con el grafo y el nodo de inicio
        HillClimbing escaladaColinas = new HillClimbing(grafo, "a");

        // Ejecutar el algoritmo de escalada de colinas
        List<String> caminoOptimizado = escaladaColinas.escaladaColinas();

        // Imprimir el camino optimizado
        System.out.println("Camino Optimizado:");
        System.out.print("[ ");
        for (String nodo : caminoOptimizado) {
            System.out.print(nodo + " ");
        }
        System.out.println("]");
    }
}
