package Hands_on_8;

public class DataSet {
    
    private final int[][] dataSet;

    // Constructor que recibe un conjunto de datos
    public DataSet(int[][] data) {
        this.dataSet = data;
    }

    // Método para obtener la longitud de las columnas en el conjunto de datos
    public int getColumnLength() {
        return dataSet.length;
    }

    // Método para obtener la suma de una columna específica en el conjunto de datos
    public int getColumnSum(int columnIndex) {
        int sum = 0;
        for (int[] row : dataSet) {
            sum += row[columnIndex];
        }
        return sum;
    }

    // Método para obtener el valor en una posición específica del conjunto de datos
    public int getValue(int row, int column) {
        return dataSet[row][column];
    }
    
    // Método para obtener el conjunto de datos completo
    public int[][] getDataSet() {
        return dataSet;
    }
}
