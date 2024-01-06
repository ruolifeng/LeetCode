/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 遍历链表删除元素
        if (head == null) {
            return head;
        }
        ListNode temp = head;
        ListNode temp2 = head;
        while (temp2.next != null) {
            if (temp2.next.val != temp2.val) {
                temp.next = temp2.next;
                temp = temp2.next;
                temp2 = temp2.next;
            } else {
                temp2 = temp2.next;
                if (temp2.next == null) {
                    temp.next = null;
                    return head;
                }
            }
        }
        return head;
    }
}
// @lc code=end
