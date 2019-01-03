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

import java.util.LinkedList;
import java.util.List;

/**
 * Generates a prime sequence and divides the given number by the primes until all prime factors are found
 * Im not really proud of the implementation because of too many casts. The reason is that the current PrimeSequence generator allows
 * only ints. But nevertheless wanted to add it because i know that some students around the globe have to deal with the algorithm.
 * And for understanding it is good enough (it is anyhow not an algorithm to use in real world).
 *
 * @author benw@wwt
 * @todo extend long,BigInteger when the rest of prime is done
 */
public final class FactorizationByDivision implements FactorizationAlgorithm {


    private final PrimeSequenceGenerator primeSequenceGenerator;

    private  FactorizationByDivision(PrimeSequenceGenerator primeSequenceGenerator) {
        this.primeSequenceGenerator = primeSequenceGenerator;
    }
    /**
     *
     * @param number the number which should be split into the prime factor representation
     * @return
     * @throws IllegalArgumentException if number is > Integer.MAX_VALUE because the currently implemented prime sequence does not allow to do more
     */
    @Override
    public List<Long> factorize(final long number) {
        if(number >= (long) Integer.MAX_VALUE) throw new IllegalArgumentException("Number too big for current implementation");
        long toSplit = number;
        List<Long> returnValue = new LinkedList<>();
        List<Integer> primes = primeSequenceGenerator.getPrimeSequence((int)number);
        long q,r;
        int i = 0;
        while(toSplit!=1) {
            if(i == primes.size()) {
                returnValue.add(toSplit);
                break;
            }
            q = toSplit / primes.get(i);
            r = toSplit % primes.get(i);
            if(r==0) {
                returnValue.add(new Long(primes.get(i)));
                toSplit = q;
            }
            else {
                i++;
            }
        }
        return returnValue;
    }


    /**
     * For future caching of objects if needed
     *
     * @param primeSequenceGenerator
     * @return
     */
    public static FactorizationByDivision getInstance(PrimeSequenceGenerator primeSequenceGenerator) {
        return new FactorizationByDivision(primeSequenceGenerator);
    }
}
