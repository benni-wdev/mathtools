package com.wwt.tools.mathtools.function;


import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static com.wwt.tools.mathtools.MathToolTest.delta;


public class PolynomialImplementationTest {

    @Test
    public void getValueForXTest() {
        /* 2x^2 + 3x + 5*/
        double [] arr = {5,3,2};
        Polynomial p = PolynomialImplementation.from(arr);
        assertEquals(32.,p.f(3),delta);
        assertEquals(5.,p.f(0),delta);
        assertEquals(14.,p.f(-3),delta);
        assertEquals(10.,p.f(1),delta);
        /* 2x^2 + 3x + 5*/
        double [] arr2 = {5,3,2,0};
        Polynomial p1 = PolynomialImplementation.from(arr2);
        assertEquals(32.,p1.f(3),delta);
        assertEquals(5.,p1.f(0),delta);
        assertEquals(14.,p1.f(-3),delta);
        assertEquals(10.,p1.f(1),delta);

        double [] arr3 = {0,-1.477478,0,4.8348555};
        Polynomial p3 = PolynomialImplementation.from(arr3);
        double [] x = {-1.5,-0.75,0,0.75,1.5};
        double [] fx = {-14.101420,-0.931596,0,0.931596,14.101420};
        for(int i = 0; i < x.length;i++) {
            assertEquals(fx[i],p3.f(x[i]),delta);
        }
        assertEquals(p.toString(),p1.toString());
    }

    @Test
    public void getDegreeTest() {
        double [] arr = {5,3,2};
        Polynomial p = PolynomialImplementation.from(arr);
        assertEquals(2,p.getDegree());
        double [] arr1 = {5,3,2,0};
        Polynomial p1 = new PITest(arr1);
        assertEquals(2,p1.getDegree());
        double [] arr2 = {5};
        Polynomial p2 = PolynomialImplementation.from(arr2);
        assertEquals(0,p2.getDegree());
        double [] arr3 = {5,2};
        Polynomial p3 = PolynomialImplementation.from(arr3);
        assertEquals(1,p3.getDegree());
    }

    @Test
    public void getCoefficientTest() {
        double [] arr = {5,3,2};
        Polynomial p = PolynomialImplementation.from(arr);
        assertEquals(5.,p.getCoefficient(0),delta);
        assertEquals(3.,p.getCoefficient(1),delta);
        assertEquals(2.,p.getCoefficient(2),delta);
        assertEquals(0.,p.getCoefficient(3),delta);
        assertEquals(0.,p.getCoefficient(99),delta);
        assertEquals(0.,p.getCoefficient(-5),delta);
        double [] arr1 = {5,3,2,0};
        Polynomial p1 = new PITest(arr1);
        assertEquals(0.,p1.getCoefficient(3),delta);
    }

    @Test
    public void normalizeTest() {
        double [] arr = {5,3,2};
        Polynomial p = PolynomialImplementation.from(arr);
        p = p.normalize();
        assertEquals(2.5,p.getCoefficient(0),delta);
        assertEquals(1.5,p.getCoefficient(1),delta);
        assertEquals(1.,p.getCoefficient(2),delta);
        assertEquals(0.,p.getCoefficient(3),delta);
    }

    @Test
    public void multiplyScalarTest() {
        double [] arr = {5,3,2};
        Polynomial p = PolynomialImplementation.from(arr);
        p = p.multiplyScalar(2.5);
        assertEquals(12.5,p.getCoefficient(0),delta);
        assertEquals(7.5,p.getCoefficient(1),delta);
        assertEquals(5.,p.getCoefficient(2),delta);
        assertEquals(0.,p.getCoefficient(3),delta);
        p = p.multiplyScalar(-1);
        assertEquals(-12.5,p.getCoefficient(0),delta);
        assertEquals(-7.5,p.getCoefficient(1),delta);
        assertEquals(-5.,p.getCoefficient(2),delta);
        assertEquals(0.,p.getCoefficient(3),delta);
        p = p.multiplyScalar(0);
        assertEquals(0,p.getDegree(),delta);
    }

