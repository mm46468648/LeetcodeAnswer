//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。 
//
// 返回 你可以获得的最大乘积 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 
//
// 提示: 
//
// 
// 2 <= n <= 58 
// 
//
// Related Topics 数学 动态规划 👍 992 👎 0

package leetcode.editor.cn;
//java:整数拆分
public class IntegerBreak{
    public static void main(String[] args){
        Solution solution = new IntegerBreak().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {
        if(n < 4) return n - 1;

        int res = 1;

        while (n >= 3){

            if(n == 4){
                res = res * 4;
                break;
            }

            n = n-3;
            res = res * 3;

        }

        if(n == 2){
            res = res * 2;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

