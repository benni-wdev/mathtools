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

/**
 * interface for probabilistic prime test algorithms
 *
 * @author benw@wwt
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
