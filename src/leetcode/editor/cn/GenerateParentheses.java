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
//
// Related Topics 字符串 动态规划 回溯 👍 2987 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:括号生成
public class GenerateParentheses{
    public static void main(String[] args){
        Solution solution = new GenerateParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        int level = 0;
        dfs(res,level,n*2,"",0,0);
        return res;
    }

        private void dfs(List<String> res,int level, int n,String s, int l, int r) {
            if(l > n/2) return;
            if(r > l) return;

            if(level == n){
                res.add(s);
                return;
            }


            dfs(res,level+1,n,s+"(",l+1,r);
            dfs(res,level+1,n,s+")",l,r+1);


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

