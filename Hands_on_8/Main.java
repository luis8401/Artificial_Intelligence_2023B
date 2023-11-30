package Hands_on_8;
//realizar dos veces 3 ultimos para utilizacion de entrenamiento
public class Main {

    public static void main(String[] args) {
/*
        int[][] data = {
            {23, 651},
            {26, 762},
            {30, 856},
            {34, 1063},
            {43, 1190},
            {48, 1298},
            {52, 1421},
            {57, 1440},
            {58, 1518}
        };
*/int[][] data = {
        {1, 2},
        {2, 4},
        {3, 6},
        {4, 8},
        {5, 10},
        {6, 12},
        {7, 14},
        {8, 16},
        {9, 18}
    };
        DataSet dataSet = new DataSet(data);

        SLR slr = new SLR(dataSet);

        slr.analyzeData();
    }
} 	