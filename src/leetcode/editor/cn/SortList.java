//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 1859 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.structure.ListNode;

//java:排序链表
public class SortList{
    public static void main(String[] args){
        Solution solution = new SortList().new Solution();

        solution.sortList(new ListNode(new int[]{4,2,1,3}));
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
    public ListNode sortList(ListNode head) {
        if(head ==null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left,right);
    }

    public ListNode merge(ListNode left,ListNode right){
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        while (left!=null && right!=null){
            if(left.val <= right.val){
                cur.next = left;
                left = left.next;
            }else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        if(left==null){
            cur.next = right;
        }

        if(right==null){
            cur.next = left;
        }
        return pre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

