package com.wwt.tools.mathtools.function;


/**
 * computes a RealValuedFunction f which satisfies f(x[i]) = fx[i]
 * @author Benni
 */
public interface InterpolationAlgorithm {

    /**
     * returns a function f for which f(x[i])=fx[i] for all i in x.length
     * @param x sequence of x values
     * @param fx sequence of corresponding f(x) values (match by array index)
     * @return function
     */
    RealValuedFunction interpolate(double[] x, double [] fx);
}
