package leetcode.editor.cn.structure;

public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode() {}
      public TreeNode(int val) { this.val = val; }
      public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

    public static TreeNode createTree(int[] arr, int i){

        if(i >= arr.length){

            return null;

        }

        TreeNode root = new TreeNode(arr[i]);

        root.left = createTree(arr, 2 * i + 1);

        root.right = createTree(arr, 2 * i + 2);

        return root;

    }
}
