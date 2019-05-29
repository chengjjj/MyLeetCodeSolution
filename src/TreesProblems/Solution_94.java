package TreesProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;




/**
 * 二叉树的中序遍历
 * 用的是栈这个数据结构
 * 做法是先从左子树开始一直递归到低
 * 若为空,则此时出栈,中序遍历
 * 然后在判断右子树
 * */
public class Solution_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null)
            return rst;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                rst.add(root.val);
                root = root.right;
            }
        }
        return rst;
    }
}
