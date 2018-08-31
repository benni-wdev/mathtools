package com.wwt.tools.mathtools.vector;

/**
 * Some static helpers
 *
 * @author Benni
 */
public final class Vectors {

    private Vectors(){}

    /**
     * Converts a given matrix into a Vector if row number or column number is 1, otherwise IllegalArgumentException is thrown
     * The resulting vector has dimension max(rowNumber,columnNumber) of the Matrix
     * @param m Matrix
     * @return Matrix as Vector if applicable
     * @throws IllegalArgumentException if m.getColumnNumber() != 1 && m.getRowNumber() != 1
     */
    public static Vector convertToVector(Matrix m) {
        if(m.getColumnNumber() != 1 && m.getRowNumber() != 1) {
            throw new IllegalArgumentException("Matrix cannot be converted because it has row and column number > 1");
        }
        double [] returnValue = new double[Math.max(m.getColumnNumber(), m.getRowNumber())];
        for(int i=0;i<m.getRowNumber();i++) {
            for(int j=0;j<m.getColumnNumber();j++) {
                returnValue[i+j] = m.getValueAt(i,j);
            }
        }
        return VectorImplementation.from(returnValue);
    }

    /**
     * returns the vector v as Matrix with v.getDimension as rowNumber and 1 column
     * @param v the vector to convert
     * @return
     */
    public static Matrix convertToMatrix(Vector v) {
        double [][] returnValue = new double[v.getDimension()][1];
        for (int i = 0; i < v.getDimension() ; i++) {
            returnValue[i][0] = v.getValueAt(i);
        }
        return new MatrixImplementation(returnValue);
    }

    /**
     * returns the identity matrix of size dimension x dimension , e.g.
     *
     * 1 0 0
     * 0 1 0
     * 0 0 1 for dimension = 3
     *
     * @param dimension
     * @return
     */
    public static Matrix getIdentityMatrix(int dimension) {
        double [][] returnValue = new double[dimension][dimension];
        for (int i = 0; i < dimension ; i++) {
            returnValue[i][i] = 1;
        }
        return new MatrixImplementation(returnValue);
    }

}
