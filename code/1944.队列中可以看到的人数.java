/*
 * @lc app=leetcode.cn id=1944 lang=java
 *
 * [1944] 队列中可以看到的人数
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int len = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] an = new int[len];
        // 逆序遍历数组
        for (int i = len - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] > st.peek()) {
                an[i]++;
                st.pop();
            }
            if (!st.isEmpty())
                an[i]++;
            st.push(heights[i]);
        }
        return an;
    }
}
// @lc code=end
