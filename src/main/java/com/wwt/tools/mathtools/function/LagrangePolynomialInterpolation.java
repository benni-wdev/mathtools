package com.wwt.tools.mathtools.function;

/**
 * Implementation of polynomial interpolation lagrange algorithm
 *
 * @author Benni
 */
public final class LagrangePolynomialInterpolation implements PolynomialInterpolation {

    private static class LagrangePolynomialInterpolationHolder {
        private static final LagrangePolynomialInterpolation INSTANCE = new LagrangePolynomialInterpolation();
    }

    /**
     * not instantiatable -> singleton because object is stateless
     */
    private LagrangePolynomialInterpolation() {}

    @Override
    public Polynomial interpolatePolynomial(double [] x,double [] fx ) {
        Polynomial returnValue = from(new double [] {0.});
        int countConsideredPoints = Math.min(x.length,fx.length);
        for(int i = 0; i < countConsideredPoints;i++) {
            double [] arr =  new double[1];
            arr[0] = fx[i];
            Polynomial tmp = from(arr);
            for(int j = 0; j < countConsideredPoints;j++) {
                if(i != j) {
                    Polynomial factor = from(new double [] {(-x[j]/(x[i]-x[j])),(1./(x[i]-x[j]))});
                    tmp=tmp.multiply(factor);
                }
            }
            returnValue = returnValue.add(tmp);
        }
        return returnValue;
    }

    @Override
    public String toString() {
        return "LagrangePolynomialInterpolation{}";
    }

    private Polynomial from(double [] arr) {
        return PolynomialImplementation.from(arr);
    }

    /**
     * Singleton instance
     *
     * @return the one and only LagrangePolynomialInterpolation instance
     */
    public static LagrangePolynomialInterpolation getInstance() {
        return LagrangePolynomialInterpolationHolder.INSTANCE;
    }


}
