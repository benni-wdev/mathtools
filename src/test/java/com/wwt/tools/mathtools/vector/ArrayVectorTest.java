package com.wwt.tools.mathtools.vector;


import org.junit.Test;
import static com.wwt.tools.mathtools.MathToolTest.*;
import static org.junit.Assert.*;

public class ArrayVectorTest {

    @Test
    public void createTest() {
        int dim = 5;
        Vector v = ArrayVector.from(createTestVector(dim));
        assertEquals(dim,v.getDimension());
        for (int i = 0; i < dim; i++) {
            assertEquals(i,v.getValueAt(i),delta);
        }

    }

    @Test
    public void getDimensionTest() {
        int dim = 1;
        Vector v = ArrayVector.from(createTestVector(dim));
        assertEquals(dim,v.getDimension());
        dim = 5;
        v =ArrayVector.from(createTestVector(dim));
        assertEquals(dim,v.getDimension());
    }

    @Test
    public void getValueAtTest() {
        int dim = 50;
        Vector v = ArrayVector.from(createTestVector(dim));
        for (int i = 0; i < dim; i++) {
            assertEquals(i,v.getValueAt(i),delta);
        }
    }


    @Test
    public void getScalarProductTest() {
        int dim = 50;
        double check = 0;
        Vector v1 = ArrayVector.from(createTestVector(dim));
        Vector v2 = ArrayVector.from(createTestVector(dim));
        for (int i = 0; i < dim; i++) {
            check += i*i;
        }
        assertEquals(check,v1.getScalarProduct(v2),delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getScalarProductExceptionTest() {
        int dim = 50;
        double check = 0;
        Vector v1 = ArrayVector.from(createTestVector(dim));
        Vector v2 = ArrayVector.from(createTestVector(dim+1));
        for (int i = 0; i < dim; i++) {
            check += i*i;
        }
        assertEquals(check,v1.getScalarProduct(v2),delta);
    }


    @Test
    public void multiplyTest() {
        int dim = 50;
        double scalar = 3.5;
        Vector v1 = ArrayVector.from(createTestVector(dim));
        Vector v= v1.multiply(scalar);
        for (int i = 0; i < dim; i++) {
            assertEquals(i*scalar,v.getValueAt(i),delta);
        }
    }

    @Test
    public void addTest() {
        int dim = 50;
        Vector v1 = ArrayVector.from(createTestVector(dim));
        Vector v2 = ArrayVector.from(createTestVector(dim));
        Vector v= v1.add(v2);
        for (int i = 0; i < dim; i++) {
            assertEquals(i*2,v.getValueAt(i),delta);
        }
    }
    @Test(expected = IllegalArgumentException.class)
    public void addExceptionTest() {
        int dim = 50;
        Vector v1 = ArrayVector.from(createTestVector(dim));
        Vector v2 = ArrayVector.from(createTestVector(dim+1));
        Vector v= v1.add(v2);
        for (int i = 0; i < dim; i++) {
            assertEquals(i*2,v.getValueAt(i),delta);
        }
    }

    @Test
    public void switchTest() {
        int dim = 5;
        int index1 = 2;
        int index2 = 3;
        Vector v1 = ArrayVector.from(createTestVector(dim));
        Vector v  = v1.switchValues(index1,index2);
        assertEquals(index1,v.getValueAt(index2),delta);
        assertEquals(index2,v.getValueAt(index1),delta);
    }
    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void switchException1Test() {
        int dim = 5;
        int index1 = 5;
        int index2 = 3;
        Vector v1 = ArrayVector.from(createTestVector(dim));
        Vector v  = v1.switchValues(index1,index2);
    }
    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void switchException2Test() {
        int dim = 5;
        int index1 = 0;
        int index2 = 7;
        Vector v1 = ArrayVector.from(createTestVector(dim));
        Vector v  = v1.switchValues(index1,index2);
    }

    @Test
    public void equalsTest() {
        int dim = 5;
        double[] vector = new double[dim];
        for (int i = 0; i < dim; i++) {
            vector[i] = i ;
        }
        vector[dim-1] = 0;
        Vector v1 = ArrayVector.from(createTestVector(dim));
        assertEquals(v1, ArrayVector.from(createTestVector(dim)));
        assertEquals(v1, v1);
        assertNotEquals(v1, ArrayVector.from(createTestVector(dim + 1)));
        assertNotEquals(v1,null);
        assertNotEquals(v1, createTestVector(dim));
        assertNotEquals(v1, ArrayVector.from(vector));

    }

    @Test
    public void hashCodeTest() {
        int dim = 5;
        Vector v1 = ArrayVector.from(createTestVector(dim));
        Vector v2 = ArrayVector.from(createTestVector(dim));
        Vector v3 = ArrayVector.from(createTestVector(dim+1));
        assertEquals(v1.hashCode(),v2.hashCode());
        assertEquals(v1.hashCode(),v1.hashCode());
        assertNotEquals(v1.hashCode(),v3.hashCode());
    }

}
