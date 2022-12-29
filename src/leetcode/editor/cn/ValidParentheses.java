//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 3650 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//java:有效的括号
public class ValidParentheses{
    public static void main(String[] args){
        Solution solution = new ValidParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {


        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();


        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];

            if(aChar=='('){
                stack.push(')');
            }else if(aChar=='['){
                stack.push(']');
            }else if(aChar=='{'){
                stack.push('}');
            }else if(stack.isEmpty() || aChar != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }

        public boolean isValid2(String s) {
            int length = s.length();
            if(length == 0) return false;

            Stack<Character> stack = new Stack<>();
            char[] chars = s.toCharArray();


            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];

                if(aChar == '(' || aChar == '['|| aChar == '{'){
                    stack.push(aChar);
                }else {
                    if(stack.isEmpty()){
                        return false;
                    }
                    Character pop = stack.pop();
                    if(aChar == ')' && pop != '('){
                        return false;
                    }else if(aChar == ']' && pop != '['){
                        return false;
                    }else if(aChar == '}' && pop != '{'){
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}

