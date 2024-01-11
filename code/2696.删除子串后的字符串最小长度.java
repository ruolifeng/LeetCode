/*
 * @lc app=leetcode.cn id=2696 lang=java
 *
 * [2696] 删除子串后的字符串最小长度
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int minLength(String s) {

        Stack<Character> st = new Stack<>();
        st.push(' ');
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == 'B' && st.peek() == 'A') || (s.charAt(i) == 'D' && st.peek() == 'C')) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        return st.size() - 1;
    }
}
// @lc code=end
