/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // 使用hashMap
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < magazine.length(); i++) {
            if ((map.get(magazine.charAt(i)) != null)) {
                int val = (Integer) map.get(magazine.charAt(i));
                val += 1;
                map.put(magazine.charAt(i), val);
            } else {
                map.put(magazine.charAt(i), 1);
            }
        }
        for (int j = 0; j < ransomNote.length(); j++) {
            if ((map.get(ransomNote.charAt(j))) == null) {
                return false;
            } else {
                int val2 = map.get(ransomNote.charAt(j));
                val2-=1;
                if (val2 <0) {
                    return false;
                }else{
                    map.put(ransomNote.charAt(j), val2);
                }
            }
        }
        return true;

    }
}
// @lc code=end
