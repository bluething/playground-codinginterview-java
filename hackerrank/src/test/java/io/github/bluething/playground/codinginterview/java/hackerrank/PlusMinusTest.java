package io.github.bluething.playground.codinginterview.java.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PlusMinusTest extends ParentTest {

    @Test
    public void case01() {
        plusMinus(Arrays.asList(-4, 3, -9, 0, 4, 1));
        Assertions.assertEquals("0.500000\n0.333333\n0.166667", output.toString());
    }

    private void plusMinus(List<Integer> arr) {
        float moreThan0 = 0.0f;
        float lessThan0 = 0.0f;
        float _0 = 0.0f;

        System.out.printf("%6f%n", moreThan0 / arr.size());
        System.out.printf("%6f%n", lessThan0 / arr.size());
        System.out.printf("%6f", _0 / arr.size());
    }

}
