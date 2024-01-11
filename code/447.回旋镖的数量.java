/*
 * @lc app=leetcode.cn id=447 lang=java
 *
 * [447] 回旋镖的数量
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        // 暴力枚举法
        // 循环遍历数组，将其中的每一个值当做回旋镖的拐角部分，然后计算其他点到这个点的距离
        // 从相同距离的点中选出两个点作为回旋镖的其余两个点，由于需要考虑顺序，所以可以使用排列组合的方式
        // Am2，计算 = m*(m-1)
        int ans = 0;
        for (int[] p : points) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int[] q : points) {
                // 计算每一个点到其余各点的距离
                int dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            // 从第一个点开始选择
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int m = entry.getValue();
                ans += m * (m - 1);
            }
        }
        return ans;
    }
}
// @lc code=end
