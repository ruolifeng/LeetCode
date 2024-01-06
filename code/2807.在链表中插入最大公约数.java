/*
 * @lc app=leetcode.cn id=2807 lang=java
 *
 * [2807] 在链表中插入最大公约数
 */

// @lc code=start

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        /**
         * 思路：设置两个临时指针，一个指针指向插入节点的前一个节点，一个指针指向插入节点的后一个节点
         * 当插入之后将这两个节点交换并后移
         */
        ListNode temp = head;
        while (temp.next !=null) {
            int min = Math.min(temp.val, temp.next.val);
            int max = Math.max(temp.val, temp.next.val);
            int b = max%min;
            while (b != 0) {
                max = min;
                min = b;
                b = max%min;
            }
            temp.next = new ListNode(min,temp.next);
            temp = temp.next.next;
        }
        return head;
    }
}
// @lc code=end

