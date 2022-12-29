//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
// 
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
//
// Related Topics 链表 双指针 👍 868 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.structure.ListNode;

//java:旋转链表
public class RotateList{
    public static void main(String[] args){
        Solution solution = new RotateList().new Solution();
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        //获取链表长度
        int len = 1;
        ListNode tail = head;
        while (tail.next!=null){
            tail = tail.next;
            len++;
        }

        k %= len;
        //构成环
        tail.next = head;

        for (int i = 0; i < len - k - 1; i++) {
            head = head.next;
        }
        ListNode newHead= head.next;
        head.next = null;
        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

