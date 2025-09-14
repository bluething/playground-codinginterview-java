package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _230_KthSmallestElementinaBSTTest {

    @Test
    void case01() {
        // Input: root = [3,1,4,null,2], k = 1
        // Tree structure:
        //   3
        //  / \
        // 1   4
        //  \
        //   2
        // Inorder: [1,2,3,4], 1st smallest = 1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int k = 1;
        int expected = 1;
        int result = kthSmallest(root, k);

        assertEquals(expected, result);
    }

    @Test
    void case02() {
        // Input: root = [5,3,6,2,4,null,null,1], k = 3
        // Tree structure:
        //     5
        //   /   \
        //  3     6
        // / \
        //2   4
        ///
        //1
        // Inorder: [1,2,3,4,5,6], 3rd smallest = 3
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        int k = 3;
        int expected = 3;
        int result = kthSmallest(root, k);

        assertEquals(expected, result);
    }

    @Test
    void case03() {
        // Single node tree, k = 1
        TreeNode root = new TreeNode(5);

        int k = 1;
        int expected = 5;
        int result = kthSmallest(root, k);

        assertEquals(expected, result);
    }

    @Test
    void case04() {
        // Find largest element (k = total nodes)
        //   3
        //  / \
        // 1   4
        //  \
        //   2
        // Inorder: [1,2,3,4], 4th smallest = 4
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int k = 4;
        int expected = 4;
        int result = kthSmallest(root, k);

        assertEquals(expected, result);
    }

    @Test
    void case05() {
        // Left-skewed BST
        //   4
        //  /
        // 3
        ///
        //2
        ///
        //1
        // Inorder: [1,2,3,4], 2nd smallest = 2
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);

        int k = 2;
        int expected = 2;
        int result = kthSmallest(root, k);

        assertEquals(expected, result);
    }

    @Test
    void case06() {
        // Right-skewed BST
        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        // Inorder: [1,2,3,4], 3rd smallest = 3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        int k = 3;
        int expected = 3;
        int result = kthSmallest(root, k);

        assertEquals(expected, result);
    }

    @Test
    void case07() {
        // Balanced BST
        //     4
        //   /   \
        //  2     6
        // / \   / \
        //1   3 5   7
        // Inorder: [1,2,3,4,5,6,7], 5th smallest = 5
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        int k = 5;
        int expected = 5;
        int result = kthSmallest(root, k);

        assertEquals(expected, result);
    }

    @Test
    void case08() {
        // Two nodes, find 2nd smallest
        //  1
        //   \
        //    2
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        int k = 2;
        int expected = 2;
        int result = kthSmallest(root, k);

        assertEquals(expected, result);
    }

    @Test
    void case09() {
        // Two nodes, find 1st smallest
        //  2
        // /
        //1
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);

        int k = 1;
        int expected = 1;
        int result = kthSmallest(root, k);

        assertEquals(expected, result);
    }

    @Test
    void case10() {
        // Larger BST with negative values
        //      0
        //    /   \
        //  -2     2
        //  / \   / \
        //-3  -1 1   3
        // Inorder: [-3,-2,-1,0,1,2,3], 4th smallest = 0
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(-3);
        root.left.right = new TreeNode(-1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);

        int k = 4;
        int expected = 0;
        int result = kthSmallest(root, k);

        assertEquals(expected, result);
    }

    private int kthSmallest(TreeNode root, int k) {
        return 0;
    }
}
