//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 数组 回溯 👍 1577 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//java:N 皇后
public class NQueens{
    public static void main(String[] args){
        Solution solution = new NQueens().new Solution();
        solution.solveNQueens(4);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//        String[] strs = new String[]{"Q","."};

        boolean[] main;     //主对角线
        boolean[] sub;     //副对角线
        boolean[] col;      //列记录
        List<List<String>> res;
        int len;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        len = n;
        this.col = new boolean[n];
        this.main = new boolean[2 * n - 1];
        this.sub = new boolean[2 * n - 1];


        Deque<Integer> queue = new ArrayDeque<>();
        dfs(0,queue);
        return res;
    }

        private void dfs(int row, Deque<Integer> path) {
            if(row == len){
                res.add(convertToCombine(len,path));
                return;
            }

            for (int i = 0; i < len; i++) {

                if(!col[i] && !main[row-i + len-1] && !sub[row+i]){
                    path.addLast(i);
                    col[i] = true;
                    main[row-i + len-1] =true;
                    sub[row+i] = true;
                    dfs(row+1,path);
                    col[i] = false;
                    main[row-i + len-1] =false;
                    sub[row+i] = false;
                    path.removeLast();
                }
            }
        }


        private List<String> convertToCombine(int len,Deque<Integer> queue) {
            StringBuilder stringBuilder;
            List<String> list = new ArrayList<>();
            for (int num : queue) {
                stringBuilder = new StringBuilder();
                for (int i = 0; i < len; i++) {
                    if(i == num){
                        stringBuilder.append("Q");
                    }else {
                        stringBuilder.append(".");
                    }
                }
                list.add(stringBuilder.toString());
            }

            return list;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}

