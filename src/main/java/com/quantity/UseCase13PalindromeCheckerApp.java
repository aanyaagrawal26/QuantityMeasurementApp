package com.quantity;

public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "madam".repeat(10000);

        PalindromeStrategy stackStrategy = new StackPalindromeStrategy();
        PalindromeStrategy dequeStrategy = new DequePalindromeStrategy();

        System.out.println("Performance Comparison for Palindrome Algorithms");
        System.out.println("Input length: " + input.length());
        System.out.println("---------------------------------------------");

        measurePerformance("Stack Strategy", stackStrategy, input);
        measurePerformance("Deque Strategy", dequeStrategy, input);
    }

    private static void measurePerformance(String strategyName,
                                           PalindromeStrategy strategy,
                                           String input) {

        long startTime = System.nanoTime();

        boolean result = strategy.isPalindrome(input);

        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;

        System.out.println(strategyName);
        System.out.println("Result: " + result);
        System.out.println("Execution Time: " + executionTime + " ns");
        System.out.println("---------------------------------------------");
    }
}