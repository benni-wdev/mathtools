package com.wwt.tools.mathtools;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

public class MathToolTest {
    public final static double delta = 0.1;


    @Test
    public void modularExponentiationTest() {
        assertEquals(0,MathTool.exponentiateMod(2,3,2));
        assertEquals(2,MathTool.exponentiateMod(2,3,3));
        assertEquals(24,MathTool.exponentiateMod(23,20,29));
        assertEquals(0,MathTool.exponentiateMod(23,20,1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void modularExponentiationExceptionTest() {
        assertEquals(0,MathTool.exponentiateMod(23,20,0));
    }



    public static void fillArrayWithRandomDoubles(double [] valueArray, double bound) {
        for (int i =0;i< valueArray.length;i++) {
            valueArray[i] = ThreadLocalRandom.current().nextDouble(bound) -(bound/2);
        }
    }

    public static double [][]  createTestMatrix(int rowSize, int columnSize) {
        double[][] matrix = new double[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                matrix[i][j] = i + j;
            }
        }
        return matrix;
    }

    public static double [] createTestVector(int dimension) {
        double[] vector = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            vector[i] = i ;
        }
        return vector;
    }
}
