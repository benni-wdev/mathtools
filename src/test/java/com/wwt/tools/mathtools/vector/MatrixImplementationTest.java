package com.wwt.tools.mathtools.vector;


import org.junit.Test;
import static org.junit.Assert.*;
import static com.wwt.tools.mathtools.MathToolTest.*;

public class MatrixImplementationTest {

    @Test
    public void creationTest() {
        int rowSize = 3 ;
        int columnSize = 4;
        double [] [] matrix =createTestMatrix(rowSize,columnSize);
        Matrix m = MatrixImplementation.from(matrix);
        matrix[rowSize-1][columnSize-1] = Double.MAX_VALUE;
        assertEquals(rowSize+columnSize-2,m.getValueAt(rowSize-1,columnSize-1),delta);
    }

    @Test
    public void countTest() {
        int rowSize = 3 ;
        int columnSize = 4;
        Matrix m = MatrixImplementation.from(createTestMatrix(rowSize,columnSize));
        assertEquals(rowSize,m.getRowNumber());
        assertEquals(columnSize,m.getColumnNumber());
    }

    @Test
    public void getVectorTest() {
        int rowSize = 3 ;
        int columnSize = 4;
        int rowIndex = 1;
        int columnIndex = 3;
        Matrix m = MatrixImplementation.from(createTestMatrix(rowSize,columnSize));
        Vector row = m.getRowVectorAt(rowIndex);
        for(int i=0;i<columnSize;i++) {
           assertEquals(rowIndex+i,row.getValueAt(i),delta);
        }
        Vector column= m.getColumnVectorAt(columnIndex);
        for(int i=0;i<rowSize;i++) {
            assertEquals(columnIndex+i,column.getValueAt(i),delta);
        }
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void getVectorException1Test() {
        int rowSize = 3 ;
        int columnSize = 4;
        Matrix m = MatrixImplementation.from(createTestMatrix(rowSize,columnSize));
        Vector row = m.getRowVectorAt(rowSize);
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void getVectorException2Test() {
        int rowSize = 3 ;
        int columnSize = 4;
        Matrix m = MatrixImplementation.from(createTestMatrix(rowSize,columnSize));
        Vector column = m.getColumnVectorAt(columnSize);
    }

    @Test
    public void addTest() {
        int rowSize = 3 ;
        int columnSize = 4;
        Matrix m1 = MatrixImplementation.from(createTestMatrix(rowSize,columnSize));
        Matrix m2 = MatrixImplementation.from(createTestMatrix(rowSize,columnSize));
        Matrix m = m1.add(m2);
        Matrix n = m2.add(m1);
        for(int i=0;i<rowSize;i++) {
            for(int j=0;j<columnSize;j++) {
                assertEquals((i+j)*2,m.getValueAt(i,j),delta);
                assertEquals(n.getValueAt(i,j),m.getValueAt(i,j),delta);
            }
        }
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void addException1Test() {
        int rowSize1 = 2 ;
        int columnSize1 = 7;
        int rowSize2 = 3 ;
        int columnSize2 = 5;
        Matrix m1 = MatrixImplementation.from(createTestMatrix(rowSize1,columnSize1));
        Matrix m2 = MatrixImplementation.from(createTestMatrix(rowSize2,columnSize2));
        Matrix m = m1.add(m2);
    }
    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void addException2Test() {
        int rowSize1 = 2 ;
        int columnSize1 = 7;
        int rowSize2 = 2 ;
        int columnSize2 = 5;
        Matrix m1 = MatrixImplementation.from(createTestMatrix(rowSize1,columnSize1));
        Matrix m2 = MatrixImplementation.from(createTestMatrix(rowSize2,columnSize2));
        Matrix m = m1.add(m2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void addException3Test() {
        int rowSize1 = 3 ;
        int columnSize1 = 5;
        int rowSize2 = 2 ;
        int columnSize2 = 5;
        Matrix m1 = MatrixImplementation.from(createTestMatrix(rowSize1,columnSize1));
        Matrix m2 = MatrixImplementation.from(createTestMatrix(rowSize2,columnSize2));
        //noinspection unused
        Matrix m = m1.add(m2);
    }

    @Test
    public void multiplyMatrixTest() {
        int rowSize1 = 6 ;
        int columnSize1 = 3;
        int rowSize2 = 3 ;
        int columnSize2 = 4;
        Matrix m1 = MatrixImplementation.from(createTestMatrix(rowSize1,columnSize1));
        Matrix m2 = MatrixImplementation.from(createTestMatrix(rowSize2,columnSize2));
        Matrix m = m1.multiply(m2);
        assertEquals(rowSize1,m.getRowNumber());
        assertEquals(columnSize2,m.getColumnNumber());
        assertEquals(14,m.getValueAt(1,1),delta);
        assertEquals(5,m.getValueAt(0,0),delta);
        assertEquals(50,m.getValueAt(3,3),delta);
        assertEquals(14,m.getValueAt(0,3),delta);
        assertEquals(32,m.getValueAt(4,1),delta);
        assertEquals(74,m.getValueAt(5,3),delta);

    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void multiplyMatrixExceptionTest() {
        int rowSize1 = 3 ;
        int columnSize1 = 5;
        int rowSize2 = 3 ;
        int columnSize2 = 5;
        Matrix m1 = MatrixImplementation.from(createTestMatrix(rowSize1,columnSize1));
        Matrix m2 = MatrixImplementation.from(createTestMatrix(rowSize2,columnSize2));
        Matrix m = m1.multiply(m2);

    }

    @Test
    public void multiplyScalarTest() {
        int rowSize = 3 ;
        int columnSize = 4;
        double scalar = 3.5;
        Matrix m1 = MatrixImplementation.from(createTestMatrix(rowSize,columnSize));
        Matrix m = m1.multiply(scalar);
        for(int i=0;i<rowSize;i++) {
            for(int j=0;j<columnSize;j++) {
                assertEquals((i+j)*scalar,m.getValueAt(i,j),delta);
            }
        }
    }

    @Test
    public void multiplyVectorTest() {
        int rowSize = 3 ;
        int columnSize = 4;
        Matrix m1 = MatrixImplementation.from(createTestMatrix(rowSize,columnSize));
        Vector v1 = VectorImplementation.from(createTestMatrix(1,columnSize)[0]);
        Vector v = m1.multiply(v1);
        assertEquals(rowSize,v.getDimension());
        assertEquals(14,v.getValueAt(0),delta);
        assertEquals(20,v.getValueAt(1),delta);
        assertEquals(26,v.getValueAt(2),delta);
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void multiplyVectorExceptionTest() {
        int rowSize = 3 ;
        int columnSize = 4;
        Matrix m = MatrixImplementation.from(createTestMatrix(rowSize,columnSize));
        Vector v = VectorImplementation.from(new double [] {1,2});
        Vector w = m.multiply(v);
    }

    @Test
    public void switchRowTest() {
        int rowSize = 3 ;
        int columnSize = 4;
        int index1 = 1;
        int index2 = 2;
        Matrix m1 = MatrixImplementation.from(createTestMatrix(rowSize,columnSize));
        Matrix m  = m1.switchRowVector(index1,index2);
        assertEquals(m1.getRowVectorAt(index1), m.getRowVectorAt(index2));
        assertEquals(m1.getRowVectorAt(index2), m.getRowVectorAt(index1));

    }
    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void switchRowException1Test() {
        int rowSize = 3 ;
        int columnSize = 4;
        int index1 = 3;
        int index2 = 2;
        Matrix m1 = MatrixImplementation.from(createTestMatrix(rowSize,columnSize));
        Matrix m  = m1.switchRowVector(index1,index2);
    }
    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void switchRowException2Test() {
        int rowSize = 3 ;
        int columnSize = 4;
        int index1 = 2;
        int index2 = 3;
        Matrix m1 = MatrixImplementation.from(createTestMatrix(rowSize,columnSize));
        Matrix m  = m1.switchRowVector(index1,index2);
    }

    @Test
    public void switchColumnTest() {
        int rowSize = 3 ;
        int columnSize = 4;
        int index1 = 1;
        int index2 = 2;
        Matrix m1 = MatrixImplementation.from(createTestMatrix(rowSize,columnSize));
        Matrix m  = m1.switchColumnVector(index1,index2);
        assertEquals(m1.getColumnVectorAt(index1), m.getColumnVectorAt(index2));
        assertEquals(m1.getColumnVectorAt(index2), m.getColumnVectorAt(index1));
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void switchColumnException1Test() {
        int rowSize = 3 ;
        int columnSize = 4;
        int index1 = 2;
        int index2 = 4;
        Matrix m1 = MatrixImplementation.from(createTestMatrix(rowSize,columnSize));
        Matrix m  = m1.switchColumnVector(index1,index2);
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void switchColumnException2Test() {
        int rowSize = 3 ;
        int columnSize = 4;
        int index1 = 4;
        int index2 = 2;
        Matrix m1 = MatrixImplementation.from(createTestMatrix(rowSize,columnSize));
        Matrix m  = m1.switchColumnVector(index1,index2);
    }

    @Test
    public void equalsTest() {
        int rowSize = 3 ;
        int columnSize = 4;
        double [][] matrix = createTestMatrix(rowSize,columnSize);
        matrix[rowSize-1][columnSize-1] = 0;
        Matrix m1 = MatrixImplementation.from(createTestMatrix(rowSize,columnSize));
        assertEquals(m1, MatrixImplementation.from(createTestMatrix(rowSize,columnSize)));
        assertEquals(m1, m1);
        assertNotEquals(m1, MatrixImplementation.from(createTestMatrix(rowSize+1,columnSize)));
        assertNotEquals(m1, MatrixImplementation.from(createTestMatrix(rowSize,columnSize+1)));
        assertNotEquals(m1,null);
        assertNotEquals(m1, createTestMatrix(rowSize,columnSize));
        assertNotEquals(m1, MatrixImplementation.from(matrix));

    }

    @Test
    public void hashCodeTest() {
        int rowSize = 3 ;
        int columnSize = 4;
        double [][] matrix = createTestMatrix(rowSize,columnSize);
        matrix[rowSize-1][columnSize-1] = 0;
        Matrix m1 = MatrixImplementation.from(createTestMatrix(rowSize,columnSize));
        assertEquals(m1.hashCode(),MatrixImplementation.from(createTestMatrix(rowSize,columnSize)).hashCode());
        assertEquals(m1.hashCode(),m1.hashCode());
        assertNotEquals(m1.hashCode(),MatrixImplementation.from(matrix).hashCode());
    }

}
