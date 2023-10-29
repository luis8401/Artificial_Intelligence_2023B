package Hands_On3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
    private static final String ORIGIN = "NY";
    private static final String DESTINATION = "LA";

    // ArrayList para almacenar todas las trayectorias encontradas
    private  ArrayList<ArrayList<String>> paths = new ArrayList<>();

    // Cola abierta para almacenar trayectorias activas
    private Queue<ArrayList<String>> openQueue = new LinkedList<>();

    // Pila cerrada para mantener un registro de nodos explorados
    private Stack<ArrayList<String>> closedStack = new Stack<>();

    // Método para iniciar la búsqueda en amplitud (BFS)
    public void startBFS() {
        // Crear una trayectoria inicial con la ciudad de origen
        ArrayList<String> initialPath = new ArrayList<>();
        initialPath.add(ORIGIN);

        // Agregar la trayectoria inicial a la cola de exploración
        openQueue.add(initialPath);

        int step = 1; // Variable para rastrear los pasos de exploración

        // Cola para rastrear los niveles
        Queue<ArrayList<String>> levelQueue = new LinkedList<>();

        while (!openQueue.isEmpty()) {
        	//imprimir pasos y cola abierta y pila cerrada
            System.out.println("Paso " + step + ":");
            System.out.println("Cola Abierta: " + openQueue);
            System.out.println("Pila Cerrada: " + closedStack);

            // Obtener el tamaño actual de la cola abierta (nivel actual)
            int currentLevelSize = openQueue.size();
            // Iterar a través de las trayectorias en el nivel actual
            for (int i = 0; i < currentLevelSize; i++) {
            	// Obtener y eliminar la trayectoria actual de la cola abierta
                ArrayList<String> currentPath = openQueue.poll();
                // Registrar la trayectoria actual en la pila cerrada
                closedStack.push(currentPath);

                // Obtener la ciudad actual (ultima ciudad en la trayectoria)
                String currentCity = currentPath.get(currentPath.size() - 1);

                // Trrayectoria que se esta explorando
                System.out.println("Explorando trayectoria: " + currentPath);

                // Verificar si la ciudad actual es la ciudad de destino
                if (currentCity.equals(DESTINATION)) {
                	// Agregar la trayectoria completa a la lista de trayectorias encontradas
                    paths.add(currentPath);
                    System.out.println("Trayectoria a " + DESTINATION + " encontrada.");
                } else {
                	// Explorar las conexiones desde la ciudad actual
                    for (String[] connection : Cities.connections) {
                        String from = connection[0];
                        String to = connection[1];

                        // Verificar si la conexion parte desde la ciudad actual
                        // y si la ciudad de destino no ests en la trayectoria actual
                        if (from.equals(currentCity) && !currentPath.contains(to)) {
                        	// Crear una nueva trayectoria basada en la trayectoria actual
                            ArrayList<String> newPath = new ArrayList<>(currentPath);
                            newPath.add(to);
                            levelQueue.add(newPath); // Usar levelQueue en lugar de openQueue
                        }
                    }
                }
            }

            step++;// Incrementar el número de paso

            // Intercambiar levelQueue y openQueue al final del paso
            Queue<ArrayList<String>> temp = openQueue;
            openQueue = levelQueue;
            levelQueue = temp;
        }

        System.out.println("Exploración completa.");
        printExploration();
    }

    // pos imprimirs
    private void printExploration() {
        if (paths.isEmpty()) {
            System.out.println("No se encontraron trayectorias de " + ORIGIN + " a " + DESTINATION);
        } else {
            System.out.println("Todas las trayectorias de " + ORIGIN + " a " + DESTINATION + " son:");

            for (ArrayList<String> path : paths) {
                System.out.println(path);
            }
        }
    }
}