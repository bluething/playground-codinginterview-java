package io.github.bluething.playground.codinginterview.java.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class NewYearChaosTest extends ParentTest {
    @Test
    void case01() {
        minimumBribes(List.of(2, 1, 5, 3, 4));
        Assertions.assertEquals("3\n", output.toString());
    }
    @Test
    void case02() {
        minimumBribes(List.of(2, 5, 1, 3, 4));
        Assertions.assertEquals("Too chaotic\n", output.toString());
    }
    private void minimumBribes(List<Integer> q) {

    }
}
