package com.aads.palidrome.number;

public class palindromeNumber {

    public static void main(String[] args) {

        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(11));
        System.out.println(isPalindrome(200));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 && x % 10 == 0) {
            return false;
        }
        int invertedNumber = 0;
        int copyOfx = x;

        while (copyOfx != 0) {
            invertedNumber = invertedNumber * 10 + copyOfx % 10;
            copyOfx = copyOfx / 10;
        }

        return invertedNumber == x;
    }

}
