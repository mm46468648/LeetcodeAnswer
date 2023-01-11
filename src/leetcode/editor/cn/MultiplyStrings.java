//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
//
// Related Topics 数学 字符串 模拟 👍 1118 👎 0

package leetcode.editor.cn;
//java:字符串相乘
public class MultiplyStrings{
    public static void main(String[] args){
        Solution solution = new MultiplyStrings().new Solution();
        solution.multiply("123","456");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        //如果其中一个为0，结果为0
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();

        //从个位数，遍历num2的每一个字符（比如题解中的5，6，7）
        for (int i = n-1; i>=0; i--) {
            //用于保存每次 num2中的单个字符 乘以 num1的结果
            StringBuffer sb = new StringBuffer();
            //拼接0，比如10位数字（6）乘以num1后的结果，要拼接1个0，百位拼接两个。。
            for (int j = n-1; j >i; j--) {
                sb.append(0);
            }

            //表示进位的数字，待会会用到
            int add = 0;
            //这是一个字符转换为数字的小技巧
            int y = num2.charAt(i) - '0';
            //也是从个位数遍历，分别与num1中的字符相乘
            for (int j = m-1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                //两数相乘 + 进位的结果
                int product = x * y + add;
                //拼接个位
                sb.append(product % 10);
                //保留进位
                add = product / 10;
            }

            //最后一位的进位
            if(add!=0){
                sb.append(add%10);
            }
            //由于我们拼接的时候是先拼接个位再拼接十位的，计算的时候要倒过来
            ans = addStrings(ans,sb.reverse().toString());
        }
        return ans;


    }

        /**
         * 整数相加。不了解做一下Leetcode415. 字符串相加
         */
        public String addStrings(String num1, String num2) {
            int i = num1.length() - 1, j = num2.length() - 1, add = 0;
            StringBuffer ans = new StringBuffer();
            while (i >= 0 || j >= 0 || add != 0) {
                int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                int result = x + y + add;
                ans.append(result % 10);
                add = result / 10;
                i--;
                j--;
            }
            ans.reverse();
            return ans.toString();
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}

