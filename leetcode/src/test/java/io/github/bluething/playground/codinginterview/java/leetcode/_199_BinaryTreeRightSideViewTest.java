package io.github.bluething.playground.codinginterview.java.leetcode;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _199_BinaryTreeRightSideViewTest {

    @Test
    void case01() {
        // Input: root = [1,2,3,null,5,null,4]
        // Output: [1,3,4]
        // Right side view: 1 (level 0), 3 (level 1), 4 (level 2)
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(5)
                ),
                new TreeNode(3,
                        null,
                        new TreeNode(4)
                )
        );

        List<Integer> expected = Arrays.asList(1, 3, 4);

        List<Integer> result = rightSideView(root);
        assertEquals(expected, result);
    }

    @Test
    void case02() {
        // Input: root = [1,2,3,4,null,null,null,5]
        // Output: [1,3,4,5]
        // Right side view: 1 (level 0), 3 (level 1), 4 (level 2), 5 (level 3)
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(5),
                                null
                        ),
                        null
                ),
                new TreeNode(3)
        );

        List<Integer> expected = Arrays.asList(1, 3, 4, 5);

        List<Integer> result = rightSideView(root);
        assertEquals(expected, result);
    }

    @Test
    void case03() {
        // Input: root = [1,null,3]
        // Output: [1,3]
        // Right side view: 1 (level 0), 3 (level 1)
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(3)
        );

        List<Integer> expected = Arrays.asList(1, 3);

        List<Integer> result = rightSideView(root);
        assertEquals(expected, result);
    }

    @Test
    void case04() {
        // Input: root = []
        // Output: []
        // Empty tree case
        TreeNode root = null;

        List<Integer> expected = Arrays.asList();

        List<Integer> result = rightSideView(root);
        assertEquals(expected, result);
    }

    private List<Integer> rightSideView(TreeNode root) {
        return null;
    }
}
