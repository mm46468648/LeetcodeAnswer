//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 603 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//java:连续数组
public class ContiguousArray{
    public static void main(String[] args){
        Solution solution = new ContiguousArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {
        //记录前缀和第一次出现的位置
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(0,-1); //哨兵
        int res = 0;
        int preNum = 0;
        for (int i = 0; i < nums.length; i++) {

            if(nums[i] == 0){
                preNum += -1;
            }else {
                preNum += 1;
            }

            if(hashMap.containsKey(preNum)){
                res = Math.max(res,i - hashMap.get(preNum));
            }else {
                hashMap.put(preNum,i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

