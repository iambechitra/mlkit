package io.bechitra.mlkit.utility;

public class Random {
    public double[] getArray(double upperBound, double lowerBound, int length) {
        double[] array = new double[length];

        for(int i = 0; i < array.length; i++) {
            //Generate Random number lowerBound inclusive and upperbound exclusive
            double random = Math.random() * (upperBound - lowerBound + 1) + lowerBound;
            array[i] = random;
        }
        return array;
    }
}
