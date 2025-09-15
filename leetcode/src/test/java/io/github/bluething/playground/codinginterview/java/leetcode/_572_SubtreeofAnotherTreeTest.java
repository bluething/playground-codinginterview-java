package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _572_SubtreeofAnotherTreeTest {

    @Test
    void case01() {
        // Input: root = [3,4,5,1,2], subRoot = [4,1,2]
        // Output: true
        // The subtree rooted at node 4 in the main tree matches subRoot exactly
        TreeNode root = new TreeNode(3,
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(2)
                ),
                new TreeNode(5)
        );

        TreeNode subRoot = new TreeNode(4,
                new TreeNode(1),
                new TreeNode(2)
        );

        boolean expected = true;
        boolean result = isSubtree(root, subRoot);
        assertEquals(expected, result);
    }

    @Test
    void case02() {
        // Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
        // Output: false
        // The node 4 in the main tree has an additional child (0 under node 2),
        // so it doesn't match subRoot exactly
        TreeNode root = new TreeNode(3,
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(2,
                                new TreeNode(0),
                                null
                        )
                ),
                new TreeNode(5)
        );

        TreeNode subRoot = new TreeNode(4,
                new TreeNode(1),
                new TreeNode(2)
        );

        boolean expected = false;
        boolean result = isSubtree(root, subRoot);
        assertEquals(expected, result);
    }

    private boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        return isSameTree(root, subRoot) ||
                isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }
    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.value != root2.value) {
            return false;
        }

        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
}
