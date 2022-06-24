package com.aads.palidrome.string;

/**
 isPalindrome(String text);

 >>isPalindrome("ABBA BBBB ABba") -> true;
 >>isPalindrome("ABBA 2345 AB':ba") -> true;
 >>isPalindrome("ABewrBA 2345 ABba") -> false;
 */

public class palindromeString {

    public static void main(String[] args) {

        System.out.println(isPalindrome("ABBA BBBB ABba"));
        System.out.println(isPalindrome("ABBA 2345 AB':ba"));
        System.out.println(isPalindrome("ABewrBA 2345 ABba"));
    }

    public static boolean isPalindrome(String text) {
        String s1 = text.toUpperCase().replaceAll("[^A-Za-z]", "");
        StringBuilder s2 = new StringBuilder(s1).reverse();
        boolean isPalindrome = true;
        for (int index = 0; index < s1.length(); index++) {
            if (s1.charAt(index) != s2.charAt(index)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

}
