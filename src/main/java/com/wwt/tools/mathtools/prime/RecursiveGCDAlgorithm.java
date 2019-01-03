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
 * @author benw@wwt
 */
public final class RecursiveGCDAlgorithm implements GreatestCommonDivisorAlgorithm {

    private static class RecursiveGCDAlgorithmHolder {
        private static final RecursiveGCDAlgorithm INSTANCE = new RecursiveGCDAlgorithm();
    }

    /**
     * not instantiatable -> singleton because object is stateless
     */
    private RecursiveGCDAlgorithm() {}


    @Override
    public long getGreatestCommonDivisor(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if(a==0) return b;
        if(b==0) return a;
        return recursiveGreatestCommonDivisor(a,b);
    }

    @Override
    public String toString() {
        return "RecursiveGCDAlgorithm{}";
    }


    private long recursiveGreatestCommonDivisor(long a, long b) {
        if (a == b) return a;
        if (a < b) {
            b = b % a;
        }
        else {
            a = a % b;
        }
        if (a == 0) return b;
        if (b == 0) return a;
        return recursiveGreatestCommonDivisor(b, a);
    }

    /**
     * Singleton instance
     *
     * @return the one and only RecursiveGCDAlgorithm instance
     */
    public static RecursiveGCDAlgorithm getInstance() {
        return RecursiveGCDAlgorithmHolder.INSTANCE;
    }
}
