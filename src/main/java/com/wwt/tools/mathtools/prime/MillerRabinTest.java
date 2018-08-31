package com.wwt.tools.mathtools.prime;

import com.wwt.tools.mathtools.MathTool;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Benni
 */
public final class MillerRabinTest implements ProbabilisticPrimeTest {

    private static class MillerRabinTestHolder {
        private static MillerRabinTest INSTANCE = new MillerRabinTest();
    }

    /**
     * not instantiatable -> singleton because object is stateless
     */
    private  MillerRabinTest() {}

    @Override
    public boolean isPrime(long numberToTest, int iterations) {
        if (numberToTest == 2 || numberToTest == 3 || numberToTest == 5) {
            return true;
        }
        if (numberToTest == 0 || numberToTest == 1 || numberToTest % 2 == 0) {
            return false;
        }

        long oddRest = numberToTest - 1;
        while (oddRest % 2 == 0) {
            oddRest /= 2;
        }


        for (int i = 0; i < iterations; i++)  {
            long r = Math.abs(ThreadLocalRandom.current().nextLong());
            long a = r % (numberToTest - 1) + 1;
            long temp = oddRest;
            long mod = MathTool.exponentiateMod(a, temp, numberToTest);
            while (temp != numberToTest - 1 && mod != 1 && mod != numberToTest - 1) {
                mod = MathTool.multiplyMod(mod, mod, numberToTest);
                temp *= 2;
            }
            if (mod != numberToTest - 1 && temp % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "MillerRabinTest{}";
    }

    /**
     * Singleton instance
     *
     * @return the one and only MillerRabinTest instance
     */
    public static MillerRabinTest getInstance() { return MillerRabinTestHolder.INSTANCE; }
}