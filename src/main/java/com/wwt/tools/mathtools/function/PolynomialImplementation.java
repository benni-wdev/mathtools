package com.wwt.tools.mathtools.function;

import java.util.Arrays;

/**
 * Immutable implementation of Polynomial as double array of coefficients
 * @author Benni
 * @todo override equals,hashCode
 */
public class PolynomialImplementation implements Polynomial {


    private final double [] coefficients;

    /**
     * protected constructor for subclassing, so that the implementation can be extended with new operations
     * For creation use the static factory method.
     * @param coefficients
     */
    protected PolynomialImplementation(double [] coefficients) {
        this.coefficients = coefficients;
    }

    /**
     * Implementation with Horner Schema
     * @param x
     * @return
     */
    @Override
    public double f(double x) {
        double value=coefficients[coefficients.length-1];
        for(int i=coefficients.length-2;i>=0;i--) {
            value = value  * x + coefficients[i] ;
        }
        return value;
    }

    @Override
    public int getDegree() {
        for(int i = coefficients.length-1;i>= 0; i--) {
            if(coefficients[i] != 0) {
                return i;
            }
        }
        return 0;
    }
    @Override
    public double getCoefficient(int degree){
        if(degree > coefficients.length-1 || degree < 0) {
            return 0;
        }
        return coefficients[degree];
    }

    @Override
    public Polynomial normalize() {
        PolynomialImplementation returnValue = this.constructReturnValue();
        double tmp = returnValue.coefficients[returnValue.coefficients.length-1];

        for(int i=0;i<returnValue.coefficients.length-1;i++) {
            if(returnValue.coefficients[i] != 0) {
                returnValue.coefficients[i] /= tmp;
            }
        }
        returnValue.coefficients[returnValue.coefficients.length-1]=1;
        return returnValue;

    }

    @Override
    public Polynomial multiplyScalar(double scalar) {
        PolynomialImplementation returnValue = this.constructReturnValue();
        for(int i=0;i<returnValue.coefficients.length;i++) {
            returnValue.coefficients[i] *= scalar;
        }
        return returnValue;
    }

    @Override
    public Polynomial differentiate() {
        double [] derivative =new double[coefficients.length-1];
        for(int i=0;i<derivative.length;i++){
            derivative[i] = coefficients[i+1]*(double)(i+1);
        }
        return PolynomialImplementation.from(derivative);
    }


    @Override
    public Polynomial add(Polynomial p2) {
        double [] addedCoefficients = new double[Math.max(this.getDegree(),p2.getDegree())+1];
        for(int i = 0;i<addedCoefficients.length;i++) {
            addedCoefficients[i] = this.getCoefficient(i) + p2.getCoefficient(i);
        }
        return PolynomialImplementation.from(addedCoefficients);

    }

    @Override
    public Polynomial subtract(Polynomial p2) {
        double [] addedCoefficients = new double[Math.max(this.getDegree(),p2.getDegree())+1];
        for(int i = 0;i<addedCoefficients.length;i++) {
            addedCoefficients[i] = this.getCoefficient(i) - p2.getCoefficient(i);
        }
        return PolynomialImplementation.from(addedCoefficients);
    }

    @Override
    public Polynomial multiply(Polynomial p2) {
        double [] multipliedCoefficients=new double[this.getDegree()+p2.getDegree()+1];
        for(int i=0;i<=this.getDegree();i++) {
            for(int j=0;j<=p2.getDegree();j++) {
                multipliedCoefficients[i+j] += this.getCoefficient(i)*p2.getCoefficient(j);
            }
        }
        return PolynomialImplementation.from(multipliedCoefficients);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        for(int i = coefficients.length-1;i>= 2; i--) {
            if(coefficients[i] != 0) {
                if(s.length()>1) s.append("+");
                s.append(coefficients[i]).append("*x^").append(i);
            }
        }
        if(coefficients.length> 1 && coefficients[1] != 0 ) {
            s.append("+").append(coefficients[1]).append("*x");
        }
        if(coefficients[0] != 0 ) s.append("+").append(coefficients[0]);
        s.append("]");
        return s.toString();
    }


    /**
     * Exposed public for storage optimization
     *
     * @return
     */
    public final PolynomialImplementation shrinkArray() {
        if(coefficients[coefficients.length-1] != 0) {
            return this;
        }
        else return (PolynomialImplementation) PolynomialImplementation.from(coefficients);
    }


    private PolynomialImplementation constructReturnValue() {
        if (coefficients[coefficients.length-1] == 0) {
            return this.shrinkArray();
        }
        else {
            double [] coefficientsCopy = Arrays.copyOf(coefficients,coefficients.length);
            return new PolynomialImplementation(coefficientsCopy);
        }
    }

    /**
     * Please note that a copy of the input array is created to guarantee immutability
     *
     * @param coefficients
     * @return
     */
    public static Polynomial from(double [] coefficients) {
        int newSize = 1;
        for(int i = coefficients.length-1;i>= 0; i--) {
            if(coefficients[i] != 0) {
                newSize = i+1;
                break;
            }
        }
        double [] coefficientsCopy = Arrays.copyOf(coefficients,newSize);
        return new PolynomialImplementation(coefficientsCopy);
    }


}
