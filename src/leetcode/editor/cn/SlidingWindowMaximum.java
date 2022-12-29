//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2034 👎 0

package leetcode.editor.cn;

import java.util.*;

//java:滑动窗口最大值
public class SlidingWindowMaximum{
    public static void main(String[] args){
        Solution solution = new SlidingWindowMaximum().new Solution();
        solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int leftIndex = 0;
        int rightIndex = 0;
        int[] res = new int[len - k + 1];

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < len; i++) {

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            //超出边界的要移除
            if (deque.peek() <= i - k){
                deque.poll();
            }

            if(i+1 >= k){
                res[i+1-k] = nums[deque.peek()];
            }
        }
        return res;
    }

        public int[] maxSlidingWindow2(int[] nums, int k) {
            int len = nums.length;
            int leftIndex = 0;
            int rightIndex = 0;
            int[] res = new int[len - k + 1];

            while (rightIndex<len){

                if (rightIndex- leftIndex + 1 == k){
                    int[] tempNums = new int[k];
                    tempNums = Arrays.copyOfRange(nums,leftIndex,rightIndex+1);
                    int max = maxArea(tempNums);
                    res[leftIndex] = max;
                    leftIndex++;
                }
                rightIndex++;

            }
            return res;
        }

    int maxArea(int[] area){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < area.length; i++) {
            max = Math.max(max,area[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

