package com.quantity;

import java.util.Scanner;

public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PalindromeChecker checker = new PalindromeChecker();

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