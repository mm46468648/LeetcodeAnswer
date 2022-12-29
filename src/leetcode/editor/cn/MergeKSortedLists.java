//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2259 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.structure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.ToIntFunction;

//java:合并K个升序链表
public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();

        ListNode[] nodes = new ListNode[3];
        int[] i1 = new int[]{1, 4, 5};
        int[] i2 = new int[]{1, 3, 4};
        int[] i3 = new int[]{2, 6};
        nodes[0] = makeList(i1);
        nodes[1] = makeList(i2);
        nodes[2] = makeList(i3);
        solution.mergeKLists(nodes);
    }

    static ListNode makeList(int[] arr) {
        ListNode pre = new ListNode(-1);
        ListNode head = pre;

        for (int i = 0; i < arr.length; i++) {
            ListNode l = new ListNode(arr[i]);
            head.next = l;
            head = head.next;
        }
        return pre.next;
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            int len = lists.length;
            if (len == 0) return null;

            ListNode dummy = new ListNode(-1);
            ListNode head = dummy;
            //创建一个优先级队列
            PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(len, (o1, o2) -> o1.val - o2.val);

            //将链表入队

            for (int i = 0; i < len; i++) {
                ListNode list = lists[i];
                if (list != null)
                    priorityQueue.offer(list);
            }

            //依次从队列中取出
            while (!priorityQueue.isEmpty()) {
                ListNode poll = priorityQueue.poll();
                ListNode next = poll.next;
                head.next = poll;
                head = head.next;

                if (next != null) {
                    priorityQueue.offer(next);
                }
            }
            return dummy.next;
        }

        public ListNode mergeKLists2(ListNode[] lists) {
            int len = lists.length;
            if (len == 0) return null;

            ListNode pre = new ListNode(-1);
            ListNode head = pre;

            PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(len, new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });

            for (int i = 0; i < lists.length; i++) {
                ListNode list = lists[i];
                if (list != null) {
                    priorityQueue.offer(list);
                }
            }

            while (!priorityQueue.isEmpty()) {

                ListNode top = priorityQueue.poll();
                ListNode next = top.next;
                head.next = top;
                head = head.next;

                if (next != null) {
                    priorityQueue.offer(next);
                }
            }
            return pre.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

