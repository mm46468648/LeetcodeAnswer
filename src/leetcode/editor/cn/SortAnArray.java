//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 760 👎 0

package leetcode.editor.cn;

import java.util.Random;

//java:排序数组
public class SortAnArray {

    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
        solution.sortArray(new int[]{5,2,3,1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final Random random = new Random(System.currentTimeMillis());

        public int[] sortArray(int[] nums) {
//            selectionSort(nums);
//            bubbleSort(nums);
//            insertionSort(nums);
//            optimizeInsertionSort(nums);
//            shellSort(nums);
//            divideAndConquerSort(nums);
            quicksor(nums);
            return nums;
        }

        /**
         * 快速排序
         * 应用最广泛的算法
         * @param nums
         */
        void quicksor(int[] nums){
            quicksor(nums,0,nums.length-1);
        }

        private void quicksor(int[] nums, int left, int right) {
            if(left >= right) return;

            int pvoitIndex = partition(nums,left,right);
            quicksor(nums,left,pvoitIndex-1);
            quicksor(nums,pvoitIndex+1,right);
        }

        private int partition(int[] nums, int left, int right) {

            int randomIndex = random.nextInt(right - left + 1) + left;
            swap(nums,left,randomIndex);
            int pvoit = nums[left];
            int j = left + 1;

            for (int i = left+1; i <= right; i++) {
                if(nums[i] <= pvoit){
                    swap(nums,i,j);
                    j++;
                }
            }
            //别忘了最后交换pvoid和j
            swap(nums,left,j-1);
            return j-1;
        }

        /**
         * 归并排序
         * @param nums
         */
        void divideAndConquerSort(int[] nums){

            int len = nums.length;
            int[] temp = new int[len];
            mergeSort(nums,temp,0,len-1);
        }

        /**
         * [left..right] 左闭右闭区间
         * @param nums
         * @param temp
         * @param left
         * @param right
         */
        private void mergeSort(int[] nums, int[] temp, int left, int right) {
            if(right - left < 16){
                insertionSort(nums,left,right);
                return;
            }
            if(left >= right) {
                return;
            }

            int mid = (left + right) / 2;
            mergeSort(nums,temp,left,mid);
            mergeSort(nums,temp,mid + 1,right);

            if(nums[mid] <= nums[mid+1]){
                return;
            }
            //数据拷贝
            for (int i = left; i <= right; i++) {
                temp[i] = nums[i];
            }

            //合并两个有序数组
            int i = left;
            int j = mid + 1;

            for (int k = left; k <= right; k++) {
                if(i == mid + 1){
                    nums[k] = temp[j];
                    j++;
                }else if(j == right + 1){
                    nums[k] = temp[i];
                    i++;
                }else if(temp[i] <= temp[j]){
                    nums[k] = temp[i];
                    i++;
                }else{
                    nums[k] = temp[j];
                    j++;
                }
            }


        }


        /**
         * 希尔排序
         */
        void shellSort(int[] nums){
            int len = nums.length;

            //分组，每次数量是上次的一半，直到1停止
            for (int delta = len/2; delta > 0; delta/=2) {
                //有多少组，比如间隔5一组，一共有5组
                for (int start = 0; start < delta; start++) {
                    //实现分组插入排序，以1为间隔的数组类比，每次间隔delta数量
                    for (int i = start + delta; i < len; i+=delta) {
                        //-1的部分替换成delta
                        int temp = nums[i];
                        int j;
                        for (j = i; j-delta >= 0; j-=delta) {
                            if(nums[j-delta] > temp){
                                //向后移动
                                nums[j] = nums[j-delta];
                            }else {
                                break;
                            }
                        }
                        //j已经走到了空出来的位置，将j赋值
                        nums[j] = temp;
                    }
                }
            }
        }

        /**
         * 优化后的插入排序
         * @param nums
         */
        void optimizeInsertionSort(int[] nums){
            int len = nums.length;

            //只需要比较n-1次
            for (int i = 1; i < len; i++) {
                //记录待比较的元素
                int temp = nums[i];
                int j;
                for (j = i; j > 0; j--) {
                    if(nums[j-1] > temp){
                        //向后移动
                        nums[j] = nums[j-1];
                    }else {
                        break;
                    }
                }
                //j已经走到了空出来的位置，将j赋值
                nums[j] = temp;
            }
        }

        /**
         * 插入排序
         * @param nums
         */
        void insertionSort(int[] nums){
            int len = nums.length;

            //只需要比较n-1次
            for (int i = 1; i < len; i++) {
                for (int j = i; j > 0; j--) {
                    if(nums[j-1] > nums[j]){
                        swap(nums,j-1,j);
                    }else {
                        break;
                    }
                }
            }
        }

        /**
         * 插入排序2
         * @param left
         * @param right
         */
        void insertionSort(int[] nums,int left,int right){
            //只需要比较n-1次
            for (int i = left; i <= right; i++) {
                //记录待比较的元素
                int temp = nums[i];
                int j;
                for (j = i; j > left; j--) {
                    if(nums[j-1] > temp){
                        //向后移动
                        nums[j] = nums[j-1];
                    }else {
                        break;
                    }
                }
                //j已经走到了空出来的位置，将j赋值
                nums[j] = temp;
            }
        }
        /**
         * 冒泡排序
         * @param nums
         */
        void bubbleSort(int[] nums){
            int len = nums.length;

            //外层循环只需要比n-1次，最后一个就不用比了
            for (int i = 0; i < len-1; i++) {
                //内存循环的规模是不断缩小的
                for (int j = 1; j < len - i; j++) {
                    if(nums[j-1] > nums[j]){
                        swap(nums,j-1,j);
                    }
                }
            }
        }
        /**
         * 选择排序
         * @param nums
         */
        void selectionSort(int[] nums) {
            int len = nums.length;

            for (int i = 0; i < len; i++) {
                int minIndex = i;
                for (int j = minIndex + 1; j < len; j++) {
                    if (nums[j] < nums[minIndex]) {
                        minIndex = j;
                    }
                }
                swap(nums, minIndex, i);
            }
        }

        /**
         * 交换两个数
         * @param nums
         * @param a
         * @param b
         */
        private void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}

