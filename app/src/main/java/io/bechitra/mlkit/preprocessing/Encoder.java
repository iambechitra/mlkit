package io.bechitra.mlkit.preprocessing;

public class Encoder {
    private double MAX, MIN, upperBound, lowerBound;
    private double[][] dataSet;

    public Encoder(double[][] matrix, double upperBound, double lowerBound) {
        this.dataSet = matrix;
        this.MAX = Double.MIN_VALUE;
        this.MIN = Double.MAX_VALUE;
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        generateMaxMin(dataSet);
    }

    public double[][] getNormalizeMatrix(boolean considerInitialColumn) {
        double [][] normalizeMatrix = new double[dataSet.length][dataSet[0].length];

        if(considerInitialColumn)
            for(int i = 0; i < normalizeMatrix.length; i++)
                for(int j = 0; j < normalizeMatrix[0].length; j++)
                    if(j == 0)
                        normalizeMatrix[i][j] = dataSet[i][j];
                    else
                        normalizeMatrix[i][j] = ((dataSet[i][j] - MIN) / (MAX - MIN)) * (upperBound - lowerBound) + lowerBound;

         else
            for(int i = 0; i < normalizeMatrix.length; i++)
                for(int j = 0; j < normalizeMatrix[0].length; j++)
                    normalizeMatrix[i][j] = ((dataSet[i][j] - MIN) / (MAX - MIN)) * (upperBound - lowerBound) + lowerBound;

        return normalizeMatrix;
    }

    public double[] getNormalizeArray(double[]array, boolean considerInitial) {
        double[] normalizeArray = new double[array.length];
        if(considerInitial)
            for (int i = 0; i < array.length; i++)
                if(i == 0)
                    normalizeArray[i] = array[i];
                else
                    normalizeArray[i] = ((array[i] - MIN) / (MAX - MIN)) * (upperBound - lowerBound) + lowerBound;
        else
            for (int i = 0; i < array.length; i++)
                normalizeArray[i] = ((array[i] - MIN) / (MAX - MIN)) * (upperBound - lowerBound) + lowerBound;

        return normalizeArray;
    }

    private void generateMaxMin(double[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (MAX < matrix[i][j])
                    MAX = matrix[i][j];
                if (MIN > matrix[i][j])
                    MIN = matrix[i][j];
            }
        }
    }

}
