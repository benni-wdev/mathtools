package com.wwt.tools.mathtools.prime;


import com.wwt.tools.mathtools.MathTool;

import java.util.LinkedList;
import java.util.List;

/**
 * The algorithm uses fermat factorization recursively until the 2 factors are proven to be prime with the ProbabilisticPrimeTest algorithm
 *
 * @author benw@wwt
 */
public class FermatFactorization implements FactorizationAlgorithm {

    private static final int DEFAULT_ITERATIONS_FOR_PRIME_TEST = 10;

    private final ProbabilisticPrimeTest primeTest;
    private final int iterationsForPrimeTest;

    private  FermatFactorization(ProbabilisticPrimeTest primeTest,int iterationsForPrimeTest) {
        this.primeTest = primeTest;
        this.iterationsForPrimeTest = iterationsForPrimeTest;
    }

    @Override
    public List<Long> factorize(final long number) {
        long toSplit = number;
        List<Long> returnValue = new LinkedList<>();
        while(toSplit % 2 == 0 && toSplit != 2) {
            toSplit /=2;
            returnValue.add(2L);
        }
        if(toSplit == 2)  returnValue.add(2L);
        else {
            returnValue.addAll(fermatFactor(toSplit));
        }
        return returnValue;
    }

    private List<Long> fermatFactor(long N) {
        List<Long> returnValue = new LinkedList<>();
        long a = (long) Math.ceil(Math.sqrt(N));
        long b2 = a * a - N;
        while (!MathTool.isSquare(b2)) {
            a++;
            b2 = a * a - N;
        }
        long r1 = a - (long)Math.sqrt(b2);
        long r2 = N / r1;
        if(r1 == 1) {
            returnValue.add(r2);
        }
        else if (r2 == 1) {
            returnValue.add(r1);
        }
        else {
            if (isFactorPrime(r1)) {
                returnValue.add(r1);
            }
            else {
                returnValue.addAll(fermatFactor(r1));
            }
            if(isFactorPrime(r2)) {
                returnValue.add(r2);
            }
            else {
                returnValue.addAll(fermatFactor(r2));
            }
        }
        return returnValue;
    }

    private boolean isFactorPrime(long factor) {
        return primeTest.isPrime(factor,iterationsForPrimeTest);
    }

    /**
     *
     * @param primeTest
     * @return FermatFactorization instance with given Probabilistic prime test and DEFAULT_ITERATIONS_FOR_PRIME_TEST
     */
    public static FermatFactorization getInstance(ProbabilisticPrimeTest primeTest) {
        return new FermatFactorization(primeTest,DEFAULT_ITERATIONS_FOR_PRIME_TEST);
    }

    /**
     *
     * @param primeTest
     * @param iterationsForPrimeTest
     * @return FermatFactorization instance with given Probabilistic prime test and iterationsForPrimeTest
     */
    public static FermatFactorization getInstance(ProbabilisticPrimeTest primeTest, int iterationsForPrimeTest) {
        return new FermatFactorization(primeTest,iterationsForPrimeTest);
    }
}
