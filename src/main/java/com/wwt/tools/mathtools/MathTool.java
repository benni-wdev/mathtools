package com.wwt.tools.mathtools;

import java.math.BigInteger;

/**
 * Some helper functions
 * @author benw@wwt
 */
public final class MathTool {


    private MathTool() {}

    /**
     *
     * @throws IllegalArgumentException if mod = 0
     */
    public static long exponentiationModulo(long base, long exp, long mod) {
        if(mod == 0) throw new IllegalArgumentException("parameter mod = 0; modulo 0 not allowed");
        long x = 1;
        long y = base;
        while(exp > 0){
            if(exp % 2 == 1){
                x = (x*y) % mod;
            }
            y = (y*y) % mod;
            exp /= 2;
        }
        return x % mod;
    }

    /**
     *
     * @param m
     * @param n
     * @param mod
     * @return
     */
    public static long multiplyModulo(long m, long n, long mod) {
        return BigInteger.valueOf(m).multiply(BigInteger.valueOf(n)).mod(BigInteger.valueOf(mod)).longValue();
    }


    /**
     * returns true if the number is a perfect square of 2 Integers
     *
     * @param number to check
     * @return true if the number can be calculated by m*m
     */
    public static boolean isSquare(long number) {
        long sqrt = (long) Math.sqrt(number);
        return sqrt * sqrt == number || (sqrt + 1) * (sqrt + 1) == number;
    }




}
