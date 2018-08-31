package com.wwt.tools.mathtools.visibilitytest;

import com.wwt.tools.mathtools.function.*;
import com.wwt.tools.mathtools.prime.*;
import com.wwt.tools.mathtools.vector.Matrix;
import com.wwt.tools.mathtools.vector.MatrixImplementation;
import com.wwt.tools.mathtools.vector.Vector;
import com.wwt.tools.mathtools.vector.VectorImplementation;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static com.wwt.tools.mathtools.MathToolTest.*;

/**
 * checking visibility
 *
 * @author Benni
 */
public class VisibilityTest {

    @Test
    public void test() {
        /* Package function */
        double [] x1 = {-1.5,-0.75,0,0.75,1.5};
        double [] fx1 = {-14.101420,-0.931596,0,0.931596,14.101420};
        InterpolationAlgorithm function1 = LagrangePolynomialInterpolation.getInstance();
        RealValuedFunction f1 = function1.interpolate(x1,fx1);
        double v1 = f1.f(x1[0]);
        double [] x2 = {-1.5,-0.75,0,0.75,1.5};
        double [] fx2 = {-14.101420,-0.931596,0,0.931596,14.101420};
        PolynomialInterpolation function2 = NewtonPolynomialInterpolation.getInstance();
        Polynomial f2 = function2.interpolatePolynomial(x1,fx1);
        double v2 = f2.f(x2[0]);

        double [] arr = {5,3,2};
        Polynomial p = PolynomialImplementation.from(arr);
        p.getDegree();
        p.multiply(p.differentiate());
        p.add(p.normalize());
        p.subtract(p.multiplyScalar(7));
        p.getCoefficient(0);
        p.f(0);
        ((PolynomialImplementation)p).shrinkArray();

        /* Package prime */
        GreatestCommonDivisorAlgorithm prime1 = IterativeGCDAlgorithm.getInstance();
        prime1.getGreatestCommonDivisor(3,5);
        ProbabilisticPrimeTest prime2 = FermatPrimeTest.getInstance(prime1);
        prime2.isPrime(8,5);
        GreatestCommonDivisorAlgorithm prime3 = RecursiveGCDAlgorithm.getInstance();
        prime3.getGreatestCommonDivisor(3,5);
        ProbabilisticPrimeTest prime4 = MillerRabinTest.getInstance();

        /* Package vector */
        double [] vector = {5,3,2};
        Vector vector1 = VectorImplementation.from(vector);
        Vector vector2 = VectorImplementation.from(vector);
        vector1.getDimension();
        vector1.getScalarProduct(vector2.add(vector1));
        vector1.getValueAt(0);
        vector1.multiply(1);
        vector1.switchValues(0,1);

        int rowSize1 = 3 ;
        int columnSize1 = 3;
        int rowSize2 = 3 ;
        int columnSize2 = 3;
        Matrix m1 = MatrixImplementation.from(createTestMatrix(rowSize1,columnSize1));
        Matrix m2 = MatrixImplementation.from(createTestMatrix(rowSize2,columnSize2));
        m1.getRowNumber();
        m1.getColumnNumber();
        m1.add(m2);
        m1.getValueAt(0,0);
        m1.getColumnVectorAt(0);
        m1.getRowVectorAt(0);
        m1.multiply(m2);
        m1.multiply(vector1);
        m1.multiply(5);
        m1.switchColumnVector(0,1);
        m1.switchRowVector(0,1);
        assertTrue(true);
    }
}
