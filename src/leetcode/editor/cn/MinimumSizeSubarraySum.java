//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 1471 👎 0

package leetcode.editor.cn;
//java:长度最小的子数组
public class MinimumSizeSubarraySum{
    public static void main(String[] args){
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        solution.minSubArrayLen(11,new int[]{1,2,3,4,5});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int len = nums.length;
        int[] preNum = new int[len+1];
        preNum[0] = 0;
        for (int i = 0; i < len; i++) {
            preNum[i+1] = preNum[i] + nums[i];
        }

        int min = len+1;
        //从左到右遍历选择长度最小的区间
        for (int left = 0; left < len; left++) {
            for (int right = 0; right < len; right++) {
                if(preNum[right+1] - preNum[left] >= target){
                    min=Math.min(min,right-left+1);
                }
            }
        }

        if(min == len+1){
            return 0;
        }
        return min;
    }

        public int minSubArrayLen2(int target, int[] nums) {

            int len = nums.length;
            int left = 0;
            int right = 0;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            while (right<len){
                sum+= nums[right];

                while (sum>=target){
                    min = Math.min(min,right-left+1);
                    sum-= nums[left];
                    left++;
                }
                right++;
            }
            if(min == Integer.MAX_VALUE){
                return 0;
            }
            return min;
        }

    int sum(int[] nums,int left,int right){
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum+=nums[i];
        }
        return sum;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}

