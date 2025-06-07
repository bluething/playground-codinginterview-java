package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _125_validPalindromeTest {
    @Test
    public void case01() {
        Assertions.assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void case02() {
        Assertions.assertFalse(isPalindrome("race a car"));
    }

    @Test
    public void case03() {
        Assertions.assertTrue(isPalindrome(" "));
    }

    @Test
    public void case04() {
        Assertions.assertTrue(isPalindrome(".,"));
    }

    @Test
    public void case05() {
        Assertions.assertFalse(isPalindrome("0P"));
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(chars[left])) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(chars[right])) {
                right--;
            }
            if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
