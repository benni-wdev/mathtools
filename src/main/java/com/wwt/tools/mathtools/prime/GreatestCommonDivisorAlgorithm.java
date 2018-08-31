package com.wwt.tools.mathtools.prime;

/**
 * Interface for algorithms calculating the greatest common divisor
 *
 * @author Benni
 */
public interface GreatestCommonDivisorAlgorithm {

    /**
     * computes the greatest common divisor for a and b
     * @param a a number
     * @param b b number
     * @return greatest common divisor of a and b
     */
    long getGreatestCommonDivisor(long a, long b);
}
