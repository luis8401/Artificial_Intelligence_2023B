package Hands_On2;

import java.util.Stack;
import java.util.ArrayList;

public class DFS {
    private static final String ORIGIN = "A";
    private static final String DESTINATION = "X";

    private final ArrayList<String> visited = new ArrayList<>();// Lista de ciudades visitadas
    private final ArrayList<ArrayList<String>> paths = new ArrayList<>();// Lista para almacenar las trayectorias encontradas
    private final Stack<String> stack = new Stack<>();// Pila para rastrear el camino actual

    public void startDFS() {
        dfs(ORIGIN);// Inicia la búsqueda DFS desde la ciudad de origen
        printPaths();// Imprime las trayectorias encontradas
    }

    private void dfs(String currentCity) {
        visited.add(currentCity);// Marcar la ciudad actual como visitada
        stack.push(currentCity);// Agregar la ciudad actual a la pila

        if (currentCity.equals(DESTINATION)) {
        	// Si se llega a la ciudad de destino, registrar la trayectoria
            ArrayList<String> path = new ArrayList<>(stack);
            paths.add(path);
        } else {
        	//revisar conexiones disponibles en el arreglo
            for (String[] connection : Cities.connections) {
            	// Obtiene las ciudades de origen y destino de la conexión actual
                String from = connection[0];
                String to = connection[1];

                if (from.equals(currentCity) && !visited.contains(to)) {
                	// Explorar las conexiones desde la ciudad actual
                    dfs(to);//explorar la sig ciudadd
                }
            }
        }

        visited.remove(currentCity);// Desmarcar la ciudad actual como visitada
        stack.pop();// Quitar la ciudad actual de la pila
        }

    private void printPaths() {
        if (paths.isEmpty()) {
            System.out.println("No se encontraron trayectorias de " + ORIGIN + " a " + DESTINATION);
        } else {
            // Filtra las trayectorias que no llegan a DESTINATION
//            paths.removeIf(path -> !path.get(path.size() - 1).equals(DESTINATION));

            // Ordena las trayectorias por longitud en orden descendente
            paths.sort((path1, path2) -> path2.size() - path1.size());

            System.out.println("Las trayectorias de " + ORIGIN + " a " + DESTINATION + " son:");
            int count = 1;
            for (ArrayList<String> path : paths) {
                System.out.println("Trayectoria " + count++ + ": " + path);
            }
        }
    }
}
