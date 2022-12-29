//从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
//可以看成任意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 
//输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// Related Topics 数组 排序 👍 227 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//java:扑克牌中的顺子
public class BuKePaiZhongDeShunZiLcof{
    public static void main(String[] args){
        Solution solution = new BuKePaiZhongDeShunZiLcof().new Solution();
        solution.isStraight(new int[]{0,0,8,5,3});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean isStraight(int[] nums) {
            int diff = 0;
            int zeroCount = 0;
            int start = 0;

            Arrays.sort(nums);
            for(int i=0;i<nums.length;i++){
                int n = nums[i];

                if(n == 0){
                    zeroCount++;
                }else if(n == start){
                    return false;
                }

                diff = Math.max(n - start,diff);
                start = n;
            }

            return zeroCount>= diff-1;

        }
}
//leetcode submit region end(Prohibit modification and deletion)

}

