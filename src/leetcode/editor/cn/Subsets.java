//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 1891 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//java:子集
public class Subsets{
    public static void main(String[] args){
        Solution solution = new Subsets().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        Deque<Integer> path = new ArrayDeque<>();
        int len = nums.length;
        dfs(0,nums,path);
        return res;
    }

        private void dfs(int index,int[] nums, Deque<Integer> path) {
            res.add(new ArrayList<>(path));
            int len = nums.length;
            for (int i = index; i <len; i++) {
                path.addLast(nums[i]);
                dfs(i+1,nums,path);
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

