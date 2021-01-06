package leetcode.template.BinSearch;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/4 11:28
 * n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n
 * 输入: [1,3,4,2,2]
 * 输出: 2
 *
 *  [1,4,3,2,5]
 *
 *  // 1,2,3,4,5
 *  // 1,2,3,4,5
 *
 *  // [1,5,3,4,3,2]
 *  // 1,2,3,4,5
 *  // 1,2,4,5,6
 *
 *   *  // [1,4,3,5,2,2]
 *  *  // 1,2,3,4,5
 *  *  // 1,3,4,5,6
 */
public class Q287_FindDuplicate {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right) {
            // 在 Java 里可以这么用，当 left + right 溢出的时候，无符号右移保证结果依然正确
            int mid = (left + right) >>> 1;


            // 1,3,4,2,2
            // 1,2,3,4,5
            // 1,3,4,5,6

            // 1,3,4,2,5
            // 1,2,3,4,5
            // 1,2,3,4,5
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }

            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
            // 此时重复元素一定出现在 [1, 4] 区间里
            if (cnt > mid) {
                // 重复元素位于区间 [left, mid]
                right = mid;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面
                // [mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }
}
