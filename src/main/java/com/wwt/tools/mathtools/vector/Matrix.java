package com.wwt.tools.mathtools.vector;


/**
 * Type for n x m matrix
 *
 * for orientation:
 *
 *    - - - -
 *    0 1 2 3   <- column number = 4
 *    - - - -
 * |0|7 2 5 1
 * |1|8 4 3 1      double getValueAt(int rowIndex,int columnIndex)
 * |2|9 7 0 6      getValueAt(2,3) = 6
 *
 *  ^
 *  |
 *  row number  = 3
 *
 * @author benw@wwt
 */
public interface Matrix {

    /**
     *
     * @return Number of rows of the matrix
     */
    int getRowNumber();

    /**
     *
     * @return Number of columns of the matrix
     */
    int getColumnNumber();

    /**
     *
     * @param columnIndex min = 0 max = getColumnNumber -1
     * @return The Vector at column position columnIndex
     */
    Vector getColumnVectorAt(int columnIndex);

    /**
     *
     * @param rowIndex min = 0 max = getRowNumber -1
     * @return Vector at row position rowIndex
     */
    Vector getRowVectorAt(int rowIndex);

    /**
     *
     * @param rowIndex min = 0 max = getRowNumber -1
     * @param columnIndex min = 0 max = getColumnNumber -1
     * @return the value within the matrix at position rowIndex,columnIndex
     */
    default double getValueAt(int rowIndex,int columnIndex) {
        return getRowVectorAt(rowIndex).getValueAt(columnIndex);
    }

    /**
     * addition of 2 matrices
     * please be aware that this only works if both matrices have the same row and column number
     * @param m
     * @return
     */
    Matrix add(Matrix m);

    /**
     * Multiplication of 2 matrices
     * please be aware that this only works the column number of this matrix is equal to the row number of given m
     * @param m
     * @return the matrix of size this.rownumber x m.columnumber
     */
    Matrix multiply(Matrix m);

    /**
     * multiplication of the matrix with a scalar on every position
     * @param scalar
     * @return
     */
    Matrix multiply(double scalar);

    /**
     * Multiplication of matrix with a vector
     * Vector dimension must be equal to matrix column number
     *
     * Matrix      Vector
     * 7 2 5 1     6       51
     * 8 4 3 1  X  7    =  ..
     * 9 7 0 6    -1       ..
     *             0
     *
     * @param v the vector
     * @return a new vector which has dimension matrix.getRowNumber
     */
    Vector multiply(Vector v);

    /**
     * exchange the row vectors at index1,index2
     * @param index1 between 0 and rowNumber -1
     * @param index2 between 0 and rowNumber -1
     * @return
     */
    Matrix switchRowVector(int index1,int index2);

    /**
     * exchange the column vectors at index1,index2
     * @param index1 between 0 and columnNumber -1
     * @param index2 between 0 and columnNumber -1
     * @return
     */
    Matrix switchColumnVector(int index1,int index2);

    /**
     * transpose returns the matrix where the column vectors of the original matrix are switched to row vectors and vice versa.
     * So an m x n matrix is transposed to a n x m matrix
     * @return
     */
    Matrix getTranspose();


}
