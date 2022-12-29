//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1805 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.structure.TreeNode;

import java.util.HashMap;

//java:从前序与中序遍历序列构造二叉树
public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args){
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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

    //缓存中序遍历中的节点位置
    HashMap<Integer,Integer> hashMap = new HashMap<>();
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length){
            throw new IllegalArgumentException("");
        }
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i],i);
        }

        return buildTree(0,preorder.length-1,0,inorder.length-1);
    }

    TreeNode buildTree(int preL,int preR,int inL,int inR){
        //递归终止条件
        if(preL>preR || inL > inR){
            return null;
        }
        int preV = preorder[preL];
        //根节点是前序遍历的第一个节点
        TreeNode treeNode = new TreeNode(preV);
        //找到中序遍历中根节点的位置
//        int pindex = inL;
//        while (preV != inorder[pindex]){
//            pindex++;
//        }
        int pindex = hashMap.get(preV);

        treeNode.left = buildTree(preL+1,preL+pindex-inL,inL,pindex+1);
        treeNode.right = buildTree(preL+pindex-inL+1,preR,pindex+1,inR);

        return treeNode;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length){
            throw new IllegalArgumentException("");
        }

        return buildTree2(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    TreeNode buildTree2(int[] preorder,int preL,int preR,int[] inorder,int inL,int inR){
        //递归终止条件
        if(preL>preR || inL > inR){
            return null;
        }
        int preV = preorder[preL];
        //根节点是前序遍历的第一个节点
        TreeNode treeNode = new TreeNode(preV);
        //找到中序遍历中根节点的位置
        int pindex = inL;
        while (preV != inorder[pindex]){
            pindex++;
        }

        treeNode.left = buildTree2(preorder,preL+1,preL+pindex-inL,inorder,inL,pindex+1);
        treeNode.right = buildTree2(preorder,preL+pindex-inL+1,preR,inorder,pindex+1,inR);

        return treeNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

