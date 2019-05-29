package TreesProblems;

/**
 * 对称二叉树
 * */
public class Solution_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSym(root.left, root.right);
    }

    private boolean isSym(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        // 当前节点是否相等,左右子树是否相等
        return left.val == right.val && isSym(left.left, right.right)
                && isSym(left.right, right.left);
    }
}
