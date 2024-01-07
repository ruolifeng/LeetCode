/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
 */

// @lc code=start

import javax.swing.tree.TreeNode;

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 使用中序遍历的方法
        if (p == null && q != null)
            return false;
        if (p != null && q == null)
            return false;
        isSameTree(p.left, q.left);
        if (p.val != q.val)
            return false;
        return true;
        isSameTree(p.right, q.right);
        if (p.val != q.val)
            return false;
        return true;
    }
}
// @lc code=end
