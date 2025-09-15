package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertTrue;

class _226_InvertBinaryTreeTest extends _01_ParentTreeTest {
    @Test
    void case01() {
        // Input: root = [4,2,7,1,3,6,9]
        // Output: [4,7,2,9,6,3,1]
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)
                ),
                new TreeNode(7,
                        new TreeNode(6),
                        new TreeNode(9)
                )
        );

        TreeNode expected = new TreeNode(4,
                new TreeNode(7,
                        new TreeNode(9),
                        new TreeNode(6)
                ),
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(1)
                )
        );

        TreeNode result = invertTree(root);
        assertTrue(areTreesEqual(result, expected));
    }

    @Test
    void case02() {
        // Input: root = [2,1,3]
        // Output: [2,3,1]
        TreeNode root = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3)
        );

        TreeNode expected = new TreeNode(2,
                new TreeNode(3),
                new TreeNode(1)
        );

        TreeNode result = invertTree(root);
        assertTrue(areTreesEqual(result, expected));
    }

    @Test
    void case03() {
        // Input: root = []
        // Output: []

        TreeNode result = invertTree(null);
        assertTrue(areTreesEqual(result, null));
    }

    @Test
    void case04() {
        // Input: root = [4,2,7,1,3,6,9]
        // Output: [4,7,2,9,6,3,1]
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)
                ),
                new TreeNode(7,
                        new TreeNode(6),
                        new TreeNode(9)
                )
        );

        TreeNode expected = new TreeNode(4,
                new TreeNode(7,
                        new TreeNode(9),
                        new TreeNode(6)
                ),
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(1)
                )
        );

        TreeNode result = invertTree2(root);
        assertTrue(areTreesEqual(result, expected));
    }

    @Test
    void case05() {
        // Input: root = [2,1,3]
        // Output: [2,3,1]
        TreeNode root = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3)
        );

        TreeNode expected = new TreeNode(2,
                new TreeNode(3),
                new TreeNode(1)
        );

        TreeNode result = invertTree2(root);
        assertTrue(areTreesEqual(result, expected));
    }

    @Test
    void case06() {
        // Input: root = []
        // Output: []

        TreeNode result = invertTree2(null);
        assertTrue(areTreesEqual(result, null));
    }

    private TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            TreeNode current = nodes.pop();
            if (current != null) {
                TreeNode temp = current.left;
                current.left = current.right;
                current.right = temp;

                nodes.push(current.left);
                nodes.push(current.right);
            }
        }

        return root;
    }
}