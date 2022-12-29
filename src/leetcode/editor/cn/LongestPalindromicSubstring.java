//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 5958 👎 0

package leetcode.editor.cn;
//java:最长回文子串
public class LongestPalindromicSubstring{
    public static void main(String[] args){
        Solution solution = new LongestPalindromicSubstring().new Solution();
        solution.longestPalindrome("a");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {

        int length = s.length();

        if(length == 0) return "";
        //dp表示 从i到j是否是回文子串
        boolean[][] dp = new boolean[length][length];

        //初始化dp数组
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();

        int max = 1;
        int begin = 0;
        //寻找左界和右界
        for (int i = length-1; i >= 0 ; i--) {
            for (int j = i+1; j < length; j++) {

                int l = j - i + 1;
                //两个字母相等
                if(chars[i] == chars[j]){
                    if(l==2){
                        dp[i][j] = true;
                    }else {
                        //取决于中间是不是
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else {
                    //不等一定不是
                    dp[i][j] = false;
                }

                //更新最长子串长度
                if(dp[i][j] && l > max){
                    max = l;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

