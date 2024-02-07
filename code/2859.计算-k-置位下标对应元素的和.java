/*
 * @lc app=leetcode.cn id=2859 lang=java
 *
 * [2859] 计算 K 置位下标对应元素的和
 */

// @lc code=start

import java.util.List;

class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        // 通过枚举的方式将每一个数字的下表中存在的置位数都存入一个新的数组中，最后统计哪一个下标满足条件
        // 枚举
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (Integer.bitCount(i) == k) {
                count += nums.get(i);
            }
        }
        return count;
    }
}
// @lc code=end
