package me.dev1001.examples.leetcode;

import java.util.*;

/**
 * @author hongzong.li
 */
public class BTZigZagLevelOrder {
  private static class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
      this.val = val;
    }
  }
  public List<List<Integer>> zigZagLevelOrderTraversal(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }

    List<List<Integer>> result = new ArrayList<>();
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    boolean fromLeftToRight = true;
    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      // Be careful, we have to calculate the level size first, because the queue size is changing
      // while traversal
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode node = fromLeftToRight ? queue.pollFirst() : queue.pollLast();
        level.add(node.val);

        if (fromLeftToRight) {
          if (node.left != null) {
            queue.addLast(node.left);
          }
          if (node.right != null) {
            queue.addLast(node.right);
          }
        } else {
          if (node.right != null) {
            queue.addFirst(node.right);
          }
          if (node.left != null) {
            queue.addFirst(node.left);
          }
        }
      }
      result.add(level);
      fromLeftToRight = !fromLeftToRight;
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);
    root.left = left;
    root.right = right;
    System.out.println(new BTZigZagLevelOrder().zigZagLevelOrderTraversal(root));
  }
}
