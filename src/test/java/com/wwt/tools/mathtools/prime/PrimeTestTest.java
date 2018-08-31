package com.wwt.tools.mathtools.prime;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrimeTestTest {


    GreatestCommonDivisorAlgorithm gcdCalculator1 = IterativeGCDAlgorithm.getInstance();
    GreatestCommonDivisorAlgorithm gcdCalculator2 = RecursiveGCDAlgorithm.getInstance();


    @Test
    public void fermatPrime1Test() {
        ProbabilisticPrimeTest test = FermatPrimeTest.getInstance(gcdCalculator1);
        assertTrue(test.isPrime(2,5));
        assertTrue(test.isPrime(3,5));
        assertTrue(test.isPrime(5,5));
        assertTrue(test.isPrime(11,5));
        assertTrue(test.isPrime(7,5));
        assertTrue(test.isPrime(17,5));
        assertTrue(test.isPrime(13,5));
        assertTrue(test.isPrime(19,5));
        assertTrue(test.isPrime(23,5));
        assertTrue(test.isPrime(31,5));
        assertTrue(test.isPrime(37,5));
        assertFalse(test.isPrime(0,5));
        assertFalse(test.isPrime(1,5));
        assertFalse(test.isPrime(4,5));
        assertFalse(test.isPrime(6,5));
        assertFalse(test.isPrime(8,5));
        assertFalse(test.isPrime(9,5));
        assertFalse(test.isPrime(12,5));
        assertFalse(test.isPrime(15,5));
        assertFalse(test.isPrime(21,5));
        assertFalse(test.isPrime(25,5));
        assertFalse(test.isPrime(27,5));
        assertTrue(test.isPrime(976777,5));
        assertTrue(test.isPrime(978287,50));
        assertTrue(test.isPrime(956861,50));
        assertTrue(test.isPrime(931639,50));
        assertTrue(test.isPrime(310547,50));
        assertTrue(test.isPrime(311951,50));
        assertTrue(test.isPrime(313699,50));
        assertTrue(test.isPrime(316759,50));
        assertTrue(test.isPrime(680971,50));
        assertTrue(test.isPrime(680873,50));
        assertTrue(test.isPrime(682811,50));
        assertFalse(test.isPrime(680087,50));
        assertFalse(test.isPrime(690381,50));
        assertFalse(test.isPrime(694491,50));
        assertFalse(test.isPrime(706713,50));
        assertFalse(test.isPrime(710517,50));
        assertFalse(test.isPrime(721743,50));
        assertFalse(test.isPrime(750511,50));
        assertFalse(test.isPrime(750513,50));
        assertFalse(test.isPrime(772191,50));
        assertFalse(test.isPrime(772193,50));
        assertFalse(test.isPrime(778113,50));
    }

    @Test
    public void fermatPrime2Test() {
        ProbabilisticPrimeTest test = FermatPrimeTest.getInstance(gcdCalculator2);
        assertTrue(test.isPrime(2,5));
        assertTrue(test.isPrime(3,5));
        assertTrue(test.isPrime(5,5));
        assertTrue(test.isPrime(11,5));
        assertTrue(test.isPrime(7,5));
        assertTrue(test.isPrime(17,5));
        assertTrue(test.isPrime(13,5));
        assertTrue(test.isPrime(19,5));
        assertTrue(test.isPrime(23,5));
        assertTrue(test.isPrime(31,5));
        assertTrue(test.isPrime(37,5));
        assertFalse(test.isPrime(0,5));
        assertFalse(test.isPrime(1,5));
        assertFalse(test.isPrime(4,5));
        assertFalse(test.isPrime(6,5));
        assertFalse(test.isPrime(8,5));
        assertFalse(test.isPrime(9,5));
        assertFalse(test.isPrime(12,5));
        assertFalse(test.isPrime(15,5));
        assertFalse(test.isPrime(21,5));
        assertFalse(test.isPrime(25,5));
        assertFalse(test.isPrime(27,5));
        assertTrue(test.isPrime(976777,5));
        assertTrue(test.isPrime(978287,50));
        assertTrue(test.isPrime(956861,50));
        assertTrue(test.isPrime(931639,50));
        assertTrue(test.isPrime(310547,50));
        assertTrue(test.isPrime(311951,50));
        assertTrue(test.isPrime(313699,50));
        assertTrue(test.isPrime(316759,50));
        assertTrue(test.isPrime(680971,50));
        assertTrue(test.isPrime(680873,50));
        assertTrue(test.isPrime(682811,50));
        assertFalse(test.isPrime(680087,50));
        assertFalse(test.isPrime(690381,50));
        assertFalse(test.isPrime(694491,50));
        assertFalse(test.isPrime(706713,50));
        assertFalse(test.isPrime(710517,50));
        assertFalse(test.isPrime(721743,50));
        assertFalse(test.isPrime(750511,50));
        assertFalse(test.isPrime(750513,50));
        assertFalse(test.isPrime(772191,50));
        assertFalse(test.isPrime(772193,50));
        assertFalse(test.isPrime(778113,50));
    }

    @Test
    public void millerRabinTest() {
        ProbabilisticPrimeTest test = MillerRabinTest.getInstance();
        assertTrue(test.isPrime(2,5));
        assertTrue(test.isPrime(3,5));
        assertTrue(test.isPrime(5,5));
        assertTrue(test.isPrime(11,5));
        assertTrue(test.isPrime(7,5));
        assertTrue(test.isPrime(17,5));
        assertTrue(test.isPrime(13,5));
        assertTrue(test.isPrime(19,5));
        assertTrue(test.isPrime(23,5));
        assertTrue(test.isPrime(31,5));
        assertTrue(test.isPrime(37,5));
        assertFalse(test.isPrime(0,5));
        assertFalse(test.isPrime(1,5));
        assertFalse(test.isPrime(4,5));
        assertFalse(test.isPrime(6,5));
        assertFalse(test.isPrime(8,5));
        assertFalse(test.isPrime(9,5));
        assertFalse(test.isPrime(12,5));
        assertFalse(test.isPrime(15,5));
        assertFalse(test.isPrime(21,5));
        assertFalse(test.isPrime(25,5));
        assertFalse(test.isPrime(27,5));
        assertTrue(test.isPrime(976777,5));
        assertTrue(test.isPrime(978287,50));
        assertTrue(test.isPrime(956861,50));
        assertTrue(test.isPrime(931639,50));
        assertTrue(test.isPrime(310547,50));
        assertTrue(test.isPrime(311951,50));
        assertTrue(test.isPrime(313699,50));
        assertTrue(test.isPrime(316759,50));
        assertTrue(test.isPrime(680971,50));
        assertTrue(test.isPrime(680873,50));
        assertTrue(test.isPrime(682811,50));
        assertFalse(test.isPrime(680087,50));
        assertFalse(test.isPrime(690381,50));
        assertFalse(test.isPrime(694491,50));
        assertFalse(test.isPrime(706713,50));
        assertFalse(test.isPrime(710517,50));
        assertFalse(test.isPrime(721743,50));
        assertFalse(test.isPrime(750511,50));
        assertFalse(test.isPrime(750513,50));
        assertFalse(test.isPrime(772191,50));
        assertFalse(test.isPrime(772193,50));
        assertFalse(test.isPrime(778113,50));

    }

}
