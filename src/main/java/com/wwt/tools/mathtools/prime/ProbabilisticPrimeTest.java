package com.wwt.tools.mathtools.prime;

/**
 * interface for probabilistic prime test algorithms
 *
 * @author Benni
 */
public interface ProbabilisticPrimeTest {

    /**
     *
     * @param numberToTest the input number which should be tested if it is prime
     * @param iterations number of tests (increases probability)
     * @return true if number is probable prime, false if it is for sure not prime
     */
    boolean isPrime(long numberToTest,int iterations);
}
