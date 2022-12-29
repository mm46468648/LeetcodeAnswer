//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 4001 👎 0

package leetcode.editor.cn;
//java:接雨水
public class TrappingRainWater{
    public static void main(String[] args){
        Solution solution = new TrappingRainWater().new Solution();
        solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {

        int anr = 0;
        int len = height.length;
        int maxLeft = 0;
        int maxRight = 0;
        int left = 0;
        int right = len-1;

        while (left<right){
            maxLeft = Math.max(maxLeft,height[left]);
            maxRight = Math.max(maxRight,height[right]);

            if(maxLeft<maxRight){
                anr = anr + maxLeft-height[left];
                left++;
            }else {
                anr = anr + maxRight-height[right];
                right--;
            }
        }

        return anr;
    }
        public int trap4(int[] height) {

            int anr = 0;
            int len = height.length;

            int[] maxLeft = new int[len];
            int[] maxRight = new int[len];

            maxLeft[0] = 0;
            for (int i = 1; i < len; i++) {
                maxLeft[i] = Math.max(maxLeft[i-1],height[i-1]);
            }

            maxRight[len-1] = 0;
            for (int i = len-2; i >=0; i--) {
                maxRight[i] = Math.max(maxRight[i+1],height[i+1]);
            }

            for (int i = 0; i < len; i++) {

                int min = Math.min(maxLeft[i],maxRight[i]);

                if(min>height[i]){
                    anr =anr + (min- height[i]);
                }

            }
            return anr;
        }

        public int trap3(int[] height) {

            int anr = 0;

            for (int i = 0; i < height.length; i++) {

                //找到左边最高的墙
                int maxLeft = 0;
                for (int j = 0; j < i; j++) {
                    maxLeft = Math.max(maxLeft,height[j]);
                }

                int maxRight = 0;
                //找到右边最高的墙
                for (int j = i+1; j < height.length; j++) {
                    maxRight = Math.max(maxRight,height[j]);
                }

                int min = Math.min(maxLeft,maxRight);

                if(min>height[i]){
                    anr =anr + (min- height[i]);
                }

            }
            return anr;
        }

        public int trap2(int[] height) {
            int maxHeight = 0;
            int len = height.length;

            for (int i = 0; i < len; i++) {
                maxHeight = Math.max(maxHeight,height[i]);
            }

            int anr = 0;

            for (int i = 1; i <= maxHeight; i++) {
                boolean start = false;
                int temp = 0;
                for (int j = 0; j < len; j++) {

                    if (start && height[j] < i) {
                        temp++;
                    }
                    if (height[j] >= i) {
                        anr = anr + temp;
                        temp = 0;
                        start = true;
                    }

                }
            }
            return anr;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}

