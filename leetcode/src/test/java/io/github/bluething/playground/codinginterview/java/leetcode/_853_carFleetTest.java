package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class _853_carFleetTest {
    @Test
    void case01() {
        Assertions.assertEquals(3, carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3}));
    }
    @Test
    void case02() {
        Assertions.assertEquals(1, carFleet(10, new int[]{3}, new int[]{3}));
    }
    @Test
    void case03() {
        Assertions.assertEquals(1, carFleet(100, new int[]{0,2,4}, new int[]{4,2,1}));
    }

    private int carFleet(int target, int[] position, int[] speed) {
        double [][] carPositions = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            carPositions[i][0] = position[i];
            carPositions[i][1] = speed[i];
        }
        Arrays.sort(carPositions, Comparator.comparingDouble(o -> o[0]));
        Stack<Double> stack = new Stack<>();
        // from the closest car to the target
        for (int i = carPositions.length-1; i >= 0; i--) {
            // calculate the time needed to reach the target
            double timeSpent = (target - carPositions[i][0]) / carPositions[i][1];
            // if the stack is not empty
            // and current car will reach the target earlier or at same time as the other cars (top of the stack)
            // then the current car join the fleet
            // the stack will have asc order, from bottom
            // because we calculate time spent from closest car
            if (!stack.isEmpty() && timeSpent <= stack.peek()) {
                continue;
            }
            stack.push(timeSpent);
        }
        return stack.size();
    }
}
