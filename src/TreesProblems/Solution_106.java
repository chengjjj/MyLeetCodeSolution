package TreesProblems;

/**
 * 从中序与后序遍历序列构造二叉树
 * */
public class Solution_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return constructCore(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode constructCore(int[] inorder, int inStart, int inEnd,
                                   int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        // 在中序中找到根节点的位置
        int rootInorder = 0;
        // 在中序遍历中找到root的索引
        while (rootInorder < inEnd && inorder[rootInorder] != root.val)
            rootInorder++;
        // 在中序序列中根节点与有效起始索引间的距离,即root的左子树的节点个数
        int leftLength = rootInorder - inStart;
        // 计算在后序序列中左子树的结束点,加1就得到了右子树在前序序列中的起始索引
        int leftPostOrderEnd = postStart + leftLength;
        root.left = constructCore(inorder, inStart, rootInorder - 1,
                postorder, postStart, leftPostOrderEnd - 1);
        root.right = constructCore(inorder, rootInorder + 1, inEnd,
                postorder, leftPostOrderEnd, postEnd - 1);

        return root;
    }
}
