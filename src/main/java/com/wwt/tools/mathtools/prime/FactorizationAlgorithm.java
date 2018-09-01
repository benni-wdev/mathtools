package com.wwt.tools.mathtools.prime;

import java.util.List;

/**
 * interface for factorization algorithms
 * @author benw@wwt
 */
public interface FactorizationAlgorithm {

    /**
     *
     * @param number the number which should be split into the prime factor representation
     * @return all prime factors of the given number
     */
    List<Long> factorize(long number);
}
