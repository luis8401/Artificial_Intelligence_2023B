// Archivo: Prueba.java

package MLR;

public class Main {

    public static void main(String[] args) {
        double[][] data = DatosMLR.obtenerDatos();
        ProcesadorMLR procesador = new ProcesadorMLR(data);
        procesador.imprimirResultados();
    }
}
