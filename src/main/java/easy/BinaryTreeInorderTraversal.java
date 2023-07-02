package easy;

import java.util.*;

public class BinaryTreeInorderTraversal {

    protected static class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    /**
     * Runtime 0 ms Beats 100%
     * Memory 40.6 MB Beats 86.68%
     */
    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        inorderTraversalHelper(root, result);
        return result;
    }

    private static void inorderTraversalHelper(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorderTraversalHelper(node.left, list);
        list.add(node.val);
        inorderTraversalHelper(node.right, list);
    }

    /**
     * Runtime 0 ms Beats 100%
     * Memory 41.2 MB Beats 13.31%
     */
    public static List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> dfsStack = new Stack<>();
        TreeNode currentNode = root;

        while (currentNode != null || !dfsStack.isEmpty()) {
            while (currentNode != null) {
                dfsStack.add(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = dfsStack.pop();
            result.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return result;
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

}
