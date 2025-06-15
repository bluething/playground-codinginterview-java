package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class _22_generateParenthesesTest {
    @Test
    void case01() {
        Assertions.assertEquals(List.of("((()))","(()())","(())()","()(())","()()()"), generateParenthesis(3));
    }

    @Test
    void case02() {
        Assertions.assertEquals(List.of("()"), generateParenthesis(1));
    }

    @Test
    void case03() {
        Assertions.assertEquals(List.of("((()))","(()())","(())()","()(())","()()()"), generateParenthesis2(3));
    }

    @Test
    void case04() {
        Assertions.assertEquals(List.of("()"), generateParenthesis2(1));
    }

    private List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void generate(List<String> parenthesis, StringBuilder sb, int open, int close, int max) {
        if (close == max && open == max) {
            parenthesis.add(sb.toString());
            return;
        }

        if (open < max) {
            generate(parenthesis, sb.append("("), open + 1, close, max);
            sb.setLength(sb.length() - 1);
        }
        if (close < open) {
            generate(parenthesis, sb.append(")"), open, close + 1, max);
            sb.setLength(sb.length() - 1);
        }
    }

    private List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        // Stack holds triples: (currentString, openCount, closeCount)
        Deque<State> stack = new ArrayDeque<>();
        stack.push(new State(new StringBuilder(), 0, 0));

        while (!stack.isEmpty()) {
            State cur = stack.pop();

            // If we've placed all parentheses, add to result
            if (cur.open == n && cur.close == n) {
                result.add(cur.sb.toString());
                continue;
            }

            // Try to add "(" if still have opens left
            if (cur.open < n) {
                StringBuilder sbOpen = new StringBuilder(cur.sb);
                sbOpen.append('(');
                stack.push(new State(sbOpen, cur.open + 1, cur.close));
            }

            // Try to add ")" if valid (close < open)
            if (cur.close < cur.open) {
                StringBuilder sbClose = new StringBuilder(cur.sb);
                sbClose.append(')');
                stack.push(new State(sbClose, cur.open, cur.close + 1));
            }
        }

        return result;
    }

    // Helper state class
    private static class State {
        StringBuilder sb;
        int open, close;
        State(StringBuilder sb, int open, int close) {
            this.sb = sb;
            this.open = open;
            this.close = close;
        }
    }

}
