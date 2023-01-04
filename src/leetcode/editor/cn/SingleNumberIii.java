//给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。 
//
// 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,1,3,2,5]
//输出：[3,5]
//解释：[5, 3] 也是有效的答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1,0]
//输出：[-1,0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,1]
//输出：[1,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 除两个只出现一次的整数外，nums 中的其他数字都出现两次 
// 
//
// Related Topics 位运算 数组 👍 688 👎 0

package leetcode.editor.cn;
//java:只出现一次的数字 III
public class SingleNumberIii{
    public static void main(String[] args){
        Solution solution = new SingleNumberIii().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumber(int[] nums) {
        //获取异或值
        int a = 0;
        int b = 0;
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        //从右向左，找到异或值为1的部分，分为两组
        int div = 1;
        while ((xor & div) == 0){
            div = div << 1;
        }

        //遍历num，异或出ab
        for (int i = 0; i < nums.length; i++) {
            if((nums[i] & div) == 0){
                a = a ^ nums[i];
            }else {
                b = b ^ nums[i];
            }
        }
        return new int[]{a,b};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

