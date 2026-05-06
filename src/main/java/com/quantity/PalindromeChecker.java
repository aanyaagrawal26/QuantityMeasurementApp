package com.quantity;

import java.util.Stack;

public class PalindromeChecker {

    public boolean checkPalindrome(String input) {

        if (input == null) {
            return false;
        }

        String cleaned = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (char ch : cleaned.toCharArray()) {
            stack.push(ch);
        }

        String reversed = "";

        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return cleaned.equals(reversed);
    }
}