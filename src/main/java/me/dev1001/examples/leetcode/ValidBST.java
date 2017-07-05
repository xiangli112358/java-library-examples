package me.dev1001.examples.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hongzong.li
 */
public class ValidBST {
  private static class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  public boolean validBST(TreeNode root) {
    return validateHelper(root, Integer.MIN_VALUE - 1L, Integer.MAX_VALUE + 1L);
  }

  private boolean validateHelper(TreeNode root, long min, long max) {
    if (root == null) {
      return true;
    }

    if (root.val <= min || root.val >= max) {
      return false;
    }

    return validateHelper(root.left, min, Math.min(max, root.val)) &&
        validateHelper(root.right, Math.max(min, root.val), max);
  }

  public boolean validBSTUsingTraversal(TreeNode root) {
    if (root == null) {
      return true;
    }

    List<Integer> ordered = new ArrayList<>();
    inOrderTraversal(root, ordered);
    for (int i = 1; i < ordered.size(); i++) {
      if (ordered.get(i) <= ordered.get(i - 1)) {
        return false;
      }
    }
    return true;
  }

  private void inOrderTraversal(TreeNode root, List<Integer> ordered) {
    if (root.left != null) {
      inOrderTraversal(root.left, ordered);
    }
    ordered.add(root.val);
    if (root.right != null) {
      inOrderTraversal(root.right, ordered);
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(1);
    root.left = left;

    System.out.println(new ValidBST().validBSTUsingTraversal(root));
  }
}
