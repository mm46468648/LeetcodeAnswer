//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 954 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//java:二叉树的后序遍历
public class BinaryTreePostorderTraversal{
    public static void main(String[] args){
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        //记录是否访问过此节点
        TreeNode prev = null;
        while (!stack.isEmpty() || root!=null){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            //如果右子节点为空或者访问过,就访问此节点
            if(root.right == null || root.right == prev){
                list.add(root.val);
                prev = root;
                root = null;
            }else {
                //不为空,根节点重新入栈
                stack.push(root);
                root = root.right;
            }

        }
        return list;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur!=null){
            while (cur!=null){
                list.add(cur.val);
                stack.push(cur);
                cur = cur.right;
            }

            TreeNode pop = stack.pop();
            if(pop.left!=null){
                cur = pop.left;
            }

        }
        Collections.reverse(list);
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

