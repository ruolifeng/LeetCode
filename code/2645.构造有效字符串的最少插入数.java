/*
 * @lc app=leetcode.cn id=2645 lang=java
 *
 * [2645] 构造有效字符串的最少插入数
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int addMinimum(String word) {
        // 计算ABC的数目，统计abc的个数*3，最后减去原始拥有的字符个数
        /**
         * 1.若第一个数为a查看第二个数，若第二个数为b查看第三个数，若第三个数为c则出现一个abc
         * 2.若第一个数是b，则查看第三个数，若第三个数是c则出现一个abc
         * 3.可以使用栈的方法
         * 若入栈的元素和栈底元素可以组成abc那么就将其出栈，否则将其入栈，最终栈中留下的数字就是需要添加字符的abc的个数将这几个字符*3最后减去栈中存在的字符数
         * 如何判断入栈的c是否需要出栈呢？若在c入栈之前，前一次有出栈操作那么说明c不应该入栈
         */
        Stack<Character> stk = new Stack<>();
        // 统计abc的个数
        int countAbc = 0;
        // c是否应该入栈
        boolean isPush = true;
        stk.push(' ');
        for (int i = 0; i < word.length(); i++) {
            if ((stk.peek() == 'a' && word.charAt(i) == 'b') || (stk.peek() == 'a' && word.charAt(i) == 'c')
                    || (stk.peek() == 'b' && word.charAt(i) == 'c')) {
                countAbc++;
                if (stk.peek() == 'a' && word.charAt(i) == 'b') {
                    isPush = false;
                }
                stk.pop();
            } else {
                if (word.charAt(i) == 'c' && !isPush) {
                    isPush = true;
                } else {
                    stk.push(word.charAt(i));
                }
            }
        }
        return ((stk.size() - 1 + countAbc) * 3 - word.length());
    }
}
// @lc code=end
