package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _236_LowestCommonAncestorofaBinaryTreeTest {
    @Test
    void case01() {
        // Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        // Tree structure:
        //         3
        //       /   \
        //      5     1
        //     / \   / \
        //    6   2 0   8
        //       / \
        //      7   4
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left; // node 5
        TreeNode q = root.right; // node 1
        TreeNode expected = root; // node 3

        TreeNode result = lowestCommonAncestor(root, p, q);
        assertEquals(expected.value, result.value);
    }

    @Test
    void case02() {
        // Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
        // Same tree as case01
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left; // node 5
        TreeNode q = root.left.right.right; // node 4
        TreeNode expected = root.left; // node 5

        TreeNode result = lowestCommonAncestor(root, p, q);
        assertEquals(expected.value, result.value);
    }

    @Test
    void case03() {
        // Input: root = [1,2], p = 1, q = 2
        // Tree structure:
        //   1
        //  /
        // 2
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        TreeNode p = root; // node 1
        TreeNode q = root.left; // node 2
        TreeNode expected = root; // node 1

        TreeNode result = lowestCommonAncestor(root, p, q);
        assertEquals(expected.value, result.value);
    }

    @Test
    void case04() {
        // Simple two-node tree with right child
        //   1
        //    \
        //     2
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        TreeNode p = root; // node 1
        TreeNode q = root.right; // node 2
        TreeNode expected = root; // node 1

        TreeNode result = lowestCommonAncestor(root, p, q);
        assertEquals(expected.value, result.value);
    }

    @Test
    void case05() {
        // Three-level balanced tree
        //     1
        //    / \
        //   2   3
        //  / \
        // 4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode p = root.left.left; // node 4
        TreeNode q = root.left.right; // node 5
        TreeNode expected = root.left; // node 2

        TreeNode result = lowestCommonAncestor(root, p, q);
        assertEquals(expected.value, result.value);
    }

    @Test
    void case06() {
        // LCA is one of the nodes itself (p is ancestor of q)
        //     1
        //    / \
        //   2   3
        //  /
        // 4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        TreeNode p = root.left; // node 2
        TreeNode q = root.left.left; // node 4
        TreeNode expected = root.left; // node 2

        TreeNode result = lowestCommonAncestor(root, p, q);
        assertEquals(expected.value, result.value);
    }

    @Test
    void case07() {
        // LCA across different subtrees at deeper levels
        //       1
        //     /   \
        //    2     3
        //   / \   / \
        //  4   5 6   7
        // /
        //8
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);

        TreeNode p = root.left.left.left; // node 8
        TreeNode q = root.right.right; // node 7
        TreeNode expected = root; // node 1

        TreeNode result = lowestCommonAncestor(root, p, q);
        assertEquals(expected.value, result.value);
    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }
}
