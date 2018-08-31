package com.wwt.tools.mathtools;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Some helper functions
 * @author Benni
 */
public final class MathTool {


    private MathTool() {}

    /**
     *
     * @throws IllegalArgumentException if mod = 0
     */
    public static long exponentiateMod(long base, long exp, long mod) {
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
    public static long multiplyMod(long m, long n, long mod) {
        return BigInteger.valueOf(m).multiply(BigInteger.valueOf(n)).mod(BigInteger.valueOf(mod)).longValue();
    }




}
