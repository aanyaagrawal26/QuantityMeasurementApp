package com.quantity;

import java.util.Scanner;

public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose Palindrome Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackPalindromeStrategy();
        } else {
            strategy = new DequePalindromeStrategy();
        }

        PalindromeCheckerWithStrategy checker =
                new PalindromeCheckerWithStrategy(strategy);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        scanner.close();
    }
}