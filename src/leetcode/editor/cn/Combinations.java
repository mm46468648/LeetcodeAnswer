//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics 回溯 👍 1250 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//java:组合
public class Combinations{

    public static void main(String[] args){
        Solution solution = new Combinations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[n+1];
        dfs(1,n,k,path,used);
        return res;
    }

    void dfs(int cur, int n, int k, Deque<Integer> path,boolean[] used){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = cur; i <= n; i++) {
//            if(!used[i]){
//                used[i] = true;
                path.addLast(i);
                dfs(i+1,n,k,path,used);
                path.removeLast();
//                used[i] = false;
//            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

