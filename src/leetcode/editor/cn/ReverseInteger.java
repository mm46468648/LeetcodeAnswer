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
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        Stack<Character> stack = new Stack<>();
        String xs = String.valueOf(x);
        char[] chars = xs.toCharArray();
        boolean fushu = chars[0] == '-';
        int startIndex = fushu?1:0;
        for (int i = startIndex; i < chars.length; i++) {
            stack.push(chars[i]);
        }

        StringBuilder sb = new StringBuilder();
        if(fushu){
            sb.append('-');
        }

        boolean startnotling = false;
        while (!stack.isEmpty()){
            Character pop = stack.pop();
            if(pop!='0'){
                startnotling = true;
                sb.append(pop);
            }

            if(startnotling && pop=='0'){
                sb.append(pop);
            }

        }

        String s = sb.toString();
        if(s.length() == 0) return 0;

        return Integer.valueOf(s);


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

