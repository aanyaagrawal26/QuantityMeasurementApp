package com.quantity;

public class PalindromeCheckerWithStrategy {

    private PalindromeStrategy strategy;

    public PalindromeCheckerWithStrategy(PalindromeStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy cannot be null");
        }

        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy cannot be null");
        }

        this.strategy = strategy;
    }

    public boolean checkPalindrome(String input) {
        return strategy.isPalindrome(input);
    }
}