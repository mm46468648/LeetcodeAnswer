//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 2263 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//java:柱状图中最大的矩形
public class LargestRectangleInHistogram{
    public static void main(String[] args){
        Solution solution = new LargestRectangleInHistogram().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int len = heights.length;
        //添加哨兵
        int[] newHeight = new int[len+2];
        for (int i = 0; i < len; i++) {
            newHeight[i+1] = heights[i];
        }
        len += 2;
        heights = newHeight;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]){
                //弹出栈顶元素
                Integer top = stack.removeLast();
                int topHeight = heights[top];

                //弹出栈顶元素,新的栈顶元素就是左界
                int leftIndex = stack.peekLast();
                //右界就是当前元素
                int rightIndex = i;
                int width = rightIndex - leftIndex -1;
                res = Math.max(res,width * topHeight);
            }

            stack.addLast(i);
        }

        return res;
    }

        public int largestRectangleArea2(int[] heights) {
            int res = 0;

            int len = heights.length;
            for (int i = 0; i < len; i++) {
                //寻找左边比自身大的最大边界
                int leftIndex = i;
                for (int j = i; j >= 0 ; j--) {
                    if(heights[j] >= heights[i]){
                        leftIndex = j;
                    }else {
                        break;
                    }
                }
                //寻找右边比自己大的边界
                int rightIndex = i;
                for (int j = i; j < len; j++) {
                    if(heights[j] >= heights[i]){
                        rightIndex = j;
                    }else {
                        break;
                    }
                }

                //根据左右边界最大值,以及自身高度计算矩形
                int area = (rightIndex-leftIndex+1) * heights[i];
                res = Math.max(area,res);
            }
            return res;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}

