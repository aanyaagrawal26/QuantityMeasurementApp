package com.quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromePerformanceTest {

    @Test
    void testStackStrategyWorksForLargeInput() {
        PalindromeStrategy strategy = new StackPalindromeStrategy();

        String input = "madam".repeat(1000);

        assertTrue(strategy.isPalindrome(input));
    }

    @Test
    void testDequeStrategyWorksForLargeInput() {
        PalindromeStrategy strategy = new DequePalindromeStrategy();

        String input = "madam".repeat(1000);

        assertTrue(strategy.isPalindrome(input));
    }

    @Test
    void testBothStrategiesGiveSameResult() {
        PalindromeStrategy stack = new StackPalindromeStrategy();
        PalindromeStrategy deque = new DequePalindromeStrategy();

        String input = "nurses run";

        assertEquals(stack.isPalindrome(input), deque.isPalindrome(input));
    }
}