//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 3734 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//java:整数反转
public class ReverseInteger{
    public static void main(String[] args){
        Solution solution = new ReverseInteger().new Solution();
        solution.reverse(-1234);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x!=0){
            //取末尾数字
            int temp = x % 10;
            //判断是否整形溢出
            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10){
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10){
                return 0;
            }
            x = x / 10;
            res = res * 10 + temp;

        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

