package com.wwt.tools.mathtools.prime;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author benw@wwt
 */
public final class SieveOfEratosthenes implements PrimeSequenceGenerator {

    private static class SieveOfEratosthenesHolder {
        private static final SieveOfEratosthenes INSTANCE = new SieveOfEratosthenes();
    }

    /**
     * not instantiatable -> singleton because object is stateless
     */
    private  SieveOfEratosthenes() {}


    @Override
    public List<Integer> getPrimeSequence(int upperBound) {
        if(upperBound < 2) throw new IllegalArgumentException("no primes in that range");
        BitSet notPrime  = new BitSet(upperBound+1);
        for (int i = 2; i*i <= upperBound; i++) {
            if (!notPrime.get(i)) {
                for (int j = i * 2; j <= upperBound; j += i) {
                    notPrime.set(j);
                }
            }
        }
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 2; i <= upperBound; i++) {
            if (!notPrime.get(i)) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

    @Override
    public String toString() {
        return "SieveOfEratosthenes{}";
    }

    /**
     * Singleton instance
     *
     * @return the one and only SieveOfEratosthenes instance
     */
    public static SieveOfEratosthenes getInstance() { return SieveOfEratosthenesHolder.INSTANCE; }
}
