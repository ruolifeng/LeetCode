/*
 * @lc app=leetcode.cn id=2744 lang=java
 *
 * [2744] 最大字符串配对数目
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int num = 0;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<words.length;i++){
            num = words[i].charAt(0)*10 - words[i].charAt(1)*99;
            if ((map.getOrDefault((words[i].charAt(1)*10 - words[i].charAt(0)*99), 0) == 1)) {
                count ++;
            }else{
                map.put(num, 1);
            }
        }
        return count;
    }
}
// @lc code=end
