package TreesProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * 二叉树的前序遍历
 * 采用栈
 * */
public class Solution_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null)
            return rst;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                rst.add(root.val);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
        return rst;
    }
}
