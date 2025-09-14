package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _297_SerializeandDeserializeBinaryTreeTest extends _01_ParentTreeTest {
    class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return "";
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return null;
        }
    }

    @Test
    void case01() {
        // Test with a simple balanced tree
        //     1
        //   /   \
        //  2     3
        //       / \
        //      4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec ser = new Codec();
        Codec deser = new Codec();

        String serialized = ser.serialize(root);
        assertNotNull(serialized);

        TreeNode deserialized = deser.deserialize(serialized);
        assertTrue(areTreesEqual(root, deserialized));
    }

    @Test
    void case02() {
        // Test with null tree
        TreeNode root = null;

        Codec ser = new Codec();
        Codec deser = new Codec();

        String serialized = ser.serialize(root);
        assertNotNull(serialized);

        TreeNode deserialized = deser.deserialize(serialized);
        assertNull(deserialized);
        assertTrue(areTreesEqual(root, deserialized));
    }

    @Test
    void case03() {
        // Test with single node
        TreeNode root = new TreeNode(1);

        Codec ser = new Codec();
        Codec deser = new Codec();

        String serialized = ser.serialize(root);
        assertNotNull(serialized);

        TreeNode deserialized = deser.deserialize(serialized);
        assertTrue(areTreesEqual(root, deserialized));
    }

    @Test
    void case04() {
        // Test with left-skewed tree
        //   1
        //  /
        // 2
        ///
        //3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        Codec ser = new Codec();
        Codec deser = new Codec();

        String serialized = ser.serialize(root);
        assertNotNull(serialized);

        TreeNode deserialized = deser.deserialize(serialized);
        assertTrue(areTreesEqual(root, deserialized));
    }

    @Test
    void case05() {
        // Test with right-skewed tree
        // 1
        //  \
        //   2
        //    \
        //     3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        Codec ser = new Codec();
        Codec deser = new Codec();

        String serialized = ser.serialize(root);
        assertNotNull(serialized);

        TreeNode deserialized = deser.deserialize(serialized);
        assertTrue(areTreesEqual(root, deserialized));
    }

    @Test
    void case06() {
        // Test with complete binary tree
        //     1
        //   /   \
        //  2     3
        // / \   / \
        //4   5 6   7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Codec ser = new Codec();
        Codec deser = new Codec();

        String serialized = ser.serialize(root);
        assertNotNull(serialized);

        TreeNode deserialized = deser.deserialize(serialized);
        assertTrue(areTreesEqual(root, deserialized));
    }

    @Test
    void case07() {
        // Test with negative values
        //    -1
        //   /  \
        // -2    3
        //      /
        //    -4
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(-4);

        Codec ser = new Codec();
        Codec deser = new Codec();

        String serialized = ser.serialize(root);
        assertNotNull(serialized);

        TreeNode deserialized = deser.deserialize(serialized);
        assertTrue(areTreesEqual(root, deserialized));
    }

    @Test
    void case08() {
        // Test with asymmetric tree
        //       1
        //     /   \
        //    2     3
        //   /       \
        //  4         5
        // /           \
        //6             7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        Codec ser = new Codec();
        Codec deser = new Codec();

        String serialized = ser.serialize(root);
        assertNotNull(serialized);

        TreeNode deserialized = deser.deserialize(serialized);
        assertTrue(areTreesEqual(root, deserialized));
    }

    @Test
    void case09() {
        // Test with two nodes (left child only)
        //  1
        // /
        //2
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        Codec ser = new Codec();
        Codec deser = new Codec();

        String serialized = ser.serialize(root);
        assertNotNull(serialized);

        TreeNode deserialized = deser.deserialize(serialized);
        assertTrue(areTreesEqual(root, deserialized));
    }

    @Test
    void case10() {
        // Test with two nodes (right child only)
        // 1
        //  \
        //   2
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        Codec ser = new Codec();
        Codec deser = new Codec();

        String serialized = ser.serialize(root);
        assertNotNull(serialized);

        TreeNode deserialized = deser.deserialize(serialized);
        assertTrue(areTreesEqual(root, deserialized));
    }

    @Test
    void case11() {
        // Test multiple serialize/deserialize cycles
        //   1
        //  / \
        // 2   3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Codec codec = new Codec();

        // First cycle
        String serialized1 = codec.serialize(root);
        TreeNode deserialized1 = codec.deserialize(serialized1);

        // Second cycle
        String serialized2 = codec.serialize(deserialized1);
        TreeNode deserialized2 = codec.deserialize(serialized2);

        // All should be equal
        assertTrue(areTreesEqual(root, deserialized1));
        assertTrue(areTreesEqual(root, deserialized2));
        assertTrue(areTreesEqual(deserialized1, deserialized2));
        assertEquals(serialized1, serialized2);
    }

    @Test
    void case12() {
        // Test with large values
        TreeNode root = new TreeNode(1000000);
        root.left = new TreeNode(-1000000);
        root.right = new TreeNode(999999);

        Codec ser = new Codec();
        Codec deser = new Codec();

        String serialized = ser.serialize(root);
        assertNotNull(serialized);

        TreeNode deserialized = deser.deserialize(serialized);
        assertTrue(areTreesEqual(root, deserialized));
    }
}
