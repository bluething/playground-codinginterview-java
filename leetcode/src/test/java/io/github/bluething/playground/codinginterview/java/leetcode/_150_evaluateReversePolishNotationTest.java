package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _150_evaluateReversePolishNotationTest {
    @Test
    void case01() {
        Assertions.assertEquals(9, evalRPN(new String[]{"2","1","+","3","*"}));
    }
    @Test
    void case02() {
        Assertions.assertEquals(6, evalRPN(new String[]{"4","13","5","/","+"}));
    }
    @Test
    void case03() {
        Assertions.assertEquals(22, evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
    private int evalRPN(String[] tokens) {
        return 0;
    }
}
