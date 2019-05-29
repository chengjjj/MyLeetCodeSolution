package TreesProblems;

/**
 * 从前序与中序遍历序列构造二叉树
 * */
public class Solution_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        return constructCore(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private static TreeNode constructCore(int[] preorder, int preStart, int preEnd,
                                          int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preorder[preStart] == preorder[preEnd] ) {
            // System.out.println(preorder[preStart]);
            return root;
        }
        int rootInorder = 0;
        // 在中序遍历中找到root的索引
        while (rootInorder < inEnd && inorder[rootInorder] != root.val)
            ++rootInorder;
        // 在中序序列中根节点与有效起始索引间的距离,即root的左子树的节点个数
        int leftLength = rootInorder - inStart;
        // 计算在前序序列中左子树的结束点,加1就得到了右子树在前序序列中的起始索引
        int leftPreorderEnd = preStart + leftLength;
        root.left = constructCore(preorder, preStart + 1, leftPreorderEnd,
                inorder, inStart, rootInorder - 1);
        root.right = constructCore(preorder, leftPreorderEnd + 1, preEnd,
                inorder, rootInorder + 1, inEnd);
        return root;
    }
}
