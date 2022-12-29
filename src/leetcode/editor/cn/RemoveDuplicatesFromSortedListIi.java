//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics 链表 双指针 👍 1034 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.structure.ListNode;

//java:删除排序链表中的重复元素 II
public class RemoveDuplicatesFromSortedListIi{
    public static void main(String[] args){
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next!=null && cur.next.next!=null){
            if(cur.next.val == cur.next.next.val){
                //如果下一个和下下个相等,寻找最后一个相等的结点
                ListNode tail = cur.next;
                while (tail.next!=null && tail.next.val == cur.next.val){
                    tail = tail.next;
                }
                cur.next = tail.next;
            }else {
                cur = cur.next;
            }

        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

