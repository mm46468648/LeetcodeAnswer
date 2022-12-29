//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2000 👎 0

package leetcode.editor.cn;
//java:岛屿数量
public class NumberOfIslands{
    public static void main(String[] args){
        Solution solution = new NumberOfIslands().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int isLandNum = 0;

        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i][j];
                if(c == '1'){
                    isLandNum++;
                    dfs(i,j,m,n,grid);
                }
            }
        }
        return isLandNum;
    }

        private void dfs(int i, int j, int m, int n,char[][] grid) {
            //递归终止条件
            if(i < 0 || j<0 || i>=m || j>=n || grid[i][j] == '0'){
                return;
            }
            //遇到一个1,就变成0
            grid[i][j] = '0';
            dfs(i-1,j,m,n,grid);
            dfs(i+1,j,m,n,grid);
            dfs(i,j-1,m,n,grid);
            dfs(i,j+1,m,n,grid);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

