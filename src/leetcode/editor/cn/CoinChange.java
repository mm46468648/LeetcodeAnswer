//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2271 👎 0

package leetcode.editor.cn;
//java:零钱兑换
public class CoinChange{
    public static void main(String[] args){
        Solution solution = new CoinChange().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int res = Integer.MAX_VALUE;
        int[] memo;
    public int coinChange(int[] coins, int amount) {

        if(coins.length == 0) return -1;

        //1.暴力搜索
//        findWay(coins,amount,0);
//
//        if(res == Integer.MAX_VALUE){
//            return -1;
//        }
//        return res;

//    2.记忆化搜索
//        memo = new int[amount];
//        return  memorySearch(coins,amount);

        //3。动态规划
        return  dp(coins,amount);
    }

        /**
         * 动态规划
         * @param coins
         * @param amount
         * @return
         */
    int dp(int[] coins,  int amount){
        // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] memo = new int[amount+1];
        memo[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0 && memo[i-coins[j]] < min){
                    min = memo[i-coins[j]] + 1;
                }
            }
            memo[i] = min;
        }

        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }



        /**
         *记忆化搜索
         * @param coins 硬币面值
         */
        private int memorySearch(int[] coins,  int amount) {
            if(amount < 0){
                return -1;
            }

            if(amount == 0){
                return 0;
            }

            if(memo[amount-1] != 0){
                return memo[amount-1];
            }

            int min = Integer.MAX_VALUE;

            for (int i = 0; i < coins.length; i++) {
                int res = memorySearch(coins,amount-coins[i]);
                if(res >= 0 && res < min){
                    min = res + 1;
                }
            }

            memo[amount-1] = min == Integer.MAX_VALUE ? -1 :min;
            return memo[amount-1];
        }

        /**
         *
         * @param coins 硬币面值
         * @param rem 剩余零钱钱数
         * @param count 需要零钱数量
         */
        private void findWay(int[] coins, int rem, int count) {
            if(rem < 0){
                return;
            }

            if(rem == 0){
                res = Math.min(res,count);
            }

            for (int i = 0; i < coins.length; i++) {
                findWay(coins,rem-coins[i],count+1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

