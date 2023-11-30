// Archivo: ProcesadorMLR.java

package MLR;

public class ProcesadorMLR {

    private double[][] datos;

    // Constructor que recibe los datos
    public ProcesadorMLR(double[][] datos) {
        this.datos = datos;
    }

    // Método principal que imprime todos los resultados
    public void imprimirResultados() {
        ImpresorResultados.imprimirMeanX1(meanx1());
        ImpresorResultados.imprimirMeanX2(meanx2());
        ImpresorResultados.imprimirMeanY(meany());
        ImpresorResultados.imprimirSumX1(sumx1());
        ImpresorResultados.imprimirSumX2(sumx2());
        ImpresorResultados.imprimirSumY(sumy());
        ImpresorResultados.imprimirSumOfSquaresX1(soqx1());
        ImpresorResultados.imprimirSumOfSquaresX2(soqx2());
        ImpresorResultados.imprimirSumOfProductsX1Y(sopx1y());
        ImpresorResultados.imprimirSumOfProductsX2Y(sopx2y());
        ImpresorResultados.imprimirSumOfProductsX1X2(sopx1x2());
        ImpresorResultados.imprimirBeta1(b1());
        ImpresorResultados.imprimirBeta2(b2());
        ImpresorResultados.imprimirBeta0(b0());
        ImpresorResultados.imprimirPredictions(predict());
        double[] predictions = predict();
        ImpresorResultados.imprimirR2(calculateR2(predictions));
        int numPredictors = 2;
        ImpresorResultados.imprimirAdjustedR2(calculateAdjustedR2(calculateR2(predictions), datos.length, numPredictors));
    }

    // Métodos privados para cálculos internos

    private double meanx1() {
        int filas = datos.length;
        double meanx1 = 0;

        for (int i = 0; i < filas; i++) {
            meanx1 += datos[i][0];
        }

        return meanx1 / filas;
    }

    private double meanx2() {
        int filas = datos.length;
        double meanx2 = 0;

        for (int i = 0; i < filas; i++) {
            meanx2 += datos[i][1];
        }

        return meanx2 / filas;
    }

    private double meany() {
        int filas = datos.length;
        double meany = 0;

        for (int i = 0; i < filas; i++) {
            meany += datos[i][2];
        }

        return meany / filas;
    }

    private double sumx1() {
        int filas = datos.length;
        double sumx1 = 0;

        for (int i = 0; i < filas; i++) {
            sumx1 += datos[i][0];
        }

        return sumx1;
    }

    private double sumx2() {
        int filas = datos.length;
        double sumx2 = 0;

        for (int i = 0; i < filas; i++) {
            sumx2 += datos[i][1];
        }

        return sumx2;
    }

    private double sumy() {
        int filas = datos.length;
        double sumy = 0;

        for (int i = 0; i < filas; i++) {
            sumy += datos[i][2];
        }

        return sumy;
    }

    private double soqx1() {
        int fila = datos.length;
        double soqx1 = 0;

        for (int i = 0; i < fila; i++) {
            soqx1 += Math.pow((datos[i][0] - meanx1()), 2);
        }

        return soqx1;
    }

    private double soqx2() {
        int fila = datos.length;
        double soqx2 = 0;

        for (int i = 0; i < fila; i++) {
            soqx2 += Math.pow((datos[i][1] - meanx2()), 2);
        }

        return soqx2;
    }

    private double sopx1y() {
        int fila = datos.length;
        double sopx1y = 0;

        for (int i = 0; i < fila; i++) {
            sopx1y += (datos[i][0] - meanx1()) * (datos[i][2] - meany());
        }

        return sopx1y;
    }

    private double sopx2y() {
        int fila = datos.length;
        double sopx2y = 0;

        for (int i = 0; i < fila; i++) {
            sopx2y += (datos[i][1] - meanx2()) * (datos[i][2] - meany());
        }

        return sopx2y;
    }

    private double sopx1x2() {
        int fila = datos.length;
        double sopx1x2 = 0;

        for (int i = 0; i < fila; i++) {
            sopx1x2 += (datos[i][0] - meanx1()) * (datos[i][1] - meanx2());
        }

        return sopx1x2;
    }

    private double b1() {
        double b1 = 0;
        b1 = (sopx1y() * soqx2() - sopx1x2() * sopx2y()) / (soqx1() * soqx2() - sopx1x2() * sopx1x2());
        return b1;
    }

    private double b2() {
        double b2 = 0;
        b2 = (sopx2y() * soqx1() - sopx1x2() * sopx1y()) / (soqx1() * soqx2() - sopx1x2() * sopx1x2());
        return b2;
    }

    private double b0() {
        double b0 = 0;
        b0 = meany() - (b1() * meanx1()) - ((b2() * meanx2()));
        return b0;
    }

    private double[] predict() {
        int fila = datos.length;
        double[] predictions = new double[fila];

        for (int i = 0; i < fila; i++) {
            predictions[i] = b0() + (b1() * datos[i][0]) + (b2() * datos[i][1]);
            System.out.println((i + 1) + ": " + predictions[i]);
        }

        return predictions;
    }

    private double calculateR2(double[] predictions) {
        int fila = datos.length;

        // Calcular la suma total de cuadrados
        double totalSumOfSquares = 0;
        for (int i = 0; i < fila; i++) {
            totalSumOfSquares += Math.pow((datos[i][2] - meany()), 2);
        }

        // Calcular la suma de errores cuadráticos residuales
        double sumOfSquaredResiduals = 0;
        for (int i = 0; i < fila; i++) {
            sumOfSquaredResiduals += Math.pow((datos[i][2] - predictions[i]), 2);
        }

        // Calcular R^2
        return 1 - (sumOfSquaredResiduals / totalSumOfSquares);
    }

    private double calculateAdjustedR2(double rSquared, int n, int k) {
        return 1 - ((1 - rSquared) * (n - 1) / (n - k - 1));
    }
}
