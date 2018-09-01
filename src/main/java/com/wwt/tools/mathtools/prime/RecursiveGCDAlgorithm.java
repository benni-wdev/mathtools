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
