package com.quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeStrategyTest {

    @Test
    void testStackStrategyPalindrome() {
        PalindromeCheckerWithStrategy checker =
                new PalindromeCheckerWithStrategy(new StackPalindromeStrategy());

        assertTrue(checker.checkPalindrome("madam"));
    }

    @Test
    void testStackStrategyNonPalindrome() {
        PalindromeCheckerWithStrategy checker =
                new PalindromeCheckerWithStrategy(new StackPalindromeStrategy());

        assertFalse(checker.checkPalindrome("hello"));
    }

    @Test
    void testDequeStrategyPalindrome() {
        PalindromeCheckerWithStrategy checker =
                new PalindromeCheckerWithStrategy(new DequePalindromeStrategy());

        assertTrue(checker.checkPalindrome("nurses run"));
    }

    @Test
    void testDequeStrategyNonPalindrome() {
        PalindromeCheckerWithStrategy checker =
                new PalindromeCheckerWithStrategy(new DequePalindromeStrategy());

        assertFalse(checker.checkPalindrome("world"));
    }

    @Test
    void testRuntimeStrategyChange() {
        PalindromeCheckerWithStrategy checker =
                new PalindromeCheckerWithStrategy(new StackPalindromeStrategy());

        assertTrue(checker.checkPalindrome("madam"));

        checker.setStrategy(new DequePalindromeStrategy());

        assertTrue(checker.checkPalindrome("racecar"));
    }

    @Test
    void testNullStrategyThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new PalindromeCheckerWithStrategy(null));
    }
}