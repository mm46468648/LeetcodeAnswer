//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 268 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.structure.TreeNode;

import java.util.*;

//java:从上到下打印二叉树 III
public class CongShangDaoXiaDaYinErChaShuIiiLcof{
    public static void main(String[] args){
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
        solution.levelOrder(TreeNode.createTree(new int[]{3,9,20,6,8,15,7},0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;

        Deque<TreeNode> deque = new LinkedList();
        deque.addLast(root);

        int c = 0;
        while(!deque.isEmpty()){

            int size = deque.size();
            List<Integer> temp = new ArrayList();
            for(int i = 0;i<size;i++){
                TreeNode node = deque.removeFirst();
                temp.add(node.val);
                if(node.left != null){
                    deque.addLast(node.left);
                }

                if(node.right != null){
                    deque.addLast(node.right);
                }
            }
            if(c % 2 == 1) {
                Collections.reverse(temp);
            }
            c++;
            res.add(temp);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

