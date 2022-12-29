//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 1 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 1433 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//java:最大矩形
public class MaximalRectangle{
    public static void main(String[] args){
        Solution solution = new MaximalRectangle().new Solution();
        char[] area1 = new char[]{'0','1'};
        char[] area2 = new char[]{'1','0'};
        char[][] chat = new char[2][2];
        chat[0] = area1;
        chat[1] = area2;

        solution.maximalRectangle(chat);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int res = 0;
        //1.先填表
        int[][] dp = new int[row][col];
        //2.再根据每一行计算最大矩形
        for (int i = 0; i < row; i++) {
            char[] matrix1 = matrix[i];
            for (int j = 0; j < matrix1.length; j++) {
                if(i == 0){
                    if(matrix1[j] == '0'){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = 1;
                    }
                }else {
                    if(matrix1[j] == '0'){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = dp[i-1][j] + 1;
                    }
                }

            }
        }

        //计算每一行的最大矩形高度
        for (int i = 0; i < dp.length; i++) {
            int temp = largestRectangleArea(dp[i]);
            res = Math.max(res,temp);
        }
        return res;
    }

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
}
//leetcode submit region end(Prohibit modification and deletion)

}

