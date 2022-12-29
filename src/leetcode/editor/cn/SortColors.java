//给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// Related Topics 数组 双指针 排序 👍 1475 👎 0

package leetcode.editor.cn;
//java:颜色分类
public class SortColors{
    public static void main(String[] args){
        Solution solution = new SortColors().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public void sortColors(int[] nums) {
            int pre = 0;
            //第一遍交换所有的0
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] == 0){
                    int temp = nums[i];
                    nums[i] = nums[pre];
                    nums[pre] = temp;
                    pre++;
                }
            }
            //第一遍交换所有的1
            for (int i = pre; i < nums.length; i++) {
                if(nums[i] == 1){
                    int temp = nums[i];
                    nums[i] = nums[pre];
                    nums[pre] = temp;
                    pre++;
                }
            }
        }

    public void sortColors2(int[] nums) {
        int n0 = 0,n1 = 0,n2=0; //每个颜色的个数

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num==0){
                n0++;
            }else if(num==1){
                n1++;
            }else {
                n2++;
            }
        }

        int cur = 0;
        for (int i = 0; i < n0; i++) {
            nums[cur++] = 0;
        }
        for (int i = 0; i < n1; i++) {
            nums[cur++] = 1;
        }
        for (int i = 0; i < n2; i++) {
            nums[cur++] = 2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

