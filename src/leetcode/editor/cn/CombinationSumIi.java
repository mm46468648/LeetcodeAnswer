//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics 数组 回溯 👍 1181 👎 0

package leetcode.editor.cn;

import java.util.*;

//java:组合总和 II
public class CombinationSumIi{
    public static void main(String[] args){
        Solution solution = new CombinationSumIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs(0,candidates.length,candidates,target,res,path);
        return res;
    }

        private void dfs(int begin,int len,int[] candidates, int target, List<List<Integer>> res, Deque<Integer> path) {
//            if(target < 0) return;

            if(target ==0){
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = begin; i < len; i++) {

                int candidate = candidates[i];
                //大剪枝
                if(target - candidate < 0){
                    break;
                }

                //小剪枝,当前层,和上一个一样
                if(i > begin && candidates[i] == candidates[i-1]){
                    continue;
                }
                path.addLast(candidate);
                System.out.println("  递归之前 => " + path);
                dfs(i+1,len,candidates,target-candidate,res,path);
                path.removeLast();
                System.out.println("  递归之后 => " + path);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

