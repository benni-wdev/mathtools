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
 * interface for functions like f(x) = y with x,y in Real Numbers (modeled via double type)
 * Interpolation algorithm which returns a Polynomial as result
 * @author benw@wwt
 */
public interface PolynomialInterpolation extends InterpolationAlgorithm {

    /**
     * another method to avoid casting all over the place
     * @param x sequence of x values
     * @param fx sequence of corresponding f(x) values (match by array index)
     * @return f(x) as polynomial
     */
    Polynomial interpolatePolynomial(double[] x, double [] fx);

    /**
     * defaulted to the more specific interpolatePolynomial method as they are doing the same thing for PolynomialInterpolation
     *
     * @param x sequence of x values
     * @param fx sequence of corresponding f(x) values (match by array index)
     * @return f(x)
     */
    default RealValuedFunction interpolate(double[] x, double [] fx) {
        return interpolatePolynomial(x,fx);
    }

}


