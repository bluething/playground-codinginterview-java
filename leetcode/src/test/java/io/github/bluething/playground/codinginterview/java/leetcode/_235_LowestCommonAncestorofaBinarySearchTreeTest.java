package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class _235_LowestCommonAncestorofaBinarySearchTreeTest extends _01_ParentTreeTest {
    @Test
    void case01() {
        // Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        // Output: 6
        // The LCA of nodes 2 and 8 is 6
        TreeNode root = new TreeNode(6,
                new TreeNode(2,
                        new TreeNode(0),
                        new TreeNode(4,
                                new TreeNode(3),
                                new TreeNode(5)
                        )
                ),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(9)
                )
        );

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        TreeNode expected = new TreeNode(6);

        TreeNode result = lowestCommonAncestor(root, p, q);
        assertNotNull(result);
        assertEquals(expected.value, result.value);
    }

    @Test
    void case02() {
        // Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
        // Output: 2
        // The LCA of nodes 2 and 4 is 2 (node can be ancestor of itself)
        TreeNode root = new TreeNode(6,
                new TreeNode(2,
                        new TreeNode(0),
                        new TreeNode(4,
                                new TreeNode(3),
                                new TreeNode(5)
                        )
                ),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(9)
                )
        );

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);
        TreeNode expected = new TreeNode(2);

        TreeNode result = lowestCommonAncestor(root, p, q);
        assertNotNull(result);
        assertEquals(expected.value, result.value);
    }

    @Test
    void case03() {
        // Input: root = [2,1], p = 2, q = 1
        // Output: 2
        TreeNode root = new TreeNode(2,
                new TreeNode(1),
                null
        );

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(1);
        TreeNode expected = new TreeNode(2);

        TreeNode result = lowestCommonAncestor(root, p, q);
        assertNotNull(result);
        assertEquals(expected.value, result.value);
    }

    @Test
    void case04() {
        // Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        // Output: 6
        // The LCA of nodes 2 and 8 is 6
        TreeNode root = new TreeNode(6,
                new TreeNode(2,
                        new TreeNode(0),
                        new TreeNode(4,
                                new TreeNode(3),
                                new TreeNode(5)
                        )
                ),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(9)
                )
        );

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        TreeNode expected = new TreeNode(6);

        TreeNode result = lowestCommonAncestor2(root, p, q);
        assertNotNull(result);
        assertEquals(expected.value, result.value);
    }

    @Test
    void case05() {
        // Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
        // Output: 2
        // The LCA of nodes 2 and 4 is 2 (node can be ancestor of itself)
        TreeNode root = new TreeNode(6,
                new TreeNode(2,
                        new TreeNode(0),
                        new TreeNode(4,
                                new TreeNode(3),
                                new TreeNode(5)
                        )
                ),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(9)
                )
        );

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);
        TreeNode expected = new TreeNode(2);

        TreeNode result = lowestCommonAncestor2(root, p, q);
        assertNotNull(result);
        assertEquals(expected.value, result.value);
    }

    @Test
    void case06() {
        // Input: root = [2,1], p = 2, q = 1
        // Output: 2
        TreeNode root = new TreeNode(2,
                new TreeNode(1),
                null
        );

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(1);
        TreeNode expected = new TreeNode(2);

        TreeNode result = lowestCommonAncestor2(root, p, q);
        assertNotNull(result);
        assertEquals(expected.value, result.value);
    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.value < root.value && q.value < root.value) {
                root = root.left;
            } else if (p.value > root.value && q.value > root.value) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
    private TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // Both p and q are in the left subtree
        if (p.value < root.value && q.value < root.value) {
            return lowestCommonAncestor2(root.left, p, q);
        }
        // Both p and q are in the right subtree
        if (p.value > root.value && q.value > root.value) {
            return lowestCommonAncestor2(root.right, p, q);
        }

        // Split case: one node is on left, one on right (or one equals root)
        // This means current root is the LCA
        return root;
    }
}
