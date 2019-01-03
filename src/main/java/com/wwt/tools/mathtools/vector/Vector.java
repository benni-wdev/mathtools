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
 * @author benw@wwt
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
