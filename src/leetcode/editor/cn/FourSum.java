//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 1456 👎 0

package leetcode.editor.cn;

import java.util.*;

//java:四数之和
public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
//        solution.fourSum(new int[]{1,0,-1,0,-2,2},0);
        solution.fourSum(new int[]{0, 0, 0, 1000000000}, 1000000000);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> list = new ArrayList<>();
        long cur = 0;
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            dfs(nums, target, 0);
            return ans;
        }

        void dfs(int[] nums, int target, int begin) {
            if (list.size() == 4) {
                if (cur == target) {
                    ans.add(new ArrayList<>(list));
                }
                return;
            }

            for (int i = begin; i < nums.length; i++) {
                if (nums.length - i < 4 - list.size()) return;
                if (begin != i && nums[i - 1] == nums[i]) continue;
                if (i < nums.length - 1 && cur + nums[i] + (long) (3 - list.size()) * nums[i + 1] > target) return;
                if (i < nums.length - 1 && cur + nums[i] + (long) (3 - list.size()) * nums[nums.length - 1] < target)
                    continue;
                cur += nums[i];
                list.add(nums[i]);
                dfs(nums, target, i + 1);
                list.remove(list.size() - 1);
                cur -= nums[i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

