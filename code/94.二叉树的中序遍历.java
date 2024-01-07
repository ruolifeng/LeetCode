/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 二叉树的中序遍历，左根右，递归遍历
        List<Integer> list = new LinkedList<>();
        OrderList(root, list);
        return list;
    }
    public void OrderList(TreeNode node,List<Integer> list){
        if (node == null) return;
        OrderList(node.left, list);
        list.add(node.val);
        OrderList(node.right, list);
    }
}
// @lc code=end

