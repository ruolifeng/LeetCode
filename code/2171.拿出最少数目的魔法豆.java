/*
 * @lc app=leetcode.cn id=2171 lang=java
 *
 * [2171] 拿出最少数目的魔法豆
 */

// @lc code=start

import java.math.BigInteger;
import java.util.Arrays;

class Solution {
    public long minimumRemoval(int[] beans) {
        /**
         * 思路：
         * 1. 升序排序所有的口袋中的豆子数目
         * 2. 枚举每一个袋子中的豆子，将其作为最终的豆子数目
         * 1. 如果这个豆子前面有豆子，那么这些豆子的数目只能是0
         * 2. 后面的豆子的数目只能减少到目标豆子的数目
         * 3. 最终将前面减少的豆子数目和后面减少的豆子数目相加最终取最小值
         * 变量：
         * int minNum;//保存最小的豆子
         * int index;//目前的豆子
         * 
         */
        long[] array2 = new long[beans.length];// 保存需要减少的最小豆子数目
        long[][] array = new long[beans.length][2];
        long allNum = 0;
        // 先计算前缀和，再计算后缀和
        // Arrays.sort(beans);
        // for (int i = 0; i < beans.length; i++) {
        // for (int j = i; j < beans.length; j++) {
        // // 将i前面的所有豆子相加，既然之前已经相加过，那么后面将不用再相加
        // if (j > i)
        // aftNum += beans[j] - beans[i];
        // if (j - 1 >= 0 && j == i)
        // preNum += beans[j - 1];
        // }
        // minNum = Math.min(preNum+aftNum, minNum);
        // aftNum = 0;
        // }
        // return minNum;
        Arrays.sort(beans);
        for (long i = 0; i < beans.length; i++)
            allNum += beans[(int) i];
        for (long j = 0; j < beans.length; j++) {
            // 前缀
            if (j > 0)
                array[(int) j][0] = beans[(int) j - 1] + array[(int) j - 1][0];
            // 后缀
            array[(int) j][1] = allNum - array[(int) j][0] - beans[(int) j];
        }
        for (long h = 0; h < beans.length; h++) {
            // 前缀加(后缀)-(当前豆子*后缀个数)
            array2[(int) h] = array[(int) h][0] + (array[(int) h][1] - beans[(int) h] * (beans.length - h - 1));
        }
        Arrays.sort(array2);
        return array2[0];
    }
}
// @lc code=end
