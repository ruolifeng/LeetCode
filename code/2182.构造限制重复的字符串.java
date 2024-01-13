/*
 * @lc app=leetcode.cn id=2182 lang=java
 *
 * [2182] 构造限制重复的字符串
 */

// @lc code=start
class Test02 {
    public String repeatLimitedString(String s, int repeatLimit) {
        /**
         * 贪心算法
         * 1. 统计所给字符串中所有种类的字符串的个数（使用一个数组进行记录，数组中值不是0的个数就是不同字符的个数）
         * 2. 设置两个指针从数组尾部向前遍历，如果此时出现一个数组元素值不是0那么判断此时数组元素的值是否小于limit
         * 1. 如果小于limit就将这个字符全部添加进新的字符串，更新最大字符和次大字符
         * 2. 如果大于limit就添加limit个字符，然后添加一个次大字符，更新最大字符和次大字符
         * 3. 重复上述过程，直到不存在次大字符
         */

        int maxIndex = 0; // 最大字符
        int seIndex = 0; // 次大字符
        String str2 = "";
        int[] array = new int[123]; // 存储所有字符
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) { // 初始化所有字符
            array[s.charAt(i)] = array[s.charAt(i)] + 1;
        }
        for (maxIndex = 122; maxIndex >= 0; maxIndex--) {
            if (array[maxIndex] == 0)
                continue; // 寻找最大字符
            for (seIndex = maxIndex - 1; seIndex >= 0; seIndex--) {
                if (array[seIndex] == 0)
                    continue; // 寻找次大字符
                if (array[maxIndex] <= repeatLimit) { // 如果最大字符的个数小于等于limit则添加
                    for (int i = array[maxIndex]; i > 0; i--) {
                        str.append((char) (maxIndex));
                        str2 = str.toString();
                    }
                    array[maxIndex] = 0;
                    break; // 添加完成之后更新最大和次大字符
                } else {
                    for (int i = 0; i < array[maxIndex]; i++) {
                        if (i < repeatLimit) {
                            str.append((char) (maxIndex));// 否则添加limit个字符
                            str2 = str.toString();
                        } else {
                            if (array[seIndex] == 0 && array[maxIndex] > 0) {
                                // 没有次大，重新找次大
                                while (array[seIndex] == 0) {
                                    seIndex--;
                                }
                            } else {
                                str.append((char) (seIndex)); // 添加一个次大
                                str2 = str.toString();
                                array[seIndex] -= 1;
                                array[maxIndex] -= repeatLimit;
                                i = -1;
                            }
                        }
                    }
                    array[maxIndex] = 0;
                    break;
                }
            }
            if (seIndex < 0) { // 没有次大字符
                for (int i = 0; i < array[maxIndex]; i++) {
                    if (i < repeatLimit) {
                        str.append((char) (maxIndex));// 否则添加limit个字符
                        str2 = str.toString();
                    } else {
                        break;
                    }
                }
            }
        }
        return str.toString();
    }
}
// @lc code=end
