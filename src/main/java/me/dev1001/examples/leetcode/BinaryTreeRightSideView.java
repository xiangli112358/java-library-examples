package me.dev1001.examples.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hongzong.li
 */
public class BinaryTreeRightSideView {
  private static class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }

    List<Integer> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.poll();
        if (i == levelSize - 1) {
          result.add(node.val);
        }

        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
    }
    return result;
  }
}
