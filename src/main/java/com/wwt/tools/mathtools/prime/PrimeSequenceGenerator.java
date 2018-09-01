package com.wwt.tools.mathtools.prime;

import java.util.List;

/**
 * interface for prime sequence generators
 * @author benw@wwt
 * @todo extend long,BigInteger
 */
public interface PrimeSequenceGenerator {

    /**
     *
     * @param upperBound the upper bound for the list of prime numbers
     * @return all prime numbers in (0..upperBound)
     */
    List<Integer> getPrimeSequence(int upperBound);
}
