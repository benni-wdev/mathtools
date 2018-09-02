package com.wwt.tools.mathtools.vector;


import java.util.Arrays;

/**
 * Immutable implementation of Matrix as 2 dimensional double array
 *
 * @author benw@wwt
 */
public class ArrayMatrix implements Matrix {


    /**
     * for orientation:
     *
     *    - - - -
     *    0 1 2 3   <- column number = 4 = matrix[0].length
     *    - - - -
     * |0|7 2 5 1
     * |1|8 4 3 1      double getValueAt(int rowIndex,int columnIndex)
     * |2|9 7 0 6      getValueAt(2,3) = 6
     *
     *  ^
     *  |
     *  row number  = 3 = matrix.length
     */
    private final double [][] matrix;

    private int hashCode;

    /**
     * protected constructor for subclassing, so that the implementation can be extended with new operations
     * For creation use the static factory method.
     * @param matrix
     */
    @SuppressWarnings("WeakerAccess")
    protected ArrayMatrix(double [][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public int getRowNumber() {
        return matrix.length;
    }

    @Override
    public int getColumnNumber() {
        return matrix[0].length;
    }

    @Override
    public Vector getColumnVectorAt(int columnIndex) {
        if(columnIndex >= getColumnNumber()) throw new IllegalArgumentException("index out of range");
        return ArrayVector.from(getColumn(matrix,columnIndex));
    }

    @Override
    public Vector getRowVectorAt(int rowIndex) {
        if(rowIndex >= getRowNumber()) throw new IllegalArgumentException("index out of range");
        return ArrayVector.from(matrix[rowIndex]) ;
    }

    @Override
    public Matrix add(Matrix m) throws IllegalArgumentException {
        if(this.getRowNumber()!= m.getRowNumber() || this.getColumnNumber() != m.getColumnNumber())
            throw new IllegalArgumentException("dimensions of matrices are not equal");
        double [][] returnValue=new double[this.getRowNumber()][this.getColumnNumber()];
        for(int i=0;i<this.getRowNumber();i++) {
            for(int j=0;j<this.getColumnNumber();j++) {
                returnValue[i][j]=matrix[i][j]+m.getValueAt(i,j);
            }
        }
        return new ArrayMatrix(returnValue);
    }

    @Override
    public Matrix multiply(Matrix m) throws IllegalArgumentException {
        if(this.getColumnNumber()!= m.getRowNumber())
            throw new IllegalArgumentException("Horizontal dimension does not fit to vertical dimension of input matrix");
        double [][] returnValue=new double[this.getRowNumber()][m.getColumnNumber()];
        for(int i=0;i<returnValue.length;i++) {
            for(int j=0;j<returnValue[0].length;j++) {
                returnValue[i][j] = this.getRowVectorAt(i).getScalarProduct(m.getColumnVectorAt(j));
            }
        }
        return new ArrayMatrix(returnValue);
    }


    @Override
    public Matrix multiply(double scalar) {
        double [][] returnValue = copy(matrix);
        for(int i=0;i<returnValue.length;i++) {
            for(int j=0;j<returnValue[0].length;j++) {
                returnValue[i][j]=returnValue[i][j]*scalar;
            }
        }
        return new ArrayMatrix(returnValue);
    }

    @Override
    public Vector multiply(Vector v) {
        if(this.getColumnNumber()!= v.getDimension())
            throw new IllegalArgumentException("Vector dimension does not fit to matrix");
        return Vectors.convertToVector(this.multiply(Vectors.convertToMatrix(v)));
    }

    @Override
    public Matrix switchRowVector(int index1, int index2) {
        if(0 > index1 || index1 > getRowNumber()-1 || 0 > index2 || index2 >  getRowNumber()-1 ) throw new IllegalArgumentException("index out of range");
        double [][] returnValue = copy(matrix);
        Vector tmp = this.getRowVectorAt(index1);
        for (int i = 0; i < getColumnNumber(); i++) {
            returnValue[index1] = Arrays.copyOf(returnValue[index2],returnValue[index2].length);
        }
        for (int i = 0; i < getColumnNumber(); i++) {
            returnValue[index2][i] = tmp.getValueAt(i);
        }
        return new ArrayMatrix(returnValue);
    }

    @Override
    public Matrix switchColumnVector(int index1, int index2) {
        if(0 > index1 || index1 > getColumnNumber() -1 || 0 > index2 || index2 >  getColumnNumber()-1 ) throw new IllegalArgumentException("index out of range");
        double [][] returnValue = copy(matrix);
        Vector tmp = this.getColumnVectorAt(index1);
        for (int i = 0; i < getRowNumber(); i++) {
            returnValue[i][index1] = returnValue[i][index2];
        }
        for (int i = 0; i < getRowNumber(); i++) {
            returnValue[i][index2] = tmp.getValueAt(i);
        }
        return new ArrayMatrix(returnValue);
    }

    @Override
    public Matrix getTranspose() {
        double [][] returnValue = new double[this.getColumnNumber()][this.getRowNumber()];
        for (int i = 0; i < returnValue.length ; i++) {
            for (int j = 0; j < returnValue[0].length; j++) {
                returnValue[i][j] = matrix[j][i];
            }
        }
        return new ArrayMatrix(returnValue);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("ArrayMatrix{ \n");
        for(int i=0;i<this.getRowNumber();i++) {
            for(int j=0;j<this.getColumnNumber();j++) {
                s.append(matrix[i][j]);
                s.append(" ");
            }
            s.append("\n");
        }
        s.append("}");
        return s.toString();
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Matrix))return false;
        Matrix m = (Matrix) other;
        if (m.getColumnNumber() != this.getColumnNumber() || m.getRowNumber() != this.getRowNumber()) return false;
        for (int i = 0; i < this.getRowNumber(); i++) {
            for (int j = 0; j < this.getColumnNumber(); j++) {
                if (this.getValueAt(i,j) != m.getValueAt(i,j)) return false;
            }
        }
        return(true);
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if(hashCode == 0) {
            for (int i = 0; i < this.getRowNumber(); i++) {
                for (int j = 0; j < this.getColumnNumber(); j++) {
                    result = result * 31 + Double.hashCode(this.getValueAt(i,j));
                }
            }
            hashCode = result;
        }
        return result;
    }

    /**
     * Please note that a copy of the input array is created to guarantee immutability
     *
     * @param matrix given 2 dimensional double array which represents the matrix
     * @return matrix object with input array as values [rows][columns]
     */
    public static ArrayMatrix from(double [][] matrix) {
        double [][] matrixCopy = copy(matrix);
        return new ArrayMatrix(matrixCopy);
    }


    /**
     * No parameter validation, usually happens before
     */
    private static double[] getColumn(double[][] matrix, int columnIndex) {
        double[] column = new double[matrix.length];
        for(int i=0; i<matrix.length; i++){
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }


    private static double[][] copy(double[][] source) {
        double[][] returnValue = new double[source.length][];
        for (int i = 0; i < source.length; i++) {
            returnValue[i] = Arrays.copyOf(source[i], source[i].length);
        }
        return returnValue;
    }
}
