package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class _105_ConstructBinaryTreefromPreorderandInorderTest {
    @Test
    void case01() {
        // Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        // Expected tree:
        //     3
        //   /   \
        //  9    20
        //      /  \
        //     15   7
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode result = buildTree(preorder, inorder);
        assertNotNull(result);
        assertTrue(isValidConstruction(result, preorder, inorder));

        // Also verify specific tree structure for this example
        assertEquals(3, result.value);
        assertNotNull(result.left);
        assertEquals(9, result.left.value);
        assertNull(result.left.left);
        assertNull(result.left.right);
        assertNotNull(result.right);
        assertEquals(20, result.right.value);
        assertNotNull(result.right.left);
        assertEquals(15, result.right.left.value);
        assertNotNull(result.right.right);
        assertEquals(7, result.right.right.value);
    }

    @Test
    void case02() {
        // Input: preorder = [-1], inorder = [-1]
        // Single node tree
        int[] preorder = {-1};
        int[] inorder = {-1};

        TreeNode result = buildTree(preorder, inorder);
        assertNotNull(result);
        assertTrue(isValidConstruction(result, preorder, inorder));
        assertEquals(-1, result.value);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    void case03() {
        // Empty arrays
        int[] preorder = {};
        int[] inorder = {};

        TreeNode result = buildTree(preorder, inorder);
        assertNull(result);
    }

    @Test
    void case04() {
        // Left-skewed tree
        // preorder: [1,2,3] (root, left subtree, right subtree)
        // inorder: [3,2,1] (left subtree, root, right subtree)
        //   1
        //  /
        // 2
        ///
        //3
        int[] preorder = {1, 2, 3};
        int[] inorder = {3, 2, 1};

        TreeNode result = buildTree(preorder, inorder);
        assertNotNull(result);
        assertTrue(isValidConstruction(result, preorder, inorder));
        assertEquals(1, result.value);
        assertNotNull(result.left);
        assertEquals(2, result.left.value);
        assertNotNull(result.left.left);
        assertEquals(3, result.left.left.value);
        assertNull(result.right);
    }

    @Test
    void case05() {
        // Right-skewed tree
        // preorder: [1,2,3] (root, left subtree, right subtree)
        // inorder: [1,2,3] (left subtree, root, right subtree)
        // 1
        //  \
        //   2
        //    \
        //     3
        int[] preorder = {1, 2, 3};
        int[] inorder = {1, 2, 3};

        TreeNode result = buildTree(preorder, inorder);
        assertNotNull(result);
        assertTrue(isValidConstruction(result, preorder, inorder));
        assertEquals(1, result.value);
        assertNull(result.left);
        assertNotNull(result.right);
        assertEquals(2, result.right.value);
        assertNull(result.right.left);
        assertNotNull(result.right.right);
        assertEquals(3, result.right.right.value);
    }

    @Test
    void case06() {
        // Complete balanced binary tree
        // preorder: [1,2,4,5,3,6,7] (root, left subtree, right subtree)
        // inorder: [4,2,5,1,6,3,7] (left subtree, root, right subtree)
        //     1
        //   /   \
        //  2     3
        // / \   / \
        //4   5 6   7
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};

        TreeNode result = buildTree(preorder, inorder);
        assertNotNull(result);
        assertTrue(isValidConstruction(result, preorder, inorder));
        assertEquals(1, result.value);
        assertEquals(2, result.left.value);
        assertEquals(3, result.right.value);
        assertEquals(4, result.left.left.value);
        assertEquals(5, result.left.right.value);
        assertEquals(6, result.right.left.value);
        assertEquals(7, result.right.right.value);
    }

    @Test
    void case07() {
        // Two nodes (left child)
        // preorder: [1,2] (root, left subtree)
        // inorder: [2,1] (left subtree, root)
        //  1
        // /
        //2
        int[] preorder = {1, 2};
        int[] inorder = {2, 1};

        TreeNode result = buildTree(preorder, inorder);
        assertNotNull(result);
        assertTrue(isValidConstruction(result, preorder, inorder));
        assertEquals(1, result.value);
        assertEquals(2, result.left.value);
        assertNull(result.right);
    }

    @Test
    void case08() {
        // Two nodes (right child)
        // preorder: [1,2] (root, right subtree)
        // inorder: [1,2] (root, right subtree)
        // 1
        //  \
        //   2
        int[] preorder = {1, 2};
        int[] inorder = {1, 2};

        TreeNode result = buildTree(preorder, inorder);
        assertNotNull(result);
        assertTrue(isValidConstruction(result, preorder, inorder));
        assertEquals(1, result.value);
        assertNull(result.left);
        assertEquals(2, result.right.value);
    }

    @Test
    void case09() {
        // Tree with negative values
        // preorder: [-1,-2,3,-4]
        // inorder: [-2,-1,-4,3]
        //    -1
        //   /  \
        // -2    3
        //      /
        //    -4
        int[] preorder = {-1, -2, 3, -4};
        int[] inorder = {-2, -1, -4, 3};

        TreeNode result = buildTree(preorder, inorder);
        assertNotNull(result);
        assertTrue(isValidConstruction(result, preorder, inorder));
        assertEquals(-1, result.value);
        assertEquals(-2, result.left.value);
        assertEquals(3, result.right.value);
        assertEquals(-4, result.right.left.value);
    }

    @Test
    void case10() {
        // Asymmetric tree
        // preorder: [1,2,4,8,5,3,6,7]
        // inorder: [8,4,2,5,1,6,3,7]
        //       1
        //     /   \
        //    2     3
        //   / \   / \
        //  4   5 6   7
        // /
        //8
        int[] preorder = {1, 2, 4, 8, 5, 3, 6, 7};
        int[] inorder = {8, 4, 2, 5, 1, 6, 3, 7};

        TreeNode result = buildTree(preorder, inorder);
        assertNotNull(result);
        assertTrue(isValidConstruction(result, preorder, inorder));
        assertEquals(1, result.value);
        assertEquals(2, result.left.value);
        assertEquals(3, result.right.value);
        assertEquals(4, result.left.left.value);
        assertEquals(5, result.left.right.value);
        assertEquals(6, result.right.left.value);
        assertEquals(7, result.right.right.value);
        assertEquals(8, result.left.left.left.value);
    }

    @Test
    void case11() {
        // Tree with duplicate values (if allowed by problem constraints)
        // preorder: [1,2,2,3]
        // inorder: [2,2,1,3]
        //   1
        //  / \
        // 2   3
        ///
        //2
        int[] preorder = {1, 2, 2, 3};
        int[] inorder = {2, 2, 1, 3};

        TreeNode result = buildTree(preorder, inorder);
        assertNotNull(result);
        assertTrue(isValidConstruction(result, preorder, inorder));
    }

    @Test
    void case12() {
        // Large values
        int[] preorder = {1000000, 999999, 999998};
        int[] inorder = {999998, 999999, 1000000};

        TreeNode result = buildTree(preorder, inorder);
        assertNotNull(result);
        assertTrue(isValidConstruction(result, preorder, inorder));
        assertEquals(1000000, result.value);
        assertEquals(999999, result.left.value);
        assertEquals(999998, result.left.left.value);
    }

    private boolean isValidConstruction(TreeNode root, int[] expectedPreorder, int[] expectedInorder) {
        if (root == null) return expectedPreorder.length == 0 && expectedInorder.length == 0;

        // Verify the constructed tree produces the same traversals
        List<Integer> actualPreorder = new ArrayList<>();
        List<Integer> actualInorder = new ArrayList<>();

        preorderTraversal(root, actualPreorder);
        inorderTraversal(root, actualInorder);

        return actualPreorder.size() == expectedPreorder.length &&
                actualInorder.size() == expectedInorder.length &&
                actualPreorder.equals(Arrays.stream(expectedPreorder).boxed().collect(Collectors.toList())) &&
                actualInorder.equals(Arrays.stream(expectedInorder).boxed().collect(Collectors.toList()));
    }

    private void preorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.value);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
    }
    private void inorderTraversal(TreeNode root, List<Integer> actualInorder) {
        if (root == null) return;
        inorderTraversal(root.left, actualInorder);
        actualInorder.add(root.value);
        inorderTraversal(root.right, actualInorder);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }
}
