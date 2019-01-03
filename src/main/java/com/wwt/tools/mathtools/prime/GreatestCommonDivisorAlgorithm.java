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
 * Interface for algorithms calculating the greatest common divisor
 *
 * @author benw@wwt
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
