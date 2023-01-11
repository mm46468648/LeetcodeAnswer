//实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xⁿ ）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// n 是一个整数 
// -104 <= xⁿ <= 104 
// 
//
// Related Topics 递归 数学 👍 1096 👎 0

package leetcode.editor.cn;
//java:Pow(x, n)
public class PowxN{
    public static void main(String[] args){
        Solution solution = new PowxN().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        return n >=0 ? quick(x,n) : 1 / quick(x,-n);
    }

    double quick(double x, int n){
        if(n == 0){
            return 1.0;
        }

        double y = quick(x,n/2);
        return n % 2 == 0? y * y : y * y * x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

