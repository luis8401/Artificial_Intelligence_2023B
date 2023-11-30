package Hands_on_8;
//
public class SLR {

    private final DataSet dataSetInstance;

    // Constructor que recibe una instancia de DataSet
    public SLR(DataSet dataSet) {
        this.dataSetInstance = dataSet;
    }

    // Método que devuelve la instancia de DataSet
    public DataSet getDataSetInstance() {
        return dataSetInstance;
    }

    // Método principal para analizar los datos
    public void analyzeData() {
        printDataSet(); // Imprimir el conjunto de datos
        printBetas(); // Imprimir los coeficientes beta
        printPredictions(); // Imprimir las predicciones
        printCorrelationAndDetermination(); // Imprimir el coeficiente de correlación y determinación
    }

    // Método privado para imprimir el conjunto de datos
    private void printDataSet() {
        int[][] data = dataSetInstance.getDataSet();
        System.out.println("X           Y ");
        for (int[] rowData : data) {
            System.out.println("" + rowData[0] + "          " + rowData[1]);
        }
        System.out.println("");
    }
    
    // Método privado para calcular la media de la variable X
    private double meanX() {
        int columnLength = dataSetInstance.getColumnLength();
        double sumX = dataSetInstance.getColumnSum(0);
        return sumX / columnLength;
    }
    
    // Método privado para calcular la media de la variable Y
    private double meanY() {
        int columnLength = dataSetInstance.getColumnLength();
        double sumY = dataSetInstance.getColumnSum(1);
        return sumY / columnLength;
    }

    // Método privado para calcular la suma de productos
    private double calculateSumOfProducts() {
        int[][] data = dataSetInstance.getDataSet();
        double sop = 0;

        for (int[] row : data) {
            sop += (row[0] - meanX()) * (row[1] - meanY());
        }
        
        return sop;
    }

    // Método privado para calcular la suma de cuadrados
    private double calculateSumOfSquares() {
        int[][] data = dataSetInstance.getDataSet();
        double soq = 0;

        for (int[] row : data) {
            soq += Math.pow((row[0] - meanX()), 2);
        }
        
        return soq;
    }

    // Método privado para calcular el coeficiente beta0
    private double calculateBeta0() {
        return meanY() - calculateBeta1() * meanX();
    }

    // Método privado para calcular el coeficiente beta1
    private double calculateBeta1() {
        return calculateSumOfProducts() / calculateSumOfSquares();
    }

    // Método privado para imprimir los coeficientes beta
    private void printBetas() {
        System.out.println("β1: " + calculateBeta1());
        System.out.println("β0: " + calculateBeta0());
        System.out.println("");
    }

    // Método privado para imprimir las predicciones
    private void printPredictions() {
        int columnLength = dataSetInstance.getColumnLength();
        System.out.println("ŷ = β1 " + calculateBeta1() + " + β0 " + calculateBeta0() + " Xi");

        for (int i = 0; i < columnLength; i++) {
            double yPredict = calculateBeta0() + calculateBeta1() * dataSetInstance.getValue(i, 0);
            System.out.println((i + 1) + ": " + yPredict);
        }
        
        System.out.println("");
    }

    // Método privado para calcular el coeficiente de correlación
    private double calculateCorrelationCoefficient() {
        int[][] data = dataSetInstance.getDataSet();
        double soqX = 0;
        double soqY = 0;

        for (int[] row : data) {
            soqX += Math.pow((row[0] - meanX()), 2);
            soqY += Math.pow((row[1] - meanY()), 2);
        }

        return calculateSumOfProducts() / (Math.sqrt(soqX) * Math.sqrt(soqY));
    }
     
    // Método privado para calcular el coeficiente de determinación
    private double calculateCoefficientOfDetermination() {
        double correlationCoefficient = calculateCorrelationCoefficient();
        return Math.pow(correlationCoefficient, 2);
    }

    // Método privado para imprimir el coeficiente de correlación y determinación
    private void printCorrelationAndDetermination() {
        System.out.println("Coeficiente de Correlación (r): " + calculateCorrelationCoefficient());
        System.out.println("Coeficiente de Determinación (r^2): " + calculateCoefficientOfDetermination());
    }
}
