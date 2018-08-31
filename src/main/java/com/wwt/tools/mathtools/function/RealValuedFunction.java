package com.wwt.tools.mathtools.function;

/**
 * interface for functions like f(x) = y with x,y in Real Numbers (modeled via double type)
 * @author Benni
 */
public interface RealValuedFunction {

    /**
     * evaluated the function for value x
     * @param x a double number for which f(x) should be computed
     * @return f(x)
     */
    double f(double x);
}
