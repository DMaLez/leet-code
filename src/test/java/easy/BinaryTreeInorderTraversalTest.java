package easy;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static easy.BinaryTreeInorderTraversal.TreeNode;

class BinaryTreeInorderTraversalTest {

    @Test
    void testInorderTraversalRecursive() {
        runAssertions(BinaryTreeInorderTraversal::inorderTraversalRecursive);
    }

    @Test
    void testInorderTraversalIterative() {
        runAssertions(BinaryTreeInorderTraversal::inorderTraversalIterative);
    }

    private void runAssertions(Function<TreeNode, List<Integer>> func) {
        TreeNode root1 = new TreeNode(1,
                null, new TreeNode(2,
                new TreeNode(3, null, null), null));
        assertEquals("[1, 3, 2]", func.apply(root1).toString());

        TreeNode root2 = null;
        assertEquals("[]", func.apply(root2).toString());

        TreeNode root3 = new TreeNode(1, null, null);
        assertEquals("[1]", func.apply(root3).toString());
    }

}