package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class _1038_BinarySearchTreetoGreaterSumTreeTest {
    @Test
    void case01() {
        // Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
        // Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(8);

        TreeNode result = bstToGst(root);

        // Verify the transformed tree values
        assertEquals(30, result.value);                    // 4 -> 30
        assertEquals(36, result.left.value);               // 1 -> 36
        assertEquals(21, result.right.value);              // 6 -> 21
        assertEquals(36, result.left.left.value);          // 0 -> 36
        assertEquals(35, result.left.right.value);         // 2 -> 35
        assertEquals(26, result.right.left.value);         // 5 -> 26
        assertEquals(15, result.right.right.value);        // 7 -> 15
        assertEquals(33, result.left.right.right.value);   // 3 -> 33
        assertEquals(8, result.right.right.right.value);   // 8 -> 8
    }

    @Test
    void case02() {
        // Input: root = [0,null,1]
        // Output: [1,null,1]

        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(1);

        TreeNode result = bstToGst(root);

        assertEquals(1, result.value);        // 0 -> 1
        assertEquals(1, result.right.value);  // 1 -> 1
        assertNull(result.left);
    }

    @Test
    void case03() {
        // Edge case: Single node
        TreeNode root = new TreeNode(5);

        TreeNode result = bstToGst(root);

        assertEquals(5, result.value);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    void case04() {
        // Edge case: Left skewed tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);

        TreeNode result = bstToGst(root);

        assertEquals(3, result.value);        // 3 -> 3
        assertEquals(5, result.left.value);   // 2 -> 5 (2+3)
        assertEquals(6, result.left.left.value); // 1 -> 6 (1+2+3)
    }

    @Test
    void case05() {
        // Edge case: Right skewed tree
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        TreeNode result = bstToGst(root);

        assertEquals(6, result.value);          // 1 -> 6 (1+2+3)
        assertEquals(5, result.right.value);    // 2 -> 5 (2+3)
        assertEquals(3, result.right.right.value); // 3 -> 3
    }

    @Test
    void case06() {
        // Edge case: Null root
        TreeNode root = null;
        TreeNode result = bstToGst(root);
        assertNull(result);
    }
    
    // Helper method to verify tree structure (for debugging)
    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.value);
        inorderHelper(node.right, result);
    }

    private TreeNode bstToGst(TreeNode root) {
        return null;
    }
}
