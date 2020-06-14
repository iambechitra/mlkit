package io.bechitra.mlkit.model;

import io.bechitra.mlkit.utility.Random;

public class LinearRegression {
    private double[] param;

    public LinearRegression(){
        param = new double[1];
    }

    public void fit(double[][] features, double[] labels) {
        param = getParamByGradient(features, labels, new Random().getArray(10, 1, features[0].length));
    }

    public double predict(double[] xValues) {
        if(xValues.length != param.length)
            return -1.0;
        else {
            double y = 0;
            for(int i = 0; i < param.length; i++)
                y += param[i]*xValues[i];
            return y;
        }
    }

    private double getErrorCalculation(double[][]features, double[]labels, double []param, int root) {
        int jIndex = features[0].length;
        int iIndex = features.length;
        double error = 0;

        for(int i = 0; i < iIndex; i++) {
            double hypothesis = 0;
            for(int j = 0; j < jIndex; j++) {
                hypothesis += (features[i][j] * param[j]);
            }
            //double pow = Math.pow((hypothesis - labels[i]), 2);
            error += ((hypothesis - labels[i])  * features[i][root]);
        }

        return error;
    }

    private double[] getParamByGradient(double[][]features, double[]labels, double[]param) {
        double []temp = new double[param.length];
        final double alpha = 0.1;
        int length = features.length;

        for (int iter = 0; iter < 1000; iter++) {
            for(int i = 0; i < param.length; i++)
                temp[i] = param[i] - (alpha/length)*getErrorCalculation(features, labels, param, i);

            for(int i = 0; i < param.length; i++)
                param[i] = temp[i];
        }

        return param;
    }
}
