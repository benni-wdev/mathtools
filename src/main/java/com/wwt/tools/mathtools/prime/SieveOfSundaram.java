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
package com.wwt.tools.mathtools.prime;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author benw@wwt
 */
public final class SieveOfSundaram implements PrimeSequenceGenerator {

    private static class SieveOfSundaramHolder {
        private static final SieveOfSundaram INSTANCE = new SieveOfSundaram();
    }

    /**
     * not instantiatable -> singleton because object is stateless
     */
    private  SieveOfSundaram() {}

    @Override
    public List<Integer> getPrimeSequence(int upperBound) {
        if(upperBound < 2) throw new IllegalArgumentException("no primes in that range");
        int maxCheck = upperBound/2;
        BitSet notPrime = new BitSet(upperBound+1);
        for (int i = 1; i <= maxCheck; i++) {
            for (int j = i; j <= (maxCheck - i)/ (2 * i + 1); j++)
                notPrime.set(i + j + 2 * i * j);
        }

        List<Integer> primeNumbers = new LinkedList<>();
        primeNumbers.add(2);
        if(upperBound>2) primeNumbers.add(3);
        for (int i = 2; i < maxCheck; i++) {
            if (!notPrime.get(i)) {
                primeNumbers.add(2*i+1);
            }
        }
        return primeNumbers;
    }

    @Override
    public String toString() {
        return "SieveOfSundaram{}";
    }

    /**
     * Singleton instance
     *
     * @return the one and only SieveOfSundaram instance
     */
    public static SieveOfSundaram getInstance() { return SieveOfSundaramHolder.INSTANCE; }
}
