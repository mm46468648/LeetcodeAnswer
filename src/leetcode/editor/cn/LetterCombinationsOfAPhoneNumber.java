//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2215 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//java:电话号码的字母组合
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("23");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        String[] digitsArr = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};



        public List<String> letterCombinations(String digits) {
            List res = new ArrayList();
            if(digits == null || digits.length() == 0) return res;
            StringBuilder sb = new StringBuilder();
            dfs(digits.length(), res, 0, digits, sb);
            return res;
        }

        private void dfs(int len, List<String> res, int l, String digits, StringBuilder sb) {
            if (l == len) {
                res.add(sb.toString());
                return;
            }

            char c = digits.charAt(l);
            char[] chars = phoneMap.get(c).toCharArray();

            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                dfs(len, res, l + 1, digits, sb.append(aChar));
                sb.deleteCharAt(l);
            }
        }


        public List<String> letterCombinations2(String digits) {
            List res = new ArrayList();
            if(digits == null || digits.length() == 0) return res;
            dfs2(digits.length(), res, 0, digits, "");
            return res;
        }

        private void dfs2(int len, List<String> res, int l, String digits, String s) {
            if (l == len) {
                res.add(s);
                return;
            }

            Integer integer = Integer.valueOf(String.valueOf(digits.charAt(l)));
            char[] chars = digitsArr[integer].toCharArray();

            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                dfs2(len, res, l + 1, digits, s + aChar);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

