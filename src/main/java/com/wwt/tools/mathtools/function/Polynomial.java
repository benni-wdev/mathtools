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
package com.wwt.tools.mathtools.function;

/**
 * Represents a polynomial like x^3 - 4.5 x^2
 * @author benw@wwt
 */
public interface Polynomial extends RealValuedFunction {

    /**
     * degree is the highest exponent for x within the polynomial, e.g. degree(x^3 - 4.5 x^2) = 3
     * @return
     */
    int getDegree();

    /**
     * get the coefficient for the input degree, e.g. -4.5 for x^3 - 4.5 x^2 and degree 2
     * @param degree
     * @return
     */
    double getCoefficient(int degree);

    /**
     * divides all coefficients of the polynomial so that the coefficient of the term with the max degree is 1
     *
     * @return Polynomial where the coefficient of the term with the max degree is 1
     */
    Polynomial normalize();

    /**
     * multiply the polynomial with a scalar value
     * @param scalar
     * @return polynomial where the scalar multiplication is applied
     */
    Polynomial multiplyScalar(double scalar);

    /**
     * returns the differentiated polynomial ala diff(x^3 - 4.5 x^2)= 3x^2 -9x
     * @return
     */
    Polynomial differentiate();

    /**
     * returns polynomial which is constructed by adding current polynomial with input
     * @param p2
     * @return
     */
    Polynomial add(Polynomial p2);
    /**
     * returns polynomial which is constructed by subtracting current polynomial with input
     * @param p2
     * @return
     */
    Polynomial subtract(Polynomial p2);

    /**
     * returns polynomial which is constructed by multiplying current polynomial with input
     * @param p2
     * @return
     */
    Polynomial multiply(Polynomial p2);


}
