//给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足： 
//
// 
// 0 <= i, j, k, l < n 
// nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
//输出：2
//解释：
//两个元组如下：
//1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1)
// + 2 = 0
//2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1)
// + 0 = 0
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length 
// n == nums2.length 
// n == nums3.length 
// n == nums4.length 
// 1 <= n <= 200 
// -2²⁸ <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2²⁸ 
// 
//
// Related Topics 数组 哈希表 👍 711 👎 0

package leetcode.editor.cn;

import java.util.*;

//java:四数相加 II
public class FourSumIi{
    public static void main(String[] args){
        Solution solution = new FourSumIi().new Solution();


        solution.fourSumCount(new int[]{1,2},new int[]{-2,-1},new int[]{-1,2},new int[]{0,2});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int sum = 0;

        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        List<int[]> arrays = new ArrayList<>();

        arrays.add(nums1);
        arrays.add(nums2);
        arrays.add(nums3);
        arrays.add(nums4);

        Deque<Integer> deque = new ArrayDeque<>();
        dfs(0,arrays,deque);
        return sum;
    }
        private void dfs(int i, List<int[]> arrays, Deque<Integer> path) {
          if(i == 4){
              int sub = sub(path);
              System.out.println(sub);
              if(sub == 0){
                  sum++;
              }
              return;
          }

            int[] ints = arrays.get(i);
            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                path.addLast(anInt);
                dfs(i+1,arrays,path);
                path.removeLast();
            }
        }

        private int sub(Deque<Integer> path) {
            int sum = 0;
            for(Integer i :path){
                sum += i;
            }
            return sum;
        }

        public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int res = 0;

            for (int a : nums1) {
                for (int b : nums2) {
                    hashMap.put(a + b, hashMap.getOrDefault(a + b, 0) + 1);
                }
            }

            for (int u : nums3) {
                for (int v : nums4) {
                    if (hashMap.containsKey(-u - v)) {
                        res += hashMap.get(-u - v);
                    }
                }
            }
            return res;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}

