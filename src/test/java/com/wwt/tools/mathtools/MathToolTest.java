/* Copyright 2018-2019 Wehe Web Technologies
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wwt.tools.mathtools;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MathToolTest {
    public final static double delta = 0.1;


    @Test
    public void modularExponentiationTest() {
        assertEquals(0,MathTool.exponentiationModulo(2,3,2));
        assertEquals(2,MathTool.exponentiationModulo(2,3,3));
        assertEquals(24,MathTool.exponentiationModulo(23,20,29));
        assertEquals(0,MathTool.exponentiationModulo(23,20,1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void modularExponentiationExceptionTest() {
        assertEquals(0,MathTool.exponentiationModulo(23,20,0));
    }

    @Test
    public void multiplyModuloTest() {
        assertEquals(1,MathTool.multiplyModulo(3,5,7));
        assertEquals(0,MathTool.multiplyModulo(1,18,3));
        assertEquals(0,MathTool.multiplyModulo(3,5,5));
        assertEquals(6,MathTool.multiplyModulo(4,5,7));
    }

    @Test
    public void isSquareTest(){
        assertTrue(MathTool.isSquare(49));
        assertTrue(MathTool.isSquare(1));
        assertTrue(MathTool.isSquare(81));
        assertFalse(MathTool.isSquare(2));
        assertFalse(MathTool.isSquare(80));
        assertFalse(MathTool.isSquare(82));
        assertTrue(MathTool.isSquare(144));
        assertTrue(MathTool.isSquare(4));

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

    public static double [][]  createRandomTestMatrix(int rowSize, int columnSize) {
        double[][] matrix = new double[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextDouble();
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

    public static List<Integer> getArrayAsList(int [] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    public static List<Long> getArrayAsList(long [] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }
}
