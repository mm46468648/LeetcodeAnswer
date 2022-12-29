//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1246 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//java:全排列 II
public class PermutationsIi{
    public static void main(String[] args){
        Solution solution = new PermutationsIi().new Solution();
        solution.permuteUnique(new int[]{1,1,2});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len == 0) return res;

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] uses = new boolean[len];
        dfs(len,nums,res,0,path,uses);
        return res;
    }

        private void dfs(int len,int[] nums, List<List<Integer>> res, int depth, Deque<Integer> path, boolean[] uses) {
            if(depth == len) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < len; i++) {
                if(uses[i] || i>0 && nums[i] == nums[i-1] && !uses[i-1]){
                    continue;
                }
                uses[i] = true;
                path.addLast(nums[i]);
                dfs(len,nums,res,depth+1,path,uses);
                path.removeLast();
                uses[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

