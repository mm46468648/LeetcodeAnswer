//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// Related Topics 栈 递归 链表 双指针 👍 1103 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.structure.ListNode;

//java:重排链表
public class ReorderList{
    public static void main(String[] args){
        Solution solution = new ReorderList().new Solution();
        solution.reorderList(new ListNode(new int[]{1,2,3,4}));
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
    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode reverse = reverse(mid);

        merge(head,reverse);
    }

    ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;

        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    ListNode merge(ListNode left,ListNode right){
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;

        int pos = 0;
        while (left!=null && right!=null){
            if(pos % 2 == 0){
                cur.next = left;
                left = left.next;
            }else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
            pos++;
        }

        if(left==null){
            cur.next = right;
        }

        if(right == null){
            cur.next = left;
        }
        return pre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

