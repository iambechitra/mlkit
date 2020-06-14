package io.bechitra.mlkit.preprocessing;

public class Builder {
    public double[][] transformMatrixWithInitial(double[][] matrix) {
        double [][] newFeatures = new double[matrix.length][matrix[0].length+1];

        for(int i = 0; i < newFeatures.length; i++)
            for(int j  = 0; j < newFeatures[0].length; j++)
                if(j == 0)
                    newFeatures[i][j] = 1;
                else
                    newFeatures[i][j] = matrix[i][j-1];

        return newFeatures;
    }

    public double[] transformArrayWithInitial(double[] array) {
        double[] newArray = new double[array.length + 1];

        for (int i = 0; i < newArray.length; i++)
            if (i == 0)
                newArray[i] = 1.0;
            else
                newArray[i] = array[i - 1];
        return newArray;
    }
}
