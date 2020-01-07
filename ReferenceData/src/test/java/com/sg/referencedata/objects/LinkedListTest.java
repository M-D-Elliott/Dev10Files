/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.referencedata.objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Corbin.
 */
import java.util.Random;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void testSize() {
        LinkedList<Integer> numbers = makeNumbers();
        assertEquals(100, numbers.size());
    }

    @Test
    public void testContains() {

        LinkedList<Integer> numbers = makeNumbers();
        int testValue = 199185217;
        numbers.add(testValue);
        numbers.print();

        assertTrue(numbers.contains(testValue));
        assertFalse(numbers.contains(-100));
    }

    private static LinkedList<Integer> makeNumbers() {

        final Random rand = new Random(512); // 512 seed guarantees the same sequence
        final LinkedList<Integer> numbers = new LinkedList<>();

        IntStream.range(0, 100).forEach(n -> numbers.add(rand.nextInt()));

        return numbers;
    }

}
