package me.dev1001.examples.leetcode;

/**
 * @author hongzong.li
 */
public class BalancedBinaryTree {
  private static class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  public boolean isBalanced(TreeNode root) {
   return maxDepth(root) != -1;
  }

  private int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftDepth = maxDepth(root.left);
    if (leftDepth == -1) {
      return -1;
    }

    int rightDepth = maxDepth(root.right);
    if (rightDepth == -1) {
      return -1;
    }

    return Math.abs(leftDepth - rightDepth) > 1 ? -1 :
        Math.max(leftDepth, rightDepth) + 1;
  }
}
