/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */

// @lc code=start

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Stack<Integer> ak = new Stack<>();
        InfixOrder(ak, root);
        if (ak.size() == 1)
            return true;
        return false;
    }

    public void InfixOrder(Stack<Integer> ak, TreeNode node) {
        if (node == null)
            return;
        InfixOrder(ak, node.left);
        if (ak.isEmpty() || ak.peek() != node.val)
            ak.push(node.val);
        ak.pop();
        InfixOrder(ak, node.right);
    }
}
// @lc code=end
