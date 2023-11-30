// Archivo: ImpresorResultados.java

package MLR;

public class ImpresorResultados {

    public static void imprimirMeanX1(double meanx1) {
        System.out.println("Mean X1: " + meanx1);
    }

    public static void imprimirMeanX2(double meanx2) {
        System.out.println("Mean X2: " + meanx2);
    }

    public static void imprimirMeanY(double meany) {
        System.out.println("Mean Y: " + meany);
    }

    public static void imprimirSumX1(double sumx1) {
        System.out.println("Sumatoria X1: " + sumx1);
    }

    public static void imprimirSumX2(double sumx2) {
        System.out.println("Sumatoria X2: " + sumx2);
    }

    public static void imprimirSumY(double sumy) {
        System.out.println("Sumatoria Y: " + sumy);
    }

    public static void imprimirSumOfSquaresX1(double soqx1) {
        System.out.println("Sum Of Squares X1: " + soqx1);
    }

    public static void imprimirSumOfSquaresX2(double soqx2) {
        System.out.println("Sum Of Squares X2: " + soqx2);
    }

    public static void imprimirSumOfProductsX1Y(double sopx1y) {
        System.out.println("Sum Of Products X1Y: " + sopx1y);
    }

    public static void imprimirSumOfProductsX2Y(double sopx2y) {
        System.out.println("Sum Of Products X2Y: " + sopx2y);
    }

    public static void imprimirSumOfProductsX1X2(double sopx1x2) {
        System.out.println("Sum Of Products X1X2: " + sopx1x2);
    }

    public static void imprimirBeta1(double b1) {
        System.out.println("Beta1: " + b1);
    }

    public static void imprimirBeta2(double b2) {
        System.out.println("Beta2: " + b2);
    }

    public static void imprimirBeta0(double b0) {
        System.out.println("Beta0: " + b0);
    }

    public static void imprimirPredictions(double[] predictions) {
        for (int i = 0; i < predictions.length; i++) {
            System.out.println((i + 1) + ": " + predictions[i]);
        }
    }

    public static void imprimirR2(double r2) {
        System.out.println("R²: " + r2);
    }

    public static void imprimirAdjustedR2(double adjustedR2) {
        System.out.println("Ajusted R²: " + adjustedR2);
    }
}
