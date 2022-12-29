//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
//
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 780 👎 0

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

//java:数据流的中位数
public class FindMedianFromDataStream {
    public static void main(String[] args) {
//        Solution solution = new FindMedianFromDataStream().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {

        int count;
        PriorityQueue maxHeap;
        PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            count = 0;
            maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });

            minHeap = new PriorityQueue<>();

        }

        public void addNum(int num) {
            count++;
            maxHeap.offer(num);
            minHeap.offer((Integer) maxHeap.poll());
            if((count & 1) != 0){
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if((count & 1) == 0){ //偶数
                return  ((Integer)maxHeap.peek() + (Integer) minHeap.peek())/2;
            }else {
                return  (Integer)maxHeap.peek();
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}

