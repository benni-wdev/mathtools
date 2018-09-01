package com.wwt.tools.mathtools.prime;

/**
 * @author benw@wwt
 */
public final class IterativeGCDAlgorithm implements GreatestCommonDivisorAlgorithm {

    private static class IterativeGCDAlgorithmHolder {
        private static final IterativeGCDAlgorithm INSTANCE = new IterativeGCDAlgorithm();
    }

    /**
     * not instantiatable -> singleton because object is stateless
     */
    private IterativeGCDAlgorithm() {}

    @Override
    public long getGreatestCommonDivisor(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if(a==0) return b;
        if(b==0) return a;
        while(b!=0) {
            long h = a % b;
            a = b;
            b = h;
        }
        return a;
    }

    @Override
    public String toString() {
        return "IterativeGCDAlgorithm{}";
    }

    /**
     * Singleton instance
     *
     * @return the one and only IterativeGCDAlgorithm instance
     */
    public static IterativeGCDAlgorithm getInstance() {
        return IterativeGCDAlgorithmHolder.INSTANCE;
    }
}
