package leetcode;

import java.util.HashMap;

public class Btree_105 {

    int[] preorder;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return builder(0, preorder.length - 1);
    }

    public TreeNode builder(int start, int end) {
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[start]);
        int idx = map.get(root.val);
            root.left = builder(start + 1, idx - 1);
        root.right = builder(idx + 1, end);
        return root;
    }

    public static void main(String[] args) {
//        TreeNode treeNode = new Btree_105().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        TreeNode treeNode2 = new Btree_105().buildTree(new int[]{1,2}, new int[]{1,2});

        System.out.println();
    }
}
