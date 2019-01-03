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

import com.wwt.tools.mathtools.MathToolTest;
import org.junit.Test;

import static com.wwt.tools.mathtools.MathToolTest.delta;

import static org.junit.Assert.assertEquals;

public class InterpolationTest {

    private final static double bound = 100;
    private final static int randomTestSize = 15;

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

    @SuppressWarnings("SameParameterValue")
    private void executeInterpolationTest(double []x, double [] fx, PolynomialInterpolation pi, double delta) {
        Polynomial p = pi.interpolatePolynomial(x,fx);
        for(int i = 0; i < x.length;i++) {
            assertEquals(fx[i],p.f(x[i]),delta);
        }
    }


}
