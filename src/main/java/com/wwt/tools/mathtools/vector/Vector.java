package com.wwt.tools.mathtools.vector;

/**
 * Type for linear vectors
 *
 * |0|-2
 * |1| 0
 * |2| 5
 *
 *  ^
 *  |
 *  dimension  = 3
 *
 *
 * @author Benni
 */
public interface Vector {
    /**
     *
     * @return the dimension of the vector
     */
    int getDimension();

    /**
     *
     * @param index between 0 and dimension -1
     * @return the value in that dimension
     */
    double getValueAt(int index);

    /**
     * dimensions have to be equal
     * @param v
     * @return
     */
    double getScalarProduct(Vector v);

    /**
     * multiplication of the vector with a scalar in every dimension
     * @param scalar
     * @return
     */
    Vector multiply(double scalar);

    /**
     * addition of 2 vectors
     * please be aware that this only works if both vectors have the same dimension
     * @param
     * @return
     */
    Vector add(Vector v);

    /**
     * exchange the values at index1,index2
     * @param index1 between 0 and dimension -1
     * @param index2 between 0 and dimension -1
     * @return
     */
    Vector switchValues(int index1,int index2);

}
