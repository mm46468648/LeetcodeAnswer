//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2498 👎 0

package leetcode.editor.cn;

import java.util.*;

//java:括号生成
public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {

            List<String> strList = new ArrayList<>();
            String cur = "";
//            dfs(cur,n,strList);
            dfs2(cur,0,0,n,strList);

//            strList.removeIf(next -> !check(next));
            return strList;
        }
        void dfs(String s,int n,List<String> list){
            if(s.length() == 2*n){
                list.add(s);
                return;
            }

            dfs(s+"(",n,list);
            dfs(s+")",n,list);
        }

        void dfs2(String s,int left,int right,int n,List<String> list){
            if(left == n && right == n){
                list.add(s);
                return;
            }

            if(right > left){
                return;
            }

            if(left<n){
                dfs2(s+"(",left+1,right,n,list);
            }

            if(right<n){
                dfs2(s+")",left,right+1,n,list);
            }
        }

        boolean check(String s) {
            int leftNum = 0;
            int rightNum = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '('){
                    leftNum++;
                }else {
                    rightNum++;
                }

                if(rightNum>leftNum){
                    return false;
                }
            }
            return rightNum == leftNum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

