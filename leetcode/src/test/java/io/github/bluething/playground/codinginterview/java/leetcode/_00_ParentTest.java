package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

abstract class _00_ParentTest {
    public final ByteArrayOutputStream output = new ByteArrayOutputStream();
    public final PrintStream originalOutput = System.out;

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOutput);
    }
}
