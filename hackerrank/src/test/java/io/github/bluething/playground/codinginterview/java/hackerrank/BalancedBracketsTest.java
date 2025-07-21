package io.github.bluething.playground.codinginterview.java.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BalancedBracketsTest {
    @Test
    void case01() {
        Assertions.assertEquals("YES", isBalanced("{[()]}"));
    }
    @Test
    void case02() {
        Assertions.assertEquals("NO", isBalanced("{[(])}"));
    }
    @Test
    void case03() {
        Assertions.assertEquals("YES", isBalanced("{{[[(())]]}}"));
    }
    private String isBalanced(String s) {
        return "";
    }
}
