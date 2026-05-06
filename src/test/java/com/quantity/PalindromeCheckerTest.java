package com.quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeCheckerTest {

    PalindromeChecker checker = new PalindromeChecker();

    @Test
    void testPalindromeWord() {
        assertTrue(checker.checkPalindrome("madam"));
    }

    @Test
    void testNonPalindromeWord() {
        assertFalse(checker.checkPalindrome("hello"));
    }

    @Test
    void testPalindromeSentence() {
        assertTrue(checker.checkPalindrome("nurses run"));
    }

    @Test
    void testCaseInsensitivePalindrome() {
        assertTrue(checker.checkPalindrome("Madam"));
    }

    @Test
    void testEmptyString() {
        assertTrue(checker.checkPalindrome(""));
    }

    @Test
    void testNullInput() {
        assertFalse(checker.checkPalindrome(null));
    }
}