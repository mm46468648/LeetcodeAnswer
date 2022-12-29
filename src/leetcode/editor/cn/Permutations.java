//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2326 👎 0

package leetcode.editor.cn;

import java.util.*;

//java:全排列
public class Permutations{
    public static void main(String[] args){
        Solution solution = new Permutations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len= nums.length;
        if(len == 0) return res;

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums,res,len,0,path,used);

        return res;
    }

        private void dfs(int[] nums,List<List<Integer>> res, int len, int depth, Deque<Integer> path, boolean[] used) {
            if(depth == len){
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < len; i++) {
                if(used[i]){
                    continue;
                }
                path.push(nums[i]);
                used[i] = true;
                dfs(nums,res,len,depth+1,path,used);
                used[i] = false;
                path.pop();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

