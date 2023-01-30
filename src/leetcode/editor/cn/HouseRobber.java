//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// Related Topics 数组 动态规划 👍 2371 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

//java:打家劫舍
public class HouseRobber {
    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
        solution.rob(new int[]{1,2,3,1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 双指针循环计数
         * @param nums
         * @return
         */
        public int rob(int[] nums) {
            int n = nums.length;

            int a = 0;
            int b = nums[0];

            for (int i = 2; i <= n; i++) {
                int temp = b;
                b = Math.max(b, a + nums[i - 1]);
                a = temp;
            }
            return b;
        }

        /**
         * 记忆化搜索
         * @param nums
         * @return
         */
        public int rob3(int[] nums) {
            int n = nums.length;
            //递推
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = nums[0];

            for (int i = 2; i <= n; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
            }
            return dp[n];
        }

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        public int rob2(int[] nums) {

            return rob2(nums,nums.length);
        }


        /**
         * 记忆化搜索
         * @param nums
         * @param n
         * @return
         */
        int rob2(int[] nums,int n){
            if(n == 0) return 0;
            if(n == 1) return nums[0];

            if(hashMap.get(n) == null){
                int max = Math.max(rob2(nums,n-1),rob2(nums,n-2) + nums[n-1]);
                hashMap.put(n,max);
            }
            return hashMap.get(n);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}

