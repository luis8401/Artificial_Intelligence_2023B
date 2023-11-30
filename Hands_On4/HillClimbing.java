package Hands_On4;

import java.util.*;

public class HillClimbing {

    private Grafo grafo;
    private String nodoInicio;

    // Constructor que inicializa el algoritmo con el nodo de inicio
    public HillClimbing(Grafo grafo, String nodoInicio) {
        this.grafo = grafo;
        this.nodoInicio = nodoInicio;
    }

    // Algoritmo de escalada de colinas
    public List<String> escaladaColinas() {
        List<String> caminoActual = caminoMasCorto(nodoInicio);
        int iteracion = 1;

        while (iteracion <= 4) {
            System.out.println("Iteración " + iteracion + ":");
            System.out.println("Camino Actual: " + caminoActual);
            System.out.println("Costo Actual: " + costo(caminoActual));

            List<List<String>> vecinos = obtenerVecinos(caminoActual);
            List<List<String>> vecinosOrdenados = ordenarPorCosto(vecinos);

            if (vecinosOrdenados.isEmpty() || costo(vecinosOrdenados.get(0)) >= costo(caminoActual)) {
                System.out.println("No hay vecinos mejores. Saliendo.");
                return caminoActual;
            } else {
                List<String> mejorVecino = vecinosOrdenados.get(0);
                int nuevoCosto = costo(mejorVecino);

                System.out.println("Se encontró un vecino mejor - Costo: " + nuevoCosto);
                System.out.print("Conexiones realizadas: ");

                Set<String> nodosImpresos = new HashSet<>();
                for (int i = 0; i < mejorVecino.size() - 1; i++) {
                    String desde = mejorVecino.get(i);
                    String hacia = mejorVecino.get(i + 1);
                    if (nodosImpresos.add(desde)) {
                        System.out.print(desde + " con conexión " + hacia + " con peso " + grafo.obtenerPeso(desde, hacia));
                        if (i < mejorVecino.size() - 2) {
                            System.out.print(", ");
                        }
                    }
                }
                System.out.println();

                System.out.println();
                caminoActual = mejorVecino;
                iteracion++;
            }
        }

        System.out.println("Se alcanzó el número máximo de iteraciones. Saliendo.");
        return caminoActual;
    }

    // Método para encontrar el camino más corto desde el nodo de inicio
    private List<String> caminoMasCorto(String nodoInicio) {
        List<String> camino = new ArrayList<>(grafo.obtenerGrafo().keySet());
        Collections.shuffle(camino);

        List<String> nodosVisitados = new ArrayList<>();
        Set<String> nodosNoVisitados = new HashSet<>(grafo.obtenerGrafo().keySet());

        nodosVisitados.add(nodoInicio);
        nodosNoVisitados.remove(nodoInicio);

        while (!nodosNoVisitados.isEmpty()) {
            String nodoActual = nodosVisitados.get(nodosVisitados.size() - 1);
            String siguienteNodo = null;
            int pesoMinimo = Integer.MAX_VALUE;

            for (String nodo : grafo.obtenerGrafo().get(nodoActual).keySet()) {
                if (!nodosVisitados.contains(nodo) && grafo.obtenerGrafo().get(nodoActual).get(nodo) < pesoMinimo) {
                    siguienteNodo = nodo;
                    pesoMinimo = grafo.obtenerGrafo().get(nodoActual).get(nodo);
                }
            }

            if (siguienteNodo != null) {
                nodosVisitados.add(siguienteNodo);
                nodosNoVisitados.remove(siguienteNodo);
            } else {
                nodosVisitados.add(nodoInicio);
            }
        }

        return nodosVisitados;
    }

    // Método para obtener vecinos del camino actual
    private List<List<String>> obtenerVecinos(List<String> camino) {
        List<List<String>> vecinos = new ArrayList<>();
        for (int i = 1; i < camino.size() - 1; i++) {
            for (int j = i + 1; j < camino.size() - 1; j++) {
                List<String> vecino = new ArrayList<>(camino.subList(0, i));
                vecino.addAll(camino.subList(j, camino.size()));
                vecino.addAll(camino.subList(i, j));
                vecinos.add(vecino);
            }
        }
        return vecinos;
    }

    // Método para ordenar caminos por costo
    private List<List<String>> ordenarPorCosto(List<List<String>> caminos) {
        caminos.sort(Comparator.comparingInt(this::costo));
        return caminos;
    }

    // Método para calcular el costo de un camino
    private int costo(List<String> camino) {
        int costoTotal = 0;
        for (int i = 0; i < camino.size() - 1; i++) {
            String desde = camino.get(i);
            String hacia = camino.get(i + 1);
            costoTotal += grafo.obtenerPeso(desde, hacia);
        }
        return costoTotal;
    }
}
