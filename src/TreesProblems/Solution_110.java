package TreesProblems;

/**
 * 平衡二叉树
 * 获取深度,并且判断深度差
 * */
public class Solution_110 {
    boolean isBalance = true;
    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return isBalance;
    }

    private int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1) {
            isBalance = false;
        }
        return right > left ? right + 1 : left + 1;
    }
}
