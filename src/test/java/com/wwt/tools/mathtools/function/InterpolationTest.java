package com.wwt.tools.mathtools.function;

import com.wwt.tools.mathtools.MathToolTest;
import org.junit.Test;

import static com.wwt.tools.mathtools.MathToolTest.delta;

import static org.junit.Assert.assertEquals;

public class InterpolationTest {

    public final static double bound = 100;
    public final static int randomTestSize = 15;

    @Test
    public void lagrangeInterpolationTest() {
        double [] x = {-1.5,-0.75,0,0.75,1.5};
        double [] fx = {-14.101420,-0.931596,0,0.931596,14.101420};
        executeInterpolationTest(x,fx,LagrangePolynomialInterpolation.getInstance(),delta);
    }


    @Test
    public void newtonInterpolationTest() {
        double [] x = {-1.5,-0.75,0,0.75,1.5};
        double [] fx = {-14.101420,-0.931596,0,0.931596,14.101420};
        executeInterpolationTest(x,fx,NewtonPolynomialInterpolation.getInstance(),delta);

    }

    @Test
    public void newtonInterpolationRandomTest() {
        double [] x = new double[randomTestSize];
        double [] fx = new double[randomTestSize];
        MathToolTest.fillArrayWithRandomDoubles(x,bound);
        MathToolTest.fillArrayWithRandomDoubles(fx,bound);
        executeInterpolationTest(x,fx,NewtonPolynomialInterpolation.getInstance(),delta);

    }

    @Test
    public void lagrangeInterpolationRandomTest() {
        double [] x = new double[randomTestSize];
        double [] fx = new double[randomTestSize];
        MathToolTest.fillArrayWithRandomDoubles(x,bound);
        MathToolTest.fillArrayWithRandomDoubles(fx,bound);
        executeInterpolationTest(x,fx,LagrangePolynomialInterpolation.getInstance(),delta);
    }

    private void executeInterpolationTest(double []x,double [] fx,PolynomialInterpolation pi,double delta) {
        Polynomial p = pi.interpolatePolynomial(x,fx);
        for(int i = 0; i < x.length;i++) {
            assertEquals(fx[i],p.f(x[i]),delta);
        }
    }


}
