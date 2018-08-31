package com.wwt.tools.mathtools.function;


/**
 * interface for functions like f(x) = y with x,y in Real Numbers (modeled via double type)
 * Interpolation algorithm which returns a Polynomial as result
 * @author Benni
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


