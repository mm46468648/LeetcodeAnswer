//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 2763 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//java:爬楼梯
public class ClimbingStairs{
    public static void main(String[] args){
        Solution solution = new ClimbingStairs().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<Integer,Integer> hashMap = new HashMap<>();


        public int climbStairs(int n) {
            if(n == 1){
                return 1;
            }
            if(n == 2){
                return 2;
            }

            int res=0;
            int a = 1;
            int b = 2;
            for (int i = 3; i <= n; i++) {
                res = a + b;
                a = b;
                b = res;
            }

            return res;

        }

        public int climbStairs4(int n) {
            if(n == 1){
                return 1;
            }
            if(n == 2){
                return 2;
            }

            return climbStairs4(n-1) + climbStairs4(n-2);

        }

        public int climbStairs3(int n) {

            if(n < 2) return 1;

            int a = 1,b = 1,c = 2;
            for (int i = 2; i < n; i++) {
                a = b;
                b = c;
                c = a + b;
            }
            return c;
        }

    public int climbStairs2(int n) {

        if(n <= 1) return 1;

        Integer integer = hashMap.get(n);
        if(integer == null){
            int res = climbStairs(n-1) + climbStairs(n-2);
            hashMap.put(n,res);
        }
        return hashMap.get(n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

