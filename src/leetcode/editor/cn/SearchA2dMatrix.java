//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 750 👎 0

package leetcode.editor.cn;
//java:搜索二维矩阵
public class SearchA2dMatrix{
    public static void main(String[] args){
        Solution solution = new SearchA2dMatrix().new Solution();
//        int[][] a = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] a = {{1},{3}};
        solution.searchMatrix(a,3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = binarySearchFirstColumn(matrix,target);

        int columnIndex = binarySearchRow(matrix[rowIndex],target);
        return matrix[rowIndex][columnIndex] == target;
    }

    int binarySearchRow(int[] row,int target){
        int low = 0,height = row.length-1;

        while (low < height){
            int mid = low + (height-low)/2;
            if(row[mid] == target){
                return mid;
            }else if(row[mid]< target){
                low = mid + 1;
            }else {
                height = mid-1;
            }
        }

        return low;
    }
        /**
         * 搜素第一列,0
         * @param matrix
         * @intparam target
         */
    int binarySearchFirstColumn(int[][] matrix,int target){
        int low = 0,height = matrix.length-1 ,ans = 0;

        while (low <=height){
            int mid = low + (height-low)/2;
            if(matrix[mid][0] <= target){
                ans = mid;
                low = mid + 1;
            }else {
                height = mid-1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

