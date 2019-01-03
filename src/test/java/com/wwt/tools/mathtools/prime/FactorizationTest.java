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

import com.wwt.tools.mathtools.MathToolTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactorizationTest {



    private final long [] pf11 = { 11L};
    private final long [] pf8 = { 2L,2L,2L};
    private final long [] pf16 = { 2L,2L,2L,2L};
    private final long [] pf60 = { 2L,2L,3L,5L};

    @Test
    public void fermatFactorizationTest() {
        FactorizationAlgorithm a = FermatFactorization.getInstance(MillerRabinTest.getInstance());
        a.factorize(27);
        assertEquals(MathToolTest.getArrayAsList(pf16), a.factorize( getNumberFromFactorization(pf16)));
        assertEquals(MathToolTest.getArrayAsList(pf11), a.factorize( getNumberFromFactorization(pf11)));
        assertEquals(MathToolTest.getArrayAsList(pf8), a.factorize( getNumberFromFactorization(pf8)));
        assertEquals(MathToolTest.getArrayAsList(pf60), a.factorize( getNumberFromFactorization(pf60)));
        a.factorize(Long.MAX_VALUE-1);
    }

    @Test
    public void factorizationByDivisionTest() {
        FactorizationAlgorithm a = FactorizationByDivision.getInstance(SieveOfSundaram.getInstance());
        System.out.println(a.factorize(27));
        assertEquals(MathToolTest.getArrayAsList(pf16), a.factorize( getNumberFromFactorization(pf16)));
        assertEquals(MathToolTest.getArrayAsList(pf11), a.factorize( getNumberFromFactorization(pf11)));
        assertEquals(MathToolTest.getArrayAsList(pf8), a.factorize( getNumberFromFactorization(pf8)));
        assertEquals(MathToolTest.getArrayAsList(pf60), a.factorize( getNumberFromFactorization(pf60)));
        //System.out.println(a.factorize(Integer.MAX_VALUE-1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void factorizationByDivisionExceptionTest() {
        FactorizationAlgorithm a = FactorizationByDivision.getInstance(SieveOfSundaram.getInstance());
        a.factorize(Integer.MAX_VALUE);
    }

    private static long getNumberFromFactorization(long[] arr) {
        long returnValue =1;
        for (long anArr : arr) {
            returnValue *= anArr;
        }
        return returnValue;
    }
}
