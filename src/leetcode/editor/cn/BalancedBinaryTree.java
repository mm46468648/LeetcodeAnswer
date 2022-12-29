//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1196 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.structure.TreeNode;

//java:平衡二叉树
public class BalancedBinaryTree{
    public static void main(String[] args){
        Solution solution = new BalancedBinaryTree().new Solution();
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
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    int height(TreeNode node){
        if(node == null) return 0;

        int leftH = height(node.left);
        int rightH = height(node.right);

        if(leftH == -1 || rightH == -1 || Math.abs(leftH - rightH) > 1){
            return -1;
        }else {
            return Math.max(leftH,rightH) + 1;
        }
    }

    public boolean isBalanced2(TreeNode root) {
        if(root == null) return true;
        boolean b = Math.abs(height2(root.left) - height2(root.right)) > 1;
        return !b && isBalanced(root.left) && isBalanced(root.right);
    }

    int height2(TreeNode node){
        if(node == null) return 0;
        return Math.max(height2(node.left) , height2(node.right)) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

