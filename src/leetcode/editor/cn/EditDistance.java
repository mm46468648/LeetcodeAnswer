//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 2748 👎 0

package leetcode.editor.cn;
//java:编辑距离
public class EditDistance{
    public static void main(String[] args){
        Solution solution = new EditDistance().new Solution();
        solution.minDistance("distance","springbok");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int minDistance4(String word1, String word2) {
            int n = word1.length();
            int m = word2.length();

            // 有一个字符串为空串
            if (n * m == 0) {
                return n + m;
            }

            // DP 数组
            int[][] D = new int[n + 1][m + 1];

            // 边界状态初始化
            for (int i = 0; i < n + 1; i++) {
                D[i][0] = i;
            }
            for (int j = 0; j < m + 1; j++) {
                D[0][j] = j;
            }

            // 计算所有 DP 值
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    int left = D[i - 1][j] + 1;
                    int down = D[i][j - 1] + 1;
                    int left_down = D[i - 1][j - 1];
                    if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                        left_down += 1;
                    }
                    D[i][j] = Math.min(left, Math.min(down, left_down));
                }
            }
            return D[n][m];
        }


    public int minDistance(String word1, String word2) {

        int l1 =word1.length();
        int l2 = word2.length();

        if(l1 * l2 == 0){
            return l1 + l2;
        }

        int[][] dp = new int[l1 + 1][l2+1];
        //初始化边界
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= l2; i++) {
            dp[0][i] = i;
        }

        //计算所有dp的值
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = 1 + Math.min(dp[i][j-1]
                            ,Math.min(dp[i-1][j],dp[i-1][j-1]));
                }
            }
        }

        return dp[l1][l2];
    }


        /**
         * 暴力递归
         * @param word1
         * @param word2
         * @return
         */
        public int minDistance2(String word1, String word2) {

            int l1 =word1.length();
            int l2 = word2.length();
            if(l1 == 0 || l2 ==0){
                return Math.max(l1,l2);
            }

            if(word1.charAt(l1-1) == word2.charAt(l2-1)){
                return minDistance(word1.substring(0,l1-1),word2.substring(0,l2-1));
            }

            return 1 + Math.min(minDistance(word1,word2.substring(0,l2-1))
                    ,Math.min(minDistance(word1.substring(0,l1-1),word2),minDistance(word1.substring(0,l1-1),word2.substring(0,l2-1))));
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}

