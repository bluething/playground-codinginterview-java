package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

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
    @Test
    void case04() {
        Assertions.assertEquals(9, evalRPN2(new String[]{"2","1","+","3","*"}));
    }
    @Test
    void case05() {
        Assertions.assertEquals(6, evalRPN2(new String[]{"4","13","5","/","+"}));
    }
    @Test
    void case06() {
        Assertions.assertEquals(22, evalRPN2(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
    private int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(apply(token, operand1, operand2));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    private int apply(String operator, int operand1, int operand2) {
        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            default -> operand1 / operand2;
        };
    }

    private int evalRPN2(String[] tokens) {
        int[] stack = new int[tokens.length];
        int idx = 0;
        for (String token : tokens) {
            if (isOperator(token)) {
                int operand2 = stack[--idx];
                int operand1 = stack[--idx];
                stack[idx++] = apply(token, operand1, operand2);
            } else {
                stack[idx++] = Integer.parseInt(token);
            }
        }

        return stack[0];
    }
}
