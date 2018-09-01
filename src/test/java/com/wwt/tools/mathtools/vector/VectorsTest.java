package com.wwt.tools.mathtools.vector;

import org.junit.Test;
import static org.junit.Assert.*;
import static com.wwt.tools.mathtools.MathToolTest.*;


public class VectorsTest {

    @Test
    public void convertToVectorTest() {
        int rowSize = 3 ;
        int columnSize = 1;
        Matrix m = MatrixImplementation.from(createTestMatrix(rowSize,columnSize));
        Vector v1 = Vectors.convertToVector(m);
        rowSize = 1 ;
        columnSize = 3;
        m = MatrixImplementation.from(createTestMatrix(rowSize,columnSize));
        Vector v2 = Vectors.convertToVector(m);
        for (int i = 0; i < v1.getDimension(); i++) {
            assertEquals(i,v1.getValueAt(i),delta);
        }
        for (int i = 0; i < v2.getDimension(); i++) {
            assertEquals(i,v2.getValueAt(i),delta);
        }
        assertEquals(v1.getDimension(),v2.getDimension());

    }


    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void convertToVectorExceptionTest() {
        int rowSize = 2 ;
        int columnSize = 4;
        Matrix m = MatrixImplementation.from(createTestMatrix(rowSize,columnSize));
        Vector v = Vectors.convertToVector(m);
    }


    @Test
    public void convertToMatrixTest() {
        int dim = 3 ;
        Vector v = VectorImplementation.from(createTestVector(dim));
        Matrix m = Vectors.convertToMatrix(v);
        assertEquals(1,m.getColumnNumber());
        assertEquals(dim,m.getRowNumber());
        for (int i = 0; i < dim; i++) {
            assertEquals(i,m.getValueAt(i,0),delta);
        }
    }

    @Test
    public void getIdentityMatrixTest() {
        int dim = 5;
        Matrix m = Vectors.getIdentityMatrix(dim);
        for(int i=0;i<dim;i++) {
            for(int j=0;j<dim;j++) {
                assertEquals(i==j?1:0,m.getValueAt(i,j),delta);
            }
        }
    }



}
