//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 1872 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.structure.ListNode;

//java:K 个一组翻转链表
public class ReverseNodesInKGroup{
    public static void main(String[] args){
        Solution solution = new ReverseNodesInKGroup().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        //定义翻转链表的头结点
        ListNode pre = dummy;
        //定义翻转链表的尾结点
        ListNode end = dummy;

        //end next为空代表走到了终点
        while (end.next!=null){

            //寻找要翻转的尾结点
            for (int i = 0; i < k && end!=null; i++) {
                end = end.next;
            }
            //如果head==null代表不足k整数倍
            if(end == null) break;

            ListNode start = pre.next;
            ListNode next = end.next;
            //断链
            end.next = null;
            //翻转
            pre.next = reverse(start);
            //再链接
            start.next = next;
            //移动节点到下一个区间
            pre = start;
            end = pre;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode start) {
        ListNode pre = null;
        ListNode cur = start;

        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