    @Test
    public void differentiateTest() {
        double [] arr = {5,3,2,6};
        Polynomial p = PolynomialImplementation.from(arr);
        p = p.differentiate();
        assertEquals(3.,p.getCoefficient(0),delta);
        assertEquals(4.,p.getCoefficient(1),delta);
        assertEquals(18.,p.getCoefficient(2),delta);
        assertEquals(0.,p.getCoefficient(3),delta);
    }

    @Test
    public void addTest() {
        double [] arr = {5,3,2};
        Polynomial p1 = PolynomialImplementation.from(arr);
        Polynomial p2 = PolynomialImplementation.from(arr);
        Polynomial p = p1.add(p2);
        assertEquals(10,p.getCoefficient(0),delta);
        assertEquals(6.,p.getCoefficient(1),delta);
        assertEquals(4.,p.getCoefficient(2),delta);
        assertEquals(0.,p.getCoefficient(3),delta);
        double [] arr2 = {5,3,2,4,7};
        Polynomial p3 = PolynomialImplementation.from(arr2);
        p = p.add(p3);
        assertEquals(15,p.getCoefficient(0),delta);
        assertEquals(9.,p.getCoefficient(1),delta);
        assertEquals(6.,p.getCoefficient(2),delta);
        assertEquals(4.,p.getCoefficient(3),delta);
        assertEquals(7.,p.getCoefficient(4),delta);
        assertEquals(0.,p.getCoefficient(5),delta);
    }

    @Test
    public void subtractTest() {
        double [] arr = {5,3,2};
        Polynomial p1 = PolynomialImplementation.from(arr);
        Polynomial p2 = PolynomialImplementation.from(arr);
        Polynomial p = p1.subtract(p2);

        assertEquals(0.,p.getCoefficient(0),delta);
        assertEquals(0.,p.getCoefficient(1),delta);
        assertEquals(0.,p.getCoefficient(2),delta);
        assertEquals(0.,p.getCoefficient(3),delta);
        assertEquals(0,p.getDegree());
        double [] arr2 = {4,3,2,4,7};
        Polynomial p3 = PolynomialImplementation.from(arr2);
        p = p1.subtract(p3);
        assertEquals(1,p.getCoefficient(0),delta);
        assertEquals(0.,p.getCoefficient(1),delta);
        assertEquals(0.,p.getCoefficient(2),delta);
        assertEquals(-4.,p.getCoefficient(3),delta);
        assertEquals(-7.,p.getCoefficient(4),delta);
        assertEquals(0.,p.getCoefficient(5),delta);
    }

    @Test
    public void multiplyTest() {
        double [] arr1 = {1,1,3,-4};
        double [] arr2 = {1,2,-5,-3};
        Polynomial p1 = PolynomialImplementation.from(arr1);
        Polynomial p2 = PolynomialImplementation.from(arr2);
        Polynomial p = p1.multiply(p2);
        assertEquals(1.,p.getCoefficient(0),delta);
        assertEquals(3.,p.getCoefficient(1),delta);
        assertEquals(0.,p.getCoefficient(2),delta);
        assertEquals(-6.,p.getCoefficient(3),delta);
        assertEquals(-26.,p.getCoefficient(4),delta);
        assertEquals(11.,p.getCoefficient(5),delta);
        assertEquals(12.,p.getCoefficient(6),delta);

    }


    @Test
    public void shrinkTest() {
        double [] arr = {5,3,2,0};
        Polynomial p1 = new PITest(arr);

        assertEquals(32.,p1.f(3),delta);
        assertEquals(5.,p1.f(0),delta);
        assertEquals(14.,p1.f(-3),delta);
        assertEquals(10.,p1.f(1),delta);

        Polynomial p2 = ((PolynomialImplementation)p1).shrinkArray();
        assertEquals(p1.f(3),p2.f(3),delta);
        assertEquals(p1.f(0),p2.f(0),delta);
        assertEquals(p1.f(-3),p2.f(-3),delta);
        assertEquals(p1.f(1),p2.f(1),delta);
        assertEquals(p1.toString(),p2.toString());
    }


    class PITest extends PolynomialImplementation {
        PITest(double [] arr) {
            super(arr);
        }
    }

}
