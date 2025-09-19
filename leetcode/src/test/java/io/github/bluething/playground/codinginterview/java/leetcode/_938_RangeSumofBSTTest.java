package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _938_RangeSumofBSTTest {
    @Test
    void case01() {
        // Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
        // Output: 32
        // Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        int result = rangeSumBST(root, 7, 15);
        assertEquals(32, result);
    }

    @Test
    void case02() {
        // Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
        // Output: 23
        // Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);
        root.left.left.left = new TreeNode(1);
        root.left.right.left = new TreeNode(6);

        int result = rangeSumBST(root, 6, 10);
        assertEquals(23, result);
    }

    @Test
    void case03() {
        // Edge case: Single node within range
        TreeNode root = new TreeNode(5);

        int result = rangeSumBST(root, 3, 7);
        assertEquals(5, result);
    }

    @Test
    void case04() {
        // Edge case: Single node outside range (too small)
        TreeNode root = new TreeNode(2);

        int result = rangeSumBST(root, 5, 10);
        assertEquals(0, result);
    }

    @Test
    void case05() {
        // Edge case: Single node outside range (too large)
        TreeNode root = new TreeNode(15);

        int result = rangeSumBST(root, 5, 10);
        assertEquals(0, result);
    }

    @Test
    void case06() {
        // Edge case: All nodes within range
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        int result = rangeSumBST(root, 1, 10);
        assertEquals(21, result); // 2 + 3 + 4 + 5 + 7 = 21
    }

    @Test
    void case07() {
        // Edge case: No nodes within range
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        int result = rangeSumBST(root, 12, 13);
        assertEquals(0, result);
    }

    @Test
    void case08() {
        // Edge case: Range equals single node value
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        int result = rangeSumBST(root, 10, 10);
        assertEquals(10, result);
    }

    @Test
    void case09() {
        // Edge case: Left skewed tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(6);
        root.left.left.left = new TreeNode(4);

        int result = rangeSumBST(root, 5, 9);
        assertEquals(14, result); // 6 + 8 = 14
    }

    @Test
    void case10() {
        // Edge case: Right skewed tree
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(11);

        int result = rangeSumBST(root, 6, 10);
        assertEquals(16, result); // 7 + 9 = 16
    }

    @Test
    void case11() {
        // Edge case: Null root
        TreeNode root = null;

        int result = rangeSumBST(root, 1, 10);
        assertEquals(0, result);
    }

    @Test
    void case12() {
        // Test with larger values
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(50);
        root.right = new TreeNode(150);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(75);
        root.right.left = new TreeNode(125);
        root.right.right = new TreeNode(175);

        int result = rangeSumBST(root, 60, 130);
        assertEquals(300, result); // 75 + 100 + 125 = 300
    }

    private int rangeSumBST(TreeNode root, int low, int high) {
        return 0;
    }
}
