package com.wwt.tools.mathtools.prime;

import com.wwt.tools.mathtools.MathToolTest;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

@SuppressWarnings("unused")
public class PrimeSequenceTest {

    private final int [] p100 = { 2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};

    @Test
    public void SieveOfEratosthenesTest() {
        int number = 100;
        PrimeSequenceGenerator psg = SieveOfEratosthenes.getInstance();
        List<Integer> l = psg.getPrimeSequence(number);
        System.out.println(psg+""+l);
        assertEquals(MathToolTest.getArrayAsList(p100),l);
        number=2;
        l = psg.getPrimeSequence(number);
        assertEquals(1,l.size());
        assertEquals(2,l.get(0).intValue());
    }

    @Test
    public void SieveOfSundaramTest() {
        int number = 100;
        PrimeSequenceGenerator psg = SieveOfSundaram.getInstance();
        List<Integer> l = psg.getPrimeSequence(number);
        System.out.println(psg+""+l);
        assertEquals(MathToolTest.getArrayAsList(p100),l);
        number=2;
        l = psg.getPrimeSequence(number);
        assertEquals(1,l.size());
        assertEquals(2,l.get(0).intValue());
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void SieveOfEratosthenesExceptionTest() {
        int number = 1;
        PrimeSequenceGenerator psg = SieveOfEratosthenes.getInstance();
        List<Integer> l = psg.getPrimeSequence(number);
    }
    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void SieveOfSundaramExceptionTest() {
        int number = 1;
        PrimeSequenceGenerator psg = SieveOfEratosthenes.getInstance();
        List<Integer> l = psg.getPrimeSequence(number);
    }





}

